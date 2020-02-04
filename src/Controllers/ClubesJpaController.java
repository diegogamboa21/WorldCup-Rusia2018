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
import rusia2018.Jugador;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rusia2018.Clubes;

/**
 *
 * @author Diego Gamboa
 */
public class ClubesJpaController implements Serializable {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Rusia2018PU");
    public ClubesJpaController() {
     
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Clubes clubes) throws PreexistingEntityException, Exception {
        if (clubes.getJugadorList() == null) {
            clubes.setJugadorList(new ArrayList<Jugador>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Jugador> attachedJugadorList = new ArrayList<Jugador>();
            for (Jugador jugadorListJugadorToAttach : clubes.getJugadorList()) {
                jugadorListJugadorToAttach = em.getReference(jugadorListJugadorToAttach.getClass(), jugadorListJugadorToAttach.getIdPersona());
                attachedJugadorList.add(jugadorListJugadorToAttach);
            }
            clubes.setJugadorList(attachedJugadorList);
            em.persist(clubes);
            for (Jugador jugadorListJugador : clubes.getJugadorList()) {
                jugadorListJugador.getClubesList().add(clubes);
                jugadorListJugador = em.merge(jugadorListJugador);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findClubes(clubes.getIdClub()) != null) {
                throw new PreexistingEntityException("Clubes " + clubes + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Clubes clubes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clubes persistentClubes = em.find(Clubes.class, clubes.getIdClub());
            List<Jugador> jugadorListOld = persistentClubes.getJugadorList();
            List<Jugador> jugadorListNew = clubes.getJugadorList();
            List<Jugador> attachedJugadorListNew = new ArrayList<Jugador>();
            for (Jugador jugadorListNewJugadorToAttach : jugadorListNew) {
                jugadorListNewJugadorToAttach = em.getReference(jugadorListNewJugadorToAttach.getClass(), jugadorListNewJugadorToAttach.getIdPersona());
                attachedJugadorListNew.add(jugadorListNewJugadorToAttach);
            }
            jugadorListNew = attachedJugadorListNew;
            clubes.setJugadorList(jugadorListNew);
            clubes = em.merge(clubes);
            for (Jugador jugadorListOldJugador : jugadorListOld) {
                if (!jugadorListNew.contains(jugadorListOldJugador)) {
                    jugadorListOldJugador.getClubesList().remove(clubes);
                    jugadorListOldJugador = em.merge(jugadorListOldJugador);
                }
            }
            for (Jugador jugadorListNewJugador : jugadorListNew) {
                if (!jugadorListOld.contains(jugadorListNewJugador)) {
                    jugadorListNewJugador.getClubesList().add(clubes);
                    jugadorListNewJugador = em.merge(jugadorListNewJugador);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigInteger id = clubes.getIdClub();
                if (findClubes(id) == null) {
                    throw new NonexistentEntityException("The clubes with id " + id + " no longer exists.");
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
            Clubes clubes;
            try {
                clubes = em.getReference(Clubes.class, id);
                clubes.getIdClub();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clubes with id " + id + " no longer exists.", enfe);
            }
            List<Jugador> jugadorList = clubes.getJugadorList();
            for (Jugador jugadorListJugador : jugadorList) {
                jugadorListJugador.getClubesList().remove(clubes);
                jugadorListJugador = em.merge(jugadorListJugador);
            }
            em.remove(clubes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Clubes> findClubesEntities() {
        return findClubesEntities(true, -1, -1);
    }

    public List<Clubes> findClubesEntities(int maxResults, int firstResult) {
        return findClubesEntities(false, maxResults, firstResult);
    }

    private List<Clubes> findClubesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Clubes.class));
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

    public Clubes findClubes(BigInteger id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Clubes.class, id);
        } finally {
            em.close();
        }
    }

    public int getClubesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Clubes> rt = cq.from(Clubes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
