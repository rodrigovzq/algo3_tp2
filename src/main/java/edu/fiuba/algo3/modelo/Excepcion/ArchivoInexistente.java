package edu.fiuba.algo3.modelo.Excepcion;

import java.io.IOException;

public class ArchivoInexistente extends IOException {
    public ArchivoInexistente(String message) {
        super(message + ": El archivo no existe.");
    }
}
