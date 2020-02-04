/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controllers.exceptions.IllegalOrphanException;
import Controllers.exceptions.NonexistentEntityException;
import Controllers.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import rusia2018.Ciudad;
import rusia2018.Partido;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rusia2018.Estadio;
import rusia2018.Silla;

/**
 *
 * @author Diego Gamboa
 */
public class EstadioJpaController implements Serializable {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Rusia2018PU");
    public EstadioJpaController() {
    
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Estadio estadio) throws PreexistingEntityException, Exception {
        if (estadio.getPartidoList() == null) {
            estadio.setPartidoList(new ArrayList<Partido>());
        }
        if (estadio.getSillaList() == null) {
            estadio.setSillaList(new ArrayList<Silla>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ciudad idCiudad = estadio.getIdCiudad();
            if (idCiudad != null) {
                idCiudad = em.getReference(idCiudad.getClass(), idCiudad.getIdCiudad());
                estadio.setIdCiudad(idCiudad);
            }
            List<Partido> attachedPartidoList = new ArrayList<Partido>();
            for (Partido partidoListPartidoToAttach : estadio.getPartidoList()) {
                partidoListPartidoToAttach = em.getReference(partidoListPartidoToAttach.getClass(), partidoListPartidoToAttach.getIdPartido());
                attachedPartidoList.add(partidoListPartidoToAttach);
            }
            estadio.setPartidoList(attachedPartidoList);
            List<Silla> attachedSillaList = new ArrayList<Silla>();
            for (Silla sillaListSillaToAttach : estadio.getSillaList()) {
                sillaListSillaToAttach = em.getReference(sillaListSillaToAttach.getClass(), sillaListSillaToAttach.getSillaPK());
                attachedSillaList.add(sillaListSillaToAttach);
            }
            estadio.setSillaList(attachedSillaList);
            em.persist(estadio);
            if (idCiudad != null) {
                idCiudad.getEstadioList().add(estadio);
                idCiudad = em.merge(idCiudad);
            }
            for (Partido partidoListPartido : estadio.getPartidoList()) {
                Estadio oldIdEstadioOfPartidoListPartido = partidoListPartido.getIdEstadio();
                partidoListPartido.setIdEstadio(estadio);
                partidoListPartido = em.merge(partidoListPartido);
                if (oldIdEstadioOfPartidoListPartido != null) {
                    oldIdEstadioOfPartidoListPartido.getPartidoList().remove(partidoListPartido);
                    oldIdEstadioOfPartidoListPartido = em.merge(oldIdEstadioOfPartidoListPartido);
                }
            }
            for (Silla sillaListSilla : estadio.getSillaList()) {
                Estadio oldEstadioOfSillaListSilla = sillaListSilla.getEstadio();
                sillaListSilla.setEstadio(estadio);
                sillaListSilla = em.merge(sillaListSilla);
                if (oldEstadioOfSillaListSilla != null) {
                    oldEstadioOfSillaListSilla.getSillaList().remove(sillaListSilla);
                    oldEstadioOfSillaListSilla = em.merge(oldEstadioOfSillaListSilla);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEstadio(estadio.getIdEstadio()) != null) {
                throw new PreexistingEntityException("Estadio " + estadio + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Estadio estadio) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estadio persistentEstadio = em.find(Estadio.class, estadio.getIdEstadio());
            Ciudad idCiudadOld = persistentEstadio.getIdCiudad();
            Ciudad idCiudadNew = estadio.getIdCiudad();
            List<Partido> partidoListOld = persistentEstadio.getPartidoList();
            List<Partido> partidoListNew = estadio.getPartidoList();
            List<Silla> sillaListOld = persistentEstadio.getSillaList();
            List<Silla> sillaListNew = estadio.getSillaList();
            List<String> illegalOrphanMessages = null;
            for (Silla sillaListOldSilla : sillaListOld) {
                if (!sillaListNew.contains(sillaListOldSilla)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Silla " + sillaListOldSilla + " since its estadio field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idCiudadNew != null) {
                idCiudadNew = em.getReference(idCiudadNew.getClass(), idCiudadNew.getIdCiudad());
                estadio.setIdCiudad(idCiudadNew);
            }
            List<Partido> attachedPartidoListNew = new ArrayList<Partido>();
            for (Partido partidoListNewPartidoToAttach : partidoListNew) {
                partidoListNewPartidoToAttach = em.getReference(partidoListNewPartidoToAttach.getClass(), partidoListNewPartidoToAttach.getIdPartido());
                attachedPartidoListNew.add(partidoListNewPartidoToAttach);
            }
            partidoListNew = attachedPartidoListNew;
            estadio.setPartidoList(partidoListNew);
            List<Silla> attachedSillaListNew = new ArrayList<Silla>();
            for (Silla sillaListNewSillaToAttach : sillaListNew) {
                sillaListNewSillaToAttach = em.getReference(sillaListNewSillaToAttach.getClass(), sillaListNewSillaToAttach.getSillaPK());
                attachedSillaListNew.add(sillaListNewSillaToAttach);
            }
            sillaListNew = attachedSillaListNew;
            estadio.setSillaList(sillaListNew);
            estadio = em.merge(estadio);
            if (idCiudadOld != null && !idCiudadOld.equals(idCiudadNew)) {
                idCiudadOld.getEstadioList().remove(estadio);
                idCiudadOld = em.merge(idCiudadOld);
            }
            if (idCiudadNew != null && !idCiudadNew.equals(idCiudadOld)) {
                idCiudadNew.getEstadioList().add(estadio);
                idCiudadNew = em.merge(idCiudadNew);
            }
            for (Partido partidoListOldPartido : partidoListOld) {
                if (!partidoListNew.contains(partidoListOldPartido)) {
                    partidoListOldPartido.setIdEstadio(null);
                    partidoListOldPartido = em.merge(partidoListOldPartido);
                }
            }
            for (Partido partidoListNewPartido : partidoListNew) {
                if (!partidoListOld.contains(partidoListNewPartido)) {
                    Estadio oldIdEstadioOfPartidoListNewPartido = partidoListNewPartido.getIdEstadio();
                    partidoListNewPartido.setIdEstadio(estadio);
                    partidoListNewPartido = em.merge(partidoListNewPartido);
                    if (oldIdEstadioOfPartidoListNewPartido != null && !oldIdEstadioOfPartidoListNewPartido.equals(estadio)) {
                        oldIdEstadioOfPartidoListNewPartido.getPartidoList().remove(partidoListNewPartido);
                        oldIdEstadioOfPartidoListNewPartido = em.merge(oldIdEstadioOfPartidoListNewPartido);
                    }
                }
            }
            for (Silla sillaListNewSilla : sillaListNew) {
                if (!sillaListOld.contains(sillaListNewSilla)) {
                    Estadio oldEstadioOfSillaListNewSilla = sillaListNewSilla.getEstadio();
                    sillaListNewSilla.setEstadio(estadio);
                    sillaListNewSilla = em.merge(sillaListNewSilla);
                    if (oldEstadioOfSillaListNewSilla != null && !oldEstadioOfSillaListNewSilla.equals(estadio)) {
                        oldEstadioOfSillaListNewSilla.getSillaList().remove(sillaListNewSilla);
                        oldEstadioOfSillaListNewSilla = em.merge(oldEstadioOfSillaListNewSilla);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigInteger id = estadio.getIdEstadio();
                if (findEstadio(id) == null) {
                    throw new NonexistentEntityException("The estadio with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(BigInteger id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estadio estadio;
            try {
                estadio = em.getReference(Estadio.class, id);
                estadio.getIdEstadio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estadio with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Silla> sillaListOrphanCheck = estadio.getSillaList();
            for (Silla sillaListOrphanCheckSilla : sillaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Estadio (" + estadio + ") cannot be destroyed since the Silla " + sillaListOrphanCheckSilla + " in its sillaList field has a non-nullable estadio field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Ciudad idCiudad = estadio.getIdCiudad();
            if (idCiudad != null) {
                idCiudad.getEstadioList().remove(estadio);
                idCiudad = em.merge(idCiudad);
            }
            List<Partido> partidoList = estadio.getPartidoList();
            for (Partido partidoListPartido : partidoList) {
                partidoListPartido.setIdEstadio(null);
                partidoListPartido = em.merge(partidoListPartido);
            }
            em.remove(estadio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Estadio> findEstadioEntities() {
        return findEstadioEntities(true, -1, -1);
    }

    public List<Estadio> findEstadioEntities(int maxResults, int firstResult) {
        return findEstadioEntities(false, maxResults, firstResult);
    }

    private List<Estadio> findEstadioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Estadio.class));
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

    public Estadio findEstadio(BigInteger id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estadio.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstadioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Estadio> rt = cq.from(Estadio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
