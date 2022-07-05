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

    private Lector lector;
    private Impresora impresora;
    private final Jugador jugador;
    private final Ranking ranking;
    private final Mapa mapa;

    public Juego( Jugador jugador, Mapa mapa, Ranking ranking) {
        this.jugador = jugador;
        this.ranking = ranking;
        this.jugador.setPosicion( mapa.getCeldaJugador() );
        this.mapa = mapa;
        Celda meta = mapa.getMeta();
        //Agregar observador al Juego
        //meta.agregarObservador( this )
    }

    //Al llegar a la meta, se le notifica que debe agregar al jugador.
    @Override
    public void actualizar() {
        this.ranking.agregar(jugador);
        this.guardarRanking();
    }

    private void guardarRanking() {
        this.impresora = new ImpresoraFile("saves/ranking.txt.txt");
        this.impresora.imprimir( ranking );
    }

    public void guardarMapa(){
        this.impresora = new ImpresoraFile("saves/mapa.txt");
        this.impresora.imprimir( mapa );
    }
    public void guardarJugador(){
        this.impresora = new ImpresoraFile("saves/jugador.txt");
        this.impresora.imprimir( jugador );
    }

    public void guardarPartida(){
        guardarJugador();
        guardarMapa();
        guardarRanking();
    }
    //TODO: Guardar meta!!
}
