package edu.fiuba.algo3.modelo.Evento.EventoPuntaje;

import edu.fiuba.algo3.modelo.Movimiento.Movimiento;

public class AumentoPorcentaje implements EventoPuntaje {
    private Integer porcentaje;
    public AumentoPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public Movimiento actualizarPuntaje(Movimiento m) {
        return m.aplicarAumento( this.porcentaje);
    }
}
