package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.NoCambiarPosicion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.Penalizacion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.SinPenalizar;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.NoCambiarVehiculo;

import java.util.Random;

public class Moto implements IVehiculo {

    public static final int PENALIZACION_POZO = 3;
    public static final int PENALIZACION_PIQUETE = 2;
    public static final int  MOVIMIENTO_DEFAULT = 1;

    private static final Float PROBABILIDAD_DE_SER_DEMORADO = 0.8f;
    private static final int PENALIZACION_POLICIAL=3;
    @Override
    public  Evento avanzarComun() {
        return new Evento( new SinPenalizar(),new NoCambiarVehiculo(), new Avanzar());
    }

    @Override
    public  Evento avanzarPiquete() {
        return new Evento( new Penalizacion(PENALIZACION_PIQUETE),new NoCambiarVehiculo(), new Avanzar());
    }

    @Override
    public  Evento avanzarControlPolicial() {
        Evento evento = null;
        Random random = new Random();
        if (this.obtenerProbabilidadDeSerDetenido()>random.nextDouble()){
            evento = new Evento(new Penalizacion(PENALIZACION_POLICIAL),new NoCambiarVehiculo(),new Avanzar());
        }else{
            evento = new Evento(new Penalizacion(PENALIZACION_POLICIAL),new NoCambiarVehiculo(),new NoCambiarPosicion());
        }
        return evento;
    }

    @Override
    public IVehiculo siguiente() {
        return new Auto();
    }

    @Override
    public  Evento avanzarPozo() {
        return new Evento( new Penalizacion(PENALIZACION_POZO),new NoCambiarVehiculo(), new Avanzar());
    }

    @Override
    public Float obtenerProbabilidadDeSerDetenido() {
        return PROBABILIDAD_DE_SER_DEMORADO;
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }
}
