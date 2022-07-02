package edu.fiuba.algo3.modelo.Sorpresa;

import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.AumentoPorcentaje;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.DescuentoPorcentaje;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.SinPenalizar;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.NoCambiarVehiculo;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.SiguienteVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DesfavorableTest {
    @Test
    public void esImprimible() {
        Desfavorable cv = new Desfavorable();
        String resultado = cv.imprimir();
        String esperado = "DESFAVORABLE";
        assertEquals(esperado, resultado);
    }

    @Test
    public void avanzarSobreCambioDeVehiculoAvanzaSinCambiarElVehiculoYConUnAumentoDel25Porciento() {
        Desfavorable cv = new Desfavorable();
        IVehiculo mockV = mock(IVehiculo.class);
        Evento resultado = cv.avanzarEn(mockV);
        Evento esperado = new Evento(new AumentoPorcentaje(25.0F), new NoCambiarVehiculo(), new Avanzar());
        assertEquals(esperado, resultado);
    }
}