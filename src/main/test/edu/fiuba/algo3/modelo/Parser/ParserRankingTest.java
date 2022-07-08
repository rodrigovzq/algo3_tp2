package edu.fiuba.algo3.modelo.Parser;

import edu.fiuba.algo3.modelo.Excepcion.ArchivoInexistente;
import edu.fiuba.algo3.modelo.Excepcion.ArchivoMalformado;
import edu.fiuba.algo3.modelo.Ranking.Ranking;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ParserRankingTest {
    @Test
    public void leeDeUnArchivoYDevuelveUnRanking() throws IOException {
        String pathFileTest = "saves/test/ranking_test.txt";
        ParserRanking parser = new ParserRanking( pathFileTest );
        parser.parsear();
        Ranking resultado = parser.getEntidadParseada();

        Ranking esperado = new Ranking();
        Jugador mockJugador = mock( Jugador.class );
        when( mockJugador.imprimir()).thenReturn("Test;(0,0);Auto;100");
        for( int i = 0; i < 10; i++)
            esperado.agregar(mockJugador);

        assertEquals(esperado, resultado);
    }
    @Test
    public void verificaQueEsteBienFormadoElArchivoAlParsear(){
        assertThrows(ArchivoMalformado.class, () -> new ParserRanking( "saves/test/fail/ranking_test.txt").parsear() );
        assertThrows(ArchivoInexistente.class, () -> new ParserRanking( "saves/fail/ranking_test.txt").parsear() );
        assertDoesNotThrow(() -> new ParserRanking( "saves/test/ranking_test.txt").parsear() );
    }

}