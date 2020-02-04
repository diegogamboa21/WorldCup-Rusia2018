/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rusia2018;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego Gamboa
 */
@Entity
@Table(name = "JUEZ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Juez.findAll", query = "SELECT j FROM Juez j")
    , @NamedQuery(name = "Juez.findByIdJuez", query = "SELECT j FROM Juez j WHERE j.idJuez = :idJuez")
    , @NamedQuery(name = "Juez.findByTipo", query = "SELECT j FROM Juez j WHERE j.tipo = :tipo")})
public class Juez implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_JUEZ")
    private BigInteger idJuez;
    @Column(name = "TIPO")
    private String tipo;
    @JoinColumn(name = "ID_PARTIDO", referencedColumnName = "ID_PARTIDO")
    @ManyToOne
    private Partido idPartido;

    public Juez() {
    }

    public Juez(BigInteger idJuez) {
        this.idJuez = idJuez;
    }

    public BigInteger getIdJuez() {
        return idJuez;
    }

    public void setIdJuez(BigInteger idJuez) {
        this.idJuez = idJuez;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Partido getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Partido idPartido) {
        this.idPartido = idPartido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJuez != null ? idJuez.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Juez)) {
            return false;
        }
        Juez other = (Juez) object;
        if ((this.idJuez == null && other.idJuez != null) || (this.idJuez != null && !this.idJuez.equals(other.idJuez))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rusia2018.Juez[ idJuez=" + idJuez + " ]";
    }
    
}
