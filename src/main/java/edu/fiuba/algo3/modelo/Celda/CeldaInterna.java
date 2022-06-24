package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

import java.util.Objects;

public class CeldaInterna extends Celda {

    private Celda celdaNorte;
    private Celda celdaEste;
    private Celda celdaSur;
    private Celda celdaOeste;

    public CeldaInterna(EstadoCelda estado, Celda celdaNorte, Celda celdaEste, Celda celdaSur, Celda celdaOeste) {
        super( estado );
        this.celdaNorte = celdaNorte;
        this.celdaEste = celdaEste;
        this.celdaSur = celdaSur;
        this.celdaOeste = celdaOeste;
    }

    public CeldaInterna(EstadoCelda estado) {
        super( estado );
        this.celdaNorte = null;
        this.celdaEste =  null;
        this.celdaSur =  null;
        this.celdaOeste =  null;
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

        if( nuevaCelda.getCelda(direccion.opuesto()) == null)
            nuevaCelda.setCelda( this, direccion.opuesto() );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CeldaInterna celda = (CeldaInterna) o;
        return Objects.equals(celdaNorte, celda.celdaNorte) && Objects.equals(celdaEste, celda.celdaEste) && Objects.equals(celdaSur, celda.celdaSur) && Objects.equals(celdaOeste, celda.celdaOeste);
    }

}
