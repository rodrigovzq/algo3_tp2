package edu.fiuba.algo3.modelo.Posicion;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

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
            case Direccion.NORTE:
                nuevaPosicion = posicionJugador.getCeldaNorte();
            case Direccion.ESTE:
                nuevaPosicion = posicionJugador.getCeldaEste();
            case Direccion.OESTE:
                nuevaPosicion = posicionJugador.getCeldaOeste();
            case Direccion.SUR:
                nuevaPosicion = posicionJugador.getCeldaSur();
        }

        movimiento = nuevaPosicion.avanzarEn( vehiculo );
        if( movimiento.esPosible() ){
            this.posicionJugador = nuevaPosicion;
        }

        return movimiento;
    }
}
