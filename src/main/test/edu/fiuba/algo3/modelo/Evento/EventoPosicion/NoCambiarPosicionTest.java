package edu.fiuba.algo3.modelo.Evento.EventoPosicion;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoCambiarPosicionTest {
    @Test
    public void cualquieraSeaLaDireccionDevuelveLaMismaCeldaQueSePasaPorParametro(){
        NoCambiarPosicion sinCambiar = new NoCambiarPosicion();

        Celda celdaOeste = new Celda( null );
        Celda celdaEste = new Celda( null );
        Celda celdaNorte = celdaEste;
        Celda celdaSur = celdaEste;

        Celda celdaActual = new Celda( null, celdaNorte, celdaEste, celdaSur, celdaOeste );

        Celda esperado = celdaActual;

        sinCambiar.setDireccion(Direccion.ESTE);
        Celda resultado = sinCambiar.actualizarPosicion( celdaActual );
        assertEquals(esperado, resultado);


        sinCambiar.setDireccion(Direccion.NORTE);
        resultado = sinCambiar.actualizarPosicion( celdaActual );
        assertEquals(esperado, resultado);

        sinCambiar.setDireccion(Direccion.SUR);
        resultado = sinCambiar.actualizarPosicion( celdaActual );
        assertEquals(esperado, resultado);

        sinCambiar.setDireccion(Direccion.OESTE);
        resultado = sinCambiar.actualizarPosicion( celdaActual );
        assertEquals(esperado, resultado);

    }
}