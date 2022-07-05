package edu.fiuba.algo3.modelo.Sorpresa;

import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.DescuentoPorcentaje;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.NoCambiarVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class Favorable implements ISorpresa {

    private final float PORCENTAJE = 20.0F;

    @Override
    public Evento avanzarEn(IVehiculo vehiculo) {
        return new Evento(new DescuentoPorcentaje(PORCENTAJE), new NoCambiarVehiculo(), new Avanzar());
    }

    @Override
    public String imprimir() {
        return Sorpresa.FAVORABLE.name();
    }
    @Override
    public boolean equals(Object obj) {
        return ( obj != null && ( this == obj || this.getClass() == obj.getClass() ));
    }
}
