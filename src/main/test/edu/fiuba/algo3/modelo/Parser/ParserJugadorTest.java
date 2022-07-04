package edu.fiuba.algo3.modelo.Parser;

import edu.fiuba.algo3.modelo.Celda.CeldaInterna;
import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.EstadoCelda.Comun;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserJugadorTest {
    @Test
    public void leeDeUnArchivoYDevuelveElJugador(){
        String pathFileTest = "saves/test/jugador_test.txt";
        ParserJugador parser = new ParserJugador( pathFileTest );

        Jugador resultado = parser.parsear();
        //TODO: De alguna forma hay que inicializarlo con una celda de mapa
        Jugador esperado = new Jugador("Test", new CeldaInterna(new Comun(), new Coordenada(3,4)),new Auto(),100);

        assertEquals(esperado, resultado);

    }

}