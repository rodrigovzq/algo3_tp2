package edu.fiuba.algo3.modelo.CeldaInterna.Obstaculo.Evento.EventoPosicion;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.CeldaInterna;
import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.NoCambiarPosicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoCambiarPosicionTest {
    @Test
    public void cualquieraSeaLaDireccionDevuelveLaMismaCeldaInternaQueSePasaPorParametro(){
        NoCambiarPosicion sinCambiar = new NoCambiarPosicion();

        Coordenada coordenada = new Coordenada(0,0);
        CeldaInterna celdaOeste = new CeldaInterna( null, coordenada);
        CeldaInterna celdaEste = new CeldaInterna( null, coordenada);
        CeldaInterna celdaNorte = celdaEste;
        CeldaInterna celdaSur = celdaEste;

        CeldaInterna celdaActual = new CeldaInterna( null, coordenada, celdaNorte, celdaEste, celdaSur, celdaOeste );

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