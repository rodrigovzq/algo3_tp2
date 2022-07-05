package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CeldaBloqueadoraTest {
    @Test
    public void siQuieroObtenerUnaCeldaAdyacenteSeRetornaAEllaMisma(){
        CeldaBloqueadora celda = new CeldaBloqueadora();
        assertEquals( celda, celda.getCelda(Direccion.NORTE));
        assertEquals( celda, celda.getCelda(Direccion.SUR));
        assertEquals( celda, celda.getCelda(Direccion.ESTE));
        assertEquals( celda, celda.getCelda(Direccion.OESTE));
    }

    @Test
    public void siQuieroSetearUnaCeldaAdyacenteNoCambiaElObtenerLaCelda(){
        CeldaBloqueadora celda = new CeldaBloqueadora();

        celda.setCelda( new CeldaBloqueadora(), Direccion.NORTE);
        assertEquals( celda, celda.getCelda(Direccion.NORTE));

        celda.setCelda( new CeldaBloqueadora(), Direccion.SUR);
        assertEquals( celda, celda.getCelda(Direccion.SUR));

        celda.setCelda( new CeldaBloqueadora(), Direccion.ESTE);
        assertEquals( celda, celda.getCelda(Direccion.ESTE));

        celda.setCelda( new CeldaBloqueadora(), Direccion.OESTE);
        assertEquals( celda, celda.getCelda(Direccion.OESTE));
    }

}