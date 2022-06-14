package edu.fiuba.algo3.modelo.Evento;

import edu.fiuba.algo3.modelo.Evento.EventoPosicion.EventoPosicion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.EventoPuntaje;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.EventoVehiculo;

public class Evento {
    public Evento(EventoPuntaje eventoPuntaje, EventoVehiculo eventoVehiculo, EventoPosicion eventoPosicion) {
        this.eventoPuntaje = eventoPuntaje;
        this.eventoVehiculo = eventoVehiculo;
        this.eventoPosicion = eventoPosicion;
    }

    private EventoPuntaje eventoPuntaje;
    private EventoVehiculo eventoVehiculo;
    private EventoPosicion eventoPosicion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return eventoPuntaje.equals(evento.eventoPuntaje) && eventoVehiculo.equals(evento.eventoVehiculo) && eventoPosicion.equals(evento.eventoPosicion);
    }

}
