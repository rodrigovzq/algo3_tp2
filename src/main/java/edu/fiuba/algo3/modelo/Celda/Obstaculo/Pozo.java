package edu.fiuba.algo3.modelo.Celda.Obstaculo;

import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class Pozo implements Obstaculo{
    @Override
    public Movimiento avanzarEn(IVehiculo vehiculo) {
        return vehiculo.avanzarPozo();
    }
}
