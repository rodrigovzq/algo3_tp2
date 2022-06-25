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
import edu.fiuba.algo3.modelo.Excepcion.PosicionInvalida;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

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
}