package edu.fiuba.algo3.modelo.Celda.Sorpresa;

import edu.fiuba.algo3.modelo.Celda.EstadoCelda;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.DescuentoPorcentaje;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.SinPenalizar;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.NoCambiarVehiculo;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.SiguienteVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class Favorable implements EstadoCelda {

    @Override
    public Evento avanzarEn(IVehiculo vehiculo) {
        return new Evento(new DescuentoPorcentaje(20.0F), new NoCambiarVehiculo(), new Avanzar());
    }
}