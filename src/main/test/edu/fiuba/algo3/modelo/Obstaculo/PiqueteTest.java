package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.EstadoCelda.IEstadoCelda;
import edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorAleatorio;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PiqueteTest {
    @Test
    public void esImprimible(){
        Piquete piquete = new Piquete();
        String resultado = piquete.imprimir();
        String esperado = "PIQUETE";
        assertEquals(esperado, resultado);
    }

    @Test
    public void alAvanzarPorUnPiqueteElVehiculoDecideQueEventoLanzar(){
        Piquete piquete = new Piquete();
        IVehiculo mockVehiculo = mock( IVehiculo.class );
        piquete.avanzarEn(mockVehiculo);
        verify(mockVehiculo).avanzarPiquete();
    }

    @Test
    public void alPedirElSiguienteSeDevuelveAsiMismo(){
        Piquete obstaculo = new Piquete();
        IEstadoCelda estado = obstaculo.siguiente();

        assertEquals( obstaculo, estado );
    }
}