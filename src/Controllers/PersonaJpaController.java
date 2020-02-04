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
import rusia2018.Jugador;
import rusia2018.Auxiliar;
import rusia2018.Director;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rusia2018.Persona;

/**
 *
 * @author Diego Gamboa
 */
public class PersonaJpaController implements Serializable {

    public PersonaJpaController() {
        
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Rusia2018PU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Persona persona) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Jugador jugador = persona.getJugador();
            if (jugador != null) {
                jugador = em.getReference(jugador.getClass(), jugador.getIdPersona());
                persona.setJugador(jugador);
            }
            Auxiliar auxiliar = persona.getAuxiliar();
            if (auxiliar != null) {
                auxiliar = em.getReference(auxiliar.getClass(), auxiliar.getIdPersona());
                persona.setAuxiliar(auxiliar);
            }
            Director director = persona.getDirector();
            if (director != null) {
                director = em.getReference(director.getClass(), director.getIdDirector());
                persona.setDirector(director);
            }
            em.persist(persona);
            if (jugador != null) {
                Persona oldPersonaOfJugador = jugador.getPersona();
                if (oldPersonaOfJugador != null) {
                    oldPersonaOfJugador.setJugador(null);
                    oldPersonaOfJugador = em.merge(oldPersonaOfJugador);
                }
                jugador.setPersona(persona);
                jugador = em.merge(jugador);
            }
            if (auxiliar != null) {
                Persona oldPersonaOfAuxiliar = auxiliar.getPersona();
                if (oldPersonaOfAuxiliar != null) {
                    oldPersonaOfAuxiliar.setAuxiliar(null);
                    oldPersonaOfAuxiliar = em.merge(oldPersonaOfAuxiliar);
                }
                auxiliar.setPersona(persona);
                auxiliar = em.merge(auxiliar);
            }
            if (director != null) {
                Persona oldPersonaOfDirector = director.getPersona();
                if (oldPersonaOfDirector != null) {
                    oldPersonaOfDirector.setDirector(null);
                    oldPersonaOfDirector = em.merge(oldPersonaOfDirector);
                }
                director.setPersona(persona);
                director = em.merge(director);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPersona(persona.getIdPersona()) != null) {
                throw new PreexistingEntityException("Persona " + persona + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Persona persona) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona persistentPersona = em.find(Persona.class, persona.getIdPersona());
            Jugador jugadorOld = persistentPersona.getJugador();
            Jugador jugadorNew = persona.getJugador();
            Auxiliar auxiliarOld = persistentPersona.getAuxiliar();
            Auxiliar auxiliarNew = persona.getAuxiliar();
            Director directorOld = persistentPersona.getDirector();
            Director directorNew = persona.getDirector();
            List<String> illegalOrphanMessages = null;
            if (jugadorOld != null && !jugadorOld.equals(jugadorNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Jugador " + jugadorOld + " since its persona field is not nullable.");
            }
            if (auxiliarOld != null && !auxiliarOld.equals(auxiliarNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Auxiliar " + auxiliarOld + " since its persona field is not nullable.");
            }
            if (directorOld != null && !directorOld.equals(directorNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Director " + directorOld + " since its persona field is not nullable.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (jugadorNew != null) {
                jugadorNew = em.getReference(jugadorNew.getClass(), jugadorNew.getIdPersona());
                persona.setJugador(jugadorNew);
            }
            if (auxiliarNew != null) {
                auxiliarNew = em.getReference(auxiliarNew.getClass(), auxiliarNew.getIdPersona());
                persona.setAuxiliar(auxiliarNew);
            }
            if (directorNew != null) {
                directorNew = em.getReference(directorNew.getClass(), directorNew.getIdDirector());
                persona.setDirector(directorNew);
            }
            persona = em.merge(persona);
            if (jugadorNew != null && !jugadorNew.equals(jugadorOld)) {
                Persona oldPersonaOfJugador = jugadorNew.getPersona();
                if (oldPersonaOfJugador != null) {
                    oldPersonaOfJugador.setJugador(null);
                    oldPersonaOfJugador = em.merge(oldPersonaOfJugador);
                }
                jugadorNew.setPersona(persona);
                jugadorNew = em.merge(jugadorNew);
            }
            if (auxiliarNew != null && !auxiliarNew.equals(auxiliarOld)) {
                Persona oldPersonaOfAuxiliar = auxiliarNew.getPersona();
                if (oldPersonaOfAuxiliar != null) {
                    oldPersonaOfAuxiliar.setAuxiliar(null);
                    oldPersonaOfAuxiliar = em.merge(oldPersonaOfAuxiliar);
                }
                auxiliarNew.setPersona(persona);
                auxiliarNew = em.merge(auxiliarNew);
            }
            if (directorNew != null && !directorNew.equals(directorOld)) {
                Persona oldPersonaOfDirector = directorNew.getPersona();
                if (oldPersonaOfDirector != null) {
                    oldPersonaOfDirector.setDirector(null);
                    oldPersonaOfDirector = em.merge(oldPersonaOfDirector);
                }
                directorNew.setPersona(persona);
                directorNew = em.merge(directorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigInteger id = persona.getIdPersona();
                if (findPersona(id) == null) {
                    throw new NonexistentEntityException("The persona with id " + id + " no longer exists.");
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
            Persona persona;
            try {
                persona = em.getReference(Persona.class, id);
                persona.getIdPersona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The persona with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Jugador jugadorOrphanCheck = persona.getJugador();
            if (jugadorOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Persona (" + persona + ") cannot be destroyed since the Jugador " + jugadorOrphanCheck + " in its jugador field has a non-nullable persona field.");
            }
            Auxiliar auxiliarOrphanCheck = persona.getAuxiliar();
            if (auxiliarOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Persona (" + persona + ") cannot be destroyed since the Auxiliar " + auxiliarOrphanCheck + " in its auxiliar field has a non-nullable persona field.");
            }
            Director directorOrphanCheck = persona.getDirector();
            if (directorOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Persona (" + persona + ") cannot be destroyed since the Director " + directorOrphanCheck + " in its director field has a non-nullable persona field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(persona);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Persona> findPersonaEntities() {
        return findPersonaEntities(true, -1, -1);
    }

    public List<Persona> findPersonaEntities(int maxResults, int firstResult) {
        return findPersonaEntities(false, maxResults, firstResult);
    }

    private List<Persona> findPersonaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Persona.class));
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

    public Persona findPersona(BigInteger id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Persona.class, id);
        } finally {
            em.close();
        }
    }

    public int getPersonaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Persona> rt = cq.from(Persona.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
