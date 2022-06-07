package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoValido;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class Jugador {
    private String nombre;
    private Posicion posicionActual;
    private IVehiculo vehiculo;
    private Movimiento puntaje;

    public Jugador(String nombre, Posicion posicionActual, IVehiculo vehiculo) {
        this.nombre = nombre;
        this.posicionActual = posicionActual;
        this.vehiculo = vehiculo;
        this.puntaje = new MovimientoValido( 0 );
    }

    public Movimiento avanzarHaciaLaDireccion(String direccion, IVehiculo vehiculo) {
        return posicionActual.avanzarrHaciaLaDireccion( direccion, vehiculo);
    }
}
