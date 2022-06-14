package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public interface EstadoCelda {
    Evento avanzarEn(IVehiculo vehiculo);
}
