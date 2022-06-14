package edu.fiuba.algo3.modelo.Evento.EventoVehiculo;

import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.SinPenalizar;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class SiguienteVehiculo implements EventoVehiculo {
    @Override
    public IVehiculo actualizarVehiculo(IVehiculo v) {
        return v.siguiente();
    }
}
