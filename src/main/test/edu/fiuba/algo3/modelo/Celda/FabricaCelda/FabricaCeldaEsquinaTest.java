package edu.fiuba.algo3.modelo.Celda.FabricaCelda;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.CeldaBorde;
import edu.fiuba.algo3.modelo.Celda.CeldaEsquina;
import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FabricaCeldaEsquinaTest {
    @Test
    public void creoUnaCeldaEsquinaPasandoLaDireccionBloqueada(){
        FabricaCeldaEsquina fabrica = new FabricaCeldaEsquina();
        Coordenada coordenada = new Coordenada(0,0);

        // TODO: ¿Debo pasarle el estado? El null no es correcto ya que no es un estado valido.
        Celda norteste = fabrica.crearCelda(Direccion.NORESTE, coordenada);
        Celda sureste = fabrica.crearCelda(Direccion.SUDESTE, coordenada);
        Celda noroeste = fabrica.crearCelda(Direccion.NOROESTE, coordenada);
        Celda sudoeste = fabrica.crearCelda(Direccion.SUDOESTE, coordenada);

        Celda esperado = new CeldaEsquina(null, coordenada, Direccion.SUR,Direccion.OESTE);
        assertEquals(esperado, norteste);

        esperado = new CeldaEsquina(null, coordenada, Direccion.NORTE,Direccion.OESTE);
        assertEquals(esperado, sureste);

        esperado = new CeldaEsquina(null, coordenada, Direccion.SUR,Direccion.ESTE);
        assertEquals(esperado, noroeste);

        esperado = new CeldaEsquina(null, coordenada, Direccion.NORTE,Direccion.ESTE);
        assertEquals(esperado, sudoeste);
    }
}