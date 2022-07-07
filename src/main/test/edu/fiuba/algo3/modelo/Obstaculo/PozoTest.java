package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.EstadoCelda.IEstadoCelda;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PozoTest {
    @Test
    public void esImprimible(){
        Pozo pozo = new Pozo();
        String resultado = pozo.imprimir();
        String esperado = "POZO";
        assertEquals(esperado, resultado);
    }

    @Test
    public void alAvanzarPorUnPiqueteElVehiculoDecideQueEventoLanzar(){
        Pozo pozo = new Pozo();
        IVehiculo mockVehiculo = mock( IVehiculo.class );
        pozo.avanzarEn(mockVehiculo);
        verify(mockVehiculo).avanzarPozo();
    }

    @Test
    public void alPedirElSiguienteSeDevuelveAsiMismo(){
        Piquete obstaculo = new Piquete();
        IEstadoCelda estado = obstaculo.siguiente();

        assertEquals( obstaculo, estado );
    }
}