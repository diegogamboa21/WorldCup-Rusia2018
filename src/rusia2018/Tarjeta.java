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
@Table(name = "TARJETA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarjeta.findAll", query = "SELECT t FROM Tarjeta t")
    , @NamedQuery(name = "Tarjeta.findByIdTarjeta", query = "SELECT t FROM Tarjeta t WHERE t.idTarjeta = :idTarjeta")
    , @NamedQuery(name = "Tarjeta.findByTipo", query = "SELECT t FROM Tarjeta t WHERE t.tipo = :tipo")
    , @NamedQuery(name = "Tarjeta.findByMinuto", query = "SELECT t FROM Tarjeta t WHERE t.minuto = :minuto")})
public class Tarjeta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TARJETA")
    private BigInteger idTarjeta;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "MINUTO")
    private BigInteger minuto;
    @JoinColumn(name = "ID_JUGADOR", referencedColumnName = "ID_PERSONA")
    @ManyToOne
    private Jugador idJugador;
    @JoinColumn(name = "ID_PARTIDO", referencedColumnName = "ID_PARTIDO")
    @ManyToOne
    private Partido idPartido;

    public Tarjeta() {
    }

    public Tarjeta(BigInteger idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public BigInteger getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(BigInteger idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigInteger getMinuto() {
        return minuto;
    }

    public void setMinuto(BigInteger minuto) {
        this.minuto = minuto;
    }

    public Jugador getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Jugador idJugador) {
        this.idJugador = idJugador;
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
        hash += (idTarjeta != null ? idTarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarjeta)) {
            return false;
        }
        Tarjeta other = (Tarjeta) object;
        if ((this.idTarjeta == null && other.idTarjeta != null) || (this.idTarjeta != null && !this.idTarjeta.equals(other.idTarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rusia2018.Tarjeta[ idTarjeta=" + idTarjeta + " ]";
    }
    
}
