package edu.fiuba.algo3.modelo.Sorpresa;

import edu.fiuba.algo3.modelo.EstadoCelda.Comun;
import edu.fiuba.algo3.modelo.EstadoCelda.IEstadoCelda;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.SinPenalizar;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.SiguienteVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CambioVehiculoTest {
    @Test
    public void esImprimible(){
        CambioVehiculo cv = new CambioVehiculo();
        String resultado = cv.imprimir();
        String esperado = "CAMBIO_VEHICULO";
        assertEquals(esperado,resultado);
    }

    @Test
    public void avanzarSobreCambioDeVehiculoAvanzaSinPenalizarYCambiaElVehiculo(){
        CambioVehiculo cv = new CambioVehiculo();
        IVehiculo mockV = mock(IVehiculo.class);
        Evento resultado = cv.avanzarEn(mockV);
        Evento esperado =  new Evento(new SinPenalizar(), new SiguienteVehiculo(), new Avanzar());
        assertEquals(esperado,resultado);
    }
    @Test
    public void dosSorpresasFavorablesSonIgualesConSerDeLaMismaClase(){
        CambioVehiculo sorpresa1 = new CambioVehiculo();
        CambioVehiculo sorpresa2 = new CambioVehiculo();

        assertEquals(sorpresa1, sorpresa2);
    }

    @Test
    public void laSorpresaCambioVehiculoAlConsumirseDevuelveElEstadoDeCeldaComun(){
        CambioVehiculo sorpresa = new CambioVehiculo();
        IEstadoCelda estado = sorpresa.siguiente();
        assertEquals( new Comun(), estado );
    }

}