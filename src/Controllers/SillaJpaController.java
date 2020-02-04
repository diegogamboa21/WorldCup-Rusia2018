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
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import rusia2018.Estadio;
import rusia2018.Tiquete;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rusia2018.Categoria;
import rusia2018.Silla;
import rusia2018.SillaPK;

/**
 *
 * @author Diego Gamboa
 */
public class SillaJpaController implements Serializable {

    public SillaJpaController() {

    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Rusia2018PU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Silla silla) throws PreexistingEntityException, Exception {
        if (silla.getSillaPK() == null) {
            silla.setSillaPK(new SillaPK());
        }
        if (silla.getTiqueteList() == null) {
            silla.setTiqueteList(new ArrayList<Tiquete>());
        }
        if (silla.getCategoriaList() == null) {
            silla.setCategoriaList(new ArrayList<Categoria>());
        }
        silla.getSillaPK().setIdEstadio(silla.getEstadio().getIdEstadio());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estadio estadio = silla.getEstadio();
            if (estadio != null) {
                estadio = em.getReference(estadio.getClass(), estadio.getIdEstadio());
                silla.setEstadio(estadio);
            }
            List<Tiquete> attachedTiqueteList = new ArrayList<Tiquete>();
            for (Tiquete tiqueteListTiqueteToAttach : silla.getTiqueteList()) {
                tiqueteListTiqueteToAttach = em.getReference(tiqueteListTiqueteToAttach.getClass(), tiqueteListTiqueteToAttach.getIdCliente());
                attachedTiqueteList.add(tiqueteListTiqueteToAttach);
            }
            silla.setTiqueteList(attachedTiqueteList);
            List<Categoria> attachedCategoriaList = new ArrayList<Categoria>();
            for (Categoria categoriaListCategoriaToAttach : silla.getCategoriaList()) {
                categoriaListCategoriaToAttach = em.getReference(categoriaListCategoriaToAttach.getClass(), categoriaListCategoriaToAttach.getCategoriaPK());
                attachedCategoriaList.add(categoriaListCategoriaToAttach);
            }
            silla.setCategoriaList(attachedCategoriaList);
            em.persist(silla);
            if (estadio != null) {
                estadio.getSillaList().add(silla);
                estadio = em.merge(estadio);
            }
            for (Tiquete tiqueteListTiquete : silla.getTiqueteList()) {
                Silla oldSillaOfTiqueteListTiquete = tiqueteListTiquete.getSilla();
                tiqueteListTiquete.setSilla(silla);
                tiqueteListTiquete = em.merge(tiqueteListTiquete);
                if (oldSillaOfTiqueteListTiquete != null) {
                    oldSillaOfTiqueteListTiquete.getTiqueteList().remove(tiqueteListTiquete);
                    oldSillaOfTiqueteListTiquete = em.merge(oldSillaOfTiqueteListTiquete);
                }
            }
            for (Categoria categoriaListCategoria : silla.getCategoriaList()) {
                Silla oldSillaOfCategoriaListCategoria = categoriaListCategoria.getSilla();
                categoriaListCategoria.setSilla(silla);
                categoriaListCategoria = em.merge(categoriaListCategoria);
                if (oldSillaOfCategoriaListCategoria != null) {
                    oldSillaOfCategoriaListCategoria.getCategoriaList().remove(categoriaListCategoria);
                    oldSillaOfCategoriaListCategoria = em.merge(oldSillaOfCategoriaListCategoria);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSilla(silla.getSillaPK()) != null) {
                throw new PreexistingEntityException("Silla " + silla + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Silla silla) throws IllegalOrphanException, NonexistentEntityException, Exception {
        silla.getSillaPK().setIdEstadio(silla.getEstadio().getIdEstadio());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Silla persistentSilla = em.find(Silla.class, silla.getSillaPK());
            Estadio estadioOld = persistentSilla.getEstadio();
            Estadio estadioNew = silla.getEstadio();
            List<Tiquete> tiqueteListOld = persistentSilla.getTiqueteList();
            List<Tiquete> tiqueteListNew = silla.getTiqueteList();
            List<Categoria> categoriaListOld = persistentSilla.getCategoriaList();
            List<Categoria> categoriaListNew = silla.getCategoriaList();
            List<String> illegalOrphanMessages = null;
            for (Categoria categoriaListOldCategoria : categoriaListOld) {
                if (!categoriaListNew.contains(categoriaListOldCategoria)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Categoria " + categoriaListOldCategoria + " since its silla field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (estadioNew != null) {
                estadioNew = em.getReference(estadioNew.getClass(), estadioNew.getIdEstadio());
                silla.setEstadio(estadioNew);
            }
            List<Tiquete> attachedTiqueteListNew = new ArrayList<Tiquete>();
            for (Tiquete tiqueteListNewTiqueteToAttach : tiqueteListNew) {
                tiqueteListNewTiqueteToAttach = em.getReference(tiqueteListNewTiqueteToAttach.getClass(), tiqueteListNewTiqueteToAttach.getIdCliente());
                attachedTiqueteListNew.add(tiqueteListNewTiqueteToAttach);
            }
            tiqueteListNew = attachedTiqueteListNew;
            silla.setTiqueteList(tiqueteListNew);
            List<Categoria> attachedCategoriaListNew = new ArrayList<Categoria>();
            for (Categoria categoriaListNewCategoriaToAttach : categoriaListNew) {
                categoriaListNewCategoriaToAttach = em.getReference(categoriaListNewCategoriaToAttach.getClass(), categoriaListNewCategoriaToAttach.getCategoriaPK());
                attachedCategoriaListNew.add(categoriaListNewCategoriaToAttach);
            }
            categoriaListNew = attachedCategoriaListNew;
            silla.setCategoriaList(categoriaListNew);
            silla = em.merge(silla);
            if (estadioOld != null && !estadioOld.equals(estadioNew)) {
                estadioOld.getSillaList().remove(silla);
                estadioOld = em.merge(estadioOld);
            }
            if (estadioNew != null && !estadioNew.equals(estadioOld)) {
                estadioNew.getSillaList().add(silla);
                estadioNew = em.merge(estadioNew);
            }
            for (Tiquete tiqueteListOldTiquete : tiqueteListOld) {
                if (!tiqueteListNew.contains(tiqueteListOldTiquete)) {
                    tiqueteListOldTiquete.setSilla(null);
                    tiqueteListOldTiquete = em.merge(tiqueteListOldTiquete);
                }
            }
            for (Tiquete tiqueteListNewTiquete : tiqueteListNew) {
                if (!tiqueteListOld.contains(tiqueteListNewTiquete)) {
                    Silla oldSillaOfTiqueteListNewTiquete = tiqueteListNewTiquete.getSilla();
                    tiqueteListNewTiquete.setSilla(silla);
                    tiqueteListNewTiquete = em.merge(tiqueteListNewTiquete);
                    if (oldSillaOfTiqueteListNewTiquete != null && !oldSillaOfTiqueteListNewTiquete.equals(silla)) {
                        oldSillaOfTiqueteListNewTiquete.getTiqueteList().remove(tiqueteListNewTiquete);
                        oldSillaOfTiqueteListNewTiquete = em.merge(oldSillaOfTiqueteListNewTiquete);
                    }
                }
            }
            for (Categoria categoriaListNewCategoria : categoriaListNew) {
                if (!categoriaListOld.contains(categoriaListNewCategoria)) {
                    Silla oldSillaOfCategoriaListNewCategoria = categoriaListNewCategoria.getSilla();
                    categoriaListNewCategoria.setSilla(silla);
                    categoriaListNewCategoria = em.merge(categoriaListNewCategoria);
                    if (oldSillaOfCategoriaListNewCategoria != null && !oldSillaOfCategoriaListNewCategoria.equals(silla)) {
                        oldSillaOfCategoriaListNewCategoria.getCategoriaList().remove(categoriaListNewCategoria);
                        oldSillaOfCategoriaListNewCategoria = em.merge(oldSillaOfCategoriaListNewCategoria);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                SillaPK id = silla.getSillaPK();
                if (findSilla(id) == null) {
                    throw new NonexistentEntityException("The silla with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(SillaPK id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Silla silla;
            try {
                silla = em.getReference(Silla.class, id);
                silla.getSillaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The silla with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Categoria> categoriaListOrphanCheck = silla.getCategoriaList();
            for (Categoria categoriaListOrphanCheckCategoria : categoriaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Silla (" + silla + ") cannot be destroyed since the Categoria " + categoriaListOrphanCheckCategoria + " in its categoriaList field has a non-nullable silla field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Estadio estadio = silla.getEstadio();
            if (estadio != null) {
                estadio.getSillaList().remove(silla);
                estadio = em.merge(estadio);
            }
            List<Tiquete> tiqueteList = silla.getTiqueteList();
            for (Tiquete tiqueteListTiquete : tiqueteList) {
                tiqueteListTiquete.setSilla(null);
                tiqueteListTiquete = em.merge(tiqueteListTiquete);
            }
            em.remove(silla);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Silla> findSillaEntities() {
        return findSillaEntities(true, -1, -1);
    }

    public List<Silla> findSillaEntities(int maxResults, int firstResult) {
        return findSillaEntities(false, maxResults, firstResult);
    }

    private List<Silla> findSillaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Silla.class));
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

    public Silla findSilla(SillaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Silla.class, id);
        } finally {
            em.close();
        }
    }

    public int getSillaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Silla> rt = cq.from(Silla.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
