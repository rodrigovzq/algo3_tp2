package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Obstaculo.Comun;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CeldaInternaTest {
    @Test
    public void creoUnaCeldaInternaYInicializoEnLasCeldas() {
        // TODO: Mockear?
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

    @Test
    public void verificoQueLaInicializacionDeCeldasSeaCoherente() {
        // TODO: Mockear?
        CeldaInterna celda = new CeldaInterna(new Comun());

        CeldaInterna norte = new CeldaInterna(new Pozo());
        CeldaInterna sur = new CeldaInterna(new Pozo());
        CeldaInterna este = new CeldaInterna(new Pozo());
        CeldaInterna oeste = new CeldaInterna(new Pozo());

        celda.setCelda( norte , Direccion.NORTE);
        celda.setCelda( sur , Direccion.SUR);
        celda.setCelda( este  , Direccion.ESTE);
        celda.setCelda( oeste , Direccion.OESTE);


        assertEquals(celda, norte.getCelda( Direccion.SUR ) );
        assertEquals(celda, sur.getCelda( Direccion.NORTE ) );
        assertEquals(celda, este .getCelda( Direccion.OESTE ) );
        assertEquals(celda, oeste.getCelda( Direccion.ESTE ) );
    }
}