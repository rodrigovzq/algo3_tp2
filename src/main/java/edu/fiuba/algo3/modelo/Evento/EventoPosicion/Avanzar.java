package edu.fiuba.algo3.modelo.Evento.EventoPosicion;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Direccion.Direccion;

public class Avanzar implements EventoPosicion{

    private Direccion direccion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
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
