package edu.fiuba.algo3.modelo.Evento.Avanzar;

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
        
        Celda resultado = avanzar.actualizarPosicion( new Celda( null ) );
        Celda esperado = new Celda( null );
        
        assertEquals(esperado, resultado);
    }
    @Test
    public void seteoLaDireccionParaElNorteYDevuelveLaCeldaNorte(){
        Avanzar avanzar = new Avanzar();
        avanzar.setDireccion(Direccion.NORTE);

        Celda resultado = avanzar.actualizarPosicion( new Celda( null ) );
        Celda esperado = new Celda( null );

        assertEquals(esperado, resultado);
    }
    @Test
    public void seteoLaDireccionParaElSurYDevuelveLaCeldaSur(){
        Avanzar avanzar = new Avanzar();
        avanzar.setDireccion(Direccion.SUR);

        Celda resultado = avanzar.actualizarPosicion( new Celda( null ) );
        Celda esperado = new Celda( null );

        assertEquals(esperado, resultado);
    }
    @Test
    public void seteoLaDireccionParaElOesteYDevuelveLaCeldaOeste(){
        Avanzar avanzar = new Avanzar();
        avanzar.setDireccion(Direccion.OESTE);

        Celda resultado = avanzar.actualizarPosicion( new Celda( null ) );
        Celda esperado = new Celda( null );

        assertEquals(esperado, resultado);

    }
}