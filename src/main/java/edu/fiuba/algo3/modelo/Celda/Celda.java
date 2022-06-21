package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Excepcion.DireccionInvalida;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public abstract class Celda {
    private EstadoCelda estado;

    public Celda(EstadoCelda estado) {
        this.estado = estado;
    }

    public Evento avanzarEn(IVehiculo vehiculo){
        return estado.avanzarEn( vehiculo );
    }

    // TODO: Lanzar excepcion para las direcciones inaccesibles.
    public abstract Celda getCelda(Direccion direccion) throws DireccionInvalida;
    public abstract void setCelda(Celda nuevaCelda, Direccion direccion) throws DireccionInvalida;
}
