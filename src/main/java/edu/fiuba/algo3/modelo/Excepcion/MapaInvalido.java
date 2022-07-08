package edu.fiuba.algo3.modelo.Excepcion;

public class MapaInvalido extends RuntimeException {
    public MapaInvalido(String message) {
        super(message + ": El mapa no puede ser creado.");
    }
}
