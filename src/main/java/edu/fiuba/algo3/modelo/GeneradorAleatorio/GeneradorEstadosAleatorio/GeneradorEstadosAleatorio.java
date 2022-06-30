package edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorEstadosAleatorio;

import edu.fiuba.algo3.modelo.Celda.EstadoCelda;
import edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorAleatorio;

public interface GeneradorEstadosAleatorio extends GeneradorAleatorio {
    EstadoCelda sortearEstadoCelda();
}
