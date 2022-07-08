package edu.fiuba.algo3.modelo.Mapa;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.CeldaInterna;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCelda;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCeldaBorde;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCeldaEsquina;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCeldaInterna;
import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Excepcion.*;
import edu.fiuba.algo3.modelo.EstadoCelda.Comun;
import edu.fiuba.algo3.modelo.Observador;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class MapaTest {
    @Test
    public void mapaEsCapazDeGenerarCorrectamenteCeldasEsquinasSegunLasCoordenadas(){
        Mapa mapa = new Mapa(2,2);
        //TODO: Mockear Fabrica.
        FabricaCelda fabrica = new FabricaCeldaEsquina();

        Coordenada coord = new Coordenada(0,0);
        Celda resultado = mapa.generarNuevaCelda(coord );
        Celda esperado = fabrica.crearCelda(Direccion.NOROESTE, coord);
        assertEquals(esperado, resultado);

        coord = new Coordenada(0,1);
        resultado = mapa.generarNuevaCelda(coord);
        esperado = fabrica.crearCelda(Direccion.NORESTE, coord);
        assertEquals(esperado, resultado);

        coord = new Coordenada(1,1);
        resultado = mapa.generarNuevaCelda(coord);
        esperado = fabrica.crearCelda(Direccion.SUDESTE, coord);
        assertEquals(esperado, resultado);


        coord = new Coordenada(1,0);
        resultado = mapa.generarNuevaCelda(coord);
        esperado = fabrica.crearCelda(Direccion.SUDESTE, coord);
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
        Celda esperado = fabrica.crearCelda(Direccion.NORTE, coord);
        Celda resultado = mapa.generarNuevaCelda( coord );
        assertEquals(esperado, resultado);

        coord = new Coordenada(1,0);
        resultado = mapa.generarNuevaCelda( coord );
        esperado = fabrica.crearCelda(Direccion.OESTE, coord);
        assertEquals(esperado, resultado);

        coord = new Coordenada(2,1);
        resultado = mapa.generarNuevaCelda( coord );
        esperado = fabrica.crearCelda(Direccion.SUR, coord);
        assertEquals(esperado, resultado);

        coord = new Coordenada(1,2);
        resultado = mapa.generarNuevaCelda( coord );
        esperado = fabrica.crearCelda(Direccion.OESTE, coord);
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
        Celda esperado = fabrica.crearCelda( coord );
        assertEquals(esperado, resultado);

        coord = new Coordenada(1,2);
        resultado = mapa.generarNuevaCelda(coord );
        esperado = fabrica.crearCelda( coord );
        assertEquals(esperado, resultado);

        coord = new Coordenada(2,1);
        resultado = mapa.generarNuevaCelda(coord );
        esperado = fabrica.crearCelda( coord );
        assertEquals(esperado, resultado);

        coord = new Coordenada(2,2);
        resultado = mapa.generarNuevaCelda(coord );
        esperado = fabrica.crearCelda( coord );
        assertEquals(esperado, resultado);

        assertThrows(PosicionInvalida.class, ()-> {
            Coordenada coords = new Coordenada(4,4);
            mapa.generarNuevaCelda( coords );
        });
    }

    @Test
    public void generoUnMapa3x3YPuedoMovermeALoLargoDeTodoElMapa(){
        Mapa mapa = new Mapa( 3, 3);
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

    @Test
    public void generoUnMapa3x3YVerificoQueCorrespondanLasCoordenadas(){
        Mapa mapa = new Mapa( 3, 3);
        Celda esquinaNO = mapa.getEsquinaSuperiorIzquierda();
        Coordenada coord = new Coordenada(0,0);

        String resultado = esquinaNO.imprimir().split(Celda.DELIMITADOR)[1];
        String esperado = coord.imprimir();

        assertEquals(esperado, resultado);

        Celda bordeO = esquinaNO.getCelda(Direccion.SUR);
        coord.mover(Direccion.SUR);
        resultado = bordeO.imprimir().split(Celda.DELIMITADOR)[1];
        esperado = coord.imprimir();
        assertEquals(esperado, resultado);

        Celda esquinaSO = bordeO.getCelda(Direccion.SUR);
        coord.mover(Direccion.SUR);
        resultado = esquinaSO.imprimir().split(Celda.DELIMITADOR)[1];
        esperado = coord.imprimir();
        assertEquals(esperado, resultado);

        Celda bordeS = esquinaSO.getCelda(Direccion.ESTE);
        coord.mover(Direccion.ESTE);
        resultado = bordeS.imprimir().split(Celda.DELIMITADOR)[1];
        esperado = coord.imprimir();
        assertEquals(esperado, resultado);

        Celda centro = bordeO.getCelda(Direccion.ESTE);
        coord.mover(Direccion.NORTE);
        resultado = centro.imprimir().split(Celda.DELIMITADOR)[1];
        esperado = coord.imprimir();
        assertEquals(esperado, resultado);

        Celda bordeN = esquinaNO.getCelda(Direccion.ESTE);
        coord.mover(Direccion.NORTE);
        resultado = bordeN.imprimir().split(Celda.DELIMITADOR)[1];
        esperado = coord.imprimir();
        assertEquals(esperado, resultado);

        Celda esquinaNE = bordeN.getCelda(Direccion.ESTE);
        coord.mover(Direccion.ESTE);
        resultado = esquinaNE.imprimir().split(Celda.DELIMITADOR)[1];
        esperado = coord.imprimir();
        assertEquals(esperado, resultado);

        Celda bordeE = centro.getCelda(Direccion.ESTE);
        coord.mover(Direccion.SUR);
        resultado = bordeE.imprimir().split(Celda.DELIMITADOR)[1];
        esperado = coord.imprimir();
        assertEquals(esperado, resultado);

        Celda esquinaSE = bordeS.getCelda(Direccion.ESTE);
        coord.mover(Direccion.SUR);
        resultado = esquinaSE.imprimir().split(Celda.DELIMITADOR)[1];
        esperado = coord.imprimir();
        assertEquals(esperado, resultado);


    }
    @Test
    public void creoDistintasCombinacionesDeMapas(){
        assertDoesNotThrow( () -> new Mapa(10,10) );
        assertDoesNotThrow( () -> new Mapa(2,2) );
        assertThrows( MapaInvalido.class, () -> new Mapa(1,1) );
        assertThrows( MapaInvalido.class, () -> new Mapa(0,2) );
        assertThrows( MapaInvalido.class, () -> new Mapa(2,0) );
        assertThrows( MapaInvalido.class, () -> new Mapa(0,0) );
        assertThrows( MapaInvalido.class, () -> new Mapa(-3,3) );
        assertThrows( MapaInvalido.class, () -> new Mapa(3,-3) );
    }
    @Test
    public void LaCeldaJugadorSiempreSeSorteaEnELCuartoCuartoDeMapa(){
        Mapa mapa = new Mapa(20,20);
        Celda celda = mapa.getCeldaJugador();

        Coordenada coordenada = new Coordenada( (int)(20 * 0.25F + 1), (int)(20 * 0.25F + 1));
        Celda celdaMax = new CeldaInterna( new Comun() ,coordenada);

        Integer distanciaX = celda.distanciaHorizontal(celdaMax);
        Integer distanciaY = celda.distanciaVertical(celdaMax);

        boolean resultado = ( distanciaX > 0);
        assertTrue(resultado);
        resultado = ( distanciaY > 0);
        assertTrue(resultado);

    }

    @Test
    public void laCeldaMetaSiempreSeSorteaEnELPrimerCuartoDelMapa(){
        Mapa mapa = new Mapa(20,20);
        Coordenada meta = mapa.getMeta();
        Coordenada coordenada = new Coordenada( 9, 9);
        assertTrue( coordenada.distanciaVertical(meta) > 0);
        assertTrue( coordenada.distanciaHorizontal(meta)  > 0);
    }

    @Test
    public void esImprimible(){
        Mapa mapa = new Mapa(3,3);

        String resultado = mapa.imprimir();
        String esperado = "3x3;\n";

        for(int i = 0; i < 3; i++){
            esperado += "COMUN-COMUN-COMUN;\n";
        }
        //Al generarse aleatoriamente no tengo forma de saber como va a ser.
        assertNotEquals(esperado, resultado);
        assertNotEquals("", resultado);
    }

    @Test
    public void elAnchoEsSeteable(){
        Mapa mapa = new Mapa(3,3);
        mapa.setAncho(4);

        assertEquals(new Mapa(4,3),mapa);
    }
    @Test
    public void laAlturaEsSeteable(){
        Mapa mapa = new Mapa(3,3);
        mapa.setAltura(4);

        assertEquals(new Mapa(3,4),mapa);
    }

    @Test
    public void laCeldaDelJugadorSeSorteaUnaUnicaVez(){
        Mapa mapa = new Mapa(3,3);
        Celda jugador1 = mapa.getCeldaJugador();
        Celda jugador2 = mapa.getCeldaJugador();

        assertEquals(jugador1,jugador2);
    }

    @Test
    public void mapaEsObservable(){
        Mapa mapa = new Mapa(2,2);
        Observador mockObservador = mock( Observador.class );

        mapa.agregarObservador(mockObservador);
        mapa.agregarObservador(mockObservador);
        mapa.agregarObservador(mockObservador);

        mapa.notificarATodos();

        verify( mockObservador, times(3)).actualizar();
    }


}