package edu.fiuba.algo3.modelo.Vehiculos;


import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoInvalido;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoValido;

public class Auto implements IVehiculo {

    public static final int PENALIZACION_POZO = 3;

    @Override
    public Movimiento avanzarComun() {
        /* se implementa algo*/
        return null;
    }

    @Override
    public Movimiento avanzarPiquete() {
        return new MovimientoInvalido();
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
