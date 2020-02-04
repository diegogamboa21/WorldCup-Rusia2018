package rusia2018;

import java.math.BigInteger;

/**
 *
 * @author Diego Gamboa
 */
public class Octavos {
    private Equipo equipo;
    private int pos;
    private int pe;
    private int pg;
    private int pp;
    private int puntos;

    public Octavos(Equipo equipo) {
        this.equipo = equipo;
        this.pe = 0;
        this.pg = 0;
        this.pp = 0;
        this.puntos = 0;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getPe() {
        return pe;
    }

    public void setPe(int pe) {
        this.pe = pe;
    }

    public int getPg() {
        return pg;
    }

    public void setPg(int pg) {
        this.pg = pg;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    
}
