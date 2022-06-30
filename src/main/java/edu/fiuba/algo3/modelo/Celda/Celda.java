package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Excepcion.DireccionInvalida;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

//TODO: Refactorizar distribución de paquetes. Celda en paquete aparte, separado de Obstaculo, Sorpresa y FabricaCelda.
public abstract class Celda {
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
            if( opuesto == null )
                celda.setCelda( this, direccion.opuesto() );
        }
        catch( DireccionInvalida e){
            //TODO: Completar.
            // Sinceramente no se si hay algun caso posible que pase.
        }

    }

    public abstract Celda getCelda(Direccion direccion) throws DireccionInvalida;
    public abstract void setCelda(Celda nuevaCelda, Direccion direccion) throws DireccionInvalida;
}
