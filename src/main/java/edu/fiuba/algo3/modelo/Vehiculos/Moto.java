package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.NoCambiarPosicion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.Penalizacion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.SinPenalizar;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.NoCambiarVehiculo;
import edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorDemora;

import java.util.Random;

public class Moto implements IVehiculo {

    private final Integer PENALIZACION_POZO = 3;
    private final Integer PENALIZACION_PIQUETE = 2;
    private final Float PROBABILIDAD_DE_SER_DEMORADO = 0.8f;
    private final Integer PENALIZACION_CONTROL_POLICIAL = 3;
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
        return new Evento(new Penalizacion(PENALIZACION_CONTROL_POLICIAL), new NoCambiarVehiculo(), new Avanzar());
    }
    @Override
    public IVehiculo siguiente() {
        return new ReliantRobin(new GeneradorDemora());
    }

    @Override
    public String imprimir() {
        return "Moto";
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
        if( o == null) return false;
        if (this == o || getClass() == o.getClass()) return true;
        return false;
    }

}
