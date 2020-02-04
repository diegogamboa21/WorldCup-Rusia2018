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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import rusia2018.Juez;
import rusia2018.Partido;

/**
 *
 * @author Diego Gamboa
 */
public class JuezJpaController implements Serializable {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Rusia2018PU");
    public JuezJpaController() {
        
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Juez juez) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Partido idPartido = juez.getIdPartido();
            if (idPartido != null) {
                idPartido = em.getReference(idPartido.getClass(), idPartido.getIdPartido());
                juez.setIdPartido(idPartido);
            }
            em.persist(juez);
            if (idPartido != null) {
                idPartido.getJuezList().add(juez);
                idPartido = em.merge(idPartido);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findJuez(juez.getIdJuez()) != null) {
                throw new PreexistingEntityException("Juez " + juez + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Juez juez) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Juez persistentJuez = em.find(Juez.class, juez.getIdJuez());
            Partido idPartidoOld = persistentJuez.getIdPartido();
            Partido idPartidoNew = juez.getIdPartido();
            if (idPartidoNew != null) {
                idPartidoNew = em.getReference(idPartidoNew.getClass(), idPartidoNew.getIdPartido());
                juez.setIdPartido(idPartidoNew);
            }
            juez = em.merge(juez);
            if (idPartidoOld != null && !idPartidoOld.equals(idPartidoNew)) {
                idPartidoOld.getJuezList().remove(juez);
                idPartidoOld = em.merge(idPartidoOld);
            }
            if (idPartidoNew != null && !idPartidoNew.equals(idPartidoOld)) {
                idPartidoNew.getJuezList().add(juez);
                idPartidoNew = em.merge(idPartidoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigInteger id = juez.getIdJuez();
                if (findJuez(id) == null) {
                    throw new NonexistentEntityException("The juez with id " + id + " no longer exists.");
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
            Juez juez;
            try {
                juez = em.getReference(Juez.class, id);
                juez.getIdJuez();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The juez with id " + id + " no longer exists.", enfe);
            }
            Partido idPartido = juez.getIdPartido();
            if (idPartido != null) {
                idPartido.getJuezList().remove(juez);
                idPartido = em.merge(idPartido);
            }
            em.remove(juez);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Juez> findJuezEntities() {
        return findJuezEntities(true, -1, -1);
    }

    public List<Juez> findJuezEntities(int maxResults, int firstResult) {
        return findJuezEntities(false, maxResults, firstResult);
    }

    private List<Juez> findJuezEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Juez.class));
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

    public Juez findJuez(BigInteger id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Juez.class, id);
        } finally {
            em.close();
        }
    }

    public int getJuezCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Juez> rt = cq.from(Juez.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
