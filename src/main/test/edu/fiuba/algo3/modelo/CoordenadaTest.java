package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Excepcion.CoordenadaInvalida;
import edu.fiuba.algo3.modelo.Excepcion.PosicionInvalida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordenadaTest {
    @Test
    public void creoUnaCoordenadaYDeterminaSiEsValidaSegunElTamañoDelMapa(){
        Coordenada coord = new Coordenada(2,5);

        boolean resultado = coord.esValidaEnMapa(2,2);
        boolean esperado = false;
        assertEquals( esperado, resultado );

        resultado = coord.esValidaEnMapa(2,5);
        esperado = false;
        assertEquals( esperado, resultado );

        resultado = coord.esValidaEnMapa(3,6);
        esperado = true;
        assertEquals( esperado, resultado );

        resultado = coord.esValidaEnMapa(2,6);
        esperado = false;
        assertEquals( esperado, resultado );

        resultado = coord.esValidaEnMapa(3,5);
        esperado = false;
        assertEquals( esperado, resultado );

        resultado = coord.esValidaEnMapa(-1,5);
        esperado = false;
        assertEquals( esperado, resultado );

        resultado = coord.esValidaEnMapa(2,0);
        esperado = false;
        assertEquals( esperado, resultado );

        resultado = coord.esValidaEnMapa(1,1);
        esperado = false;
        assertEquals( esperado, resultado );

    }

    @Test
    public void creoUnaCoordenadaYMuevoLaPosicionEnDistintasDirecciones(){
        Coordenada coord = new Coordenada(0,0);

        coord.mover(Direccion.SUR);
        Coordenada esperado = new Coordenada(0,1);
        assertEquals(esperado, coord);

        coord.mover(Direccion.NORTE);
        esperado = new Coordenada(0,0);
        assertEquals(esperado, coord);


        coord.mover(Direccion.ESTE);
        esperado = new Coordenada(1,0);
        assertEquals(esperado, coord);

        coord.mover(Direccion.OESTE);
        esperado = new Coordenada(0,0);
        assertEquals(esperado, coord);

        assertThrows( PosicionInvalida.class, () -> coord.mover(Direccion.NORTE));
        assertThrows( PosicionInvalida.class, () -> coord.mover(Direccion.OESTE));
    }
    @Test
    public void creoUnaCoordenadaYEsCapazDeReconocerSiEsUnaEsquinaPasandoleElTamanioDelMapa(){
        Coordenada coord = new Coordenada(0,0);

        boolean resultado = coord.esEsquina( 2, 2 );
        boolean esperado = true;
        assertEquals(esperado, resultado);

        resultado = coord.esEsquina( 2, 10 );
        esperado = true;
        assertEquals(esperado, resultado);

        resultado = coord.esEsquina( 10, 2 );
        esperado = true;
        assertEquals(esperado, resultado);

        coord = new Coordenada(2,3 );

        resultado = coord.esEsquina( 3, 4 );
        esperado = true;
        assertEquals(esperado, resultado);

        resultado = coord.esEsquina( 5, 5 );
        esperado = false;
        assertEquals(esperado, resultado);

        resultado = coord.esEsquina( 3, 10 );
        esperado = false;
        assertEquals(esperado, resultado);

        coord = new Coordenada(0,3 );

        resultado = coord.esEsquina( 3, 4 );
        esperado = true;
        assertEquals(esperado, resultado);

        coord = new Coordenada(2,0 );

        resultado = coord.esEsquina( 3, 4 );
        esperado = true;
        assertEquals(esperado, resultado);

        assertThrows( PosicionInvalida.class, () -> {
            Coordenada coordenada = new Coordenada(2,3 );
            coordenada.esEsquina(1,1);
        } );
        assertThrows( PosicionInvalida.class, () -> {
            Coordenada coordenada = new Coordenada(2,3 );
            coordenada.esEsquina(2, 3);
        } );

    }

    @Test
    public void creoUnaCoordenadaYEsCapazDeReconocerSiEsUnaBordePasandoleElTamanioDelMapa(){
        Coordenada coord = new Coordenada(3,3);

        boolean resultado = coord.esBorde( 4, 4 );
        boolean esperado = false;
        assertEquals(esperado, resultado);

        resultado = coord.esBorde( 5, 4 );
        esperado = true;
        assertEquals(esperado, resultado);

        resultado = coord.esBorde( 4, 5 );
        esperado = true;
        assertEquals(esperado, resultado);

        coord = new Coordenada(0,0 );

        resultado = coord.esBorde( 3, 4 );
        esperado = false;
        assertEquals(esperado, resultado);

        coord = new Coordenada(0,1 );
        
        resultado = coord.esBorde( 2, 2 );
        esperado = false;
        assertEquals(esperado, resultado);

        resultado = coord.esBorde( 3, 3 );
        esperado = true;
        assertEquals(esperado, resultado);
        
        coord = new Coordenada(1,0 );

        resultado = coord.esBorde( 2, 2 );
        esperado = false;
        assertEquals(esperado, resultado);

        resultado = coord.esBorde( 3, 3 );
        esperado = true;
        assertEquals(esperado, resultado);

        assertThrows( PosicionInvalida.class, () -> {
            Coordenada coordenada = new Coordenada(2,3 );
            coordenada.esBorde(1,1);
        } );
        assertThrows( PosicionInvalida.class, () -> {
            Coordenada coordenada = new Coordenada(2,3 );
            coordenada.esBorde(2, 3);
        } );

    }

    @Test
    public void creoDistintasCombinacionesDeCoordenadas(){
        assertDoesNotThrow( () -> new Coordenada(1,1) );
        assertDoesNotThrow( () -> new Coordenada(0,0) );
        assertThrows( CoordenadaInvalida.class, () -> new Coordenada(1,-1) );
        assertThrows( CoordenadaInvalida.class, () -> new Coordenada(-1,-1) );
        assertThrows( CoordenadaInvalida.class, () -> new Coordenada(-1,1) );

    }

    @Test
    public void obtengoLaDistanciaADistintasCoordenadas(){
        Coordenada coordenada = new Coordenada(0,0);

        Integer longitud = coordenada.distanciaHorizontal( new Coordenada(0,0) );
        assertEquals( 0, longitud);
        longitud = coordenada.distanciaVertical( new Coordenada(0,0) );
        assertEquals( 0, longitud);
        longitud = coordenada.distanciaHorizontal( new Coordenada(3,0) );
        assertEquals( 3, longitud);
        longitud = coordenada.distanciaVertical( new Coordenada(0,5) );
        assertEquals( 5, longitud);


        coordenada = new Coordenada(2,2);

        longitud = coordenada.distanciaHorizontal( new Coordenada(3,0) );
        assertEquals( 1, longitud);
        longitud = coordenada.distanciaVertical( new Coordenada(0,1) );
        assertEquals( -1, longitud);
        longitud = coordenada.distanciaHorizontal( new Coordenada(2,2) );
        assertEquals( 0, longitud);
        longitud = coordenada.distanciaVertical( new Coordenada(2,2) );
        assertEquals( 0, longitud);

    }
}