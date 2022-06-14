package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

import java.util.Objects;

public class Celda {
    private EstadoCelda estado;
    private Celda celdaNorte;
    private Celda celdaEste;
    private Celda celdaSur;
    private Celda celdaOeste;

    public Celda(EstadoCelda estado, Celda celdaNorte, Celda celdaEste, Celda celdaSur, Celda celdaOeste) {
        this.estado = estado;
        this.celdaNorte = celdaNorte;
        this.celdaEste = celdaEste;
        this.celdaSur = celdaSur;
        this.celdaOeste = celdaOeste;
    }

    public Celda(EstadoCelda estado) {
        this.estado = estado;
        this.celdaNorte = null;
        this.celdaEste =  null;
        this.celdaSur =  null;
        this.celdaOeste =  null;
    }

    public Evento avanzarEn(IVehiculo vehiculo){
        return estado.avanzarEn( vehiculo );
    }

    // TODO: La idea es que la celda que tiene posicion
    // sea un nodo del grafo que representa nuestro mapa
    // de esta forma con una celda es suficiente para
    // movernos por el resto del mapa
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Celda celda = (Celda) o;
        return Objects.equals(celdaNorte, celda.celdaNorte) && Objects.equals(celdaEste, celda.celdaEste) && Objects.equals(celdaSur, celda.celdaSur) && Objects.equals(celdaOeste, celda.celdaOeste);
    }

}
