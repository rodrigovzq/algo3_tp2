package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Impresora.Impresora;
import edu.fiuba.algo3.modelo.Impresora.ImpresoraFile;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Lector.Lector;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Ranking.Ranking;

import java.util.ArrayList;
import java.util.List;

public class Juego implements Observador {

    private Lector lector;
    private Impresora impresora;
    private final Jugador jugador;
    private final Ranking ranking;

    public Juego( Jugador jugador, Ranking ranking) {
        this.jugador = jugador;
        this.ranking = ranking;
        this.impresora = new ImpresoraFile("saves/ranking.txt");
    }

    private List<String> lecturaPuntaje() {
        String puntaje;
        List<String> lista = new ArrayList<String>();
        do {
            puntaje = this.lector.leerLinea();
            lista.add(puntaje);
        }while( puntaje != "" );

        return lista;
    }

    //Al llegar a la meta, se le notifica que debe agregar al jugador.
    @Override
    public void actualizar() {
        this.ranking.agregar(jugador);
        this.guardarRanking();
    }

    private void guardarRanking() {
        this.impresora = new ImpresoraFile("saves/ranking.txt");
        this.impresora.imprimir( ranking );
    }

    public void guardarMapa(){
        this.impresora = new ImpresoraFile("saves/mapa.txt");
    }
    public void guardarJugador(){
        this.impresora = new ImpresoraFile("saves/jugador.txt");
        this.impresora.imprimir( jugador );
    }
    //TODO: ¿O es más correcto que el juego tenga una instancia del Mapa?
    public void guardarMapa( Mapa mapa ){
        this.impresora = new ImpresoraFile("saves/jugador.txt");
        this.impresora.imprimir( mapa );
    }

    //TODO: Guardar meta!!
}
