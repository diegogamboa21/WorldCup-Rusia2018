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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego Gamboa
 */
@Entity
@Table(name = "SILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Silla.findAll", query = "SELECT s FROM Silla s")
    , @NamedQuery(name = "Silla.findByIdSilla", query = "SELECT s FROM Silla s WHERE s.sillaPK.idSilla = :idSilla")
    , @NamedQuery(name = "Silla.findByNumSilla", query = "SELECT s FROM Silla s WHERE s.numSilla = :numSilla")
    , @NamedQuery(name = "Silla.findByIdEstadio", query = "SELECT s FROM Silla s WHERE s.sillaPK.idEstadio = :idEstadio")})
public class Silla implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SillaPK sillaPK;
    @Column(name = "NUM_SILLA")
    private BigInteger numSilla;
    @OneToMany(mappedBy = "silla")
    private List<Tiquete> tiqueteList;
    @JoinColumn(name = "ID_ESTADIO", referencedColumnName = "ID_ESTADIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estadio estadio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "silla")
    private List<Categoria> categoriaList;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private BigInteger estado;
    @Transient
    private String categoria;
    @Transient
    private int valor;
    
    public Silla() {
    }

    public Silla(SillaPK sillaPK) {
        this.sillaPK = sillaPK;
    }

    public Silla(BigInteger idSilla, BigInteger idEstadio) {
        this.sillaPK = new SillaPK(idSilla, idEstadio);
    }

    public SillaPK getSillaPK() {
        return sillaPK;
    }

    public void setSillaPK(SillaPK sillaPK) {
        this.sillaPK = sillaPK;
    }

    public BigInteger getNumSilla() {
        return numSilla;
    }

    public void setNumSilla(BigInteger numSilla) {
        this.numSilla = numSilla;
    }

    @XmlTransient
    public List<Tiquete> getTiqueteList() {
        return tiqueteList;
    }

    public void setTiqueteList(List<Tiquete> tiqueteList) {
        this.tiqueteList = tiqueteList;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    @XmlTransient
    public List<Categoria> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<Categoria> categoriaList) {
        this.categoriaList = categoriaList;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sillaPK != null ? sillaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Silla)) {
            return false;
        }
        Silla other = (Silla) object;
        if ((this.sillaPK == null && other.sillaPK != null) || (this.sillaPK != null && !this.sillaPK.equals(other.sillaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rusia2018.Silla[ sillaPK=" + sillaPK + " ]";
    }
    
}
