package edu.fiuba.algo3.modelo.EstadoCelda;

import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.SinPenalizar;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.NoCambiarVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class Meta implements IEstadoCelda{
    @Override
    public Evento avanzarEn(IVehiculo vehiculo) {
        return new Evento(new SinPenalizar(), new NoCambiarVehiculo(), new Avanzar());
    }

    @Override
    public IEstadoCelda siguiente() {
        return this;
    }

    @Override
    public String imprimir() {
        return "META";
    }

    @Override
    public boolean equals(Object obj) {
        return ( obj != null && ( this == obj || this.getClass() == obj.getClass() ));
    }

}
