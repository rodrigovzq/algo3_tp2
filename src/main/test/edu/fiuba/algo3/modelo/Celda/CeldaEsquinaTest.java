package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Obstaculo.Comun;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Excepcion.DireccionInvalida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CeldaEsquinaTest {
    @Test
    public void creoUnaCeldaEsquinaYObtengoLasCeldasBloqueada() {
        // TODO: Mockear?
        Coordenada coordenada = new Coordenada(0,0);
        CeldaEsquina celda = new CeldaEsquina(new Comun(), coordenada, Direccion.SUR, Direccion.ESTE);

        assertThrows(DireccionInvalida.class, () -> celda.getCelda(Direccion.NORTE));
        assertThrows(DireccionInvalida.class, () -> celda.getCelda(Direccion.OESTE));
        assertDoesNotThrow(() -> celda.getCelda(Direccion.ESTE));
        assertDoesNotThrow(() -> celda.getCelda(Direccion.SUR));
    }

    @Test
    public void creoUnaCeldaEsquinaYInicializoEnLasCeldasBloqueadas() {
        // TODO: Mockear?
        Coordenada coordenada = new Coordenada(0,0);
        CeldaEsquina celda = new CeldaEsquina(new Comun(), coordenada, Direccion.SUR, Direccion.ESTE);

        assertThrows(DireccionInvalida.class, () -> celda.setCelda(new CeldaInterna(new Pozo(), coordenada), Direccion.NORTE));
        assertThrows(DireccionInvalida.class, () -> celda.setCelda(new CeldaInterna(new Pozo(), coordenada), Direccion.OESTE));
        assertDoesNotThrow(() -> celda.setCelda(new CeldaInterna(new Pozo(), coordenada), Direccion.SUR));
        assertDoesNotThrow(() -> celda.setCelda(new CeldaInterna(new Pozo(), coordenada), Direccion.ESTE));
    }

    @Test
    public void verificoQueLaInicializacionDeCeldasSeaCoherente() {
        // TODO: Mockear?
        Coordenada coordenada = new Coordenada(0,0);
        CeldaEsquina celda = new CeldaEsquina(new Comun(), coordenada, Direccion.NORTE, Direccion.ESTE);

        CeldaInterna norte = new CeldaInterna(new Pozo(), coordenada);
        CeldaInterna este = new CeldaInterna(new Pozo(), coordenada);

        celda.setCelda( norte , Direccion.NORTE);
        celda.setCelda( este  , Direccion.ESTE);

        assertEquals(celda, norte.getCelda( Direccion.SUR ) );
        assertEquals(celda, este .getCelda( Direccion.OESTE ) );
    }

}
