package edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorEstadosAleatorio;

import edu.fiuba.algo3.modelo.EstadoCelda.IEstadoCelda;
import edu.fiuba.algo3.modelo.Excepcion.ProbabilidadInvalida;
import edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorAleatorio;
import edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorDemora;
import edu.fiuba.algo3.modelo.Obstaculo.IObstaculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneradorObstaculoTest {
    @Test
    public void cuandoLaProbabilidadEsMayorAUnoElGeneradorSeVuelveDeterministico(){
        GeneradorAleatorio gen = new GeneradorObstaculo();
        boolean resultado = gen.aplicar(1.2f);
        assertTrue(resultado);
    }

    @Test
    public void noEsPosibleTenerProbabilidadesNegativas(){
        GeneradorAleatorio gen = new GeneradorObstaculo();
        assertThrows(ProbabilidadInvalida.class , () -> gen.aplicar(-1.2f));
    }

}