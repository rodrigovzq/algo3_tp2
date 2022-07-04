package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Ranking.Puntaje;
import edu.fiuba.algo3.modelo.Ranking.Ranking;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RankingTest {
    @Test
    public void agregoJugadoresAlRankingYLosVaOrdenandoAMedidaQueSeAgregan(){
        Ranking rank = new Ranking();

        Jugador mockJugador = mock( Jugador.class );
        when( mockJugador.imprimir()).thenReturn("J1;(0,0);Auto;100");
        Puntaje puntaje = new Puntaje(mockJugador);
        rank.agregar( puntaje );
        List<Puntaje> puntajes = rank.devolverListaDeLosPrimerosDiez();
        List<String> esperado = new ArrayList<>();
        esperado.add("J1,100");

        List<String> resultado = new ArrayList<String>();
        for(Puntaje p : puntajes )
            resultado.add(p.imprimir());

        assertEquals(esperado, resultado);

        when( mockJugador.imprimir()).thenReturn("J2;(0,0);Auto;200");
        puntaje = new Puntaje(mockJugador);
        rank.agregar( puntaje );
        puntajes = rank.devolverListaDeLosPrimerosDiez();
        esperado = new ArrayList<>();
        esperado.add("J1,100");
        esperado.add("J2,200");

        resultado = new ArrayList<String>();
        for(Puntaje p : puntajes )
            resultado.add(p.imprimir());

        assertEquals(esperado, resultado);

        when( mockJugador.imprimir()).thenReturn("J3;(0,0);Auto;50");
        puntaje = new Puntaje(mockJugador);
        rank.agregar( puntaje );
        puntajes = rank.devolverListaDeLosPrimerosDiez();
        esperado = new ArrayList<>();
        esperado.add("J3,50");
        esperado.add("J1,100");
        esperado.add("J2,200");

        resultado = new ArrayList<String>();
        for(Puntaje p : puntajes )
            resultado.add(p.imprimir());

        assertEquals(esperado, resultado);

        when( mockJugador.imprimir()).thenReturn("J4;(0,0);Auto;75");
        puntaje = new Puntaje(mockJugador);
        rank.agregar( puntaje );
        puntajes = rank.devolverListaDeLosPrimerosDiez();
        esperado = new ArrayList<>();
        esperado.add("J3,50");
        esperado.add("J4,75");
        esperado.add("J1,100");
        esperado.add("J2,200");

        resultado = new ArrayList<String>();
        for(Puntaje p : puntajes )
            resultado.add(p.imprimir());

        assertEquals(esperado, resultado);

        when( mockJugador.imprimir()).thenReturn("J5;(0,0);Auto;100");
        puntaje = new Puntaje(mockJugador);
        rank.agregar( puntaje );
        puntajes = rank.devolverListaDeLosPrimerosDiez();
        esperado = new ArrayList<>();
        esperado.add("J3,50");
        esperado.add("J4,75");
        esperado.add("J1,100");
        esperado.add("J5,100");
        esperado.add("J2,200");

        resultado = new ArrayList<String>();
        for(Puntaje p : puntajes )
            resultado.add(p.imprimir());
        
        assertEquals(esperado, resultado);

    }

    @Test
    public void tengoMasDe10PunetajesYSigueMostrandoElTop10(){
        Ranking rank = new Ranking();

        Jugador mockJugador = mock( Jugador.class );
        when( mockJugador.imprimir()).thenReturn("J1;(0,0);Auto;100");
        Puntaje puntaje = new Puntaje(mockJugador);
        for( int i = 0; i < 10; i++)
            rank.agregar( puntaje );

        List<Puntaje> puntajes = rank.devolverListaDeLosPrimerosDiez();
        List<String> esperado = new ArrayList<>();
        for( int i = 0; i < 10; i++)
            esperado.add("J1,100");

        List<String> resultado = new ArrayList<String>();
        for(Puntaje p : puntajes )
            resultado.add(p.imprimir());

        assertEquals(esperado, resultado);

        when( mockJugador.imprimir()).thenReturn("J2;(0,0);Auto;50");
        puntaje = new Puntaje(mockJugador);
        rank.agregar( puntaje );
        puntajes = rank.devolverListaDeLosPrimerosDiez();
        esperado = new ArrayList<>();
        esperado.add("J2,50");
        for( int i = 0; i < 9; i++)
            esperado.add("J1,100");

        resultado = new ArrayList<String>();
        for(Puntaje p : puntajes )
            resultado.add(p.imprimir());

        assertEquals(esperado, resultado);

        when( mockJugador.imprimir()).thenReturn("J3;(0,0);Auto;75");
        puntaje = new Puntaje(mockJugador);
        rank.agregar( puntaje );
        puntajes = rank.devolverListaDeLosPrimerosDiez();
        esperado = new ArrayList<>();
        esperado.add("J2,50");
        esperado.add("J3,75");
        for( int i = 0; i < 8; i++)
            esperado.add("J1,100");

        resultado = new ArrayList<String>();
        for(Puntaje p : puntajes )
            resultado.add(p.imprimir());
        
        assertEquals(esperado, resultado);
    }

    @Test
    public void esCapazDeImprimirSuInformacionEnUnString(){
        Ranking rank = new Ranking();
        Jugador mockJugador = mock(Jugador.class);
        when(mockJugador.imprimir()).thenReturn("Grupo3;(0,0);Auto;1000");
        String esperado = "";
        for(int i = 0; i < 10; i++) {
            rank.agregar(mockJugador);
            esperado += "Grupo3,1000\n";
        }

        String resultado = rank.imprimir();
        assertEquals(esperado, resultado);
    }
}