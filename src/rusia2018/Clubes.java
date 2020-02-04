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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego Gamboa
 */
@Entity
@Table(name = "CLUBES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clubes.findAll", query = "SELECT c FROM Clubes c")
    , @NamedQuery(name = "Clubes.findByIdClub", query = "SELECT c FROM Clubes c WHERE c.idClub = :idClub")
    , @NamedQuery(name = "Clubes.findByNombreEquipo", query = "SELECT c FROM Clubes c WHERE c.nombreEquipo = :nombreEquipo")})
public class Clubes implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CLUB")
    private BigInteger idClub;
    @Basic(optional = false)
    @Column(name = "NOMBRE_EQUIPO")
    private String nombreEquipo;
    @ManyToMany(mappedBy = "clubesList")
    private List<Jugador> jugadorList;

    public Clubes() {
    }

    public Clubes(BigInteger idClub) {
        this.idClub = idClub;
    }

    public Clubes(BigInteger idClub, String nombreEquipo) {
        this.idClub = idClub;
        this.nombreEquipo = nombreEquipo;
    }

    public BigInteger getIdClub() {
        return idClub;
    }

    public void setIdClub(BigInteger idClub) {
        this.idClub = idClub;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    @XmlTransient
    public List<Jugador> getJugadorList() {
        return jugadorList;
    }

    public void setJugadorList(List<Jugador> jugadorList) {
        this.jugadorList = jugadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClub != null ? idClub.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clubes)) {
            return false;
        }
        Clubes other = (Clubes) object;
        if ((this.idClub == null && other.idClub != null) || (this.idClub != null && !this.idClub.equals(other.idClub))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rusia2018.Clubes[ idClub=" + idClub + " ]";
    }
    
}
