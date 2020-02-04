/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rusia2018;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego Gamboa
 */
@Entity
@Table(name = "JUGADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jugador.findAll", query = "SELECT j FROM Jugador j")
    , @NamedQuery(name = "Jugador.findByIdPersona", query = "SELECT j FROM Jugador j WHERE j.idPersona = :idPersona")
    , @NamedQuery(name = "Jugador.findByFechaNacimineto", query = "SELECT j FROM Jugador j WHERE j.fechaNacimineto = :fechaNacimineto")
    , @NamedQuery(name = "Jugador.findByEstatura", query = "SELECT j FROM Jugador j WHERE j.estatura = :estatura")
    , @NamedQuery(name = "Jugador.findByNaciaonalidad", query = "SELECT j FROM Jugador j WHERE j.naciaonalidad = :naciaonalidad")
    , @NamedQuery(name = "Jugador.findByNumeroJugador", query = "SELECT j FROM Jugador j WHERE j.numeroJugador = :numeroJugador")
    , @NamedQuery(name = "Jugador.findByTipoJugador", query = "SELECT j FROM Jugador j WHERE j.tipoJugador = :tipoJugador")
    , @NamedQuery(name = "Jugador.findByTitsup", query = "SELECT j FROM Jugador j WHERE j.titsup = :titsup")})
public class Jugador implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PERSONA")
    private BigInteger idPersona;
    @Basic(optional = false)
    @Column(name = "FECHA_NACIMINETO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimineto;
    @Basic(optional = false)
    @Column(name = "ESTATURA")
    private String estatura;
    @Basic(optional = false)
    @Column(name = "NACIAONALIDAD")
    private String naciaonalidad;
    @Lob
    @Column(name = "FOTO")
    private byte[] foto;
    @Basic(optional = false)
    @Column(name = "NUMERO_JUGADOR")
    private BigInteger numeroJugador;
    @Basic(optional = false)
    @Column(name = "TIPO_JUGADOR")
    private String tipoJugador;
    @Basic(optional = false)
    @Column(name = "TITSUP")
    private String titsup;
    @JoinTable(name = "JUGADOR_CLUB", joinColumns = {
        @JoinColumn(name = "ID_JUGADOR", referencedColumnName = "ID_PERSONA")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_CLUB", referencedColumnName = "ID_CLUB")})
    @ManyToMany
    private List<Clubes> clubesList;
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID_EQUIPO")
    @ManyToOne(optional = false)
    private Equipo idEquipo;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;
    @OneToMany(mappedBy = "idJugador")
    private List<Tarjeta> tarjetaList;
    @OneToMany(mappedBy = "idJugador")
    private List<Goles> golesList;

    public Jugador() {
    }

    public Jugador(BigInteger idPersona) {
        this.idPersona = idPersona;
    }

    public Jugador(BigInteger idPersona, Date fechaNacimineto, String estatura, String naciaonalidad, BigInteger numeroJugador, String tipoJugador, String titsup) {
        this.idPersona = idPersona;
        this.fechaNacimineto = fechaNacimineto;
        this.estatura = estatura;
        this.naciaonalidad = naciaonalidad;
        this.numeroJugador = numeroJugador;
        this.tipoJugador = tipoJugador;
        this.titsup = titsup;
    }

    public BigInteger getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(BigInteger idPersona) {
        this.idPersona = idPersona;
    }

    public Date getFechaNacimineto() {
        return fechaNacimineto;
    }

    public void setFechaNacimineto(Date fechaNacimineto) {
        this.fechaNacimineto = fechaNacimineto;
    }

    public String getEstatura() {
        return estatura;
    }

    public void setEstatura(String estatura) {
        this.estatura = estatura;
    }

    public String getNaciaonalidad() {
        return naciaonalidad;
    }

    public void setNaciaonalidad(String naciaonalidad) {
        this.naciaonalidad = naciaonalidad;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public BigInteger getNumeroJugador() {
        return numeroJugador;
    }

    public void setNumeroJugador(BigInteger numeroJugador) {
        this.numeroJugador = numeroJugador;
    }

    public String getTipoJugador() {
        return tipoJugador;
    }

    public void setTipoJugador(String tipoJugador) {
        this.tipoJugador = tipoJugador;
    }

    public String getTitsup() {
        return titsup;
    }

    public void setTitsup(String titsup) {
        this.titsup = titsup;
    }

    @XmlTransient
    public List<Clubes> getClubesList() {
        return clubesList;
    }

    public void setClubesList(List<Clubes> clubesList) {
        this.clubesList = clubesList;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @XmlTransient
    public List<Tarjeta> getTarjetaList() {
        return tarjetaList;
    }

    public void setTarjetaList(List<Tarjeta> tarjetaList) {
        this.tarjetaList = tarjetaList;
    }

    @XmlTransient
    public List<Goles> getGolesList() {
        return golesList;
    }

    public void setGolesList(List<Goles> golesList) {
        this.golesList = golesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugador)) {
            return false;
        }
        Jugador other = (Jugador) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rusia2018.Jugador[ idPersona=" + idPersona + " ]";
    }
    
}
