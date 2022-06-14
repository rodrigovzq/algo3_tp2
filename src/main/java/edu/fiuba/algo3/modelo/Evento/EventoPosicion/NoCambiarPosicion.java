package edu.fiuba.algo3.modelo.Evento.EventoPosicion;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Direccion.Direccion;

public class NoCambiarPosicion implements EventoPosicion{
    private Direccion direccion;
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion; // No es de utilidad.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }

    public Celda actualizarPosicion(Celda celdaActual) {
        return celdaActual;
    }
}
