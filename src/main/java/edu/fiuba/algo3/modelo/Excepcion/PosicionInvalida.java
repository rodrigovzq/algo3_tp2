package edu.fiuba.algo3.modelo.Excepcion;

public class PosicionInvalida extends RuntimeException {
    public PosicionInvalida(String message) {
        super(message);
    }
}
