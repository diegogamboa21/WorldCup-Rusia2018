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
import rusia2018.Jugador;
import rusia2018.Partido;
import rusia2018.Tarjeta;

/**
 *
 * @author Diego Gamboa
 */
public class TarjetaJpaController implements Serializable {

    public TarjetaJpaController() {
        
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Rusia2018PU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tarjeta tarjeta) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Jugador idJugador = tarjeta.getIdJugador();
            if (idJugador != null) {
                idJugador = em.getReference(idJugador.getClass(), idJugador.getIdPersona());
                tarjeta.setIdJugador(idJugador);
            }
            Partido idPartido = tarjeta.getIdPartido();
            if (idPartido != null) {
                idPartido = em.getReference(idPartido.getClass(), idPartido.getIdPartido());
                tarjeta.setIdPartido(idPartido);
            }
            em.persist(tarjeta);
            if (idJugador != null) {
                idJugador.getTarjetaList().add(tarjeta);
                idJugador = em.merge(idJugador);
            }
            if (idPartido != null) {
                idPartido.getTarjetaList().add(tarjeta);
                idPartido = em.merge(idPartido);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTarjeta(tarjeta.getIdTarjeta()) != null) {
                throw new PreexistingEntityException("Tarjeta " + tarjeta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tarjeta tarjeta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tarjeta persistentTarjeta = em.find(Tarjeta.class, tarjeta.getIdTarjeta());
            Jugador idJugadorOld = persistentTarjeta.getIdJugador();
            Jugador idJugadorNew = tarjeta.getIdJugador();
            Partido idPartidoOld = persistentTarjeta.getIdPartido();
            Partido idPartidoNew = tarjeta.getIdPartido();
            if (idJugadorNew != null) {
                idJugadorNew = em.getReference(idJugadorNew.getClass(), idJugadorNew.getIdPersona());
                tarjeta.setIdJugador(idJugadorNew);
            }
            if (idPartidoNew != null) {
                idPartidoNew = em.getReference(idPartidoNew.getClass(), idPartidoNew.getIdPartido());
                tarjeta.setIdPartido(idPartidoNew);
            }
            tarjeta = em.merge(tarjeta);
            if (idJugadorOld != null && !idJugadorOld.equals(idJugadorNew)) {
                idJugadorOld.getTarjetaList().remove(tarjeta);
                idJugadorOld = em.merge(idJugadorOld);
            }
            if (idJugadorNew != null && !idJugadorNew.equals(idJugadorOld)) {
                idJugadorNew.getTarjetaList().add(tarjeta);
                idJugadorNew = em.merge(idJugadorNew);
            }
            if (idPartidoOld != null && !idPartidoOld.equals(idPartidoNew)) {
                idPartidoOld.getTarjetaList().remove(tarjeta);
                idPartidoOld = em.merge(idPartidoOld);
            }
            if (idPartidoNew != null && !idPartidoNew.equals(idPartidoOld)) {
                idPartidoNew.getTarjetaList().add(tarjeta);
                idPartidoNew = em.merge(idPartidoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigInteger id = tarjeta.getIdTarjeta();
                if (findTarjeta(id) == null) {
                    throw new NonexistentEntityException("The tarjeta with id " + id + " no longer exists.");
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
            Tarjeta tarjeta;
            try {
                tarjeta = em.getReference(Tarjeta.class, id);
                tarjeta.getIdTarjeta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tarjeta with id " + id + " no longer exists.", enfe);
            }
            Jugador idJugador = tarjeta.getIdJugador();
            if (idJugador != null) {
                idJugador.getTarjetaList().remove(tarjeta);
                idJugador = em.merge(idJugador);
            }
            Partido idPartido = tarjeta.getIdPartido();
            if (idPartido != null) {
                idPartido.getTarjetaList().remove(tarjeta);
                idPartido = em.merge(idPartido);
            }
            em.remove(tarjeta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tarjeta> findTarjetaEntities() {
        return findTarjetaEntities(true, -1, -1);
    }

    public List<Tarjeta> findTarjetaEntities(int maxResults, int firstResult) {
        return findTarjetaEntities(false, maxResults, firstResult);
    }

    private List<Tarjeta> findTarjetaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tarjeta.class));
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

    public Tarjeta findTarjeta(BigInteger id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tarjeta.class, id);
        } finally {
            em.close();
        }
    }

    public int getTarjetaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tarjeta> rt = cq.from(Tarjeta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
