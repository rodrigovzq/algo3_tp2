package edu.fiuba.algo3.modelo.Excepcion;

public class EstadoCeldaInvalido extends RuntimeException {
    public EstadoCeldaInvalido(String message) {
        super(message + ": No existe el EstadoCelda ingresado.");
    }
}
