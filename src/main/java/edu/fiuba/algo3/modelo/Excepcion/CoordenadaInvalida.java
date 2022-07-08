package edu.fiuba.algo3.modelo.Excepcion;

public class CoordenadaInvalida extends RuntimeException {
    public CoordenadaInvalida(String message) {
        super(message + ": La coordenada no puede tener valores negativos.");
    }
}
