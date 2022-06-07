package edu.fiuba.algo3.modelo.Movimiento;

public class MovimientoValido extends Movimiento {
    public MovimientoValido(Integer cantidad) {
        super(cantidad);
    }

    @Override
    public boolean esPosible() {
        return true;
    }
}
