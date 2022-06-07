package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public interface EstadoCelda {
    Movimiento avanzarEn(IVehiculo vehiculo);
}
