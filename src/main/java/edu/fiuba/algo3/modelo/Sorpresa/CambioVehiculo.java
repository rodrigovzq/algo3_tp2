package edu.fiuba.algo3.modelo.Sorpresa;

import edu.fiuba.algo3.modelo.EstadoCelda.Comun;
import edu.fiuba.algo3.modelo.EstadoCelda.IEstadoCelda;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.SinPenalizar;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.SiguienteVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class CambioVehiculo implements ISorpresa {
    @Override
    public Evento avanzarEn(IVehiculo vehiculo) {
        return new Evento(new SinPenalizar(), new SiguienteVehiculo(), new Avanzar());
    }

    @Override
    public boolean equals(Object obj) {
        return ( obj != null && ( this == obj || this.getClass() == obj.getClass() ));
    }

    @Override
    public String imprimir() {
        return Sorpresa.CAMBIO_VEHICULO.name();
    }

    public IEstadoCelda siguiente(){ return new Comun();}
}
