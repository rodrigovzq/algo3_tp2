package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class Jugador {
    public static final int MOVIMIENTOS_INICIALES = 0;
    private String nombre;
    private Celda posicion;
    private IVehiculo vehiculo;
    private Movimiento puntaje;

    public Jugador(String nombre, Celda posicion, IVehiculo vehiculo) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.vehiculo = vehiculo;
        this.puntaje = new Movimiento(MOVIMIENTOS_INICIALES);
    }

    public Evento avanzarHaciaLaDireccion(Direccion direccion, IVehiculo vehiculo){
        Evento movimiento = null;
        Celda nuevaPosicion = null;

        switch (direccion) {
            case NORTE:
                nuevaPosicion = posicion.getCeldaNorte();
            case ESTE:
                nuevaPosicion = posicion.getCeldaEste();
            case OESTE:
                nuevaPosicion = posicion.getCeldaOeste();
            case SUR:
                nuevaPosicion = posicion.getCeldaSur();
                break;
        }

        movimiento = nuevaPosicion.avanzarEn( vehiculo );
        return movimiento;
    }
}

