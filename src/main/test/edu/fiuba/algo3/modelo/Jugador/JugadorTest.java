package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class JugadorTest {
    @Test
    public void elJugadorEsCapazDeImprimirEnUnStringSuInformacion(){
        Celda mockCelda = mock( Celda.class );
        when( mockCelda.imprimir()).thenReturn("ESTADO-(0,0)");
        IVehiculo mockVehiculo = mock( IVehiculo.class );
        when( mockVehiculo.imprimir()).thenReturn("Auto");
        Jugador jugador = new Jugador("Grupo3", mockCelda, mockVehiculo );

        String resultado = jugador.imprimir();
        String esperado = "Grupo3;(0,0);Auto;0";

        assertEquals(esperado, resultado);
    }
    //El resto de test son realizados en las Entregas.

}