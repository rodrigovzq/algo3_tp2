package edu.fiuba.algo3.modelo.Excepcion;

import java.io.IOException;

public class ArchivoMalformado extends IOException {
    public ArchivoMalformado(String causa) {
        super(causa + ": Provoca que el archivo esté corrupto y no puede leerse correctamente.");
    }
}
