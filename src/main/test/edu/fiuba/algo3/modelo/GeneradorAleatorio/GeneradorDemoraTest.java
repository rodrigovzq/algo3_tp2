package edu.fiuba.algo3.modelo.GeneradorAleatorio;

import edu.fiuba.algo3.modelo.Excepcion.ProbabilidadInvalida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneradorDemoraTest {
    @Test
    public void cuandoLaProbabilidadEsMayorAUnoElGeneradorSeVuelveDeterministico(){
        GeneradorAleatorio gen = new GeneradorDemora();
        boolean resultado = gen.aplicar(1.2f);
        assertTrue(resultado);
    }

    @Test
    public void noEsPosibleTenerProbabilidadesNegativas(){
        GeneradorAleatorio gen = new GeneradorDemora();
        assertThrows(ProbabilidadInvalida.class , () -> gen.aplicar(-1.2f));
    }
}