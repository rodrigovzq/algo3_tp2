package edu.fiuba.algo3.modelo.EstadoCelda;

import edu.fiuba.algo3.modelo.EstadoCelda.EstadoCelda;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class Comun implements EstadoCelda {
    @Override
    public Evento avanzarEn(IVehiculo vehiculo) {
        return vehiculo.avanzarComun();
    }

    @Override
    public String imprimir() {
        return "COMUN";
    }
}
