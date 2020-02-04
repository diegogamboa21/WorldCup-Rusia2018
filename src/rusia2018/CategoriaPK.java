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
public class CategoriaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_CATEGORIA")
    private BigInteger idCategoria;
    @Basic(optional = false)
    @Column(name = "ID_SILLA")
    private BigInteger idSilla;
    @Basic(optional = false)
    @Column(name = "ID_ESTADIO")
    private BigInteger idEstadio;

    public CategoriaPK() {
    }

    public CategoriaPK(BigInteger idCategoria, BigInteger idSilla, BigInteger idEstadio) {
        this.idCategoria = idCategoria;
        this.idSilla = idSilla;
        this.idEstadio = idEstadio;
    }

    public BigInteger getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(BigInteger idCategoria) {
        this.idCategoria = idCategoria;
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
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        hash += (idSilla != null ? idSilla.hashCode() : 0);
        hash += (idEstadio != null ? idEstadio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaPK)) {
            return false;
        }
        CategoriaPK other = (CategoriaPK) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
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
        return "rusia2018.CategoriaPK[ idCategoria=" + idCategoria + ", idSilla=" + idSilla + ", idEstadio=" + idEstadio + " ]";
    }
    
}
