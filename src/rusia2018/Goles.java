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
@Table(name = "GOLES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Goles.findAll", query = "SELECT g FROM Goles g")
    , @NamedQuery(name = "Goles.findByIdGol", query = "SELECT g FROM Goles g WHERE g.idGol = :idGol")
    , @NamedQuery(name = "Goles.findByTipo", query = "SELECT g FROM Goles g WHERE g.tipo = :tipo")
    , @NamedQuery(name = "Goles.findByMinuto", query = "SELECT g FROM Goles g WHERE g.minuto = :minuto")})
public class Goles implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_GOL")
    private BigInteger idGol;
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

    public Goles() {
    }
    
    public Goles(BigInteger idGol,BigInteger minuto,Jugador jugador,Partido partido) {
        this.idGol = idGol;
        this.idJugador = jugador;
        this.tipo= "";
        this.idPartido = partido;
        this.minuto = minuto;
    } 

    public Goles(BigInteger idGol) {
        this.idGol = idGol;
    }

    public BigInteger getIdGol() {
        return idGol;
    }

    public void setIdGol(BigInteger idGol) {
        this.idGol = idGol;
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
        hash += (idGol != null ? idGol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Goles)) {
            return false;
        }
        Goles other = (Goles) object;
        if ((this.idGol == null && other.idGol != null) || (this.idGol != null && !this.idGol.equals(other.idGol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rusia2018.Goles[ idGol=" + idGol + " ]";
    }
    
}
