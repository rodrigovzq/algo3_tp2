package edu.fiuba.algo3.modelo.Movimiento;

import java.util.Objects;

public class Movimiento {
    private Integer cantidad;

    public Movimiento(Integer cantidad) {
        this.cantidad = cantidad;
    }

    private Integer getCantidad() {
        return cantidad;
    }

    public Movimiento sumarMovimiento(Movimiento m) {
        this.cantidad += m.cantidad;
        return m;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movimiento that = (Movimiento) o;
        return Objects.equals(cantidad, that.cantidad);
    }

}
