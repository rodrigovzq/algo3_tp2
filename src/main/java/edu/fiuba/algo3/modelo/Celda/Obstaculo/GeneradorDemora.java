package edu.fiuba.algo3.modelo.Celda.Obstaculo;

import edu.fiuba.algo3.modelo.Excepcion.ProbabilidadInvalida;

import java.util.Random;

public class GeneradorDemora implements GeneradorAleatorio {

    Random rng;
    GeneradorDemora() {
        this.rng = new Random();
    }
    @Override
    public boolean aplicar(Float probabilidad) {
        if( probabilidad > 0)
            return this.rng.nextDouble() <= probabilidad;
        else
            throw new ProbabilidadInvalida();
    }
}
