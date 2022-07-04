package edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorEstadosAleatorio;

import edu.fiuba.algo3.modelo.EstadoCelda.EstadoCelda;
import edu.fiuba.algo3.modelo.Excepcion.ProbabilidadInvalida;
import edu.fiuba.algo3.modelo.Obstaculo.Obstaculo;

import java.util.Random;

public class GeneradorObstaculo implements GeneradorEstadosAleatorio {
    private final int NUM_OBSTACULOS = Obstaculo.values().length;
    Random rng;
    public GeneradorObstaculo() {
        this.rng = new Random();
    }
    @Override
    public boolean aplicar(Float probabilidad) throws ProbabilidadInvalida {
        if( probabilidad > 0)
            return this.sortearNumero() <= probabilidad;
        else
            throw new ProbabilidadInvalida();
    }
    @Override
    public EstadoCelda sortearEstadoCelda(){
        Integer indice = (int) (this.sortearNumero() * NUM_OBSTACULOS);
        Obstaculo obstaculo = Obstaculo.values()[indice];
        return obstaculo.crear();
    }

    @Override
    public Float sortearNumero() {
        return this.rng.nextFloat();
    }
}
