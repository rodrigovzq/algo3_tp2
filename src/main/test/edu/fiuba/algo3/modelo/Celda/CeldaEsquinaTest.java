package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Celda.Obstaculo.Comun;
import edu.fiuba.algo3.modelo.Celda.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Excepcion.DireccionInvalida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CeldaEsquinaTest {
    @Test
    public void creoUnaCeldaEsquinaYObtengoLasCeldasBloqueada() {
        // TODO: Mockear
        CeldaEsquina celda = new CeldaEsquina(new Comun(), Direccion.SUR, Direccion.ESTE);

        assertThrows(DireccionInvalida.class, () -> celda.getCelda(Direccion.NORTE));
        assertThrows(DireccionInvalida.class, () -> celda.getCelda(Direccion.OESTE));
        assertDoesNotThrow(() -> celda.getCelda(Direccion.ESTE));
        assertDoesNotThrow(() -> celda.getCelda(Direccion.SUR));
    }

    @Test
    public void creoUnaCeldaEsquinaYInicializoEnLasCeldasBloqueadas() {
        // TODO: Mockear
        CeldaEsquina celda = new CeldaEsquina(new Comun(), Direccion.SUR, Direccion.ESTE);

        assertThrows(DireccionInvalida.class, () -> celda.setCelda(new CeldaInterna(new Pozo()), Direccion.NORTE));
        assertThrows(DireccionInvalida.class, () -> celda.setCelda(new CeldaInterna(new Pozo()), Direccion.OESTE));
        assertDoesNotThrow(() -> celda.setCelda(new CeldaInterna(new Pozo()), Direccion.SUR));
        assertDoesNotThrow(() -> celda.setCelda(new CeldaInterna(new Pozo()), Direccion.ESTE));
    }

    @Test
    public void verificoQueLaInicializacionDeCeldasSeaCoherente() {
        // TODO: Mockear
        CeldaEsquina celda = new CeldaEsquina(new Comun(), Direccion.NORTE, Direccion.ESTE);

        CeldaInterna norte = new CeldaInterna(new Pozo());
        CeldaInterna este = new CeldaInterna(new Pozo());

        celda.setCelda( norte , Direccion.NORTE);
        celda.setCelda( este  , Direccion.ESTE);

        assertEquals(celda, norte.getCelda( Direccion.SUR ) );
        assertEquals(celda, este .getCelda( Direccion.OESTE ) );
    }

}
