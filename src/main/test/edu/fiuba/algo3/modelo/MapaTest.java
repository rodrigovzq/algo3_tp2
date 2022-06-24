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
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

class MapaTest {
    @Test
    public void pasandoleCoordenadasMapaVerificaSiEsUnaEsquina(){
        Mapa mapa = new Mapa(5,5);

        boolean resultado = mapa.esEsquina(0,0);
        boolean esperado = true;
        assertEquals(esperado, resultado);

        resultado = mapa.esEsquina(4,0);
        esperado = true;
        assertEquals(esperado, resultado);

        resultado = mapa.esEsquina(0,4);
        esperado = true;
        assertEquals(esperado, resultado);

        resultado = mapa.esEsquina(4,4);
        esperado = true;
        assertEquals(esperado, resultado);

        resultado = mapa.esEsquina(0,1);
        esperado = false;
        assertEquals(esperado, resultado);

        resultado = mapa.esEsquina(1,0);
        esperado = false;
        assertEquals(esperado, resultado);

        resultado = mapa.esEsquina(4,1);
        esperado = false;
        assertEquals(esperado, resultado);

        resultado = mapa.esEsquina(1,4);
        esperado = false;
        assertEquals(esperado, resultado);

        assertThrows(CeldaIncorrecta.class, () -> mapa.esEsquina(5,5));
    }

    @Test
    public void pasandoleCoordenadasMapaVerificaSiEsUnBorde() {
        Mapa mapa = new Mapa(5, 5);

        boolean resultado = mapa.esBorde(0, 0);
        boolean esperado = false;
        assertEquals(esperado, resultado);

        resultado = mapa.esBorde(4, 0);
        esperado = false;
        assertEquals(esperado, resultado);

        resultado = mapa.esBorde(0, 4);
        esperado = false;
        assertEquals(esperado, resultado);

        resultado = mapa.esBorde(4, 4);
        esperado = false;
        assertEquals(esperado, resultado);

        resultado = mapa.esBorde(0, 1);
        esperado = true;
        assertEquals(esperado, resultado);

        resultado = mapa.esBorde(1, 0);
        esperado = true;
        assertEquals(esperado, resultado);

        resultado = mapa.esBorde(4, 1);
        esperado = true;
        assertEquals(esperado, resultado);

        resultado = mapa.esBorde(1, 4);
        esperado = true;
        assertEquals(esperado, resultado);

        assertThrows(CeldaIncorrecta.class, () -> mapa.esEsquina(5, 5));
    }
    
    @Test
    public void mapaEsCapazDeGenerarCorrectamenteCeldasEsquinasSegunLasCoordenadas(){
        Mapa mapa = new Mapa(2,2);
        //TODO: Mockear Fabrica.
        FabricaCelda fabrica = new FabricaCeldaEsquina();
        Celda resultado = mapa.generarNuevaCelda(0,0);
        Celda esperado = fabrica.crearCelda(Direccion.NOROESTE);
        assertEquals(esperado, resultado);
        
        resultado = mapa.generarNuevaCelda(0,1);
        esperado = fabrica.crearCelda(Direccion.NORESTE);
        assertEquals(esperado, resultado);

        resultado = mapa.generarNuevaCelda(1,1);
        esperado = fabrica.crearCelda(Direccion.SUDESTE);
        assertEquals(esperado, resultado);

        resultado = mapa.generarNuevaCelda(1,0);
        esperado = fabrica.crearCelda(Direccion.SUDESTE);
        assertEquals(esperado, resultado);

        assertThrows(CeldaIncorrecta.class, ()-> mapa.generarNuevaCelda(2,2));
    }

    @Test
    public void mapaEsCapazDeGenerarCorrectamenteCeldasBordeSegunLasCoordenadas(){
        Mapa mapa = new Mapa(3,3);
        //TODO: Mockear Fabrica.
        FabricaCelda fabrica = new FabricaCeldaBorde();
        Celda resultado = mapa.generarNuevaCelda(0,1);
        Celda esperado = fabrica.crearCelda(Direccion.NORTE);
        assertEquals(esperado, resultado);

        resultado = mapa.generarNuevaCelda(1,0);
        esperado = fabrica.crearCelda(Direccion.OESTE);
        assertEquals(esperado, resultado);

        resultado = mapa.generarNuevaCelda(2,1);
        esperado = fabrica.crearCelda(Direccion.SUR);
        assertEquals(esperado, resultado);

        resultado = mapa.generarNuevaCelda(1,2);
        esperado = fabrica.crearCelda(Direccion.OESTE);
        assertEquals(esperado, resultado);

        assertThrows(CeldaIncorrecta.class, ()-> mapa.generarNuevaCelda(3,3));
    }

    @Test
    public void mapaEsCapazDeGenerarCorrectamenteCeldasInternasSegunLasCoordenadas(){
        Mapa mapa = new Mapa(4,4);
        //TODO: Mockear Fabrica.
        FabricaCeldaInterna fabrica = new FabricaCeldaInterna();
        Celda resultado = mapa.generarNuevaCelda(1,1);
        Celda esperado = fabrica.crearCelda();
        assertEquals(esperado, resultado);

        resultado = mapa.generarNuevaCelda(1,2);
        esperado = fabrica.crearCelda();
        assertEquals(esperado, resultado);

        resultado = mapa.generarNuevaCelda(2,1);
        esperado = fabrica.crearCelda();
        assertEquals(esperado, resultado);

        resultado = mapa.generarNuevaCelda(2,2);
        esperado = fabrica.crearCelda();
        assertEquals(esperado, resultado);

        assertThrows(CeldaIncorrecta.class, ()-> mapa.generarNuevaCelda(4,4));
    }
}