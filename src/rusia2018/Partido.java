/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rusia2018;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego Gamboa
 */
@Entity
@Table(name = "PARTIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partido.findAll", query = "SELECT p FROM Partido p")
    , @NamedQuery(name = "Partido.findByIdPartido", query = "SELECT p FROM Partido p WHERE p.idPartido = :idPartido")
    , @NamedQuery(name = "Partido.findByFechayhora", query = "SELECT p FROM Partido p WHERE p.fechayhora = :fechayhora")
    , @NamedQuery(name = "Partido.findByFase", query = "SELECT p FROM Partido p WHERE p.fase = :fase")
    , @NamedQuery(name = "Partido.findByEncuentro", query = "SELECT p FROM Partido p WHERE p.encuentro = :encuentro")})
public class Partido implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PARTIDO")
    private BigInteger idPartido;
    @Basic(optional = false)
    @Column(name = "FECHAYHORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechayhora;
    @Basic(optional = false)
    @Column(name = "FASE")
    private String fase;
    @Basic(optional = false)
    @Column(name = "ENCUENTRO")
    private String encuentro;
    @OneToMany(mappedBy = "idPartido")
    private List<Juez> juezList;
    @OneToMany(mappedBy = "idPartido")
    private List<Tiquete> tiqueteList;
    @JoinColumn(name = "ID_LOCAL", referencedColumnName = "ID_EQUIPO")
    @ManyToOne
    private Equipo idLocal;
    @JoinColumn(name = "ID_VISITANTE", referencedColumnName = "ID_EQUIPO")
    @ManyToOne
    private Equipo idVisitante;
    @JoinColumn(name = "ID_ESTADIO", referencedColumnName = "ID_ESTADIO")
    @ManyToOne
    private Estadio idEstadio;
    @OneToMany(mappedBy = "idPartido")
    private List<Tarjeta> tarjetaList;
    @OneToMany(mappedBy = "idPartido")
    private List<Goles> golesList;

    @Transient
    private int golesLocal;
    @Transient
    private int golesVisitante;
    
    public Partido() {
    }

    public Partido(BigInteger idPartido) {
        this.idPartido = idPartido;
    }
    
    public Partido(BigInteger idPartido, Date fechayhora, String fase, String encuentro) {
        this.idPartido = idPartido;
        this.fechayhora = fechayhora;
        this.fase = fase;
        this.encuentro = encuentro;
        this.golesLocal = 0;
        this.golesVisitante = 0;
    }

    public BigInteger getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(BigInteger idPartido) {
        this.idPartido = idPartido;
    }

    public Date getFechayhora() {
        return fechayhora;
    }

    public void setFechayhora(Date fechayhora) {
        this.fechayhora = fechayhora;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getEncuentro() {
        return encuentro;
    }

    public void setEncuentro(String encuentro) {
        this.encuentro = encuentro;
    }

    @XmlTransient
    public List<Juez> getJuezList() {
        return juezList;
    }

    public void setJuezList(List<Juez> juezList) {
        this.juezList = juezList;
    }

    @XmlTransient
    public List<Tiquete> getTiqueteList() {
        return tiqueteList;
    }

    public void setTiqueteList(List<Tiquete> tiqueteList) {
        this.tiqueteList = tiqueteList;
    }

    public Equipo getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Equipo idLocal) {
        this.idLocal = idLocal;
    }

    public Equipo getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(Equipo idVisitante) {
        this.idVisitante = idVisitante;
    }

    public Estadio getIdEstadio() {
        return idEstadio;
    }

    public void setIdEstadio(Estadio idEstadio) {
        this.idEstadio = idEstadio;
    }

    @XmlTransient
    public List<Tarjeta> getTarjetaList() {
        return tarjetaList;
    }

    public void setTarjetaList(List<Tarjeta> tarjetaList) {
        this.tarjetaList = tarjetaList;
    }

    @XmlTransient
    public List<Goles> getGolesList() {
        return golesList;
    }

    public void setGolesList(List<Goles> golesList) {
        this.golesList = golesList;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPartido != null ? idPartido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partido)) {
            return false;
        }
        Partido other = (Partido) object;
        if ((this.idPartido == null && other.idPartido != null) || (this.idPartido != null && !this.idPartido.equals(other.idPartido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rusia2018.Partido[ idPartido=" + idPartido + " ]";
    }
    
}
