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
import rusia2018.Clubes;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rusia2018.Tarjeta;
import rusia2018.Goles;
import rusia2018.Jugador;

/**
 *
 * @author Diego Gamboa
 */
public class JugadorJpaController implements Serializable {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Rusia2018PU");
    public JugadorJpaController() {
        
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Jugador jugador) throws IllegalOrphanException, PreexistingEntityException, Exception {
        if (jugador.getClubesList() == null) {
            jugador.setClubesList(new ArrayList<Clubes>());
        }
        if (jugador.getTarjetaList() == null) {
            jugador.setTarjetaList(new ArrayList<Tarjeta>());
        }
        if (jugador.getGolesList() == null) {
            jugador.setGolesList(new ArrayList<Goles>());
        }
        List<String> illegalOrphanMessages = null;
        Persona personaOrphanCheck = jugador.getPersona();
        if (personaOrphanCheck != null) {
            Jugador oldJugadorOfPersona = personaOrphanCheck.getJugador();
            if (oldJugadorOfPersona != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Persona " + personaOrphanCheck + " already has an item of type Jugador whose persona column cannot be null. Please make another selection for the persona field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Equipo idEquipo = jugador.getIdEquipo();
            if (idEquipo != null) {
                idEquipo = em.getReference(idEquipo.getClass(), idEquipo.getIdEquipo());
                jugador.setIdEquipo(idEquipo);
            }
            Persona persona = jugador.getPersona();
            if (persona != null) {
                persona = em.getReference(persona.getClass(), persona.getIdPersona());
                jugador.setPersona(persona);
            }
            List<Clubes> attachedClubesList = new ArrayList<Clubes>();
            for (Clubes clubesListClubesToAttach : jugador.getClubesList()) {
                clubesListClubesToAttach = em.getReference(clubesListClubesToAttach.getClass(), clubesListClubesToAttach.getIdClub());
                attachedClubesList.add(clubesListClubesToAttach);
            }
            jugador.setClubesList(attachedClubesList);
            List<Tarjeta> attachedTarjetaList = new ArrayList<Tarjeta>();
            for (Tarjeta tarjetaListTarjetaToAttach : jugador.getTarjetaList()) {
                tarjetaListTarjetaToAttach = em.getReference(tarjetaListTarjetaToAttach.getClass(), tarjetaListTarjetaToAttach.getIdTarjeta());
                attachedTarjetaList.add(tarjetaListTarjetaToAttach);
            }
            jugador.setTarjetaList(attachedTarjetaList);
            List<Goles> attachedGolesList = new ArrayList<Goles>();
            for (Goles golesListGolesToAttach : jugador.getGolesList()) {
                golesListGolesToAttach = em.getReference(golesListGolesToAttach.getClass(), golesListGolesToAttach.getIdGol());
                attachedGolesList.add(golesListGolesToAttach);
            }
            jugador.setGolesList(attachedGolesList);
            em.persist(jugador);
            if (idEquipo != null) {
                idEquipo.getJugadorList().add(jugador);
                idEquipo = em.merge(idEquipo);
            }
            if (persona != null) {
                persona.setJugador(jugador);
                persona = em.merge(persona);
            }
            for (Clubes clubesListClubes : jugador.getClubesList()) {
                clubesListClubes.getJugadorList().add(jugador);
                clubesListClubes = em.merge(clubesListClubes);
            }
            for (Tarjeta tarjetaListTarjeta : jugador.getTarjetaList()) {
                Jugador oldIdJugadorOfTarjetaListTarjeta = tarjetaListTarjeta.getIdJugador();
                tarjetaListTarjeta.setIdJugador(jugador);
                tarjetaListTarjeta = em.merge(tarjetaListTarjeta);
                if (oldIdJugadorOfTarjetaListTarjeta != null) {
                    oldIdJugadorOfTarjetaListTarjeta.getTarjetaList().remove(tarjetaListTarjeta);
                    oldIdJugadorOfTarjetaListTarjeta = em.merge(oldIdJugadorOfTarjetaListTarjeta);
                }
            }
            for (Goles golesListGoles : jugador.getGolesList()) {
                Jugador oldIdJugadorOfGolesListGoles = golesListGoles.getIdJugador();
                golesListGoles.setIdJugador(jugador);
                golesListGoles = em.merge(golesListGoles);
                if (oldIdJugadorOfGolesListGoles != null) {
                    oldIdJugadorOfGolesListGoles.getGolesList().remove(golesListGoles);
                    oldIdJugadorOfGolesListGoles = em.merge(oldIdJugadorOfGolesListGoles);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findJugador(jugador.getIdPersona()) != null) {
                throw new PreexistingEntityException("Jugador " + jugador + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Jugador jugador) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Jugador persistentJugador = em.find(Jugador.class, jugador.getIdPersona());
            Equipo idEquipoOld = persistentJugador.getIdEquipo();
            Equipo idEquipoNew = jugador.getIdEquipo();
            Persona personaOld = persistentJugador.getPersona();
            Persona personaNew = jugador.getPersona();
            List<Clubes> clubesListOld = persistentJugador.getClubesList();
            List<Clubes> clubesListNew = jugador.getClubesList();
            List<Tarjeta> tarjetaListOld = persistentJugador.getTarjetaList();
            List<Tarjeta> tarjetaListNew = jugador.getTarjetaList();
            List<Goles> golesListOld = persistentJugador.getGolesList();
            List<Goles> golesListNew = jugador.getGolesList();
            List<String> illegalOrphanMessages = null;
            if (personaNew != null && !personaNew.equals(personaOld)) {
                Jugador oldJugadorOfPersona = personaNew.getJugador();
                if (oldJugadorOfPersona != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Persona " + personaNew + " already has an item of type Jugador whose persona column cannot be null. Please make another selection for the persona field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idEquipoNew != null) {
                idEquipoNew = em.getReference(idEquipoNew.getClass(), idEquipoNew.getIdEquipo());
                jugador.setIdEquipo(idEquipoNew);
            }
            if (personaNew != null) {
                personaNew = em.getReference(personaNew.getClass(), personaNew.getIdPersona());
                jugador.setPersona(personaNew);
            }
            List<Clubes> attachedClubesListNew = new ArrayList<Clubes>();
            for (Clubes clubesListNewClubesToAttach : clubesListNew) {
                clubesListNewClubesToAttach = em.getReference(clubesListNewClubesToAttach.getClass(), clubesListNewClubesToAttach.getIdClub());
                attachedClubesListNew.add(clubesListNewClubesToAttach);
            }
            clubesListNew = attachedClubesListNew;
            jugador.setClubesList(clubesListNew);
            List<Tarjeta> attachedTarjetaListNew = new ArrayList<Tarjeta>();
            for (Tarjeta tarjetaListNewTarjetaToAttach : tarjetaListNew) {
                tarjetaListNewTarjetaToAttach = em.getReference(tarjetaListNewTarjetaToAttach.getClass(), tarjetaListNewTarjetaToAttach.getIdTarjeta());
                attachedTarjetaListNew.add(tarjetaListNewTarjetaToAttach);
            }
            tarjetaListNew = attachedTarjetaListNew;
            jugador.setTarjetaList(tarjetaListNew);
            List<Goles> attachedGolesListNew = new ArrayList<Goles>();
            for (Goles golesListNewGolesToAttach : golesListNew) {
                golesListNewGolesToAttach = em.getReference(golesListNewGolesToAttach.getClass(), golesListNewGolesToAttach.getIdGol());
                attachedGolesListNew.add(golesListNewGolesToAttach);
            }
            golesListNew = attachedGolesListNew;
            jugador.setGolesList(golesListNew);
            jugador = em.merge(jugador);
            if (idEquipoOld != null && !idEquipoOld.equals(idEquipoNew)) {
                idEquipoOld.getJugadorList().remove(jugador);
                idEquipoOld = em.merge(idEquipoOld);
            }
            if (idEquipoNew != null && !idEquipoNew.equals(idEquipoOld)) {
                idEquipoNew.getJugadorList().add(jugador);
                idEquipoNew = em.merge(idEquipoNew);
            }
            if (personaOld != null && !personaOld.equals(personaNew)) {
                personaOld.setJugador(null);
                personaOld = em.merge(personaOld);
            }
            if (personaNew != null && !personaNew.equals(personaOld)) {
                personaNew.setJugador(jugador);
                personaNew = em.merge(personaNew);
            }
            for (Clubes clubesListOldClubes : clubesListOld) {
                if (!clubesListNew.contains(clubesListOldClubes)) {
                    clubesListOldClubes.getJugadorList().remove(jugador);
                    clubesListOldClubes = em.merge(clubesListOldClubes);
                }
            }
            for (Clubes clubesListNewClubes : clubesListNew) {
                if (!clubesListOld.contains(clubesListNewClubes)) {
                    clubesListNewClubes.getJugadorList().add(jugador);
                    clubesListNewClubes = em.merge(clubesListNewClubes);
                }
            }
            for (Tarjeta tarjetaListOldTarjeta : tarjetaListOld) {
                if (!tarjetaListNew.contains(tarjetaListOldTarjeta)) {
                    tarjetaListOldTarjeta.setIdJugador(null);
                    tarjetaListOldTarjeta = em.merge(tarjetaListOldTarjeta);
                }
            }
            for (Tarjeta tarjetaListNewTarjeta : tarjetaListNew) {
                if (!tarjetaListOld.contains(tarjetaListNewTarjeta)) {
                    Jugador oldIdJugadorOfTarjetaListNewTarjeta = tarjetaListNewTarjeta.getIdJugador();
                    tarjetaListNewTarjeta.setIdJugador(jugador);
                    tarjetaListNewTarjeta = em.merge(tarjetaListNewTarjeta);
                    if (oldIdJugadorOfTarjetaListNewTarjeta != null && !oldIdJugadorOfTarjetaListNewTarjeta.equals(jugador)) {
                        oldIdJugadorOfTarjetaListNewTarjeta.getTarjetaList().remove(tarjetaListNewTarjeta);
                        oldIdJugadorOfTarjetaListNewTarjeta = em.merge(oldIdJugadorOfTarjetaListNewTarjeta);
                    }
                }
            }
            for (Goles golesListOldGoles : golesListOld) {
                if (!golesListNew.contains(golesListOldGoles)) {
                    golesListOldGoles.setIdJugador(null);
                    golesListOldGoles = em.merge(golesListOldGoles);
                }
            }
            for (Goles golesListNewGoles : golesListNew) {
                if (!golesListOld.contains(golesListNewGoles)) {
                    Jugador oldIdJugadorOfGolesListNewGoles = golesListNewGoles.getIdJugador();
                    golesListNewGoles.setIdJugador(jugador);
                    golesListNewGoles = em.merge(golesListNewGoles);
                    if (oldIdJugadorOfGolesListNewGoles != null && !oldIdJugadorOfGolesListNewGoles.equals(jugador)) {
                        oldIdJugadorOfGolesListNewGoles.getGolesList().remove(golesListNewGoles);
                        oldIdJugadorOfGolesListNewGoles = em.merge(oldIdJugadorOfGolesListNewGoles);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigInteger id = jugador.getIdPersona();
                if (findJugador(id) == null) {
                    throw new NonexistentEntityException("The jugador with id " + id + " no longer exists.");
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
            Jugador jugador;
            try {
                jugador = em.getReference(Jugador.class, id);
                jugador.getIdPersona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The jugador with id " + id + " no longer exists.", enfe);
            }
            Equipo idEquipo = jugador.getIdEquipo();
            if (idEquipo != null) {
                idEquipo.getJugadorList().remove(jugador);
                idEquipo = em.merge(idEquipo);
            }
            Persona persona = jugador.getPersona();
            if (persona != null) {
                persona.setJugador(null);
                persona = em.merge(persona);
            }
            List<Clubes> clubesList = jugador.getClubesList();
            for (Clubes clubesListClubes : clubesList) {
                clubesListClubes.getJugadorList().remove(jugador);
                clubesListClubes = em.merge(clubesListClubes);
            }
            List<Tarjeta> tarjetaList = jugador.getTarjetaList();
            for (Tarjeta tarjetaListTarjeta : tarjetaList) {
                tarjetaListTarjeta.setIdJugador(null);
                tarjetaListTarjeta = em.merge(tarjetaListTarjeta);
            }
            List<Goles> golesList = jugador.getGolesList();
            for (Goles golesListGoles : golesList) {
                golesListGoles.setIdJugador(null);
                golesListGoles = em.merge(golesListGoles);
            }
            em.remove(jugador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Jugador> findJugadorEntities() {
        return findJugadorEntities(true, -1, -1);
    }

    public List<Jugador> findJugadorEntities(int maxResults, int firstResult) {
        return findJugadorEntities(false, maxResults, firstResult);
    }

    private List<Jugador> findJugadorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Jugador.class));
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

    public Jugador findJugador(BigInteger id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Jugador.class, id);
        } finally {
            em.close();
        }
    }

    public int getJugadorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Jugador> rt = cq.from(Jugador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
