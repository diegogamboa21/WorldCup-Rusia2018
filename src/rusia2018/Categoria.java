/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rusia2018;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "CATEGORIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
    , @NamedQuery(name = "Categoria.findByIdCategoria", query = "SELECT c FROM Categoria c WHERE c.categoriaPK.idCategoria = :idCategoria")
    , @NamedQuery(name = "Categoria.findByValor", query = "SELECT c FROM Categoria c WHERE c.valor = :valor")
    , @NamedQuery(name = "Categoria.findByIdSilla", query = "SELECT c FROM Categoria c WHERE c.categoriaPK.idSilla = :idSilla")
    , @NamedQuery(name = "Categoria.findByIdEstadio", query = "SELECT c FROM Categoria c WHERE c.categoriaPK.idEstadio = :idEstadio")
    , @NamedQuery(name = "Categoria.findByTipo", query = "SELECT c FROM Categoria c WHERE c.tipo = :tipo")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CategoriaPK categoriaPK;
    @Column(name = "VALOR")
    private BigInteger valor;
    @Column(name = "TIPO")
    private String tipo;
    @JoinColumns({
        @JoinColumn(name = "ID_SILLA", referencedColumnName = "ID_SILLA", insertable = false, updatable = false)
        , @JoinColumn(name = "ID_ESTADIO", referencedColumnName = "ID_ESTADIO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Silla silla;

    public Categoria() {
    }

    public Categoria(CategoriaPK categoriaPK) {
        this.categoriaPK = categoriaPK;
    }

    public Categoria(BigInteger idCategoria, BigInteger idSilla, BigInteger idEstadio) {
        this.categoriaPK = new CategoriaPK(idCategoria, idSilla, idEstadio);
    }

    public CategoriaPK getCategoriaPK() {
        return categoriaPK;
    }

    public void setCategoriaPK(CategoriaPK categoriaPK) {
        this.categoriaPK = categoriaPK;
    }

    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Silla getSilla() {
        return silla;
    }

    public void setSilla(Silla silla) {
        this.silla = silla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoriaPK != null ? categoriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.categoriaPK == null && other.categoriaPK != null) || (this.categoriaPK != null && !this.categoriaPK.equals(other.categoriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rusia2018.Categoria[ categoriaPK=" + categoriaPK + " ]";
    }
    
}
