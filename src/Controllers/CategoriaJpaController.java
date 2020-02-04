/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controllers.exceptions.NonexistentEntityException;
import Controllers.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import rusia2018.Categoria;
import rusia2018.CategoriaPK;
import rusia2018.Silla;

/**
 *
 * @author Diego Gamboa
 */
public class CategoriaJpaController implements Serializable {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Rusia2018PU");
    public CategoriaJpaController() {
    
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Categoria categoria) throws PreexistingEntityException, Exception {
        if (categoria.getCategoriaPK() == null) {
            categoria.setCategoriaPK(new CategoriaPK());
        }
        categoria.getCategoriaPK().setIdSilla(categoria.getSilla().getSillaPK().getIdSilla());
        categoria.getCategoriaPK().setIdEstadio(categoria.getSilla().getSillaPK().getIdEstadio());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Silla silla = categoria.getSilla();
            if (silla != null) {
                silla = em.getReference(silla.getClass(), silla.getSillaPK());
                categoria.setSilla(silla);
            }
            em.persist(categoria);
            if (silla != null) {
                silla.getCategoriaList().add(categoria);
                silla = em.merge(silla);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCategoria(categoria.getCategoriaPK()) != null) {
                throw new PreexistingEntityException("Categoria " + categoria + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Categoria categoria) throws NonexistentEntityException, Exception {
        categoria.getCategoriaPK().setIdSilla(categoria.getSilla().getSillaPK().getIdSilla());
        categoria.getCategoriaPK().setIdEstadio(categoria.getSilla().getSillaPK().getIdEstadio());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria persistentCategoria = em.find(Categoria.class, categoria.getCategoriaPK());
            Silla sillaOld = persistentCategoria.getSilla();
            Silla sillaNew = categoria.getSilla();
            if (sillaNew != null) {
                sillaNew = em.getReference(sillaNew.getClass(), sillaNew.getSillaPK());
                categoria.setSilla(sillaNew);
            }
            categoria = em.merge(categoria);
            if (sillaOld != null && !sillaOld.equals(sillaNew)) {
                sillaOld.getCategoriaList().remove(categoria);
                sillaOld = em.merge(sillaOld);
            }
            if (sillaNew != null && !sillaNew.equals(sillaOld)) {
                sillaNew.getCategoriaList().add(categoria);
                sillaNew = em.merge(sillaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                CategoriaPK id = categoria.getCategoriaPK();
                if (findCategoria(id) == null) {
                    throw new NonexistentEntityException("The categoria with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(CategoriaPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria categoria;
            try {
                categoria = em.getReference(Categoria.class, id);
                categoria.getCategoriaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The categoria with id " + id + " no longer exists.", enfe);
            }
            Silla silla = categoria.getSilla();
            if (silla != null) {
                silla.getCategoriaList().remove(categoria);
                silla = em.merge(silla);
            }
            em.remove(categoria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Categoria> findCategoriaEntities() {
        return findCategoriaEntities(true, -1, -1);
    }

    public List<Categoria> findCategoriaEntities(int maxResults, int firstResult) {
        return findCategoriaEntities(false, maxResults, firstResult);
    }

    private List<Categoria> findCategoriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Categoria.class));
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

    public Categoria findCategoria(CategoriaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Categoria.class, id);
        } finally {
            em.close();
        }
    }

    public int getCategoriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Categoria> rt = cq.from(Categoria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
