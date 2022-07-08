package edu.fiuba.algo3.modelo.Evento.EventoPuntaje;

import edu.fiuba.algo3.modelo.Excepcion.MovimientoInvalido;
import edu.fiuba.algo3.modelo.Excepcion.PenalizacionInvalida;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;

import java.util.Objects;

public class Penalizacion implements EventoPuntaje {
    private Movimiento penalizacion;
    public Penalizacion(Integer penalizacion) {
        try{
            this.penalizacion = new Movimiento(penalizacion);
        }catch(MovimientoInvalido e){
            throw new PenalizacionInvalida("La penalizacion debe ser con una cantidad de movmientos positivos");
        }
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
