package edu.fiuba.algo3.modelo.Evento.EventoPuntaje;

import edu.fiuba.algo3.modelo.Movimiento.Movimiento;

public class DescuentoPorcentaje implements EventoPuntaje {
    private Float porcentaje;
    public DescuentoPorcentaje(Float porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public Movimiento actualizarPuntaje(Movimiento m) {
        return m.aplicarDescuento( this.porcentaje );
    }
}
