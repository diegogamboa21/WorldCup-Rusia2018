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
import rusia2018.Equipo;
import rusia2018.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rusia2018.Auxiliar;

/**
 *
 * @author Diego Gamboa
 */
public class AuxiliarJpaController implements Serializable {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Rusia2018PU");
    
    public AuxiliarJpaController() {
    
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Auxiliar auxiliar) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        Persona personaOrphanCheck = auxiliar.getPersona();
        if (personaOrphanCheck != null) {
            Auxiliar oldAuxiliarOfPersona = personaOrphanCheck.getAuxiliar();
            if (oldAuxiliarOfPersona != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Persona " + personaOrphanCheck + " already has an item of type Auxiliar whose persona column cannot be null. Please make another selection for the persona field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Equipo idEquipo = auxiliar.getIdEquipo();
            if (idEquipo != null) {
                idEquipo = em.getReference(idEquipo.getClass(), idEquipo.getIdEquipo());
                auxiliar.setIdEquipo(idEquipo);
            }
            Persona persona = auxiliar.getPersona();
            if (persona != null) {
                persona = em.getReference(persona.getClass(), persona.getIdPersona());
                auxiliar.setPersona(persona);
            }
            em.persist(auxiliar);
            if (idEquipo != null) {
                idEquipo.getAuxiliarList().add(auxiliar);
                idEquipo = em.merge(idEquipo);
            }
            if (persona != null) {
                persona.setAuxiliar(auxiliar);
                persona = em.merge(persona);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAuxiliar(auxiliar.getIdPersona()) != null) {
                throw new PreexistingEntityException("Auxiliar " + auxiliar + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Auxiliar auxiliar) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Auxiliar persistentAuxiliar = em.find(Auxiliar.class, auxiliar.getIdPersona());
            Equipo idEquipoOld = persistentAuxiliar.getIdEquipo();
            Equipo idEquipoNew = auxiliar.getIdEquipo();
            Persona personaOld = persistentAuxiliar.getPersona();
            Persona personaNew = auxiliar.getPersona();
            List<String> illegalOrphanMessages = null;
            if (personaNew != null && !personaNew.equals(personaOld)) {
                Auxiliar oldAuxiliarOfPersona = personaNew.getAuxiliar();
                if (oldAuxiliarOfPersona != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Persona " + personaNew + " already has an item of type Auxiliar whose persona column cannot be null. Please make another selection for the persona field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idEquipoNew != null) {
                idEquipoNew = em.getReference(idEquipoNew.getClass(), idEquipoNew.getIdEquipo());
                auxiliar.setIdEquipo(idEquipoNew);
            }
            if (personaNew != null) {
                personaNew = em.getReference(personaNew.getClass(), personaNew.getIdPersona());
                auxiliar.setPersona(personaNew);
            }
            auxiliar = em.merge(auxiliar);
            if (idEquipoOld != null && !idEquipoOld.equals(idEquipoNew)) {
                idEquipoOld.getAuxiliarList().remove(auxiliar);
                idEquipoOld = em.merge(idEquipoOld);
            }
            if (idEquipoNew != null && !idEquipoNew.equals(idEquipoOld)) {
                idEquipoNew.getAuxiliarList().add(auxiliar);
                idEquipoNew = em.merge(idEquipoNew);
            }
            if (personaOld != null && !personaOld.equals(personaNew)) {
                personaOld.setAuxiliar(null);
                personaOld = em.merge(personaOld);
            }
            if (personaNew != null && !personaNew.equals(personaOld)) {
                personaNew.setAuxiliar(auxiliar);
                personaNew = em.merge(personaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigInteger id = auxiliar.getIdPersona();
                if (findAuxiliar(id) == null) {
                    throw new NonexistentEntityException("The auxiliar with id " + id + " no longer exists.");
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
            Auxiliar auxiliar;
            try {
                auxiliar = em.getReference(Auxiliar.class, id);
                auxiliar.getIdPersona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The auxiliar with id " + id + " no longer exists.", enfe);
            }
            Equipo idEquipo = auxiliar.getIdEquipo();
            if (idEquipo != null) {
                idEquipo.getAuxiliarList().remove(auxiliar);
                idEquipo = em.merge(idEquipo);
            }
            Persona persona = auxiliar.getPersona();
            if (persona != null) {
                persona.setAuxiliar(null);
                persona = em.merge(persona);
            }
            em.remove(auxiliar);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Auxiliar> findAuxiliarEntities() {
        return findAuxiliarEntities(true, -1, -1);
    }

    public List<Auxiliar> findAuxiliarEntities(int maxResults, int firstResult) {
        return findAuxiliarEntities(false, maxResults, firstResult);
    }

    private List<Auxiliar> findAuxiliarEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Auxiliar.class));
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

    public Auxiliar findAuxiliar(BigInteger id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Auxiliar.class, id);
        } finally {
            em.close();
        }
    }

    public int getAuxiliarCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Auxiliar> rt = cq.from(Auxiliar.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
