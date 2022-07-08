package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Excepcion.ArchivoMalformado;
import edu.fiuba.algo3.modelo.Excepcion.JuegoInvalido;
import edu.fiuba.algo3.modelo.Impresora.ImpresoraFile;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Parser.ParserJugador;
import edu.fiuba.algo3.modelo.Parser.ParserMapa;
import edu.fiuba.algo3.modelo.Parser.ParserRanking;
import edu.fiuba.algo3.modelo.Ranking.Ranking;
import edu.fiuba.algo3.vista.PantallasPrincipales.ContenedorConfiguracion;
import edu.fiuba.algo3.vista.PantallasPrincipales.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.io.IOException;

public class IniciarJuegoControlador implements EventHandler<ActionEvent> {

    private final Stage stage;
    private final boolean config;
    private Mapa mapa;
    Jugador jugador;

    //Mapa mapa;

    //Responsable de crear al jugador y cambiar la escena en la ventana.
    public IniciarJuegoControlador(Stage stage, Jugador jugador, Mapa mapa) {
        this.stage = stage;
        this.jugador = jugador;
        this.mapa = mapa;
        this.config = true;
    }

    public IniciarJuegoControlador(Stage stage) {
        this.stage = stage;
        this.config = false;
    }

    private void cargarConfiguracion() {
        System.out.println("Generando mapa...");
        this.mapa = new Mapa( mapa );
    }

    private void cargarPartidaRenaudada() throws JuegoInvalido {
        String path = null;
        try {
            path = Juego.PATH_MAPA_TXT;
            ParserMapa parserM = new ParserMapa(path);
            parserM.parsear();
            System.out.println("Generando mapa...");
            this.mapa = parserM.getEntidadParseada();

            path = Juego.PATH_JUGADOR_TXT;
            ParserJugador parserJ = new ParserJugador(path);
            parserJ.parsear();
            this.jugador = parserJ.getEntidadParseada();

        }catch( IOException e){
            throw new JuegoInvalido(path + ": "+ e.getMessage());
        }

        new ContenedorConfiguracion(this.stage);
    }

    @Override
    public void handle(ActionEvent event) {
        Ranking ranking = null;
        try {
            ParserRanking parserR = new ParserRanking(Juego.PATH_RANKING_TXT);
            parserR.parsear();
            ranking = parserR.getEntidadParseada();
        }catch( IOException e){
            System.out.println( e.getMessage());
            ranking = new Ranking();
        }

        try {
            if (config) {
                cargarConfiguracion();
            } else {
                cargarPartidaRenaudada();
            }

            Juego juego = new Juego(this.jugador, this.mapa, ranking);

            System.out.println("Guardando partida...");
            juego.guardarPartida();

            new ContenedorJuego(this.stage, juego);
        }catch(JuegoInvalido e){
            System.out.println(e.getMessage());
            new ContenedorConfiguracion(this.stage);
        }
    }


}
