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
import rusia2018.Grupo;
import rusia2018.Jugador;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rusia2018.Auxiliar;
import rusia2018.Partido;
import rusia2018.Director;
import rusia2018.Equipo;

/**
 *
 * @author Diego Gamboa
 */
public class EquipoJpaController implements Serializable {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Rusia2018PU");
    public EquipoJpaController() {
    
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Equipo equipo) throws PreexistingEntityException, Exception {
        if (equipo.getJugadorList() == null) {
            equipo.setJugadorList(new ArrayList<Jugador>());
        }
        if (equipo.getAuxiliarList() == null) {
            equipo.setAuxiliarList(new ArrayList<Auxiliar>());
        }
        if (equipo.getPartidoList() == null) {
            equipo.setPartidoList(new ArrayList<Partido>());
        }
        if (equipo.getPartidoList1() == null) {
            equipo.setPartidoList1(new ArrayList<Partido>());
        }
        if (equipo.getDirectorList() == null) {
            equipo.setDirectorList(new ArrayList<Director>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Grupo grupo = equipo.getGrupo();
            if (grupo != null) {
                grupo = em.getReference(grupo.getClass(), grupo.getGrupoPK());
                equipo.setGrupo(grupo);
            }
            List<Jugador> attachedJugadorList = new ArrayList<Jugador>();
            for (Jugador jugadorListJugadorToAttach : equipo.getJugadorList()) {
                jugadorListJugadorToAttach = em.getReference(jugadorListJugadorToAttach.getClass(), jugadorListJugadorToAttach.getIdPersona());
                attachedJugadorList.add(jugadorListJugadorToAttach);
            }
            equipo.setJugadorList(attachedJugadorList);
            List<Auxiliar> attachedAuxiliarList = new ArrayList<Auxiliar>();
            for (Auxiliar auxiliarListAuxiliarToAttach : equipo.getAuxiliarList()) {
                auxiliarListAuxiliarToAttach = em.getReference(auxiliarListAuxiliarToAttach.getClass(), auxiliarListAuxiliarToAttach.getIdPersona());
                attachedAuxiliarList.add(auxiliarListAuxiliarToAttach);
            }
            equipo.setAuxiliarList(attachedAuxiliarList);
            List<Partido> attachedPartidoList = new ArrayList<Partido>();
            for (Partido partidoListPartidoToAttach : equipo.getPartidoList()) {
                partidoListPartidoToAttach = em.getReference(partidoListPartidoToAttach.getClass(), partidoListPartidoToAttach.getIdPartido());
                attachedPartidoList.add(partidoListPartidoToAttach);
            }
            equipo.setPartidoList(attachedPartidoList);
            List<Partido> attachedPartidoList1 = new ArrayList<Partido>();
            for (Partido partidoList1PartidoToAttach : equipo.getPartidoList1()) {
                partidoList1PartidoToAttach = em.getReference(partidoList1PartidoToAttach.getClass(), partidoList1PartidoToAttach.getIdPartido());
                attachedPartidoList1.add(partidoList1PartidoToAttach);
            }
            equipo.setPartidoList1(attachedPartidoList1);
            List<Director> attachedDirectorList = new ArrayList<Director>();
            for (Director directorListDirectorToAttach : equipo.getDirectorList()) {
                directorListDirectorToAttach = em.getReference(directorListDirectorToAttach.getClass(), directorListDirectorToAttach.getIdDirector());
                attachedDirectorList.add(directorListDirectorToAttach);
            }
            equipo.setDirectorList(attachedDirectorList);
            em.persist(equipo);
            if (grupo != null) {
                grupo.getEquipoList().add(equipo);
                grupo = em.merge(grupo);
            }
            for (Jugador jugadorListJugador : equipo.getJugadorList()) {
                Equipo oldIdEquipoOfJugadorListJugador = jugadorListJugador.getIdEquipo();
                jugadorListJugador.setIdEquipo(equipo);
                jugadorListJugador = em.merge(jugadorListJugador);
                if (oldIdEquipoOfJugadorListJugador != null) {
                    oldIdEquipoOfJugadorListJugador.getJugadorList().remove(jugadorListJugador);
                    oldIdEquipoOfJugadorListJugador = em.merge(oldIdEquipoOfJugadorListJugador);
                }
            }
            for (Auxiliar auxiliarListAuxiliar : equipo.getAuxiliarList()) {
                Equipo oldIdEquipoOfAuxiliarListAuxiliar = auxiliarListAuxiliar.getIdEquipo();
                auxiliarListAuxiliar.setIdEquipo(equipo);
                auxiliarListAuxiliar = em.merge(auxiliarListAuxiliar);
                if (oldIdEquipoOfAuxiliarListAuxiliar != null) {
                    oldIdEquipoOfAuxiliarListAuxiliar.getAuxiliarList().remove(auxiliarListAuxiliar);
                    oldIdEquipoOfAuxiliarListAuxiliar = em.merge(oldIdEquipoOfAuxiliarListAuxiliar);
                }
            }
            for (Partido partidoListPartido : equipo.getPartidoList()) {
                Equipo oldIdLocalOfPartidoListPartido = partidoListPartido.getIdLocal();
                partidoListPartido.setIdLocal(equipo);
                partidoListPartido = em.merge(partidoListPartido);
                if (oldIdLocalOfPartidoListPartido != null) {
                    oldIdLocalOfPartidoListPartido.getPartidoList().remove(partidoListPartido);
                    oldIdLocalOfPartidoListPartido = em.merge(oldIdLocalOfPartidoListPartido);
                }
            }
            for (Partido partidoList1Partido : equipo.getPartidoList1()) {
                Equipo oldIdVisitanteOfPartidoList1Partido = partidoList1Partido.getIdVisitante();
                partidoList1Partido.setIdVisitante(equipo);
                partidoList1Partido = em.merge(partidoList1Partido);
                if (oldIdVisitanteOfPartidoList1Partido != null) {
                    oldIdVisitanteOfPartidoList1Partido.getPartidoList1().remove(partidoList1Partido);
                    oldIdVisitanteOfPartidoList1Partido = em.merge(oldIdVisitanteOfPartidoList1Partido);
                }
            }
            for (Director directorListDirector : equipo.getDirectorList()) {
                Equipo oldIdEquipoOfDirectorListDirector = directorListDirector.getIdEquipo();
                directorListDirector.setIdEquipo(equipo);
                directorListDirector = em.merge(directorListDirector);
                if (oldIdEquipoOfDirectorListDirector != null) {
                    oldIdEquipoOfDirectorListDirector.getDirectorList().remove(directorListDirector);
                    oldIdEquipoOfDirectorListDirector = em.merge(oldIdEquipoOfDirectorListDirector);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEquipo(equipo.getIdEquipo()) != null) {
                throw new PreexistingEntityException("Equipo " + equipo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Equipo equipo) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Equipo persistentEquipo = em.find(Equipo.class, equipo.getIdEquipo());
            Grupo grupoOld = persistentEquipo.getGrupo();
            Grupo grupoNew = equipo.getGrupo();
            List<Jugador> jugadorListOld = persistentEquipo.getJugadorList();
            List<Jugador> jugadorListNew = equipo.getJugadorList();
            List<Auxiliar> auxiliarListOld = persistentEquipo.getAuxiliarList();
            List<Auxiliar> auxiliarListNew = equipo.getAuxiliarList();
            List<Partido> partidoListOld = persistentEquipo.getPartidoList();
            List<Partido> partidoListNew = equipo.getPartidoList();
            List<Partido> partidoList1Old = persistentEquipo.getPartidoList1();
            List<Partido> partidoList1New = equipo.getPartidoList1();
            List<Director> directorListOld = persistentEquipo.getDirectorList();
            List<Director> directorListNew = equipo.getDirectorList();
            List<String> illegalOrphanMessages = null;
            for (Jugador jugadorListOldJugador : jugadorListOld) {
                if (!jugadorListNew.contains(jugadorListOldJugador)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Jugador " + jugadorListOldJugador + " since its idEquipo field is not nullable.");
                }
            }
            for (Auxiliar auxiliarListOldAuxiliar : auxiliarListOld) {
                if (!auxiliarListNew.contains(auxiliarListOldAuxiliar)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Auxiliar " + auxiliarListOldAuxiliar + " since its idEquipo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (grupoNew != null) {
                grupoNew = em.getReference(grupoNew.getClass(), grupoNew.getGrupoPK());
                equipo.setGrupo(grupoNew);
            }
            List<Jugador> attachedJugadorListNew = new ArrayList<Jugador>();
            for (Jugador jugadorListNewJugadorToAttach : jugadorListNew) {
                jugadorListNewJugadorToAttach = em.getReference(jugadorListNewJugadorToAttach.getClass(), jugadorListNewJugadorToAttach.getIdPersona());
                attachedJugadorListNew.add(jugadorListNewJugadorToAttach);
            }
            jugadorListNew = attachedJugadorListNew;
            equipo.setJugadorList(jugadorListNew);
            List<Auxiliar> attachedAuxiliarListNew = new ArrayList<Auxiliar>();
            for (Auxiliar auxiliarListNewAuxiliarToAttach : auxiliarListNew) {
                auxiliarListNewAuxiliarToAttach = em.getReference(auxiliarListNewAuxiliarToAttach.getClass(), auxiliarListNewAuxiliarToAttach.getIdPersona());
                attachedAuxiliarListNew.add(auxiliarListNewAuxiliarToAttach);
            }
            auxiliarListNew = attachedAuxiliarListNew;
            equipo.setAuxiliarList(auxiliarListNew);
            List<Partido> attachedPartidoListNew = new ArrayList<Partido>();
            for (Partido partidoListNewPartidoToAttach : partidoListNew) {
                partidoListNewPartidoToAttach = em.getReference(partidoListNewPartidoToAttach.getClass(), partidoListNewPartidoToAttach.getIdPartido());
                attachedPartidoListNew.add(partidoListNewPartidoToAttach);
            }
            partidoListNew = attachedPartidoListNew;
            equipo.setPartidoList(partidoListNew);
            List<Partido> attachedPartidoList1New = new ArrayList<Partido>();
            for (Partido partidoList1NewPartidoToAttach : partidoList1New) {
                partidoList1NewPartidoToAttach = em.getReference(partidoList1NewPartidoToAttach.getClass(), partidoList1NewPartidoToAttach.getIdPartido());
                attachedPartidoList1New.add(partidoList1NewPartidoToAttach);
            }
            partidoList1New = attachedPartidoList1New;
            equipo.setPartidoList1(partidoList1New);
            List<Director> attachedDirectorListNew = new ArrayList<Director>();
            for (Director directorListNewDirectorToAttach : directorListNew) {
                directorListNewDirectorToAttach = em.getReference(directorListNewDirectorToAttach.getClass(), directorListNewDirectorToAttach.getIdDirector());
                attachedDirectorListNew.add(directorListNewDirectorToAttach);
            }
            directorListNew = attachedDirectorListNew;
            equipo.setDirectorList(directorListNew);
            equipo = em.merge(equipo);
            if (grupoOld != null && !grupoOld.equals(grupoNew)) {
                grupoOld.getEquipoList().remove(equipo);
                grupoOld = em.merge(grupoOld);
            }
            if (grupoNew != null && !grupoNew.equals(grupoOld)) {
                grupoNew.getEquipoList().add(equipo);
                grupoNew = em.merge(grupoNew);
            }
            for (Jugador jugadorListNewJugador : jugadorListNew) {
                if (!jugadorListOld.contains(jugadorListNewJugador)) {
                    Equipo oldIdEquipoOfJugadorListNewJugador = jugadorListNewJugador.getIdEquipo();
                    jugadorListNewJugador.setIdEquipo(equipo);
                    jugadorListNewJugador = em.merge(jugadorListNewJugador);
                    if (oldIdEquipoOfJugadorListNewJugador != null && !oldIdEquipoOfJugadorListNewJugador.equals(equipo)) {
                        oldIdEquipoOfJugadorListNewJugador.getJugadorList().remove(jugadorListNewJugador);
                        oldIdEquipoOfJugadorListNewJugador = em.merge(oldIdEquipoOfJugadorListNewJugador);
                    }
                }
            }
            for (Auxiliar auxiliarListNewAuxiliar : auxiliarListNew) {
                if (!auxiliarListOld.contains(auxiliarListNewAuxiliar)) {
                    Equipo oldIdEquipoOfAuxiliarListNewAuxiliar = auxiliarListNewAuxiliar.getIdEquipo();
                    auxiliarListNewAuxiliar.setIdEquipo(equipo);
                    auxiliarListNewAuxiliar = em.merge(auxiliarListNewAuxiliar);
                    if (oldIdEquipoOfAuxiliarListNewAuxiliar != null && !oldIdEquipoOfAuxiliarListNewAuxiliar.equals(equipo)) {
                        oldIdEquipoOfAuxiliarListNewAuxiliar.getAuxiliarList().remove(auxiliarListNewAuxiliar);
                        oldIdEquipoOfAuxiliarListNewAuxiliar = em.merge(oldIdEquipoOfAuxiliarListNewAuxiliar);
                    }
                }
            }
            for (Partido partidoListOldPartido : partidoListOld) {
                if (!partidoListNew.contains(partidoListOldPartido)) {
                    partidoListOldPartido.setIdLocal(null);
                    partidoListOldPartido = em.merge(partidoListOldPartido);
                }
            }
            for (Partido partidoListNewPartido : partidoListNew) {
                if (!partidoListOld.contains(partidoListNewPartido)) {
                    Equipo oldIdLocalOfPartidoListNewPartido = partidoListNewPartido.getIdLocal();
                    partidoListNewPartido.setIdLocal(equipo);
                    partidoListNewPartido = em.merge(partidoListNewPartido);
                    if (oldIdLocalOfPartidoListNewPartido != null && !oldIdLocalOfPartidoListNewPartido.equals(equipo)) {
                        oldIdLocalOfPartidoListNewPartido.getPartidoList().remove(partidoListNewPartido);
                        oldIdLocalOfPartidoListNewPartido = em.merge(oldIdLocalOfPartidoListNewPartido);
                    }
                }
            }
            for (Partido partidoList1OldPartido : partidoList1Old) {
                if (!partidoList1New.contains(partidoList1OldPartido)) {
                    partidoList1OldPartido.setIdVisitante(null);
                    partidoList1OldPartido = em.merge(partidoList1OldPartido);
                }
            }
            for (Partido partidoList1NewPartido : partidoList1New) {
                if (!partidoList1Old.contains(partidoList1NewPartido)) {
                    Equipo oldIdVisitanteOfPartidoList1NewPartido = partidoList1NewPartido.getIdVisitante();
                    partidoList1NewPartido.setIdVisitante(equipo);
                    partidoList1NewPartido = em.merge(partidoList1NewPartido);
                    if (oldIdVisitanteOfPartidoList1NewPartido != null && !oldIdVisitanteOfPartidoList1NewPartido.equals(equipo)) {
                        oldIdVisitanteOfPartidoList1NewPartido.getPartidoList1().remove(partidoList1NewPartido);
                        oldIdVisitanteOfPartidoList1NewPartido = em.merge(oldIdVisitanteOfPartidoList1NewPartido);
                    }
                }
            }
            for (Director directorListOldDirector : directorListOld) {
                if (!directorListNew.contains(directorListOldDirector)) {
                    directorListOldDirector.setIdEquipo(null);
                    directorListOldDirector = em.merge(directorListOldDirector);
                }
            }
            for (Director directorListNewDirector : directorListNew) {
                if (!directorListOld.contains(directorListNewDirector)) {
                    Equipo oldIdEquipoOfDirectorListNewDirector = directorListNewDirector.getIdEquipo();
                    directorListNewDirector.setIdEquipo(equipo);
                    directorListNewDirector = em.merge(directorListNewDirector);
                    if (oldIdEquipoOfDirectorListNewDirector != null && !oldIdEquipoOfDirectorListNewDirector.equals(equipo)) {
                        oldIdEquipoOfDirectorListNewDirector.getDirectorList().remove(directorListNewDirector);
                        oldIdEquipoOfDirectorListNewDirector = em.merge(oldIdEquipoOfDirectorListNewDirector);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigInteger id = equipo.getIdEquipo();
                if (findEquipo(id) == null) {
                    throw new NonexistentEntityException("The equipo with id " + id + " no longer exists.");
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
            Equipo equipo;
            try {
                equipo = em.getReference(Equipo.class, id);
                equipo.getIdEquipo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The equipo with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Jugador> jugadorListOrphanCheck = equipo.getJugadorList();
            for (Jugador jugadorListOrphanCheckJugador : jugadorListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Equipo (" + equipo + ") cannot be destroyed since the Jugador " + jugadorListOrphanCheckJugador + " in its jugadorList field has a non-nullable idEquipo field.");
            }
            List<Auxiliar> auxiliarListOrphanCheck = equipo.getAuxiliarList();
            for (Auxiliar auxiliarListOrphanCheckAuxiliar : auxiliarListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Equipo (" + equipo + ") cannot be destroyed since the Auxiliar " + auxiliarListOrphanCheckAuxiliar + " in its auxiliarList field has a non-nullable idEquipo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Grupo grupo = equipo.getGrupo();
            if (grupo != null) {
                grupo.getEquipoList().remove(equipo);
                grupo = em.merge(grupo);
            }
            List<Partido> partidoList = equipo.getPartidoList();
            for (Partido partidoListPartido : partidoList) {
                partidoListPartido.setIdLocal(null);
                partidoListPartido = em.merge(partidoListPartido);
            }
            List<Partido> partidoList1 = equipo.getPartidoList1();
            for (Partido partidoList1Partido : partidoList1) {
                partidoList1Partido.setIdVisitante(null);
                partidoList1Partido = em.merge(partidoList1Partido);
            }
            List<Director> directorList = equipo.getDirectorList();
            for (Director directorListDirector : directorList) {
                directorListDirector.setIdEquipo(null);
                directorListDirector = em.merge(directorListDirector);
            }
            em.remove(equipo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Equipo> findEquipoEntities() {
        return findEquipoEntities(true, -1, -1);
    }

    public List<Equipo> findEquipoEntities(int maxResults, int firstResult) {
        return findEquipoEntities(false, maxResults, firstResult);
    }

    private List<Equipo> findEquipoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Equipo.class));
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

    public Equipo findEquipo(BigInteger id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Equipo.class, id);
        } finally {
            em.close();
        }
    }

    public int getEquipoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Equipo> rt = cq.from(Equipo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
