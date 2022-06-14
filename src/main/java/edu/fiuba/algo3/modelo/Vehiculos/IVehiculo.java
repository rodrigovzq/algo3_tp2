package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Evento.*;

public interface IVehiculo {

    public  Evento avanzarComun();
    public  Evento avanzarPiquete();
    public  Evento avanzarControlPolicial();
    public  Evento avanzarPozo();

    IVehiculo siguiente();
}
