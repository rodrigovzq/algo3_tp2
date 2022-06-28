package edu.fiuba.algo3.modelo.Celda.Obstaculo.Evento.EventoPosicion;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.CeldaInterna;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvanzarTest {
    @Test
    public void seteoLaDireccionParaElEsteYDevuelveLaCeldaInternaEste(){
        Avanzar avanzar = new Avanzar();
        avanzar.setDireccion(Direccion.ESTE);

        CeldaInterna celdaEste = new CeldaInterna( null );
        CeldaInterna celdaSur = new CeldaInterna( null );
        CeldaInterna celdaNorte = celdaSur;
        CeldaInterna celdaOeste = celdaSur;

        CeldaInterna celdaActual = new CeldaInterna( null, celdaNorte, celdaEste, celdaSur, celdaOeste );


        Celda resultado = avanzar.actualizarPosicion( celdaActual );
        CeldaInterna esperado = celdaEste;
        
        assertEquals(esperado, resultado);
    }
    @Test
    public void seteoLaDireccionParaElNorteYDevuelveLaCeldaInternaNorte(){
        Avanzar avanzar = new Avanzar();
        avanzar.setDireccion(Direccion.NORTE);

        CeldaInterna celdaNorte = new CeldaInterna( null );
        CeldaInterna celdaEste = new CeldaInterna( null );
        CeldaInterna celdaSur = celdaEste;
        CeldaInterna celdaOeste = celdaEste;

        CeldaInterna celdaActual = new CeldaInterna( null, celdaNorte, celdaEste, celdaSur, celdaOeste );

        Celda resultado = avanzar.actualizarPosicion( celdaActual );
        CeldaInterna esperado = celdaNorte;

        assertEquals(esperado, resultado);
    }
    @Test
    public void seteoLaDireccionParaElSurYDevuelveLaCeldaInternaSur(){
        Avanzar avanzar = new Avanzar();
        avanzar.setDireccion(Direccion.SUR);

        CeldaInterna celdaSur = new CeldaInterna( null );
        CeldaInterna celdaEste = new CeldaInterna( null );
        CeldaInterna celdaNorte = celdaEste;
        CeldaInterna celdaOeste = celdaEste;

        CeldaInterna celdaActual = new CeldaInterna( null, celdaNorte, celdaEste, celdaSur, celdaOeste );


        Celda resultado = avanzar.actualizarPosicion( celdaActual );
        CeldaInterna esperado = celdaSur;

        assertEquals(esperado, resultado);
    }
    @Test
    public void seteoLaDireccionParaElOesteYDevuelveLaCeldaInternaOeste(){
        Avanzar avanzar = new Avanzar();
        avanzar.setDireccion(Direccion.OESTE);

        CeldaInterna celdaOeste = new CeldaInterna( null );
        CeldaInterna celdaEste = new CeldaInterna( null );
        CeldaInterna celdaNorte = celdaEste;
        CeldaInterna celdaSur = celdaEste;

        CeldaInterna celdaActual = new CeldaInterna( null, celdaNorte, celdaEste, celdaSur, celdaOeste );

        Celda resultado = avanzar.actualizarPosicion( celdaActual );
        CeldaInterna esperado = celdaOeste;

        assertEquals(esperado, resultado);

    }
}