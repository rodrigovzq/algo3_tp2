package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Excepcion.ArchivoInexistente;
import edu.fiuba.algo3.modelo.Excepcion.JuegoInvalido;
import edu.fiuba.algo3.modelo.Impresora.Impresora;
import edu.fiuba.algo3.modelo.Impresora.ImpresoraFile;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Ranking.Ranking;

import java.io.File;
import java.io.IOException;

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
        if( jugador != null && mapa != null  && ranking != null) {
            this.jugador = jugador;
            this.ranking = ranking;
            this.mapa = mapa;
        }else throw new JuegoInvalido("Inicialización del Jugador insegura.");
        crearArchivosDePersistencia();
        this.jugador.setPosicion( this.mapa.getCeldaJugador() );
    }


    private void crearArchivosDePersistencia() {
        File archivo = null;
        try{
            archivo = new File(PATH_JUGADOR_TXT);
            if (!archivo.exists()) archivo.createNewFile();
            archivo = new File(PATH_RANKING_TXT);
            if (!archivo.exists()) archivo.createNewFile();
            archivo = new File(PATH_MAPA_TXT);
            if (!archivo.exists()) archivo.createNewFile();
        }catch( IOException e){
            System.out.println("Error al crear el archivo" + archivo.getName());
        }
    }
    public Jugador getJugador() {
        return jugador;
    }

    public Mapa getMapa() {
        return mapa;
    }

    //Al llegar a la meta, se le notifica que debe agregar al jugador.

    public void actualizarRanking() throws ArchivoInexistente {
        this.ranking.agregar(jugador);
        this.guardarRanking();
    }

    private void guardarRanking() throws ArchivoInexistente {
         this.impresora = new ImpresoraFile(PATH_RANKING_TXT);
         this.impresora.imprimir( ranking );
    }

    private void guardarMapa() throws ArchivoInexistente {
        this.impresora = new ImpresoraFile(PATH_MAPA_TXT);
        this.impresora.imprimir( mapa );
    }
    public void guardarJugador() throws ArchivoInexistente {
        this.impresora = new ImpresoraFile(PATH_JUGADOR_TXT);
        this.impresora.imprimir( jugador );
    }

    public void guardarPartida() throws ArchivoInexistente {
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
