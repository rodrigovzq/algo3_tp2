package edu.fiuba.algo3.modelo.Evento.EventoPuntaje;

import edu.fiuba.algo3.modelo.Movimiento.Movimiento;

public class Penalizacion implements EventoPuntaje {
    private Movimiento penalizacion;
    public Penalizacion(Integer penalizacion) {
        this.penalizacion = new Movimiento(penalizacion);
    }

    private Movimiento getPenalizacion() {
        return penalizacion;
    }

    @Override
    public Movimiento actualizarPuntaje(Movimiento m) {
        return m.sumarMovimiento( this.penalizacion );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Penalizacion p = (Penalizacion) o;
        return penalizacion.equals( p.getPenalizacion() );
    }


}
