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
import rusia2018.Goles;
import rusia2018.Jugador;
import rusia2018.Partido;

/**
 *
 * @author Diego Gamboa
 */
public class GolesJpaController implements Serializable {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Rusia2018PU");
    public GolesJpaController() {
    
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Goles goles) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Jugador idJugador = goles.getIdJugador();
            if (idJugador != null) {
                idJugador = em.getReference(idJugador.getClass(), idJugador.getIdPersona());
                goles.setIdJugador(idJugador);
            }
            Partido idPartido = goles.getIdPartido();
            if (idPartido != null) {
                idPartido = em.getReference(idPartido.getClass(), idPartido.getIdPartido());
                goles.setIdPartido(idPartido);
            }
            em.persist(goles);
            if (idJugador != null) {
                idJugador.getGolesList().add(goles);
                idJugador = em.merge(idJugador);
            }
            if (idPartido != null) {
                idPartido.getGolesList().add(goles);
                idPartido = em.merge(idPartido);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findGoles(goles.getIdGol()) != null) {
                throw new PreexistingEntityException("Goles " + goles + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Goles goles) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Goles persistentGoles = em.find(Goles.class, goles.getIdGol());
            Jugador idJugadorOld = persistentGoles.getIdJugador();
            Jugador idJugadorNew = goles.getIdJugador();
            Partido idPartidoOld = persistentGoles.getIdPartido();
            Partido idPartidoNew = goles.getIdPartido();
            if (idJugadorNew != null) {
                idJugadorNew = em.getReference(idJugadorNew.getClass(), idJugadorNew.getIdPersona());
                goles.setIdJugador(idJugadorNew);
            }
            if (idPartidoNew != null) {
                idPartidoNew = em.getReference(idPartidoNew.getClass(), idPartidoNew.getIdPartido());
                goles.setIdPartido(idPartidoNew);
            }
            goles = em.merge(goles);
            if (idJugadorOld != null && !idJugadorOld.equals(idJugadorNew)) {
                idJugadorOld.getGolesList().remove(goles);
                idJugadorOld = em.merge(idJugadorOld);
            }
            if (idJugadorNew != null && !idJugadorNew.equals(idJugadorOld)) {
                idJugadorNew.getGolesList().add(goles);
                idJugadorNew = em.merge(idJugadorNew);
            }
            if (idPartidoOld != null && !idPartidoOld.equals(idPartidoNew)) {
                idPartidoOld.getGolesList().remove(goles);
                idPartidoOld = em.merge(idPartidoOld);
            }
            if (idPartidoNew != null && !idPartidoNew.equals(idPartidoOld)) {
                idPartidoNew.getGolesList().add(goles);
                idPartidoNew = em.merge(idPartidoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigInteger id = goles.getIdGol();
                if (findGoles(id) == null) {
                    throw new NonexistentEntityException("The goles with id " + id + " no longer exists.");
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
            Goles goles;
            try {
                goles = em.getReference(Goles.class, id);
                goles.getIdGol();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The goles with id " + id + " no longer exists.", enfe);
            }
            Jugador idJugador = goles.getIdJugador();
            if (idJugador != null) {
                idJugador.getGolesList().remove(goles);
                idJugador = em.merge(idJugador);
            }
            Partido idPartido = goles.getIdPartido();
            if (idPartido != null) {
                idPartido.getGolesList().remove(goles);
                idPartido = em.merge(idPartido);
            }
            em.remove(goles);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Goles> findGolesEntities() {
        return findGolesEntities(true, -1, -1);
    }

    public List<Goles> findGolesEntities(int maxResults, int firstResult) {
        return findGolesEntities(false, maxResults, firstResult);
    }

    private List<Goles> findGolesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Goles.class));
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

    public Goles findGoles(BigInteger id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Goles.class, id);
        } finally {
            em.close();
        }
    }

    public int getGolesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Goles> rt = cq.from(Goles.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
