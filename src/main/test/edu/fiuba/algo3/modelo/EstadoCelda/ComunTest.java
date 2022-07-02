package edu.fiuba.algo3.modelo.EstadoCelda;

import edu.fiuba.algo3.modelo.Obstaculo.Piquete;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ComunTest {
    @Test
    public void esImprimible(){
        Comun comun = new Comun();
        String resultado = comun.imprimir();
        String esperado = "COMUN";
        assertEquals(esperado, resultado);
    }

    @Test
    public void alAvanzarPorUnPiqueteElVehiculoDecideQueEventoLanzar(){
        Comun comun = new Comun();
        IVehiculo mockVehiculo = mock( IVehiculo.class );
        comun.avanzarEn(mockVehiculo);
        verify(mockVehiculo).avanzarComun();
    }
}