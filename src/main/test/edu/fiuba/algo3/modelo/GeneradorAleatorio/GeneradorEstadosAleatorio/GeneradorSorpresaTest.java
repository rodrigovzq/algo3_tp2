package edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorEstadosAleatorio;

import edu.fiuba.algo3.modelo.Excepcion.ProbabilidadInvalida;
import edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorAleatorio;
import edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorDemora;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneradorSorpresaTest {
    @Test
    public void cuandoLaProbabilidadEsMayorAUnoElGeneradorSeVuelveDeterministico(){
        GeneradorAleatorio gen = new GeneradorSorpresa();
        boolean resultado = gen.aplicar(1.2f);
        assertTrue(resultado);
    }

    @Test
    public void noEsPosibleTenerProbabilidadesNegativas(){
        GeneradorAleatorio gen = new GeneradorSorpresa();
        assertThrows(ProbabilidadInvalida.class , () -> gen.aplicar(-1.2f));
    }
}