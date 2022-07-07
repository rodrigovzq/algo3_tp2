package edu.fiuba.algo3.modelo.EstadoCelda;

import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class Comun implements IEstadoCelda {
    @Override
    public Evento avanzarEn(IVehiculo vehiculo) {
        return vehiculo.avanzarComun();
    }

    @Override
    public String imprimir() {
        return "COMUN";
    }

    @Override
    public boolean equals(Object obj) {
        return ( obj != null && ( this == obj || this.getClass() == obj.getClass() ));
    }

    @Override
    public IEstadoCelda siguiente() {
        return this;
    }
}
