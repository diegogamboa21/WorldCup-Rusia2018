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
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import rusia2018.Equipo;
import rusia2018.Estadio;
import rusia2018.Juez;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rusia2018.Tiquete;
import rusia2018.Tarjeta;
import rusia2018.Goles;
import rusia2018.Partido;

/**
 *
 * @author Diego Gamboa
 */
public class PartidoJpaController implements Serializable {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Rusia2018PU");
    
    public PartidoJpaController() {}
    
    public PartidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Partido partido) throws PreexistingEntityException, Exception {
        if (partido.getJuezList() == null) {
            partido.setJuezList(new ArrayList<Juez>());
        }
        if (partido.getTiqueteList() == null) {
            partido.setTiqueteList(new ArrayList<Tiquete>());
        }
        if (partido.getTarjetaList() == null) {
            partido.setTarjetaList(new ArrayList<Tarjeta>());
        }
        if (partido.getGolesList() == null) {
            partido.setGolesList(new ArrayList<Goles>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Equipo idLocal = partido.getIdLocal();
            if (idLocal != null) {
                idLocal = em.getReference(idLocal.getClass(), idLocal.getIdEquipo());
                partido.setIdLocal(idLocal);
            }
            Equipo idVisitante = partido.getIdVisitante();
            if (idVisitante != null) {
                idVisitante = em.getReference(idVisitante.getClass(), idVisitante.getIdEquipo());
                partido.setIdVisitante(idVisitante);
            }
            Estadio idEstadio = partido.getIdEstadio();
            if (idEstadio != null) {
                idEstadio = em.getReference(idEstadio.getClass(), idEstadio.getIdEstadio());
                partido.setIdEstadio(idEstadio);
            }
            List<Juez> attachedJuezList = new ArrayList<Juez>();
            for (Juez juezListJuezToAttach : partido.getJuezList()) {
                juezListJuezToAttach = em.getReference(juezListJuezToAttach.getClass(), juezListJuezToAttach.getIdJuez());
                attachedJuezList.add(juezListJuezToAttach);
            }
            partido.setJuezList(attachedJuezList);
            List<Tiquete> attachedTiqueteList = new ArrayList<Tiquete>();
            for (Tiquete tiqueteListTiqueteToAttach : partido.getTiqueteList()) {
                tiqueteListTiqueteToAttach = em.getReference(tiqueteListTiqueteToAttach.getClass(), tiqueteListTiqueteToAttach.getIdCliente());
                attachedTiqueteList.add(tiqueteListTiqueteToAttach);
            }
            partido.setTiqueteList(attachedTiqueteList);
            List<Tarjeta> attachedTarjetaList = new ArrayList<Tarjeta>();
            for (Tarjeta tarjetaListTarjetaToAttach : partido.getTarjetaList()) {
                tarjetaListTarjetaToAttach = em.getReference(tarjetaListTarjetaToAttach.getClass(), tarjetaListTarjetaToAttach.getIdTarjeta());
                attachedTarjetaList.add(tarjetaListTarjetaToAttach);
            }
            partido.setTarjetaList(attachedTarjetaList);
            List<Goles> attachedGolesList = new ArrayList<Goles>();
            for (Goles golesListGolesToAttach : partido.getGolesList()) {
                golesListGolesToAttach = em.getReference(golesListGolesToAttach.getClass(), golesListGolesToAttach.getIdGol());
                attachedGolesList.add(golesListGolesToAttach);
            }
            partido.setGolesList(attachedGolesList);
            em.persist(partido);
            if (idLocal != null) {
                idLocal.getPartidoList().add(partido);
                idLocal = em.merge(idLocal);
            }
            if (idVisitante != null) {
                idVisitante.getPartidoList().add(partido);
                idVisitante = em.merge(idVisitante);
            }
            if (idEstadio != null) {
                idEstadio.getPartidoList().add(partido);
                idEstadio = em.merge(idEstadio);
            }
            for (Juez juezListJuez : partido.getJuezList()) {
                Partido oldIdPartidoOfJuezListJuez = juezListJuez.getIdPartido();
                juezListJuez.setIdPartido(partido);
                juezListJuez = em.merge(juezListJuez);
                if (oldIdPartidoOfJuezListJuez != null) {
                    oldIdPartidoOfJuezListJuez.getJuezList().remove(juezListJuez);
                    oldIdPartidoOfJuezListJuez = em.merge(oldIdPartidoOfJuezListJuez);
                }
            }
            for (Tiquete tiqueteListTiquete : partido.getTiqueteList()) {
                Partido oldIdPartidoOfTiqueteListTiquete = tiqueteListTiquete.getIdPartido();
                tiqueteListTiquete.setIdPartido(partido);
                tiqueteListTiquete = em.merge(tiqueteListTiquete);
                if (oldIdPartidoOfTiqueteListTiquete != null) {
                    oldIdPartidoOfTiqueteListTiquete.getTiqueteList().remove(tiqueteListTiquete);
                    oldIdPartidoOfTiqueteListTiquete = em.merge(oldIdPartidoOfTiqueteListTiquete);
                }
            }
            for (Tarjeta tarjetaListTarjeta : partido.getTarjetaList()) {
                Partido oldIdPartidoOfTarjetaListTarjeta = tarjetaListTarjeta.getIdPartido();
                tarjetaListTarjeta.setIdPartido(partido);
                tarjetaListTarjeta = em.merge(tarjetaListTarjeta);
                if (oldIdPartidoOfTarjetaListTarjeta != null) {
                    oldIdPartidoOfTarjetaListTarjeta.getTarjetaList().remove(tarjetaListTarjeta);
                    oldIdPartidoOfTarjetaListTarjeta = em.merge(oldIdPartidoOfTarjetaListTarjeta);
                }
            }
            for (Goles golesListGoles : partido.getGolesList()) {
                Partido oldIdPartidoOfGolesListGoles = golesListGoles.getIdPartido();
                golesListGoles.setIdPartido(partido);
                golesListGoles = em.merge(golesListGoles);
                if (oldIdPartidoOfGolesListGoles != null) {
                    oldIdPartidoOfGolesListGoles.getGolesList().remove(golesListGoles);
                    oldIdPartidoOfGolesListGoles = em.merge(oldIdPartidoOfGolesListGoles);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPartido(partido.getIdPartido()) != null) {
                throw new PreexistingEntityException("Partido " + partido + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Partido partido) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Partido persistentPartido = em.find(Partido.class, partido.getIdPartido());
            Equipo idLocalOld = persistentPartido.getIdLocal();
            Equipo idLocalNew = partido.getIdLocal();
            Equipo idVisitanteOld = persistentPartido.getIdVisitante();
            Equipo idVisitanteNew = partido.getIdVisitante();
            Estadio idEstadioOld = persistentPartido.getIdEstadio();
            Estadio idEstadioNew = partido.getIdEstadio();
            List<Juez> juezListOld = persistentPartido.getJuezList();
            List<Juez> juezListNew = partido.getJuezList();
            List<Tiquete> tiqueteListOld = persistentPartido.getTiqueteList();
            List<Tiquete> tiqueteListNew = partido.getTiqueteList();
            List<Tarjeta> tarjetaListOld = persistentPartido.getTarjetaList();
            List<Tarjeta> tarjetaListNew = partido.getTarjetaList();
            List<Goles> golesListOld = persistentPartido.getGolesList();
            List<Goles> golesListNew = partido.getGolesList();
            if (idLocalNew != null) {
                idLocalNew = em.getReference(idLocalNew.getClass(), idLocalNew.getIdEquipo());
                partido.setIdLocal(idLocalNew);
            }
            if (idVisitanteNew != null) {
                idVisitanteNew = em.getReference(idVisitanteNew.getClass(), idVisitanteNew.getIdEquipo());
                partido.setIdVisitante(idVisitanteNew);
            }
            if (idEstadioNew != null) {
                idEstadioNew = em.getReference(idEstadioNew.getClass(), idEstadioNew.getIdEstadio());
                partido.setIdEstadio(idEstadioNew);
            }
            List<Juez> attachedJuezListNew = new ArrayList<Juez>();
            for (Juez juezListNewJuezToAttach : juezListNew) {
                juezListNewJuezToAttach = em.getReference(juezListNewJuezToAttach.getClass(), juezListNewJuezToAttach.getIdJuez());
                attachedJuezListNew.add(juezListNewJuezToAttach);
            }
            juezListNew = attachedJuezListNew;
            partido.setJuezList(juezListNew);
            List<Tiquete> attachedTiqueteListNew = new ArrayList<Tiquete>();
            for (Tiquete tiqueteListNewTiqueteToAttach : tiqueteListNew) {
                tiqueteListNewTiqueteToAttach = em.getReference(tiqueteListNewTiqueteToAttach.getClass(), tiqueteListNewTiqueteToAttach.getIdCliente());
                attachedTiqueteListNew.add(tiqueteListNewTiqueteToAttach);
            }
            tiqueteListNew = attachedTiqueteListNew;
            partido.setTiqueteList(tiqueteListNew);
            List<Tarjeta> attachedTarjetaListNew = new ArrayList<Tarjeta>();
            for (Tarjeta tarjetaListNewTarjetaToAttach : tarjetaListNew) {
                tarjetaListNewTarjetaToAttach = em.getReference(tarjetaListNewTarjetaToAttach.getClass(), tarjetaListNewTarjetaToAttach.getIdTarjeta());
                attachedTarjetaListNew.add(tarjetaListNewTarjetaToAttach);
            }
            tarjetaListNew = attachedTarjetaListNew;
            partido.setTarjetaList(tarjetaListNew);
            List<Goles> attachedGolesListNew = new ArrayList<Goles>();
            for (Goles golesListNewGolesToAttach : golesListNew) {
                golesListNewGolesToAttach = em.getReference(golesListNewGolesToAttach.getClass(), golesListNewGolesToAttach.getIdGol());
                attachedGolesListNew.add(golesListNewGolesToAttach);
            }
            golesListNew = attachedGolesListNew;
            partido.setGolesList(golesListNew);
            partido = em.merge(partido);
            if (idLocalOld != null && !idLocalOld.equals(idLocalNew)) {
                idLocalOld.getPartidoList().remove(partido);
                idLocalOld = em.merge(idLocalOld);
            }
            if (idLocalNew != null && !idLocalNew.equals(idLocalOld)) {
                idLocalNew.getPartidoList().add(partido);
                idLocalNew = em.merge(idLocalNew);
            }
            if (idVisitanteOld != null && !idVisitanteOld.equals(idVisitanteNew)) {
                idVisitanteOld.getPartidoList().remove(partido);
                idVisitanteOld = em.merge(idVisitanteOld);
            }
            if (idVisitanteNew != null && !idVisitanteNew.equals(idVisitanteOld)) {
                idVisitanteNew.getPartidoList().add(partido);
                idVisitanteNew = em.merge(idVisitanteNew);
            }
            if (idEstadioOld != null && !idEstadioOld.equals(idEstadioNew)) {
                idEstadioOld.getPartidoList().remove(partido);
                idEstadioOld = em.merge(idEstadioOld);
            }
            if (idEstadioNew != null && !idEstadioNew.equals(idEstadioOld)) {
                idEstadioNew.getPartidoList().add(partido);
                idEstadioNew = em.merge(idEstadioNew);
            }
            for (Juez juezListOldJuez : juezListOld) {
                if (!juezListNew.contains(juezListOldJuez)) {
                    juezListOldJuez.setIdPartido(null);
                    juezListOldJuez = em.merge(juezListOldJuez);
                }
            }
            for (Juez juezListNewJuez : juezListNew) {
                if (!juezListOld.contains(juezListNewJuez)) {
                    Partido oldIdPartidoOfJuezListNewJuez = juezListNewJuez.getIdPartido();
                    juezListNewJuez.setIdPartido(partido);
                    juezListNewJuez = em.merge(juezListNewJuez);
                    if (oldIdPartidoOfJuezListNewJuez != null && !oldIdPartidoOfJuezListNewJuez.equals(partido)) {
                        oldIdPartidoOfJuezListNewJuez.getJuezList().remove(juezListNewJuez);
                        oldIdPartidoOfJuezListNewJuez = em.merge(oldIdPartidoOfJuezListNewJuez);
                    }
                }
            }
            for (Tiquete tiqueteListOldTiquete : tiqueteListOld) {
                if (!tiqueteListNew.contains(tiqueteListOldTiquete)) {
                    tiqueteListOldTiquete.setIdPartido(null);
                    tiqueteListOldTiquete = em.merge(tiqueteListOldTiquete);
                }
            }
            for (Tiquete tiqueteListNewTiquete : tiqueteListNew) {
                if (!tiqueteListOld.contains(tiqueteListNewTiquete)) {
                    Partido oldIdPartidoOfTiqueteListNewTiquete = tiqueteListNewTiquete.getIdPartido();
                    tiqueteListNewTiquete.setIdPartido(partido);
                    tiqueteListNewTiquete = em.merge(tiqueteListNewTiquete);
                    if (oldIdPartidoOfTiqueteListNewTiquete != null && !oldIdPartidoOfTiqueteListNewTiquete.equals(partido)) {
                        oldIdPartidoOfTiqueteListNewTiquete.getTiqueteList().remove(tiqueteListNewTiquete);
                        oldIdPartidoOfTiqueteListNewTiquete = em.merge(oldIdPartidoOfTiqueteListNewTiquete);
                    }
                }
            }
            for (Tarjeta tarjetaListOldTarjeta : tarjetaListOld) {
                if (!tarjetaListNew.contains(tarjetaListOldTarjeta)) {
                    tarjetaListOldTarjeta.setIdPartido(null);
                    tarjetaListOldTarjeta = em.merge(tarjetaListOldTarjeta);
                }
            }
            for (Tarjeta tarjetaListNewTarjeta : tarjetaListNew) {
                if (!tarjetaListOld.contains(tarjetaListNewTarjeta)) {
                    Partido oldIdPartidoOfTarjetaListNewTarjeta = tarjetaListNewTarjeta.getIdPartido();
                    tarjetaListNewTarjeta.setIdPartido(partido);
                    tarjetaListNewTarjeta = em.merge(tarjetaListNewTarjeta);
                    if (oldIdPartidoOfTarjetaListNewTarjeta != null && !oldIdPartidoOfTarjetaListNewTarjeta.equals(partido)) {
                        oldIdPartidoOfTarjetaListNewTarjeta.getTarjetaList().remove(tarjetaListNewTarjeta);
                        oldIdPartidoOfTarjetaListNewTarjeta = em.merge(oldIdPartidoOfTarjetaListNewTarjeta);
                    }
                }
            }
            for (Goles golesListOldGoles : golesListOld) {
                if (!golesListNew.contains(golesListOldGoles)) {
                    golesListOldGoles.setIdPartido(null);
                    golesListOldGoles = em.merge(golesListOldGoles);
                }
            }
            for (Goles golesListNewGoles : golesListNew) {
                if (!golesListOld.contains(golesListNewGoles)) {
                    Partido oldIdPartidoOfGolesListNewGoles = golesListNewGoles.getIdPartido();
                    golesListNewGoles.setIdPartido(partido);
                    golesListNewGoles = em.merge(golesListNewGoles);
                    if (oldIdPartidoOfGolesListNewGoles != null && !oldIdPartidoOfGolesListNewGoles.equals(partido)) {
                        oldIdPartidoOfGolesListNewGoles.getGolesList().remove(golesListNewGoles);
                        oldIdPartidoOfGolesListNewGoles = em.merge(oldIdPartidoOfGolesListNewGoles);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigInteger id = partido.getIdPartido();
                if (findPartido(id) == null) {
                    throw new NonexistentEntityException("The partido with id " + id + " no longer exists.");
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
            Partido partido;
            try {
                partido = em.getReference(Partido.class, id);
                partido.getIdPartido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The partido with id " + id + " no longer exists.", enfe);
            }
            Equipo idLocal = partido.getIdLocal();
            if (idLocal != null) {
                idLocal.getPartidoList().remove(partido);
                idLocal = em.merge(idLocal);
            }
            Equipo idVisitante = partido.getIdVisitante();
            if (idVisitante != null) {
                idVisitante.getPartidoList().remove(partido);
                idVisitante = em.merge(idVisitante);
            }
            Estadio idEstadio = partido.getIdEstadio();
            if (idEstadio != null) {
                idEstadio.getPartidoList().remove(partido);
                idEstadio = em.merge(idEstadio);
            }
            List<Juez> juezList = partido.getJuezList();
            for (Juez juezListJuez : juezList) {
                juezListJuez.setIdPartido(null);
                juezListJuez = em.merge(juezListJuez);
            }
            List<Tiquete> tiqueteList = partido.getTiqueteList();
            for (Tiquete tiqueteListTiquete : tiqueteList) {
                tiqueteListTiquete.setIdPartido(null);
                tiqueteListTiquete = em.merge(tiqueteListTiquete);
            }
            List<Tarjeta> tarjetaList = partido.getTarjetaList();
            for (Tarjeta tarjetaListTarjeta : tarjetaList) {
                tarjetaListTarjeta.setIdPartido(null);
                tarjetaListTarjeta = em.merge(tarjetaListTarjeta);
            }
            List<Goles> golesList = partido.getGolesList();
            for (Goles golesListGoles : golesList) {
                golesListGoles.setIdPartido(null);
                golesListGoles = em.merge(golesListGoles);
            }
            em.remove(partido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Partido> findPartidoEntities() {
        return findPartidoEntities(true, -1, -1);
    }

    public List<Partido> findPartidoEntities(int maxResults, int firstResult) {
        return findPartidoEntities(false, maxResults, firstResult);
    }

    private List<Partido> findPartidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Partido.class));
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

    public Partido findPartido(BigInteger id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Partido.class, id);
        } finally {
            em.close();
        }
    }

    public int getPartidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Partido> rt = cq.from(Partido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
