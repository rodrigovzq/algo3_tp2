package edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorEstadosAleatorio;

import edu.fiuba.algo3.modelo.EstadoCelda.IEstadoCelda;
import edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorAleatorio;

public interface GeneradorEstadosAleatorio extends GeneradorAleatorio {
    IEstadoCelda sortearEstadoCelda();
}
