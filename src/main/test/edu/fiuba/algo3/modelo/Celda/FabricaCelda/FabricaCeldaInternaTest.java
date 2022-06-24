package edu.fiuba.algo3.modelo.Celda.FabricaCelda;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.CeldaInterna;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FabricaCeldaInternaTest {
    @Test
    public void creoUnaCeldaInterna(){
        FabricaCeldaInterna fabrica = new FabricaCeldaInterna();
        //TODO: ¿Debo pasarle el estado? El null no es correcto ya que no es un estado valido.
        Celda norte = fabrica.crearCelda(Direccion.NORTE);
        Celda sur = fabrica.crearCelda(Direccion.SUR);
        Celda este = fabrica.crearCelda(Direccion.ESTE);
        Celda oeste = fabrica.crearCelda(Direccion.OESTE);
        Celda none = fabrica.crearCelda();

        Celda esperado = new CeldaInterna(null);
        assertEquals(esperado, norte);
        assertEquals(esperado, sur);
        assertEquals(esperado, este);
        assertEquals(esperado, oeste);
        assertEquals(esperado, none);
    }
}