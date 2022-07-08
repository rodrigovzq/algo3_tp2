package edu.fiuba.algo3.modelo.Parser;

import edu.fiuba.algo3.modelo.Excepcion.ArchivoMalformado;
import edu.fiuba.algo3.modelo.Impresora.Imprimible;

public interface Parser {
    void parsear() throws ArchivoMalformado;
    Imprimible getEntidadParseada() throws ArchivoMalformado;
}
