package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.EstadoCelda.Comun;
import edu.fiuba.algo3.modelo.EstadoCelda.EstadoCelda;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Excepcion.DireccionInvalida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CeldaBordeTest {
    @Test
    public void creoUnaCeldaBordeYObtengoLaCeldaDeLaDireccionBloqueada(){
        // TODO: Mockear
        Coordenada coordenada = new Coordenada(0,0);
        CeldaBorde celda = new CeldaBorde( new Comun(), coordenada, Direccion.SUR, Direccion.ESTE, Direccion.OESTE);

        assertThrows(DireccionInvalida.class, () -> celda.getCelda( Direccion.NORTE ));
        assertDoesNotThrow(() -> celda.getCelda( Direccion.SUR ));
        assertDoesNotThrow(() -> celda.getCelda( Direccion.ESTE ));
        assertDoesNotThrow(() -> celda.getCelda( Direccion.OESTE ));
    }

    @Test
    public void creoUnaCeldaBordeYInicializoLaCeldaDeLaDireccionBloqueada(){
        // TODO: Mockear
        Coordenada coordenada = new Coordenada(0,0);
        CeldaBorde celda = new CeldaBorde( new Comun(),coordenada,  Direccion.SUR, Direccion.ESTE, Direccion.OESTE);

        assertThrows(DireccionInvalida.class, () -> celda.setCelda( new CeldaInterna( new Pozo(), coordenada), Direccion.NORTE ));
        assertDoesNotThrow(() -> celda.setCelda( new CeldaInterna( new Pozo(), coordenada), Direccion.SUR ));
        assertDoesNotThrow(() -> celda.setCelda( new CeldaInterna( new Pozo(), coordenada), Direccion.ESTE ));
        assertDoesNotThrow(() -> celda.setCelda( new CeldaInterna( new Pozo(), coordenada), Direccion.OESTE ));
    }

    @Test
    public void verificoQueLaInicializacionDeCeldasSeaCoherente() {
        // TODO: Mockear?
        Coordenada coordenada = new Coordenada(0,0);
        CeldaBorde celda = new CeldaBorde(new Comun(),coordenada, Direccion.NORTE, Direccion.SUR, Direccion.ESTE);           ;

        CeldaInterna norte = new CeldaInterna(new Pozo(), coordenada);
        CeldaInterna sur = new CeldaInterna(new Pozo(), coordenada);
        CeldaInterna este = new CeldaInterna(new Pozo(), coordenada);

        celda.setCelda( norte , Direccion.NORTE);
        celda.setCelda( sur , Direccion.SUR);
        celda.setCelda( este  , Direccion.ESTE);


        assertEquals(celda, norte.getCelda( Direccion.SUR ) );
        assertEquals(celda, sur.getCelda( Direccion.NORTE ) );
        assertEquals(celda, este .getCelda( Direccion.OESTE ) );
    }



}