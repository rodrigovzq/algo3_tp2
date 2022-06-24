package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Celda.Obstaculo.Comun;
import edu.fiuba.algo3.modelo.Celda.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Excepcion.DireccionInvalida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CeldaBordeTest {
    @Test
    public void creoUnaCeldaBordeYObtengoLaCeldaDeLaDireccionBloqueada(){
        // TODO: Mockear
        CeldaBorde celda = new CeldaBorde( new Comun(), Direccion.SUR, Direccion.ESTE, Direccion.OESTE);

        assertThrows(DireccionInvalida.class, () -> celda.getCelda( Direccion.NORTE ));
        assertDoesNotThrow(() -> celda.getCelda( Direccion.SUR ));
        assertDoesNotThrow(() -> celda.getCelda( Direccion.ESTE ));
        assertDoesNotThrow(() -> celda.getCelda( Direccion.OESTE ));
    }

    @Test
    public void creoUnaCeldaBordeYInicializoLaCeldaDeLaDireccionBloqueada(){
        // TODO: Mockear
        CeldaBorde celda = new CeldaBorde( new Comun(), Direccion.SUR, Direccion.ESTE, Direccion.OESTE);

        assertThrows(DireccionInvalida.class, () -> celda.setCelda( new CeldaInterna( new Pozo()), Direccion.NORTE ));
        assertDoesNotThrow(() -> celda.setCelda( new CeldaInterna( new Pozo()), Direccion.SUR ));
        assertDoesNotThrow(() -> celda.setCelda( new CeldaInterna( new Pozo()), Direccion.ESTE ));
        assertDoesNotThrow(() -> celda.setCelda( new CeldaInterna( new Pozo()), Direccion.OESTE ));
    }

    @Test
    public void verificoQueLaInicializacionDeCeldasSeaCoherente() {
        // TODO: Mockear?
        CeldaBorde celda = new CeldaBorde(new Comun(), Direccion.NORTE, Direccion.SUR, Direccion.ESTE);           ;

        CeldaInterna norte = new CeldaInterna(new Pozo());
        CeldaInterna sur = new CeldaInterna(new Pozo());
        CeldaInterna este = new CeldaInterna(new Pozo());

        celda.setCelda( norte , Direccion.NORTE);
        celda.setCelda( sur , Direccion.SUR);
        celda.setCelda( este  , Direccion.ESTE);


        assertEquals(celda, norte.getCelda( Direccion.SUR ) );
        assertEquals(celda, sur.getCelda( Direccion.NORTE ) );
        assertEquals(celda, este .getCelda( Direccion.OESTE ) );
    }

}