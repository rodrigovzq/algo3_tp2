package edu.fiuba.algo3.modelo.Celda.Obstaculo.Evento.EventoPosicion;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvanzarTest {
    @Test
    public void seteoLaDireccionParaElEsteYDevuelveLaCeldaEste(){
        Avanzar avanzar = new Avanzar();
        avanzar.setDireccion(Direccion.ESTE);

        Celda celdaEste = new Celda( null );
        Celda celdaSur = new Celda( null );
        Celda celdaNorte = celdaSur;
        Celda celdaOeste = celdaSur;

        Celda celdaActual = new Celda( null, celdaNorte, celdaEste, celdaSur, celdaOeste );


        Celda resultado = avanzar.actualizarPosicion( celdaActual );
        Celda esperado = celdaEste;
        
        assertEquals(esperado, resultado);
    }
    @Test
    public void seteoLaDireccionParaElNorteYDevuelveLaCeldaNorte(){
        Avanzar avanzar = new Avanzar();
        avanzar.setDireccion(Direccion.NORTE);

        Celda celdaNorte = new Celda( null );
        Celda celdaEste = new Celda( null );
        Celda celdaSur = celdaEste;
        Celda celdaOeste = celdaEste;

        Celda celdaActual = new Celda( null, celdaNorte, celdaEste, celdaSur, celdaOeste );

        Celda resultado = avanzar.actualizarPosicion( celdaActual );
        Celda esperado = celdaNorte;

        assertEquals(esperado, resultado);
    }
    @Test
    public void seteoLaDireccionParaElSurYDevuelveLaCeldaSur(){
        Avanzar avanzar = new Avanzar();
        avanzar.setDireccion(Direccion.SUR);

        Celda celdaSur = new Celda( null );
        Celda celdaEste = new Celda( null );
        Celda celdaNorte = celdaEste;
        Celda celdaOeste = celdaEste;

        Celda celdaActual = new Celda( null, celdaNorte, celdaEste, celdaSur, celdaOeste );


        Celda resultado = avanzar.actualizarPosicion( celdaActual );
        Celda esperado = celdaSur;

        assertEquals(esperado, resultado);
    }
    @Test
    public void seteoLaDireccionParaElOesteYDevuelveLaCeldaOeste(){
        Avanzar avanzar = new Avanzar();
        avanzar.setDireccion(Direccion.OESTE);

        Celda celdaOeste = new Celda( null );
        Celda celdaEste = new Celda( null );
        Celda celdaNorte = celdaEste;
        Celda celdaSur = celdaEste;

        Celda celdaActual = new Celda( null, celdaNorte, celdaEste, celdaSur, celdaOeste );

        Celda resultado = avanzar.actualizarPosicion( celdaActual );
        Celda esperado = celdaOeste;

        assertEquals(esperado, resultado);

    }
}