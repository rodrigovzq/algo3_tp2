package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Celda.Obstaculo.Comun;
import edu.fiuba.algo3.modelo.Celda.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CeldaInternaTest {
    @Test
    public void creoUnaCeldaInternaYInicializoEnLasCeldas() {
        // TODO: Mockear
        CeldaInterna celda = new CeldaInterna(new Comun());

        CeldaInterna c1 = new CeldaInterna(new Pozo());
        CeldaInterna c2 = new CeldaInterna(new Pozo());
        CeldaInterna c3 = new CeldaInterna(new Pozo());
        CeldaInterna c4 = new CeldaInterna(new Pozo());

        celda.setCelda(c1, Direccion.NORTE);
        celda.setCelda(c2, Direccion.SUR);
        celda.setCelda(c3, Direccion.ESTE);
        celda.setCelda(c4, Direccion.OESTE);

        Celda esperado =  celda.getCelda(Direccion.NORTE);
        assertEquals(esperado, c1);
        esperado =  celda.getCelda(Direccion.SUR);
        assertEquals(esperado, c2);
        esperado =  celda.getCelda(Direccion.ESTE);
        assertEquals(esperado, c3);
        esperado =  celda.getCelda(Direccion.OESTE);
        assertEquals(esperado, c4);
    }
}