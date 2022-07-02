package edu.fiuba.algo3.modelo.Evento.EventoPuntaje;

import edu.fiuba.algo3.modelo.Movimiento.Movimiento;

import java.util.Objects;

public class DescuentoPorcentaje implements EventoPuntaje {
    private Float porcentaje;
    public DescuentoPorcentaje(Float porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public Movimiento actualizarPuntaje(Movimiento m) {
        return m.aplicarDescuento( this.porcentaje );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DescuentoPorcentaje that = (DescuentoPorcentaje) o;
        return porcentaje.equals( that.porcentaje );
    }

    @Override
    public int hashCode() {
        return Objects.hash(porcentaje);
    }
}
