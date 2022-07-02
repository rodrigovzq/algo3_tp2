package edu.fiuba.algo3.modelo.Evento.EventoPuntaje;

import edu.fiuba.algo3.modelo.Movimiento.Movimiento;

import java.util.Objects;

public class AumentoPorcentaje implements EventoPuntaje {
    private Float porcentaje;
    public AumentoPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public Movimiento actualizarPuntaje(Movimiento m) {
        return m.aplicarAumento( this.porcentaje);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AumentoPorcentaje that = (AumentoPorcentaje) o;
        return this.porcentaje.equals(that.porcentaje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(porcentaje);
    }
}
