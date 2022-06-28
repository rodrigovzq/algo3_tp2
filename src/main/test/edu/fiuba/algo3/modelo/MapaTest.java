package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.CeldaEsquina;
import edu.fiuba.algo3.modelo.Celda.CeldaInterna;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCelda;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCeldaBorde;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCeldaEsquina;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCeldaInterna;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Excepcion.CeldaIncorrecta;
import edu.fiuba.algo3.modelo.Excepcion.DireccionInvalida;
import edu.fiuba.algo3.modelo.Excepcion.PosicionInvalida;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class MapaTest {
    @Test
    public void mapaEsCapazDeGenerarCorrectamenteCeldasEsquinasSegunLasCoordenadas(){
        Mapa mapa = new Mapa(2,2);
        //TODO: Mockear Fabrica.
        FabricaCelda fabrica = new FabricaCeldaEsquina();

        Coordenada coord = new Coordenada(0,0);
        Celda resultado = mapa.generarNuevaCelda(coord );
        Celda esperado = fabrica.crearCelda(Direccion.NOROESTE);
        assertEquals(esperado, resultado);

        coord = new Coordenada(0,1);
        resultado = mapa.generarNuevaCelda(coord);
        esperado = fabrica.crearCelda(Direccion.NORESTE);
        assertEquals(esperado, resultado);

        coord = new Coordenada(1,1);
        resultado = mapa.generarNuevaCelda(coord);
        esperado = fabrica.crearCelda(Direccion.SUDESTE);
        assertEquals(esperado, resultado);


        coord = new Coordenada(1,0);
        resultado = mapa.generarNuevaCelda(coord);
        esperado = fabrica.crearCelda(Direccion.SUDESTE);
        assertEquals(esperado, resultado);

        assertThrows(PosicionInvalida.class, ()-> {
            Coordenada coords = new Coordenada(2,2);
            mapa.generarNuevaCelda( coords );
        });
    }

    @Test
    public void mapaEsCapazDeGenerarCorrectamenteCeldasBordeSegunLasCoordenadas(){
        Mapa mapa = new Mapa(3,3);
        //TODO: Mockear Fabrica.
        FabricaCelda fabrica = new FabricaCeldaBorde();
        Coordenada coord = new Coordenada(0,1);
        Celda esperado = fabrica.crearCelda(Direccion.NORTE);
        Celda resultado = mapa.generarNuevaCelda( coord );
        assertEquals(esperado, resultado);

        coord = new Coordenada(1,0);
        resultado = mapa.generarNuevaCelda( coord );
        esperado = fabrica.crearCelda(Direccion.OESTE);
        assertEquals(esperado, resultado);

        coord = new Coordenada(2,1);
        resultado = mapa.generarNuevaCelda( coord );
        esperado = fabrica.crearCelda(Direccion.SUR);
        assertEquals(esperado, resultado);

        coord = new Coordenada(1,2);
        resultado = mapa.generarNuevaCelda( coord );
        esperado = fabrica.crearCelda(Direccion.OESTE);
        assertEquals(esperado, resultado);

        assertThrows(PosicionInvalida.class, ()-> {
            Coordenada coords = new Coordenada(3, 3);
            mapa.generarNuevaCelda( coords );
        });
    }

    @Test
    public void mapaEsCapazDeGenerarCorrectamenteCeldasInternasSegunLasCoordenadas(){
        Mapa mapa = new Mapa(4,4);
        //TODO: Mockear Fabrica.
        FabricaCeldaInterna fabrica = new FabricaCeldaInterna();
        Coordenada coord = new Coordenada(1,1);
        Celda resultado = mapa.generarNuevaCelda( coord );
        Celda esperado = fabrica.crearCelda();
        assertEquals(esperado, resultado);

        coord = new Coordenada(1,2);
        resultado = mapa.generarNuevaCelda(coord );
        esperado = fabrica.crearCelda();
        assertEquals(esperado, resultado);

        coord = new Coordenada(2,1);
        resultado = mapa.generarNuevaCelda(coord );
        esperado = fabrica.crearCelda();
        assertEquals(esperado, resultado);

        coord = new Coordenada(2,2);
        resultado = mapa.generarNuevaCelda(coord );
        esperado = fabrica.crearCelda();
        assertEquals(esperado, resultado);

        assertThrows(PosicionInvalida.class, ()-> {
            Coordenada coords = new Coordenada(4,4);
            mapa.generarNuevaCelda( coords );
        });
    }

    @Test
    public void generoUnMapa3x3YPuedoMovermeALoLargoDeTodoElMapa(){
        Mapa mapa = new Mapa( 3, 3);
        mapa.generarMapa();
        Celda esquinaNO = mapa.getEsquinaSuperiorIzquierda();

        assertThrows(DireccionInvalida.class, () -> esquinaNO.getCelda(Direccion.OESTE));
        assertNotEquals( null, esquinaNO.getCelda(Direccion.SUR ) );
        assertThrows(DireccionInvalida.class, () -> esquinaNO.getCelda(Direccion.NORTE));
        assertNotEquals( null, esquinaNO.getCelda(Direccion.ESTE ) );

        Celda bordeO = esquinaNO.getCelda(Direccion.SUR);
        Celda esquinaSO = bordeO.getCelda(Direccion.SUR);


        assertThrows(DireccionInvalida.class, () -> bordeO.getCelda(Direccion.OESTE));
        assertNotEquals( null, bordeO.getCelda(Direccion.NORTE ) );
        assertNotEquals( null, bordeO.getCelda(Direccion.SUR ) );
        assertNotEquals( null, bordeO.getCelda(Direccion.ESTE ) );

        assertThrows(DireccionInvalida.class, () -> esquinaSO.getCelda(Direccion.OESTE));
        assertThrows(DireccionInvalida.class, () -> esquinaSO.getCelda(Direccion.SUR));
        assertNotEquals( null, esquinaSO.getCelda(Direccion.NORTE ) );
        assertNotEquals( null, esquinaSO.getCelda(Direccion.ESTE ) );


        Celda bordeN = esquinaNO.getCelda(Direccion.ESTE);
        Celda centro = bordeO.getCelda(Direccion.ESTE);
        Celda bordeS = esquinaSO.getCelda(Direccion.ESTE);

        assertThrows(DireccionInvalida.class, () -> bordeN.getCelda(Direccion.NORTE));
        assertNotEquals( null, bordeN.getCelda(Direccion.SUR ) );
        assertNotEquals( null, bordeN.getCelda(Direccion.ESTE ) );
        assertNotEquals( null, bordeN.getCelda(Direccion.OESTE ) );

        assertThrows(DireccionInvalida.class, () -> bordeS.getCelda(Direccion.SUR));
        assertNotEquals( null, bordeS.getCelda(Direccion.NORTE ) );
        assertNotEquals( null, bordeS.getCelda(Direccion.ESTE ) );
        assertNotEquals( null, bordeS.getCelda(Direccion.OESTE ) );

        assertNotEquals( null, centro.getCelda(Direccion.SUR ) );
        assertNotEquals( null, centro.getCelda(Direccion.NORTE ) );
        assertNotEquals( null, centro.getCelda(Direccion.ESTE ) );
        assertNotEquals( null, centro.getCelda(Direccion.OESTE ) );

        Celda esquinaNE = bordeN.getCelda(Direccion.ESTE);
        Celda bordeE = centro.getCelda(Direccion.ESTE);
        Celda esquinaSE = bordeS.getCelda(Direccion.ESTE);

        assertThrows(DireccionInvalida.class, () -> esquinaNE.getCelda(Direccion.ESTE));
        assertThrows(DireccionInvalida.class, () -> esquinaNE.getCelda(Direccion.NORTE));
        assertNotEquals( null, esquinaNE.getCelda(Direccion.SUR ) );
        assertNotEquals( null, esquinaNE.getCelda(Direccion.OESTE ) );

        assertThrows(DireccionInvalida.class, () -> bordeE.getCelda(Direccion.ESTE));
        assertNotEquals( null, bordeE.getCelda(Direccion.NORTE ) );
        assertNotEquals( null, bordeE.getCelda(Direccion.SUR ) );
        assertNotEquals( null, bordeE.getCelda(Direccion.OESTE ) );

        assertThrows(DireccionInvalida.class, () -> esquinaSE.getCelda(Direccion.ESTE));
        assertThrows(DireccionInvalida.class, () -> esquinaSE.getCelda(Direccion.SUR));
        assertNotEquals( null ,esquinaSE.getCelda(Direccion.NORTE ) );
        assertNotEquals( null, esquinaSE.getCelda(Direccion.OESTE ) );

    }

    @Test
    public void generoUnMapa3x4YPuedoMovermeALoLargoDeTodoElMapa(){
        Mapa mapa = new Mapa( 3, 4);
        mapa.generarMapa();
        Celda esquinaNO = mapa.getEsquinaSuperiorIzquierda();

        assertThrows(DireccionInvalida.class, () -> esquinaNO.getCelda(Direccion.OESTE));
        assertNotEquals( null, esquinaNO.getCelda(Direccion.SUR ) );
        assertThrows(DireccionInvalida.class, () -> esquinaNO.getCelda(Direccion.NORTE));
        assertNotEquals( null, esquinaNO.getCelda(Direccion.ESTE ) );

        Celda bordeO1 = esquinaNO.getCelda(Direccion.SUR);
        Celda bordeO2 = bordeO1.getCelda(Direccion.SUR);
        Celda esquinaSO = bordeO2.getCelda(Direccion.SUR);


        assertThrows(DireccionInvalida.class, () -> bordeO1.getCelda(Direccion.OESTE));
        assertNotEquals( null, bordeO1.getCelda(Direccion.NORTE ) );
        assertNotEquals( null, bordeO1.getCelda(Direccion.SUR ) );
        assertNotEquals( null, bordeO1.getCelda(Direccion.ESTE ) );

        assertThrows(DireccionInvalida.class, () -> bordeO2.getCelda(Direccion.OESTE));
        assertNotEquals( null, bordeO2.getCelda(Direccion.NORTE ) );
        assertNotEquals( null, bordeO2.getCelda(Direccion.SUR ) );
        assertNotEquals( null, bordeO2.getCelda(Direccion.ESTE ) );


        assertThrows(DireccionInvalida.class, () -> esquinaSO.getCelda(Direccion.OESTE));
        assertThrows(DireccionInvalida.class, () -> esquinaSO.getCelda(Direccion.SUR));
        assertNotEquals( null, esquinaSO.getCelda(Direccion.NORTE ) );
        assertNotEquals( null, esquinaSO.getCelda(Direccion.ESTE ) );


        Celda bordeN = esquinaNO.getCelda(Direccion.ESTE);
        Celda centro1 = bordeO1.getCelda(Direccion.ESTE);
        Celda centro2 = bordeO2.getCelda(Direccion.ESTE);
        Celda bordeS = esquinaSO.getCelda(Direccion.ESTE);

        assertThrows(DireccionInvalida.class, () -> bordeN.getCelda(Direccion.NORTE));
        assertNotEquals( null, bordeN.getCelda(Direccion.SUR ) );
        assertNotEquals( null, bordeN.getCelda(Direccion.ESTE ) );
        assertNotEquals( null, bordeN.getCelda(Direccion.OESTE ) );

        assertThrows(DireccionInvalida.class, () -> bordeS.getCelda(Direccion.SUR));
        assertNotEquals( null, bordeS.getCelda(Direccion.NORTE ) );
        assertNotEquals( null, bordeS.getCelda(Direccion.ESTE ) );
        assertNotEquals( null, bordeS.getCelda(Direccion.OESTE ) );

        assertNotEquals( null, centro1.getCelda(Direccion.SUR ) );
        assertNotEquals( null, centro1.getCelda(Direccion.NORTE ) );
        assertNotEquals( null, centro1.getCelda(Direccion.ESTE ) );
        assertNotEquals( null, centro1.getCelda(Direccion.OESTE ) );

        assertNotEquals( null, centro2.getCelda(Direccion.SUR ) );
        assertNotEquals( null, centro2.getCelda(Direccion.NORTE ) );
        assertNotEquals( null, centro2.getCelda(Direccion.ESTE ) );
        assertNotEquals( null, centro2.getCelda(Direccion.OESTE ) );

        Celda esquinaNE = bordeN.getCelda(Direccion.ESTE);
        Celda bordeE1 = centro1.getCelda(Direccion.ESTE);
        Celda bordeE2 = centro2.getCelda(Direccion.ESTE);
        Celda esquinaSE = bordeS.getCelda(Direccion.ESTE);

        assertThrows(DireccionInvalida.class, () -> esquinaNE.getCelda(Direccion.ESTE));
        assertThrows(DireccionInvalida.class, () -> esquinaNE.getCelda(Direccion.NORTE));
        assertNotEquals( null, esquinaNE.getCelda(Direccion.SUR ) );
        assertNotEquals( null, esquinaNE.getCelda(Direccion.OESTE ) );

        assertThrows(DireccionInvalida.class, () -> bordeE1.getCelda(Direccion.ESTE));
        assertNotEquals( null, bordeE1.getCelda(Direccion.NORTE ) );
        assertNotEquals( null, bordeE1.getCelda(Direccion.SUR ) );
        assertNotEquals( null, bordeE1.getCelda(Direccion.OESTE ) );

        assertThrows(DireccionInvalida.class, () -> bordeE2.getCelda(Direccion.ESTE));
        assertNotEquals( null, bordeE2.getCelda(Direccion.NORTE ) );
        assertNotEquals( null, bordeE2.getCelda(Direccion.SUR ) );
        assertNotEquals( null, bordeE2.getCelda(Direccion.OESTE ) );

        assertThrows(DireccionInvalida.class, () -> esquinaSE.getCelda(Direccion.ESTE));
        assertThrows(DireccionInvalida.class, () -> esquinaSE.getCelda(Direccion.SUR));
        assertNotEquals( null ,esquinaSE.getCelda(Direccion.NORTE ) );
        assertNotEquals( null, esquinaSE.getCelda(Direccion.OESTE ) );

    }
}