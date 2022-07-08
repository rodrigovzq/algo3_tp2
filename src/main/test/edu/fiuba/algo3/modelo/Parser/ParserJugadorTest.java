package edu.fiuba.algo3.modelo.Parser;

import edu.fiuba.algo3.modelo.Celda.CeldaInterna;
import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.EstadoCelda.Comun;
import edu.fiuba.algo3.modelo.Excepcion.ArchivoInexistente;
import edu.fiuba.algo3.modelo.Excepcion.ArchivoMalformado;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ParserJugadorTest {
    @Test
    public void leeDeUnArchivoYDevuelveElJugador() throws IOException {
        String pathFileTest = "saves/test/jugador_test.txt";
        ParserJugador parser = new ParserJugador( pathFileTest );
        parser.parsear();
        Jugador resultado = parser.getEntidadParseada();
        //TODO: De alguna forma hay que inicializarlo con una celda de mapa
        Jugador esperado = new Jugador("Test", new CeldaInterna(new Comun(), new Coordenada(3,4)),new Auto(),100);

        assertEquals(esperado, resultado);

    }

    @Test
    public void verificaQueEsteBienFormadoElArchivoAlParsear(){
        assertThrows(ArchivoMalformado.class, () -> new ParserJugador( "saves/test/fail/jugador_test.txt").parsear() );
        assertThrows(ArchivoInexistente.class, () -> new ParserJugador( "saves/fail/jugador_test.txt").parsear() );
        assertDoesNotThrow(() -> new ParserJugador( "saves/test/jugador_test.txt").parsear() );
    }

}