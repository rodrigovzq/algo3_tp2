package edu.fiuba.algo3.modelo.CeldaInterna.Obstaculo.Evento.EventoPosicion;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.CeldaInterna;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.NoCambiarPosicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoCambiarPosicionTest {
    @Test
    public void cualquieraSeaLaDireccionDevuelveLaMismaCeldaInternaQueSePasaPorParametro(){
        NoCambiarPosicion sinCambiar = new NoCambiarPosicion();

        CeldaInterna celdaOeste = new CeldaInterna( null );
        CeldaInterna celdaEste = new CeldaInterna( null );
        CeldaInterna celdaNorte = celdaEste;
        CeldaInterna celdaSur = celdaEste;

        CeldaInterna celdaActual = new CeldaInterna( null, celdaNorte, celdaEste, celdaSur, celdaOeste );

        CeldaInterna esperado = celdaActual;

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