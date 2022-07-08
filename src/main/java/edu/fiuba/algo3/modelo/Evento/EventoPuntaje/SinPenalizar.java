package edu.fiuba.algo3.modelo.Evento.EventoPuntaje;

import edu.fiuba.algo3.modelo.Movimiento.Movimiento;

public class SinPenalizar implements EventoPuntaje {
    private final int MOVIMIENTO_DEFAULT = 1;
    @Override
    public Movimiento actualizarPuntaje(Movimiento m) {
        return m.sumarMovimiento(new Movimiento(MOVIMIENTO_DEFAULT));
    }

    @Override
    public boolean equals(Object o) {
        return ( o != null && ( this == o || this.getClass() == o.getClass() ));
    }
}
