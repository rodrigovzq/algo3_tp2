package edu.fiuba.algo3.modelo.EstadoCelda;

import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.EventoPosicion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.EventoPuntaje;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.SinPenalizar;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.EventoVehiculo;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.NoCambiarVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class MetaTest {
    @Test
    public void esImprimible(){
        Meta meta = new Meta();
        String resultado = meta.imprimir();
        String esperado = "META";

        assertEquals(esperado, resultado);
    }

    @Test
    public void alPedirElSiguientSeDevuelveAsiMismo(){
        Meta meta = new Meta();
        assertEquals( meta, meta.siguiente());
    }

    @Test
    public void alAvanzarSobreLaMetaDevuelveAvanzaSinPenalizarNiCambiarVehiculo(){
        Meta meta = new Meta();
        IVehiculo mockVehiculo = mock(IVehiculo.class);
        Evento resultado = meta.avanzarEn(mockVehiculo);
        SinPenalizar eventoPuntaje = new SinPenalizar();
        Avanzar eventoPosicion = new Avanzar();
        NoCambiarVehiculo eventoVehiculo = new NoCambiarVehiculo();
        Evento esperado = new Evento( eventoPuntaje, eventoVehiculo, eventoPosicion);
        assertEquals(esperado, resultado);
    }

}