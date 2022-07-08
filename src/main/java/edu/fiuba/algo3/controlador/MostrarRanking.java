package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Parser.ParserRanking;
import edu.fiuba.algo3.modelo.Ranking.Puntaje;
import edu.fiuba.algo3.modelo.Ranking.Ranking;
import edu.fiuba.algo3.vista.PantallasPrincipales.ContenedorRanking;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MostrarRanking implements EventHandler<ActionEvent> {
    private final Stage stage;

    public MostrarRanking(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Ranking ranking = null;
        try {
            ParserRanking parser = new ParserRanking(Juego.PATH_RANKING_TXT);
            parser.parsear();
            ranking = parser.getEntidadParseada();
        }catch( IOException e){
            System.out.println( e.getMessage() );
            ranking = new Ranking();
        }

        List<Puntaje> top10 = ranking.devolverListaDeLosPrimeros( 10 );
        List< Pair<String,String> > listado = new ArrayList();

        for(Puntaje puntaje : top10){
            String[] s = puntaje.imprimir().split(Puntaje.DELIMITADOR);
            listado.add( new Pair<>(s[0], s[1]));
        }

        new ContenedorRanking(this.stage, listado);
    }
}
