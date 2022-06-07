package edu.fiuba.algo3.modelo.Posicion;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

import static edu.fiuba.algo3.modelo.Direccion.Direccion.*;

public class Posicion {
    private Celda posicionJugador;

    public Posicion(Celda posicionJugador) {
        this.posicionJugador = posicionJugador;
    }

    public void setPosicionJugador(Celda posicionJugador) {
        this.posicionJugador = posicionJugador;
    }

    public Movimiento avanzarHaciaLaDireccion(Direccion direccion, IVehiculo vehiculo){
        Movimiento movimiento = null;
        Celda nuevaPosicion = null;
        // TODO: Distinto al diagrama de secuencia y clases
        switch (direccion){
            case NORTE:
                nuevaPosicion = posicionJugador.getCeldaNorte();
            case ESTE:
                nuevaPosicion = posicionJugador.getCeldaEste();
            case OESTE:
                nuevaPosicion = posicionJugador.getCeldaOeste();
            case SUR:
                nuevaPosicion = posicionJugador.getCeldaSur();
                break;
        }

        movimiento = nuevaPosicion.avanzarEn( vehiculo );
        if( movimiento.esPosible() ){
            this.posicionJugador = nuevaPosicion;
        }

        return movimiento;
    }
}
