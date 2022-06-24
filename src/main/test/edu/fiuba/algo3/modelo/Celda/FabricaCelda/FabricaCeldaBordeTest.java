package edu.fiuba.algo3.modelo.Celda.FabricaCelda;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.CeldaBorde;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FabricaCeldaBordeTest {
    @Test
    public void creoUnaCeldaBordePasandoLaDireccionBloqueada(){
        FabricaCeldaBorde fabrica = new FabricaCeldaBorde();
        // TODO: ¿Debo pasarle el estado? El null no es correcto ya que no es un estado valido.
        Celda norte = fabrica.crearCelda(Direccion.NORTE);
        Celda sur = fabrica.crearCelda(Direccion.SUR);
        Celda este = fabrica.crearCelda(Direccion.ESTE);
        Celda oeste = fabrica.crearCelda(Direccion.OESTE);

        Celda esperado = new CeldaBorde(null, Direccion.SUR,Direccion.ESTE,Direccion.OESTE);
        assertEquals(esperado, norte);

        esperado = new CeldaBorde(null, Direccion.NORTE,Direccion.ESTE,Direccion.OESTE);
        assertEquals(esperado, sur);

        esperado = new CeldaBorde(null, Direccion.NORTE,Direccion.SUR,Direccion.OESTE);
        assertEquals(esperado, este);

        esperado = new CeldaBorde(null, Direccion.NORTE,Direccion.SUR,Direccion.ESTE);
        assertEquals(esperado, oeste);
    }
}