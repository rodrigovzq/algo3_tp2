package edu.fiuba.algo3.modelo.Evento.EventoPosicion;

public class Avanzar implements EventoPosicion{

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }
}
