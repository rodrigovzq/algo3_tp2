package edu.fiuba.algo3.modelo.Evento.EventoVehiculo;

import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public interface EventoVehiculo {
    public boolean equals(Object o);

    IVehiculo actualizarVehiculo(IVehiculo v);
}
