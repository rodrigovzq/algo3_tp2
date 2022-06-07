package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Celda.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class Celda {
    private EstadoCelda estado;
    public Movimiento avanzarEn(IVehiculo vehiculo){
        return estado.avanzarEn( vehiculo );
    }

    public Celda(EstadoCelda estado) {
        this.estado = estado;
    }

    // TODO: La idea es que la celda que tiene posicion
    // sea un nodo del grafo que representa nuestro mapa
    // de esta forma con una celda es suficiente para
    // movernos por el resto del mapa
    public Celda getCeldaEste() {
        return new Celda( estado );
    }

    public Celda getCeldaNorte() {
        return new Celda( estado );
    }

    public Celda getCeldaOeste() {
        return new Celda( estado );
    }

    public Celda getCeldaSur() {
        return new Celda( estado );
    }
}
