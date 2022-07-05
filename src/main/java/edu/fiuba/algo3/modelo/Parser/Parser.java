package edu.fiuba.algo3.modelo.Parser;

import edu.fiuba.algo3.modelo.Impresora.Imprimible;

public interface Parser {
    void parsear();
    Imprimible getEntidadParseada();
}