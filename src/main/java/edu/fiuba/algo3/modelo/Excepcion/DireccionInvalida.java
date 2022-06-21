package edu.fiuba.algo3.modelo.Excepcion;

public class DireccionInvalida extends RuntimeException{
    public DireccionInvalida(String message) {
        super(message + "La dirección ingresada no es válida");
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
