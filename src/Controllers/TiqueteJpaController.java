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
import rusia2018.Cliente;
import rusia2018.Partido;
import rusia2018.Silla;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rusia2018.Tiquete;

/**
 *
 * @author Diego Gamboa
 */
public class TiqueteJpaController implements Serializable {

    public TiqueteJpaController() {
        
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Rusia2018PU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tiquete tiquete) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        Cliente clienteOrphanCheck = tiquete.getCliente();
        if (clienteOrphanCheck != null) {
            Tiquete oldTiqueteOfCliente = clienteOrphanCheck.getTiquete();
            if (oldTiqueteOfCliente != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Cliente " + clienteOrphanCheck + " already has an item of type Tiquete whose cliente column cannot be null. Please make another selection for the cliente field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente = tiquete.getCliente();
            if (cliente != null) {
                cliente = em.getReference(cliente.getClass(), cliente.getIdCliente());
                tiquete.setCliente(cliente);
            }
            Partido idPartido = tiquete.getIdPartido();
            if (idPartido != null) {
                idPartido = em.getReference(idPartido.getClass(), idPartido.getIdPartido());
                tiquete.setIdPartido(idPartido);
            }
            Silla silla = tiquete.getSilla();
            if (silla != null) {
                silla = em.getReference(silla.getClass(), silla.getSillaPK());
                tiquete.setSilla(silla);
            }
            em.persist(tiquete);
            if (cliente != null) {
                cliente.setTiquete(tiquete);
                cliente = em.merge(cliente);
            }
            if (idPartido != null) {
                idPartido.getTiqueteList().add(tiquete);
                idPartido = em.merge(idPartido);
            }
            if (silla != null) {
                silla.getTiqueteList().add(tiquete);
                silla = em.merge(silla);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTiquete(tiquete.getIdCliente()) != null) {
                throw new PreexistingEntityException("Tiquete " + tiquete + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tiquete tiquete) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tiquete persistentTiquete = em.find(Tiquete.class, tiquete.getIdCliente());
            Cliente clienteOld = persistentTiquete.getCliente();
            Cliente clienteNew = tiquete.getCliente();
            Partido idPartidoOld = persistentTiquete.getIdPartido();
            Partido idPartidoNew = tiquete.getIdPartido();
            Silla sillaOld = persistentTiquete.getSilla();
            Silla sillaNew = tiquete.getSilla();
            List<String> illegalOrphanMessages = null;
            if (clienteNew != null && !clienteNew.equals(clienteOld)) {
                Tiquete oldTiqueteOfCliente = clienteNew.getTiquete();
                if (oldTiqueteOfCliente != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Cliente " + clienteNew + " already has an item of type Tiquete whose cliente column cannot be null. Please make another selection for the cliente field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (clienteNew != null) {
                clienteNew = em.getReference(clienteNew.getClass(), clienteNew.getIdCliente());
                tiquete.setCliente(clienteNew);
            }
            if (idPartidoNew != null) {
                idPartidoNew = em.getReference(idPartidoNew.getClass(), idPartidoNew.getIdPartido());
                tiquete.setIdPartido(idPartidoNew);
            }
            if (sillaNew != null) {
                sillaNew = em.getReference(sillaNew.getClass(), sillaNew.getSillaPK());
                tiquete.setSilla(sillaNew);
            }
            tiquete = em.merge(tiquete);
            if (clienteOld != null && !clienteOld.equals(clienteNew)) {
                clienteOld.setTiquete(null);
                clienteOld = em.merge(clienteOld);
            }
            if (clienteNew != null && !clienteNew.equals(clienteOld)) {
                clienteNew.setTiquete(tiquete);
                clienteNew = em.merge(clienteNew);
            }
            if (idPartidoOld != null && !idPartidoOld.equals(idPartidoNew)) {
                idPartidoOld.getTiqueteList().remove(tiquete);
                idPartidoOld = em.merge(idPartidoOld);
            }
            if (idPartidoNew != null && !idPartidoNew.equals(idPartidoOld)) {
                idPartidoNew.getTiqueteList().add(tiquete);
                idPartidoNew = em.merge(idPartidoNew);
            }
            if (sillaOld != null && !sillaOld.equals(sillaNew)) {
                sillaOld.getTiqueteList().remove(tiquete);
                sillaOld = em.merge(sillaOld);
            }
            if (sillaNew != null && !sillaNew.equals(sillaOld)) {
                sillaNew.getTiqueteList().add(tiquete);
                sillaNew = em.merge(sillaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigInteger id = tiquete.getIdCliente();
                if (findTiquete(id) == null) {
                    throw new NonexistentEntityException("The tiquete with id " + id + " no longer exists.");
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
            Tiquete tiquete;
            try {
                tiquete = em.getReference(Tiquete.class, id);
                tiquete.getIdCliente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tiquete with id " + id + " no longer exists.", enfe);
            }
            Cliente cliente = tiquete.getCliente();
            if (cliente != null) {
                cliente.setTiquete(null);
                cliente = em.merge(cliente);
            }
            Partido idPartido = tiquete.getIdPartido();
            if (idPartido != null) {
                idPartido.getTiqueteList().remove(tiquete);
                idPartido = em.merge(idPartido);
            }
            Silla silla = tiquete.getSilla();
            if (silla != null) {
                silla.getTiqueteList().remove(tiquete);
                silla = em.merge(silla);
            }
            em.remove(tiquete);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tiquete> findTiqueteEntities() {
        return findTiqueteEntities(true, -1, -1);
    }

    public List<Tiquete> findTiqueteEntities(int maxResults, int firstResult) {
        return findTiqueteEntities(false, maxResults, firstResult);
    }

    private List<Tiquete> findTiqueteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tiquete.class));
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

    public Tiquete findTiquete(BigInteger id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tiquete.class, id);
        } finally {
            em.close();
        }
    }

    public int getTiqueteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tiquete> rt = cq.from(Tiquete.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
