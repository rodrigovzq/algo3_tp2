package edu.fiuba.algo3.modelo.Evento.EventoPosicion;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Direccion.Direccion;

public interface EventoPosicion {
    public boolean equals(Object o);

    Celda actualizarPosicion(Celda posicion);

    void setDireccion(Direccion direccion);
}
