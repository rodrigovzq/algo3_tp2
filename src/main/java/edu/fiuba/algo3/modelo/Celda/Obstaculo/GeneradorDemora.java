package edu.fiuba.algo3.modelo.Celda.Obstaculo;

import java.util.Random;

public class GeneradorDemora implements GeneradorAleatorio {

    Random rng;
    GeneradorDemora() {
        this.rng = new Random();
    }
    @Override
    public boolean aplicar(Float probabilidad) {
        // TODO: Debe tirar una excepcion si la probabilildad es negativa
        return this.rng.nextDouble() <= probabilidad;
    }
}
