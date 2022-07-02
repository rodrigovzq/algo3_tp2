package edu.fiuba.algo3.modelo.Movimiento;

import edu.fiuba.algo3.modelo.Excepcion.MovimientoInvalido;
import edu.fiuba.algo3.modelo.Impresora.Imprimible;

import java.util.Objects;

public class Movimiento implements Imprimible {
    private Integer cantidad;

    public Movimiento(Integer cantidad) {
        if( cantidad >= 0 )
            this.cantidad = cantidad;
        else
            throw new MovimientoInvalido();
    }

    public Movimiento sumarMovimiento(Movimiento m) {
        this.cantidad += m.cantidad;
        return this;
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

    @Override
    public String imprimir() {
        return cantidad.toString();
    }
}
