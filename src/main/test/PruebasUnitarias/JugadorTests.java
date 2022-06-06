package PruebasUnitarias;

import edu.fiuba.algo3.modelo.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JugadorTests {



    @Test
    public void SeInicializaUnJugador (){

        Jugador jugador = new Jugador("Pepe");
        assertEquals("Pepe", jugador.getNombre());

    }
}
