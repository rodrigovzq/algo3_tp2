package edu.fiuba.algo3.modelo.Evento.EventoVehiculo;

import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class NoCambiarVehiculo implements EventoVehiculo {
    @Override
    public IVehiculo actualizarVehiculo(IVehiculo v) {
        return v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }
}
