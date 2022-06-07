package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoValido;

public class Moto implements IVehiculo {

    public static final int PENALIZACION_POZO = 3;
    public static final int PENALIZACION_PIQUETE = 2;
    public static final int MOVIMIENTO_DEFAULT = 1;

    @Override
    public Movimiento avanzarComun() {
        return new MovimientoValido(MOVIMIENTO_DEFAULT);
    }

    @Override
    public Movimiento avanzarPiquete() {
        return new MovimientoValido(PENALIZACION_PIQUETE);
    }

    @Override
    public Movimiento avanzarControlPolicial() {
        /* se implementa algo*/
        return null;
    }

    @Override
    public Movimiento avanzarPozo() {
        return new MovimientoValido(PENALIZACION_POZO);
    }
}
