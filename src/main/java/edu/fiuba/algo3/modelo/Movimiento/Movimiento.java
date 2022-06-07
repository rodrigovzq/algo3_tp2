package edu.fiuba.algo3.modelo.Movimiento;

import java.util.Objects;

public abstract class Movimiento {
    private Integer cantidad;

    public Movimiento(Integer cantidad) {
        this.cantidad = cantidad;
    }

    private Integer getCantidad() {
        return cantidad;
    }

    public abstract boolean esPosible();
    public void sumarMovimiento( Movimiento m){
        this.cantidad += m.getCantidad();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movimiento that = (Movimiento) o;
        return Objects.equals(cantidad, that.cantidad);
    }
}
