package edu.fiuba.algo3.modelo.GeneradorAleatorio;

import edu.fiuba.algo3.modelo.Excepcion.ProbabilidadInvalida;

import java.util.Random;

public class GeneradorDemora implements GeneradorAleatorio {

    Random rng;
    public GeneradorDemora() {
        this.rng = new Random();
    }
    @Override
    public boolean aplicar(Float probabilidad) throws ProbabilidadInvalida{
        if( probabilidad > 0)
            return this.sortearNumero() <= probabilidad;
        else
            throw new ProbabilidadInvalida("La probabilidad no puede ser negativa");
    }

    @Override
    public Float sortearNumero() {
        return this.rng.nextFloat();
    }
}
