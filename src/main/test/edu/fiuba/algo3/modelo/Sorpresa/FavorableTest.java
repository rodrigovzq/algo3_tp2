package edu.fiuba.algo3.modelo.Sorpresa;

import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.AumentoPorcentaje;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.DescuentoPorcentaje;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.NoCambiarVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class FavorableTest {
    @Test
    public void esImprimible() {
        Favorable cv = new Favorable();
        String resultado = cv.imprimir();
        String esperado = "FAVORABLE";
        assertEquals(esperado, resultado);
    }

    @Test
    public void avanzarSobreCambioDeVehiculoAvanzaSinCambiarElVehiculoYConUnDescuentoDel25Porciento() {
        Favorable cv = new Favorable();
        IVehiculo mockV = mock(IVehiculo.class);
        Evento resultado = cv.avanzarEn(mockV);
        Evento esperado = new Evento(new DescuentoPorcentaje(20.0F), new NoCambiarVehiculo(), new Avanzar());
        assertEquals(esperado, resultado);
    }

    @Test
    public void dosSorpresasFavorablesSonIgualesConSerDeLaMismaClase(){
        Favorable sorpresa1 = new Favorable();
        Favorable sorpresa2 = new Favorable();

        assertEquals(sorpresa1, sorpresa2);
    }


}