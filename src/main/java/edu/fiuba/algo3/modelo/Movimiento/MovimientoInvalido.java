package edu.fiuba.algo3.modelo.Movimiento;

public class MovimientoInvalido extends Movimiento {

    public static final int MOVIMIENTO_NULO = 0;

    public MovimientoInvalido() {
        super(MOVIMIENTO_NULO);
    }

    @Override
    public boolean esPosible() {
        return false;
    }
}
