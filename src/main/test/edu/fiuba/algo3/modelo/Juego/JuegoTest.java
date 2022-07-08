package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Excepcion.ArchivoInexistente;
import edu.fiuba.algo3.modelo.Excepcion.JuegoInvalido;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Ranking.Ranking;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JuegoTest {
    @Test
    public void alGuardarLaPartidaSeGuardaElMapaElJugadorYElRanking() throws ArchivoInexistente {
        Mapa mockMapa = mock( Mapa.class);
        Jugador mockJugador = mock( Jugador.class);
        Ranking mockRanking = mock( Ranking.class);
        when(mockRanking.imprimir()).thenReturn("Test1,10;\nTest2,11;\nTest3,12;\n");
        when(mockMapa.imprimir()).thenReturn("5x5;\n(2,2);\n" +
                "COMUN-COMUN-COMUN-COMUN-COMUN;\n" +
                "COMUN-COMUN-COMUN-COMUN-COMUN;\n" +
                "COMUN-POZO-POZO-POZO-POZO;\n" +
                "COMUN-POZO-PIQUETE-PIQUETE-PIQUETE;\n" +
                "COMUN-POZO-PIQUETE-META-PIQUETE;\n");
        when(mockJugador.imprimir()).thenReturn("Test;(2,2);Auto;10\n");
        Juego juego = new Juego( mockJugador, mockMapa, mockRanking);
        juego.guardarPartida();
        verify(mockRanking).imprimir();
        verify(mockJugador).imprimir();
        verify(mockMapa).imprimir();
    }

    @Test
    public void almacenaElRankingDelJugadorAlActualizar() throws ArchivoInexistente {
        Mapa mockMapa = mock( Mapa.class);
        Jugador mockJugador = mock( Jugador.class);
        Ranking mockRanking = mock( Ranking.class);
        when(mockRanking.imprimir()).thenReturn("Test1,10;\nTest2,11;\nTest3,12;\n");
        Juego juego = new Juego( mockJugador, mockMapa, mockRanking);

        juego.actualizarRanking();

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

    @Test
    public void alJuegoNoPuedeInicializarseConValoresNull(){
        Mapa mockMapa = mock( Mapa.class);
        Jugador mockJugador = mock( Jugador.class);
        Ranking mockRanking = mock( Ranking.class);

        assertDoesNotThrow( () -> new Juego( mockJugador, mockMapa, mockRanking) );
        assertThrows( JuegoInvalido.class, () -> new Juego( null, mockMapa, mockRanking));
        assertThrows( JuegoInvalido.class, () -> new Juego( mockJugador, null, mockRanking));
        assertThrows( JuegoInvalido.class, () -> new Juego( mockJugador, mockMapa, null));

    }

    @Test
    public void elJuegoEsCapazDeEliminarLosArchivosDePersistencia(){
        Mapa mockMapa = mock( Mapa.class);
        Jugador mockJugador = mock( Jugador.class);
        Ranking mockRanking = mock( Ranking.class);

        Juego juego = new Juego( mockJugador, mockMapa, mockRanking);

        juego.borrarPartida();

        assertFalse( new File("saves/jugador.txt").exists() );
        assertFalse( new File("saves/mapa.txt").exists() );
    }

}