package edu.fiuba.algo3.modelo.Sorpresa;

import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.AumentoPorcentaje;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.NoCambiarVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class Desfavorable implements ISorpresa {
    private final float PORCENTAJE = 25.0F;

    @Override
    public Evento avanzarEn(IVehiculo vehiculo) {
        return new Evento(new AumentoPorcentaje(PORCENTAJE), new NoCambiarVehiculo(), new Avanzar());
    }
    @Override
    public String imprimir() {
        return Sorpresa.DESFAVORABLE.name();
    }
}
