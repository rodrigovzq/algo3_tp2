package edu.fiuba.algo3.modelo.EstadoCelda;

import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Impresora.Imprimible;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public interface IEstadoCelda extends Imprimible {
    Evento avanzarEn(IVehiculo vehiculo);
}
