package edu.fiuba.algo3.modelo.Evento.EventoPosicion;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Direccion.Direccion;

public class Avanzar implements EventoPosicion{

    private Direccion direccion;

    @Override
    public boolean equals(Object o) {
        return ( o != null && ( this == o || this.getClass() == o.getClass() ));
    }

    @Override
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public Celda actualizarPosicion( Celda posicion) {
        return posicion.getCelda( this.direccion );
    }
}
