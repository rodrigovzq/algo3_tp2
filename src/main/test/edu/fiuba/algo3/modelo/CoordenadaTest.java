package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Excepcion.MapaInvalido;
import edu.fiuba.algo3.modelo.Excepcion.PosicionInvalida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordenadaTest {
    @Test
    public void creoUnaCoordenadaYDeterminaSiEsValidaSegunElTamañoDelMapa(){
        //TODO: PosicionInvalida -> posX o posY negativa.
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

        assertThrows( MapaInvalido.class, () -> coord.esValidaEnMapa(-1,5));
        assertThrows( MapaInvalido.class, () -> coord.esValidaEnMapa(2,0));
        assertThrows( MapaInvalido.class, () -> coord.esValidaEnMapa(1,1));

    }

    @Test
    public void creoUnaCoordenadaYMuevoLaPosicionEnDistintasDirecciones(){
        Coordenada coord = new Coordenada(0,0);

        coord.mover(Direccion.NORTE);
        Coordenada esperado = new Coordenada(0,1);
        assertEquals(esperado, coord);

        coord.mover(Direccion.SUR);
        esperado = new Coordenada(0,0);
        assertEquals(esperado, coord);


        coord.mover(Direccion.ESTE);
        esperado = new Coordenada(1,0);
        assertEquals(esperado, coord);

        coord.mover(Direccion.OESTE);
        esperado = new Coordenada(0,0);
        assertEquals(esperado, coord);

        assertThrows( PosicionInvalida.class, () -> coord.mover(Direccion.SUR));
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

        assertThrows( MapaInvalido.class, () -> {
            Coordenada coordenada = new Coordenada(2,3 );
            coordenada.esEsquina(1,1);
        } );
        assertThrows( PosicionInvalida.class, () -> {
            Coordenada coordenada = new Coordenada(2,3 );
            coordenada.esEsquina(2, 3);
        } );

    }

}