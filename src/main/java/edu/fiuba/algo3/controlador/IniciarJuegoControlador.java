package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Impresora.ImpresoraFile;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Parser.ParserJugador;
import edu.fiuba.algo3.modelo.Parser.ParserMapa;
import edu.fiuba.algo3.modelo.Parser.ParserRanking;
import edu.fiuba.algo3.modelo.Ranking.Ranking;
import edu.fiuba.algo3.vista.PantallasPrincipales.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class IniciarJuegoControlador implements EventHandler<ActionEvent> {
    private final Stage stage;
    private Mapa mapa;
    Jugador jugador;

    //Mapa mapa;

    //Responsable de crear al jugador y cambiar la escena en la ventana.
    public IniciarJuegoControlador(Stage stage, Jugador jugador, Mapa mapa) {
        this.stage = stage;
        this.jugador = jugador;
        this.mapa = mapa;

        cargarConfiguracion();
    }

    public IniciarJuegoControlador(Stage stage) {
        this.stage = stage;
        cargarPartidaRenaudada();
    }

    private void cargarConfiguracion() {
        System.out.println("Generando mapa...");
        mapa.generarMapa();
        mapa.setEstadosMapa();
    }

    private void cargarPartidaRenaudada() {
        ParserMapa parserM = new ParserMapa("saves/mapa.txt");
        parserM.parsear();
        System.out.println("Generando mapa...");
        this.mapa = parserM.getEntidadParseada();

        ParserJugador parserJ = new ParserJugador("saves/jugador.txt");
        parserJ.parsear();
        this.jugador = parserJ.getEntidadParseada();
    }

    @Override
    public void handle(ActionEvent event) {
        ParserRanking parserJ = new ParserRanking("saves/jugador.txt");
        parserJ.parsear();
        Ranking ranking = parserJ.getEntidadParseada();

        Juego juego = new Juego(this.jugador, this.mapa, ranking);

        System.out.println("Guardando partida...");
        juego.guardarPartida();

        new ContenedorJuego(this.stage, juego);
    }


}
