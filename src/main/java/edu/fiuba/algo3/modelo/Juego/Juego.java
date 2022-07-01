package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Observador;

import java.util.ArrayList;
import java.util.Comparator;

public class Juego implements Observador {

    private Jugador jugador;
    private ArrayList<String> ranking;

    public Juego(Jugador jugador) {
        this.jugador = jugador;
        //TODO: Levantar de files rankings anteriores
        this.ranking = new ArrayList<String>();
    }

    @Override
    public void actualizar() {
        ranking.add( jugador.toString() );
        ranking.sort( (o1,o2) -> {
            Integer puntaje1 = Integer.parseInt(o1.split(",")[1]);
            Integer puntaje2 = Integer.parseInt(o2.split(",")[1]);
            return puntaje2.compareTo(puntaje1);
        });
    }
}
