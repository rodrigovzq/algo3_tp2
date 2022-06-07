package edu.fiuba.algo3.modelo.Posicion;

import edu.fiuba.algo3.modelo.Jugador.Celda.Celda;
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

    public Movimiento avanzarrHaciaLaDireccion(String direccion, IVehiculo vehiculo){
        Movimiento movimiento = null;

        return movimiento;
    }
}
