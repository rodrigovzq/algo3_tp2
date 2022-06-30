package edu.fiuba.algo3.modelo.Vehiculos;


import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.NoCambiarPosicion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.NoCambiarPuntaje;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.Penalizacion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.SinPenalizar;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.NoCambiarVehiculo;

import java.util.Objects;

public class Auto implements IVehiculo {
    private final int PENALIZACION_POZO = 3;
    private static final Float PROBABILIDAD_DE_SER_DEMORADO = 0.5f;
    private static final Integer PENALIZACION_CONTROL_POLICIAL = 3 ;

    @Override
    public  Evento avanzarComun() {
        return new Evento( new SinPenalizar(),new NoCambiarVehiculo(), new Avanzar());
    }

    @Override
    public  Evento avanzarPiquete() {
        return new Evento( new NoCambiarPuntaje(),new NoCambiarVehiculo(), new NoCambiarPosicion());
    }

    @Override
    public  Evento avanzarControlPolicial() {
        return new Evento(new Penalizacion(PENALIZACION_CONTROL_POLICIAL), new NoCambiarVehiculo(), new Avanzar());
    }

    @Override
    public  Evento avanzarPozo() {
        return new Evento( new Penalizacion(PENALIZACION_POZO),new NoCambiarVehiculo(), new Avanzar());
    }

    @Override
    public Float obtenerProbabilidadDeSerDetenido() {
        return PROBABILIDAD_DE_SER_DEMORADO;
    }

    public IVehiculo siguiente() {
        return new CuatroPorCuatro();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }
    @Override
    public String toString() {
        return "Auto";
    }
}
