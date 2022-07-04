package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorAleatorio;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class ControlPolicial implements IObstaculo {

    private final GeneradorAleatorio generador;
    public ControlPolicial(GeneradorAleatorio generador) {
        this.generador = generador;
    }

    @Override
    public Evento avanzarEn(IVehiculo vehiculo) {
        boolean detenido = generador.aplicar(vehiculo.obtenerProbabilidadDeSerDetenido());
        if (detenido) {
            return vehiculo.avanzarControlPolicial();
        } else {
            return vehiculo.avanzarComun();
        }
    }

    @Override
    public String imprimir() {
        return Obstaculo.CONTROL_POLICIAL.name();
    }

}
