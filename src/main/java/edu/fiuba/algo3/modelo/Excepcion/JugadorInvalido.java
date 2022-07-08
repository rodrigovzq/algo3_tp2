package edu.fiuba.algo3.modelo.Excepcion;

public class JugadorInvalido extends RuntimeException {
    public JugadorInvalido(String message) {
        super(message + ": No puede crearse el jugador");
    }
}
