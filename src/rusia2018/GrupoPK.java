/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rusia2018;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Diego Gamboa
 */
@Embeddable
public class GrupoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_GRUPO")
    private String idGrupo;
    @Basic(optional = false)
    @Column(name = "NOMBRE_EQUIPO")
    private String nombreEquipo;

    public GrupoPK() {
    }

    public GrupoPK(String idGrupo, String nombreEquipo) {
        this.idGrupo = idGrupo;
        this.nombreEquipo = nombreEquipo;
    }

    public String getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupo != null ? idGrupo.hashCode() : 0);
        hash += (nombreEquipo != null ? nombreEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoPK)) {
            return false;
        }
        GrupoPK other = (GrupoPK) object;
        if ((this.idGrupo == null && other.idGrupo != null) || (this.idGrupo != null && !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        if ((this.nombreEquipo == null && other.nombreEquipo != null) || (this.nombreEquipo != null && !this.nombreEquipo.equals(other.nombreEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rusia2018.GrupoPK[ idGrupo=" + idGrupo + ", nombreEquipo=" + nombreEquipo + " ]";
    }
    
}
