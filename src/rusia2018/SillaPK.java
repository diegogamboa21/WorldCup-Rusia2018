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
import javax.persistence.Embeddable;

/**
 *
 * @author Diego Gamboa
 */
@Embeddable
public class SillaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_SILLA")
    private BigInteger idSilla;
    @Basic(optional = false)
    @Column(name = "ID_ESTADIO")
    private BigInteger idEstadio;

    public SillaPK() {
    }

    public SillaPK(BigInteger idSilla, BigInteger idEstadio) {
        this.idSilla = idSilla;
        this.idEstadio = idEstadio;
    }

    public BigInteger getIdSilla() {
        return idSilla;
    }

    public void setIdSilla(BigInteger idSilla) {
        this.idSilla = idSilla;
    }

    public BigInteger getIdEstadio() {
        return idEstadio;
    }

    public void setIdEstadio(BigInteger idEstadio) {
        this.idEstadio = idEstadio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSilla != null ? idSilla.hashCode() : 0);
        hash += (idEstadio != null ? idEstadio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SillaPK)) {
            return false;
        }
        SillaPK other = (SillaPK) object;
        if ((this.idSilla == null && other.idSilla != null) || (this.idSilla != null && !this.idSilla.equals(other.idSilla))) {
            return false;
        }
        if ((this.idEstadio == null && other.idEstadio != null) || (this.idEstadio != null && !this.idEstadio.equals(other.idEstadio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rusia2018.SillaPK[ idSilla=" + idSilla + ", idEstadio=" + idEstadio + " ]";
    }
    
}
