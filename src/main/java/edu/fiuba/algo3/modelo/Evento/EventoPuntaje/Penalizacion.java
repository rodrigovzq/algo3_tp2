package edu.fiuba.algo3.modelo.Evento.EventoPuntaje;

import edu.fiuba.algo3.modelo.Movimiento.Movimiento;

public class Penalizacion implements EventoPuntaje {
    private Movimiento penalizacion;
    public Penalizacion(Integer penalizacion) {
        this.penalizacion = new Movimiento(penalizacion);
    }

    @Override
    public Movimiento actualizarPuntaje(Movimiento m) {
        return m.sumarMovimiento( this.penalizacion );
    }
}
