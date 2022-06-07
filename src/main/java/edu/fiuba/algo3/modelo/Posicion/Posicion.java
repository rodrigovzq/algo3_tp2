package edu.fiuba.algo3.modelo.Posicion;

import edu.fiuba.algo3.modelo.Celda.Celda;
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

    public Movimiento avanzarHaciaLaDireccion(String direccion, IVehiculo vehiculo){
        Movimiento movimiento = null;
        Celda nuevaPosicion = null;
        // TODO: Cambiar. (?) Es algo que todavía no está decidido. Pero no concuerda
        //  con los diagrama de secuencia.
        if( direccion.equals("este")){
            nuevaPosicion = posicionJugador.getCeldaEste();
            movimiento = nuevaPosicion.avanzarEn( vehiculo );
        }

        if( movimiento.esPosible() ){
            this.posicionJugador = nuevaPosicion;
        }

        return movimiento;
    }
}
