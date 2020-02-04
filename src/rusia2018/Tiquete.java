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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego Gamboa
 */
@Entity
@Table(name = "TIQUETE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiquete.findAll", query = "SELECT t FROM Tiquete t")
    , @NamedQuery(name = "Tiquete.findByIdTiquete", query = "SELECT t FROM Tiquete t WHERE t.idTiquete = :idTiquete")
    , @NamedQuery(name = "Tiquete.findByIdCliente", query = "SELECT t FROM Tiquete t WHERE t.idCliente = :idCliente")})
public class Tiquete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "ID_TIQUETE")
    private BigInteger idTiquete;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private BigInteger idCliente;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "ID_PARTIDO", referencedColumnName = "ID_PARTIDO")
    @ManyToOne
    private Partido idPartido;
    @JoinColumns({
        @JoinColumn(name = "ID_SILLA", referencedColumnName = "ID_SILLA")
        , @JoinColumn(name = "ID_ESTADIO", referencedColumnName = "ID_ESTADIO")})
    @ManyToOne
    private Silla silla;

    public Tiquete() {
    }

     public Tiquete(BigInteger idTiquete,BigInteger idCliente , Cliente cliente,Partido partido,Silla s) {
         this.cliente = cliente;
         this.idCliente = idCliente;
         this.idPartido=partido;
         this.silla = s;
         this.idTiquete =  idTiquete;
    }
    
    public Tiquete(BigInteger idCliente) {
        this.idCliente = idCliente;
    }

    public BigInteger getIdTiquete() {
        return idTiquete;
    }

    public void setIdTiquete(BigInteger idTiquete) {
        this.idTiquete = idTiquete;
    }

    public BigInteger getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(BigInteger idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Partido getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Partido idPartido) {
        this.idPartido = idPartido;
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
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiquete)) {
            return false;
        }
        Tiquete other = (Tiquete) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rusia2018.Tiquete[ idCliente=" + idCliente + " ]";
    }
    
}
