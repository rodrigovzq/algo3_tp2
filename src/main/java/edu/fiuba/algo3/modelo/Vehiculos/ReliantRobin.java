package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorAleatorio;

import java.util.Objects;

public class ReliantRobin implements IVehiculo{

    GeneradorAleatorio generadorAleatorio;
    IVehiculo comportamiento;
    public ReliantRobin(GeneradorAleatorio generador) {
        generadorAleatorio = generador;
        comportamiento = elegirVehiculo();
    }
    @Override
    public Evento avanzarComun() {
        return comportamiento.avanzarComun();
    }

    @Override
    public Evento avanzarPiquete() {
        return comportamiento.avanzarPiquete();
    }

    @Override
    public Evento avanzarControlPolicial() {
        return comportamiento.avanzarControlPolicial();
    }

    @Override
    public Evento avanzarPozo() {
        return comportamiento.avanzarPozo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(generadorAleatorio, comportamiento);
    }

    @Override
    public Float obtenerProbabilidadDeSerDetenido() {
        return comportamiento.obtenerProbabilidadDeSerDetenido();
    }

    @Override
    public IVehiculo siguiente() {
        return new Auto();
    }

    @Override
    public String imprimir() {
        return "RELIANT_ROBIN";
    }

    public IVehiculo elegirVehiculo() {
        return generadorAleatorio.aplicar(0.6f) ? new Auto() : new Moto();
    }
}
