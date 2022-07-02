package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class Pozo implements IObstaculo {
    @Override
    public Evento avanzarEn(IVehiculo vehiculo) {
        return vehiculo.avanzarPozo();
    }

    @Override
    public String imprimir() {
        return Obstaculo.POZO.name();
    }
}
