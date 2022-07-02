package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class Piquete implements IObstaculo {
    @Override
    public Evento avanzarEn(IVehiculo vehiculo) {
        return vehiculo.avanzarPiquete();
    }

    @Override
    public String imprimir() {
        return Obstaculo.PIQUETE.name();
    }
}
