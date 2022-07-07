package edu.fiuba.algo3.modelo.Excepcion;

public class DireccionInvalida extends RuntimeException{
    public DireccionInvalida(String message) {
        super(message + "La dirección ingresada no es válida");
    }
}
