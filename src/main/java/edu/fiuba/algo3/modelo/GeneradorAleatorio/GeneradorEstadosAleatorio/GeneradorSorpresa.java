package edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorEstadosAleatorio;

import edu.fiuba.algo3.modelo.EstadoCelda.IEstadoCelda;
import edu.fiuba.algo3.modelo.Excepcion.ProbabilidadInvalida;
import edu.fiuba.algo3.modelo.Sorpresa.Sorpresa;

import java.util.Random;

public class GeneradorSorpresa implements GeneradorEstadosAleatorio {
    private final int NUM_SORPRESA = Sorpresa.values().length;
    Random rng;
    public GeneradorSorpresa() {
        this.rng = new Random();
    }
    @Override
    public boolean aplicar(Float probabilidad) throws ProbabilidadInvalida {
        if( probabilidad > 0 )
            return this.sortearNumero() <= probabilidad;
        else
            throw new ProbabilidadInvalida("La probabilidad no puede ser negativa");
    }

    @Override
    public IEstadoCelda sortearEstadoCelda(){
        Integer indice = (int) (sortearNumero() * NUM_SORPRESA);
        Sorpresa sorpresa = Sorpresa.values()[indice];
        return sorpresa.crear();
    }

    @Override
    public Float sortearNumero() {
        return this.rng.nextFloat();
    }
}
