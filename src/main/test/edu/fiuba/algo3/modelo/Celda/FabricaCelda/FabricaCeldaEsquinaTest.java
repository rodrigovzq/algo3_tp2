package edu.fiuba.algo3.modelo.Celda.FabricaCelda;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.CeldaEsquina;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FabricaCeldaEsquinaTest {
    @Test
    public void creoUnaCeldaBordePasandoLaDireccionBloqueada(){
        FabricaCeldaEsquina fabrica = new FabricaCeldaEsquina();
        // TODO: ¿Debo pasarle el estado? El null no es correcto ya que no es un estado valido.
        Celda norteste = fabrica.crearCelda(Direccion.NORESTE);
        Celda sureste = fabrica.crearCelda(Direccion.SUDESTE);
        Celda noroeste = fabrica.crearCelda(Direccion.NOROESTE);
        Celda sudoeste = fabrica.crearCelda(Direccion.SUDOESTE);

        Celda esperado = new CeldaEsquina(null, Direccion.NORTE,Direccion.ESTE);
        assertEquals(esperado, norteste);

        esperado = new CeldaEsquina(null, Direccion.SUR,Direccion.ESTE);
        assertEquals(esperado, sureste);

        esperado = new CeldaEsquina(null, Direccion.NORTE,Direccion.OESTE);
        assertEquals(esperado, noroeste);

        esperado = new CeldaEsquina(null, Direccion.SUR,Direccion.OESTE);
        assertEquals(esperado, sudoeste);
    }
}