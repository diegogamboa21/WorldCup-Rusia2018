/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controllers.exceptions.NonexistentEntityException;
import Controllers.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import rusia2018.Estadio;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rusia2018.Ciudad;

/**
 *
 * @author Diego Gamboa
 */
public class CiudadJpaController implements Serializable {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Rusia2018PU");
    public CiudadJpaController() {

    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ciudad ciudad) throws PreexistingEntityException, Exception {
        if (ciudad.getEstadioList() == null) {
            ciudad.setEstadioList(new ArrayList<Estadio>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Estadio> attachedEstadioList = new ArrayList<Estadio>();
            for (Estadio estadioListEstadioToAttach : ciudad.getEstadioList()) {
                estadioListEstadioToAttach = em.getReference(estadioListEstadioToAttach.getClass(), estadioListEstadioToAttach.getIdEstadio());
                attachedEstadioList.add(estadioListEstadioToAttach);
            }
            ciudad.setEstadioList(attachedEstadioList);
            em.persist(ciudad);
            for (Estadio estadioListEstadio : ciudad.getEstadioList()) {
                Ciudad oldIdCiudadOfEstadioListEstadio = estadioListEstadio.getIdCiudad();
                estadioListEstadio.setIdCiudad(ciudad);
                estadioListEstadio = em.merge(estadioListEstadio);
                if (oldIdCiudadOfEstadioListEstadio != null) {
                    oldIdCiudadOfEstadioListEstadio.getEstadioList().remove(estadioListEstadio);
                    oldIdCiudadOfEstadioListEstadio = em.merge(oldIdCiudadOfEstadioListEstadio);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCiudad(ciudad.getIdCiudad()) != null) {
                throw new PreexistingEntityException("Ciudad " + ciudad + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ciudad ciudad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ciudad persistentCiudad = em.find(Ciudad.class, ciudad.getIdCiudad());
            List<Estadio> estadioListOld = persistentCiudad.getEstadioList();
            List<Estadio> estadioListNew = ciudad.getEstadioList();
            List<Estadio> attachedEstadioListNew = new ArrayList<Estadio>();
            for (Estadio estadioListNewEstadioToAttach : estadioListNew) {
                estadioListNewEstadioToAttach = em.getReference(estadioListNewEstadioToAttach.getClass(), estadioListNewEstadioToAttach.getIdEstadio());
                attachedEstadioListNew.add(estadioListNewEstadioToAttach);
            }
            estadioListNew = attachedEstadioListNew;
            ciudad.setEstadioList(estadioListNew);
            ciudad = em.merge(ciudad);
            for (Estadio estadioListOldEstadio : estadioListOld) {
                if (!estadioListNew.contains(estadioListOldEstadio)) {
                    estadioListOldEstadio.setIdCiudad(null);
                    estadioListOldEstadio = em.merge(estadioListOldEstadio);
                }
            }
            for (Estadio estadioListNewEstadio : estadioListNew) {
                if (!estadioListOld.contains(estadioListNewEstadio)) {
                    Ciudad oldIdCiudadOfEstadioListNewEstadio = estadioListNewEstadio.getIdCiudad();
                    estadioListNewEstadio.setIdCiudad(ciudad);
                    estadioListNewEstadio = em.merge(estadioListNewEstadio);
                    if (oldIdCiudadOfEstadioListNewEstadio != null && !oldIdCiudadOfEstadioListNewEstadio.equals(ciudad)) {
                        oldIdCiudadOfEstadioListNewEstadio.getEstadioList().remove(estadioListNewEstadio);
                        oldIdCiudadOfEstadioListNewEstadio = em.merge(oldIdCiudadOfEstadioListNewEstadio);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigInteger id = ciudad.getIdCiudad();
                if (findCiudad(id) == null) {
                    throw new NonexistentEntityException("The ciudad with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(BigInteger id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ciudad ciudad;
            try {
                ciudad = em.getReference(Ciudad.class, id);
                ciudad.getIdCiudad();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ciudad with id " + id + " no longer exists.", enfe);
            }
            List<Estadio> estadioList = ciudad.getEstadioList();
            for (Estadio estadioListEstadio : estadioList) {
                estadioListEstadio.setIdCiudad(null);
                estadioListEstadio = em.merge(estadioListEstadio);
            }
            em.remove(ciudad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ciudad> findCiudadEntities() {
        return findCiudadEntities(true, -1, -1);
    }

    public List<Ciudad> findCiudadEntities(int maxResults, int firstResult) {
        return findCiudadEntities(false, maxResults, firstResult);
    }

    private List<Ciudad> findCiudadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ciudad.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Ciudad findCiudad(BigInteger id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ciudad.class, id);
        } finally {
            em.close();
        }
    }

    public int getCiudadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ciudad> rt = cq.from(Ciudad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
