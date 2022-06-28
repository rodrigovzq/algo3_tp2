package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

import java.util.Objects;

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

    public Evento avanzarHaciaLaDireccion(Direccion direccion){
        Evento evento = null;
        Celda nuevaPosicion = posicion.getCelda(direccion);

        evento = nuevaPosicion.avanzarEn( this.vehiculo );
        evento.setDireccion(direccion);
        return evento;
    }

    public void actualizar(Evento resultado) {
        this.puntaje = resultado.actualizarPuntaje( this.puntaje );
        this.vehiculo = resultado.actualizarVehiculo( this.vehiculo );
        this.posicion = resultado.actualizarPosicion( this.posicion );    
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return Objects.equals(nombre, jugador.nombre) && Objects.equals(posicion, jugador.posicion) && Objects.equals(vehiculo, jugador.vehiculo) && Objects.equals(puntaje, jugador.puntaje);
    }

}

