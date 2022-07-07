package edu.fiuba.algo3.modelo.Ranking;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PuntajeTest {
    @Test
    public void esImprimible(){
        Puntaje puntaje = new Puntaje("Grupo3", 100);
        String resultado = puntaje.imprimir();
        String esperado = "Grupo3,100";
        assertEquals(esperado, resultado);

        Jugador mockJugador = mock( Jugador.class );
        when( mockJugador.imprimir() ).thenReturn( "Grupo3;(0,0);Auto;1000;" );
        puntaje = new Puntaje( mockJugador );
        resultado = puntaje.imprimir();
        esperado = "Grupo3,1000";
        assertEquals(esperado, resultado);
    }

    @Test
    public void esComparable(){
        Puntaje puntaje1 = new Puntaje("Grupo3", 100);

        Jugador mockJugador = mock( Jugador.class );
        when( mockJugador.imprimir() ).thenReturn( "Grupo3;(0,0);Auto;1000;" );
        Puntaje puntaje2 = new Puntaje( mockJugador );

        Integer resultado = puntaje1.compareTo(puntaje2);
        assertTrue( resultado < 0 );

        puntaje1 = new Puntaje("Grupo3", 2000);
        resultado = puntaje1.compareTo(puntaje2);
        assertTrue( resultado > 0 );

        puntaje1 = new Puntaje("Grupo3", 1000);
        resultado = puntaje1.compareTo(puntaje2);
        assertTrue( resultado == 0 );

    }


}