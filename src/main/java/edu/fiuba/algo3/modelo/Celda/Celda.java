package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

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
        this.celdaEste = null;
        this.celdaSur = null;
        this.celdaOeste = null;
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
        switch (direccion) {
            case NORTE:
                celdaAdyacente = new Celda( estado );
                break;

            case ESTE:
                celdaAdyacente = new Celda( estado );
                break;

            case OESTE:
                celdaAdyacente = new Celda( estado );
                break;

            case SUR:
                celdaAdyacente = new Celda( estado );
                break;
        }
        return celdaAdyacente;
    }
}
