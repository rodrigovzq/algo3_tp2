package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Excepcion.JugadorInvalido;
import edu.fiuba.algo3.modelo.Excepcion.MovimientoInvalido;
import edu.fiuba.algo3.modelo.Impresora.Imprimible;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Observable;
import edu.fiuba.algo3.modelo.Vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

import java.util.Objects;

public class Jugador extends Observable implements Imprimible {
    private final int MOVIMIENTOS_INICIALES = 0;
    public static final String DELIMITADOR = ";";
    private String nombre;
    private Celda posicion;
    private IVehiculo vehiculo;
    private Movimiento puntaje;

    public Jugador(String nombre, Celda posicion, IVehiculo vehiculo) {
        if( nombre != null && posicion != null && vehiculo != null){
            this.nombre = nombre;
            this.posicion = posicion;
            this.vehiculo = vehiculo;
        }else throw new JugadorInvalido("Inicializacion Jugador invalida.");
        this.puntaje = new Movimiento(MOVIMIENTOS_INICIALES);
    }
    public Jugador(String nombre, Celda posicion, IVehiculo vehiculo, Integer movimientos) {
        if( nombre != null && posicion != null && vehiculo != null && movimientos != null){
            this.nombre = nombre;
            this.posicion = posicion;
            this.vehiculo = vehiculo;
            try{
                this.puntaje = new Movimiento(movimientos);
            }catch( MovimientoInvalido e ){
                throw new JugadorInvalido("Jugador.puntaje :" + e.getMessage());
            }
        }else throw new JugadorInvalido("Inicializacion Jugador invalida.");
    }
    @Override
    public String imprimir() {
        return nombre + DELIMITADOR + posicion.imprimir().split(Celda.DELIMITADOR)[1] + DELIMITADOR + vehiculo.imprimir() + DELIMITADOR + puntaje.imprimir();
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
        notificarATodos();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return nombre.equals( jugador.nombre ) && posicion.equals( jugador.posicion) && vehiculo.equals( jugador.vehiculo) && puntaje.equals(jugador.puntaje);
    }

    public void setVehiculo(IVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setNombre(String texto) {
        this.nombre = texto;
    }

    public void setPosicion(Celda posicion) {
        this.posicion = posicion;
    }

    public Coordenada getPosicion() {
        return posicion.getCoordenada();
    }
    public IVehiculo getVehiculo() {
        return vehiculo;
    }
    public Movimiento getPuntaje() {
        return puntaje;
    }
}

