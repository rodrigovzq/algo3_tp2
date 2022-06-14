package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Evento.*;

import java.util.Objects;

public interface IVehiculo {

    public  Evento avanzarComun();
    public  Evento avanzarPiquete();
    public  Evento avanzarControlPolicial();
    public  Evento avanzarPozo();

    IVehiculo siguiente();
}
