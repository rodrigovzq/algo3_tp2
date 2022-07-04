package edu.fiuba.algo3.modelo.Parser;

import edu.fiuba.algo3.modelo.Ranking.Ranking;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ParserRankingTest {
    @Test
    public void leeDeUnArchivoYDevuelveUnRanking(){
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

}