package edu.fiuba.algo3.modelo.Sorpresa;

import edu.fiuba.algo3.modelo.Celda.EstadoCelda;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.DescuentoPorcentaje;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.SinPenalizar;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.NoCambiarVehiculo;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.SiguienteVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class Favorable implements EstadoCelda {

    private final float PORCENTAJE = 20.0F;

    @Override
    public Evento avanzarEn(IVehiculo vehiculo) {
        return new Evento(new DescuentoPorcentaje(PORCENTAJE), new NoCambiarVehiculo(), new Avanzar());
    }
}
