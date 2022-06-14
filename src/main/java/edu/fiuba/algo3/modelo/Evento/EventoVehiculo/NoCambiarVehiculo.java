package edu.fiuba.algo3.modelo.Evento.EventoVehiculo;

import edu.fiuba.algo3.modelo.Evento.Evento;

public class NoCambiarVehiculo implements EventoVehiculo {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }
}
