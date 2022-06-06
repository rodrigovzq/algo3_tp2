package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Movimiento;

public interface IVehiculo {

   public Movimiento avanzarComun();
    public Movimiento avanzarPiquete();
    public Movimiento avanzarControlPolicial();
    public Movimiento avanzarPozo();

}
