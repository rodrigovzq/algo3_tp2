package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoValido;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class Jugador {
    public static final int MOVIMIENTOS_INICIALES = 0;
    private String nombre;
    private Posicion posicionActual;
    private IVehiculo vehiculo;
    private Movimiento puntaje;

    public Jugador(String nombre, Posicion posicionActual, IVehiculo vehiculo) {
        this.nombre = nombre;
        this.posicionActual = posicionActual;
        this.vehiculo = vehiculo;
        this.puntaje = new MovimientoValido(MOVIMIENTOS_INICIALES);
    }

    public Movimiento avanzarHaciaLaDireccion(Direccion direccion, IVehiculo vehiculo){
        return posicionActual.avanzarHaciaLaDireccion( direccion, vehiculo);
    }
}
