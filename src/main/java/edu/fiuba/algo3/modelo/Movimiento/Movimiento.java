package edu.fiuba.algo3.modelo.Movimiento;

import java.util.Objects;

public class Movimiento {
    private Integer cantidad;

    public Movimiento(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Movimiento sumarMovimiento(Movimiento m) {
        this.cantidad += m.cantidad;
        return m;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movimiento m = (Movimiento) o;
        return Objects.equals(cantidad, m.cantidad);
    }

    public Movimiento aplicarAumento(Float porcentaje) {
        int puntajeNuevo = Math.round(this.cantidad * (1 + porcentaje/100));
        return new Movimiento(puntajeNuevo);

    }

    public Movimiento aplicarDescuento(Float porcentaje) {
        int puntajeNuevo = Math.round(this.cantidad * (1 - porcentaje/100));
        return new Movimiento(puntajeNuevo);
    }
}
