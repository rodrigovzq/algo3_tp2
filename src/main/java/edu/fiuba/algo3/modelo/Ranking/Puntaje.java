package edu.fiuba.algo3.modelo.Ranking;

import edu.fiuba.algo3.modelo.Impresora.Imprimible;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

import java.util.Objects;

//TODO: Test
public class Puntaje implements Imprimible {
    private static final String DELIMITADOR = ",";
    private final String nombre;
    private final Integer puntaje;

    public Puntaje(String nombre, Integer puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
    }

    public Puntaje(Jugador jugador) {
        String resultado = jugador.imprimir();
        //TODO: Validar que no este vacio ni nada.
        String[] datos = resultado.split(Jugador.DELIMITADOR);
        this.nombre = datos[0];
        this.puntaje = Integer.parseInt(datos[3]);
    }

    @Override
    public String imprimir(){
        return nombre + DELIMITADOR + puntaje;
    }

    public int compareTo(Puntaje p2){
        return this.puntaje - p2.puntaje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Puntaje puntaje1 = (Puntaje) o;
        return Objects.equals(nombre, puntaje1.nombre) && Objects.equals(puntaje, puntaje1.puntaje);
    }

}
