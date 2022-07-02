package edu.fiuba.algo3.modelo.Evento;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.EventoPosicion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.EventoPuntaje;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.EventoVehiculo;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class Evento {
    private EventoPuntaje eventoPuntaje;
    private EventoVehiculo eventoVehiculo;
    private EventoPosicion eventoPosicion;
    public Evento(EventoPuntaje eventoPuntaje, EventoVehiculo eventoVehiculo, EventoPosicion eventoPosicion) {
        this.eventoPuntaje = eventoPuntaje;
        this.eventoVehiculo = eventoVehiculo;
        this.eventoPosicion = eventoPosicion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return ( eventoPuntaje.equals(evento.eventoPuntaje) && eventoVehiculo.equals(evento.eventoVehiculo) && eventoPosicion.equals(evento.eventoPosicion) );
    }

    public Movimiento actualizarPuntaje(Movimiento puntaje) {
        return eventoPuntaje.actualizarPuntaje( puntaje );
    }
    public IVehiculo actualizarVehiculo(IVehiculo vehiculo) {
        return eventoVehiculo.actualizarVehiculo( vehiculo );
    } 
    public Celda actualizarPosicion(Celda posicion) {
        return eventoPosicion.actualizarPosicion( posicion );
    }
    //TODO: ¿Esto para que nos servía?
    public void setDireccion(Direccion direccion) {
        eventoPosicion.setDireccion(direccion);
    }
}
