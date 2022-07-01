package edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorEstadosAleatorio;

import edu.fiuba.algo3.modelo.Celda.EstadoCelda;
import edu.fiuba.algo3.modelo.Excepcion.ObstaculoInvalido;
import edu.fiuba.algo3.modelo.Excepcion.ProbabilidadInvalida;
import edu.fiuba.algo3.modelo.Excepcion.SorpresaInvalida;
import edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorAleatorio;
import edu.fiuba.algo3.modelo.Obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.Obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.Obstaculo.Piquete;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Sorpresa.CambioVehiculo;
import edu.fiuba.algo3.modelo.Sorpresa.Desfavorable;
import edu.fiuba.algo3.modelo.Sorpresa.Favorable;
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
            throw new ProbabilidadInvalida();
    }

    @Override
    public EstadoCelda sortearEstadoCelda(){
        Integer indice = (int) (sortearNumero() * NUM_SORPRESA);
        Sorpresa sorpresa = Sorpresa.values()[indice];

        if( sorpresa == Sorpresa.FAVORABLE )
            return new Favorable();
        else if( sorpresa == Sorpresa.DESFAVORABLE )
            return new Desfavorable();
        else if( sorpresa == Sorpresa.CAMBIO_VEHICULO )
            return new CambioVehiculo();
        else
            throw new SorpresaInvalida();
    }

    @Override
    public Float sortearNumero() {
        return this.rng.nextFloat();
    }
}
