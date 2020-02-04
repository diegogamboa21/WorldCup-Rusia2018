/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rusia2018;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego Gamboa
 */
@Entity
@Table(name = "ESTADIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadio.findAll", query = "SELECT e FROM Estadio e")
    , @NamedQuery(name = "Estadio.findByIdEstadio", query = "SELECT e FROM Estadio e WHERE e.idEstadio = :idEstadio")
    , @NamedQuery(name = "Estadio.findByNombreEstadio", query = "SELECT e FROM Estadio e WHERE e.nombreEstadio = :nombreEstadio")
    , @NamedQuery(name = "Estadio.findByCapacidad", query = "SELECT e FROM Estadio e WHERE e.capacidad = :capacidad")})
public class Estadio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ESTADIO")
    private BigInteger idEstadio;
    @Basic(optional = false)
    @Column(name = "NOMBRE_ESTADIO")
    private String nombreEstadio;
    @Basic(optional = false)
    @Column(name = "CAPACIDAD")
    private BigInteger capacidad;
    @JoinColumn(name = "ID_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne
    private Ciudad idCiudad;
    @OneToMany(mappedBy = "idEstadio")
    private List<Partido> partidoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadio")
    private List<Silla> sillaList;

    public Estadio() {
    }

    public Estadio(BigInteger idEstadio) {
        this.idEstadio = idEstadio;
    }

    public Estadio(BigInteger idEstadio, String nombreEstadio, BigInteger capacidad) {
        this.idEstadio = idEstadio;
        this.nombreEstadio = nombreEstadio;
        this.capacidad = capacidad;
    }

    public BigInteger getIdEstadio() {
        return idEstadio;
    }

    public void setIdEstadio(BigInteger idEstadio) {
        this.idEstadio = idEstadio;
    }

    public String getNombreEstadio() {
        return nombreEstadio;
    }

    public void setNombreEstadio(String nombreEstadio) {
        this.nombreEstadio = nombreEstadio;
    }

    public BigInteger getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(BigInteger capacidad) {
        this.capacidad = capacidad;
    }

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    @XmlTransient
    public List<Partido> getPartidoList() {
        return partidoList;
    }

    public void setPartidoList(List<Partido> partidoList) {
        this.partidoList = partidoList;
    }

    @XmlTransient
    public List<Silla> getSillaList() {
        return sillaList;
    }

    public void setSillaList(List<Silla> sillaList) {
        this.sillaList = sillaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadio != null ? idEstadio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadio)) {
            return false;
        }
        Estadio other = (Estadio) object;
        if ((this.idEstadio == null && other.idEstadio != null) || (this.idEstadio != null && !this.idEstadio.equals(other.idEstadio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rusia2018.Estadio[ idEstadio=" + idEstadio + " ]";
    }
    
}
