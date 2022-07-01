package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Observador;

import java.util.ArrayList;
import java.util.Comparator;

public class Juego implements Observador {

    private Jugador jugador;
    private Ranking ranking;

    public Juego(Jugador jugador) {
        this.jugador = jugador;
        //TODO: Levantar de files rankings anteriores.
        this.ranking = new Ranking();
    }

    @Override
    public void actualizar() {
        this.ranking.agregar(jugador);
        //TODO: Cerrar partida.
        //Escribir archivo.
    }
}
