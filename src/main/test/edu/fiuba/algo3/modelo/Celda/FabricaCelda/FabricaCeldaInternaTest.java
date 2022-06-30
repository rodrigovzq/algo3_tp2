package edu.fiuba.algo3.modelo.Celda.FabricaCelda;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.CeldaInterna;
import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FabricaCeldaInternaTest {
    @Test
    public void creoUnaCeldaInterna(){
        FabricaCeldaInterna fabrica = new FabricaCeldaInterna();
        Coordenada coordenada = new Coordenada(0,0);

        Celda norte = fabrica.crearCelda(Direccion.NORTE, coordenada);
        Celda sur = fabrica.crearCelda(Direccion.SUR, coordenada);
        Celda este = fabrica.crearCelda(Direccion.ESTE, coordenada);
        Celda oeste = fabrica.crearCelda(Direccion.OESTE, coordenada);
        Celda none = fabrica.crearCelda(coordenada);

        Celda esperado = new CeldaInterna(null, coordenada);
        assertEquals(esperado, norte);
        assertEquals(esperado, sur);
        assertEquals(esperado, este);
        assertEquals(esperado, oeste);
        assertEquals(esperado, none);
    }
}