package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Evento.*;

import java.util.Objects;

public interface IVehiculo {

    Evento avanzarComun();
    Evento avanzarPiquete();
    Evento avanzarControlPolicial();
    Evento avanzarPozo();
    Float obtenerProbabilidadDeSerDetenido();
    IVehiculo siguiente();

}
