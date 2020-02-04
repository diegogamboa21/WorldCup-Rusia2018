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
import rusia2018.Tiquete;
import rusia2018.Pais;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rusia2018.Cliente;

/**
 *
 * @author Diego Gamboa
 */
public class ClienteJpaController implements Serializable {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Rusia2018PU");
    public ClienteJpaController() {
        
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tiquete tiquete = cliente.getTiquete();
            if (tiquete != null) {
                tiquete = em.getReference(tiquete.getClass(), tiquete.getIdCliente());
                cliente.setTiquete(tiquete);
            }
            Pais idPais = cliente.getIdPais();
            if (idPais != null) {
                idPais = em.getReference(idPais.getClass(), idPais.getIdPais());
                cliente.setIdPais(idPais);
            }
            em.persist(cliente);
            if (tiquete != null) {
                Cliente oldClienteOfTiquete = tiquete.getCliente();
                if (oldClienteOfTiquete != null) {
                    oldClienteOfTiquete.setTiquete(null);
                    oldClienteOfTiquete = em.merge(oldClienteOfTiquete);
                }
                tiquete.setCliente(cliente);
                tiquete = em.merge(tiquete);
            }
            if (idPais != null) {
                idPais.getClienteList().add(cliente);
                idPais = em.merge(idPais);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCliente(cliente.getIdCliente()) != null) {
                throw new PreexistingEntityException("Cliente " + cliente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getIdCliente());
            Tiquete tiqueteOld = persistentCliente.getTiquete();
            Tiquete tiqueteNew = cliente.getTiquete();
            Pais idPaisOld = persistentCliente.getIdPais();
            Pais idPaisNew = cliente.getIdPais();
            List<String> illegalOrphanMessages = null;
            if (tiqueteOld != null && !tiqueteOld.equals(tiqueteNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Tiquete " + tiqueteOld + " since its cliente field is not nullable.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (tiqueteNew != null) {
                tiqueteNew = em.getReference(tiqueteNew.getClass(), tiqueteNew.getIdCliente());
                cliente.setTiquete(tiqueteNew);
            }
            if (idPaisNew != null) {
                idPaisNew = em.getReference(idPaisNew.getClass(), idPaisNew.getIdPais());
                cliente.setIdPais(idPaisNew);
            }
            cliente = em.merge(cliente);
            if (tiqueteNew != null && !tiqueteNew.equals(tiqueteOld)) {
                Cliente oldClienteOfTiquete = tiqueteNew.getCliente();
                if (oldClienteOfTiquete != null) {
                    oldClienteOfTiquete.setTiquete(null);
                    oldClienteOfTiquete = em.merge(oldClienteOfTiquete);
                }
                tiqueteNew.setCliente(cliente);
                tiqueteNew = em.merge(tiqueteNew);
            }
            if (idPaisOld != null && !idPaisOld.equals(idPaisNew)) {
                idPaisOld.getClienteList().remove(cliente);
                idPaisOld = em.merge(idPaisOld);
            }
            if (idPaisNew != null && !idPaisNew.equals(idPaisOld)) {
                idPaisNew.getClienteList().add(cliente);
                idPaisNew = em.merge(idPaisNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigInteger id = cliente.getIdCliente();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
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
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getIdCliente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Tiquete tiqueteOrphanCheck = cliente.getTiquete();
            if (tiqueteOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cliente (" + cliente + ") cannot be destroyed since the Tiquete " + tiqueteOrphanCheck + " in its tiquete field has a non-nullable cliente field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Pais idPais = cliente.getIdPais();
            if (idPais != null) {
                idPais.getClienteList().remove(cliente);
                idPais = em.merge(idPais);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
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

    public Cliente findCliente(BigInteger id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
