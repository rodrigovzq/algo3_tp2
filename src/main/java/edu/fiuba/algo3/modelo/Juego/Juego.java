package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Excepcion.ArchivoInexistente;
import edu.fiuba.algo3.modelo.Excepcion.JuegoInvalido;
import edu.fiuba.algo3.modelo.Impresora.Impresora;
import edu.fiuba.algo3.modelo.Impresora.ImpresoraFile;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Ranking.Ranking;

import java.io.File;

//TODO: Inutil
public class Juego {
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
        try {
            this.impresora = new ImpresoraFile(PATH_JUGADOR_TXT);
            this.impresora = new ImpresoraFile(PATH_RANKING_TXT);
            this.impresora = new ImpresoraFile(PATH_MAPA_TXT);
        }catch (ArchivoInexistente e){
            throw new JuegoInvalido("Los archivos de persistencia no existen.");
        }
        this.jugador.setPosicion( this.mapa.getCeldaJugador() );
    }



    public Jugador getJugador() {
        return jugador;
    }

    public Mapa getMapa() {
        return mapa;
    }

    //Al llegar a la meta, se le notifica que debe agregar al jugador.

    public void actualizarRanking() {
        this.ranking.agregar(jugador);
        this.guardarRanking();
    }

    private void guardarRanking() {
        try {
            this.impresora = new ImpresoraFile(PATH_RANKING_TXT);
            this.impresora.imprimir( ranking );
        }catch (ArchivoInexistente e){
            System.out.println(e.getMessage());
        }
    }

    private void guardarMapa(){
        try {
            this.impresora = new ImpresoraFile(PATH_MAPA_TXT);
            this.impresora.imprimir( mapa );
        }catch (ArchivoInexistente e){
            System.out.println(e.getMessage());
        }
    }
    public void guardarJugador(){
        try{
            this.impresora = new ImpresoraFile(PATH_JUGADOR_TXT);
            this.impresora.imprimir( jugador );
        }catch (ArchivoInexistente e){
            System.out.println(e.getMessage());
        }
    }

    public void guardarPartida(){
        guardarJugador();
        guardarMapa();
        guardarRanking();
    }

    public boolean elJugadorLlegoAMeta() {
        this.mapa.setPosicionJugador( this.jugador.getPosicion() );
        return mapa.elJugadorLlegoAMeta();
    }

    public void borrarPartida() {
        new File(PATH_JUGADOR_TXT).delete();
        new File(PATH_MAPA_TXT).delete();
    }
}
