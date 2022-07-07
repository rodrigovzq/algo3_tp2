package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Impresora.Impresora;
import edu.fiuba.algo3.modelo.Impresora.ImpresoraFile;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Lector.Lector;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Ranking.Ranking;

import java.util.ArrayList;
import java.util.List;
//TODO: Inutil
public class Juego implements Observador {
    public static final String PATH_MAPA_TXT = "saves/mapa.txt";
    public static final String PATH_JUGADOR_TXT = "saves/jugador.txt";
    public static final String PATH_RANKING_TXT = "saves/ranking.txt";
    private Impresora impresora;
    private final Jugador jugador;
    private final Ranking ranking;
    private final Mapa mapa;

    public Juego( Jugador jugador, Mapa mapa, Ranking ranking) {
        this.jugador = jugador;
        this.ranking = ranking;
        this.mapa = mapa;

        this.jugador.setPosicion( this.mapa.getCeldaJugador() );
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Mapa getMapa() {
        return mapa;
    }

    //Al llegar a la meta, se le notifica que debe agregar al jugador.
    @Override
    public void actualizar() {
        this.ranking.agregar(jugador);
        this.guardarRanking();
    }

    private void guardarRanking() {
        this.impresora = new ImpresoraFile(PATH_RANKING_TXT);
        this.impresora.imprimir( ranking );
    }

    private void guardarMapa(){
        this.impresora = new ImpresoraFile(PATH_MAPA_TXT);
        this.impresora.imprimir( mapa );
    }
    public void guardarJugador(){
        this.impresora = new ImpresoraFile(PATH_JUGADOR_TXT);
        this.impresora.imprimir( jugador );
    }

    public void guardarPartida(){
        guardarJugador();
        guardarMapa();
        guardarRanking();
    }
    //TODO: Guardar meta!!
}
