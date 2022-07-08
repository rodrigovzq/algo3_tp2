package edu.fiuba.algo3.modelo.Vehiculos;


import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.NoCambiarPosicion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.EventoPuntaje;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.NoCambiarPuntaje;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.Penalizacion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.SinPenalizar;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.EventoVehiculo;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.NoCambiarVehiculo;
import java.util.Random;

public class CuatroPorCuatro implements IVehiculo {
    public static final int LIMITE_POZOS = 3;
    public static final int RESET_CONTADOR = 0;
    public static final int PENALIZACION_POZO = 2;
    private static final Float PROBABILIDAD_DE_SER_DEMORADO = 0.3f;
    private static final Integer PENALIZACION_CONTROL_POLICIAL = 3;

    private Integer contadorPozosAtravesados;

    public CuatroPorCuatro() {
        this.contadorPozosAtravesados = RESET_CONTADOR;
    }

    private void resetearContadorPozos() {
        this.contadorPozosAtravesados = RESET_CONTADOR;
    }

    private void contarPozoAtravesado() {
        this.contadorPozosAtravesados++;
    }

    private boolean limiteDePozosExcedido() {
        return contadorPozosAtravesados.equals(LIMITE_POZOS);
    }

    @Override
    public Evento avanzarComun() {
        return new Evento(new SinPenalizar(), new NoCambiarVehiculo(), new Avanzar());
    }

    @Override
    public Evento avanzarPiquete() {
        return new Evento(new NoCambiarPuntaje(), new NoCambiarVehiculo(), new NoCambiarPosicion());
    }

    @Override
    public Evento avanzarControlPolicial() {
        return new Evento(new Penalizacion(PENALIZACION_CONTROL_POLICIAL), new NoCambiarVehiculo(), new Avanzar());
    }

    @Override
    public IVehiculo siguiente() {
        return new Moto();
    }

    @Override
    public String imprimir() {
        return "CuatroPorCuatro";
    }

    @Override
    public Evento avanzarPozo() {
        Evento evento = null;

        this.contarPozoAtravesado();

        if (this.limiteDePozosExcedido()) {
            this.resetearContadorPozos();
            evento = new Evento(new Penalizacion(PENALIZACION_POZO), new NoCambiarVehiculo(), new Avanzar());
        } else {
            evento = new Evento(new SinPenalizar(), new NoCambiarVehiculo(), new Avanzar());
        }

        return evento;
    }

    @Override
    public Float obtenerProbabilidadDeSerDetenido() {
        return PROBABILIDAD_DE_SER_DEMORADO;
    }

    public boolean equals(Object o) {
        return ( o != null && ( this == o || this.getClass() == o.getClass() ));
    }

}