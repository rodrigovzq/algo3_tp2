package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.EstadoCelda.EstadoCelda;

public class CeldaInterna extends Celda {

    private Celda celdaNorte;
    private Celda celdaEste;
    private Celda celdaSur;
    private Celda celdaOeste;

    public CeldaInterna(EstadoCelda estado, Coordenada coordenada) {
        super( estado, coordenada );
        Celda celdaNula = new CeldaBloqueadora();
        this.celdaNorte = celdaNula;
        this.celdaEste =  celdaNula;
        this.celdaSur =  celdaNula;
        this.celdaOeste =  celdaNula;
    }
    @Override
    public Celda getCelda(Direccion direccion){
        Celda celdaAdyacente = null;

        if (direccion == Direccion.NORTE) {
            celdaAdyacente = celdaNorte;
        } else if (direccion == Direccion.ESTE) {
            celdaAdyacente = celdaEste;
        } else if (direccion == Direccion.OESTE) {
            celdaAdyacente = celdaOeste;
        } else if (direccion == Direccion.SUR) {
            celdaAdyacente = celdaSur;
        }
        return celdaAdyacente;
    }

    @Override
    public void setCelda(Celda nuevaCelda, Direccion direccion){

        if (direccion == Direccion.NORTE) {
            this.celdaNorte = nuevaCelda;
        } else if (direccion == Direccion.ESTE) {
            this.celdaEste = nuevaCelda;
        } else if (direccion == Direccion.OESTE) {
            this.celdaOeste = nuevaCelda;
        } else if (direccion == Direccion.SUR) {
            this.celdaSur = nuevaCelda;
        }

        this.setCeldaOpuesta( nuevaCelda, direccion);

    }

}
