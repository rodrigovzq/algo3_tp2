package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Celda.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class Celda {
    private EstadoCelda estado;
    public Evento avanzarEn(IVehiculo vehiculo){
        return estado.avanzarEn( vehiculo );
    }

    public Celda(EstadoCelda estado) {
        this.estado = estado;
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
            case ESTE:
                celdaAdyacente = new Celda( estado );
            case OESTE:
                celdaAdyacente = new Celda( estado );
            case SUR:
                celdaAdyacente = new Celda( estado );
                break;
        }
        return celdaAdyacente;
    }
}
