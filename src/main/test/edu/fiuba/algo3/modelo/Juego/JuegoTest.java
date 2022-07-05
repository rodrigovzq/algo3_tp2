package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Ranking.Ranking;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JuegoTest {
    @Test
    public void alGuardarLaPartidaSeGuardaElMapaElJugadorYElRanking(){
        Mapa mockMapa = mock( Mapa.class);
        Jugador mockJugador = mock( Jugador.class);
        Ranking mockRanking = mock( Ranking.class);
        Juego juego = new Juego( mockJugador, mockMapa, mockRanking);

        juego.guardarPartida();
        verify(mockRanking).imprimir();
        verify(mockJugador).imprimir();
        verify(mockMapa).imprimir();
    }

    @Test
    public void almacenaElRankingDelJugadorAlActualizar(){
        Mapa mockMapa = mock( Mapa.class);
        Jugador mockJugador = mock( Jugador.class);
        Ranking mockRanking = mock( Ranking.class);
        Juego juego = new Juego( mockJugador, mockMapa, mockRanking);

        juego.actualizar();

        verify(mockRanking).agregar(mockJugador);
        verify(mockRanking).imprimir();
    }

    @Test
    public void alInicializarElJuegoInicializaAlJugadorDeManeraCoherente(){
        Mapa mockMapa = mock( Mapa.class);
        Jugador mockJugador = mock( Jugador.class);
        Ranking mockRanking = mock( Ranking.class);

        Celda mockCelda = mock(Celda.class);
        when( mockMapa.getCeldaJugador()).thenReturn( mockCelda );

        new Juego( mockJugador, mockMapa, mockRanking);

        verify(mockMapa).getCeldaJugador();
        verify(mockJugador).setPosicion( mockCelda );
    }

}