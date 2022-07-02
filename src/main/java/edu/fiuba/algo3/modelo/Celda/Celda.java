package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.EstadoCelda.EstadoCelda;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Excepcion.DireccionInvalida;
import edu.fiuba.algo3.modelo.Impresora.Imprimible;
import edu.fiuba.algo3.modelo.Observable;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;


import java.util.Objects;

public abstract class Celda extends Observable implements Imprimible {
    public static final String DELIMITADOR = "-";
    private EstadoCelda estado;
    private Coordenada coordenada;
    public Celda(EstadoCelda estado, Coordenada coordenada) {
        this.estado = estado;
        this.coordenada = coordenada;
    }

    public Evento avanzarEn(IVehiculo vehiculo){
        return estado.avanzarEn( vehiculo );
    }

    public void setCeldaOpuesta( Celda celda, Direccion direccion){
        try{
            Celda opuesto = celda.getCelda(direccion.opuesto());
            if( opuesto.equals( new CeldaBloqueadora() ) )
                celda.setCelda( this, direccion.opuesto() );
        }catch( DireccionInvalida e){
            //TODO: ¿Como pretenden que tratemos a las excepciones?
            System.out.println("Se intentó conectar dos celdas que no pueden ser birdireccionales");
        }

    }

    public abstract Celda getCelda(Direccion direccion) throws DireccionInvalida;
    public abstract void setCelda(Celda nuevaCelda, Direccion direccion) throws DireccionInvalida;
    public void setEstado(EstadoCelda estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Celda celda = (Celda) o;
        return Objects.equals(coordenada, celda.coordenada);
    }

    public Integer distanciaVertical(Celda celda) {
        return coordenada.distanciaVertical(celda.coordenada);
    }

    public Integer distanciaHorizontal(Celda celda) {
        return coordenada.distanciaHorizontal(celda.coordenada);
    }

    @Override
    public String imprimir() {
        return estado.imprimir() + this.DELIMITADOR + coordenada.imprimir();
    }
}
