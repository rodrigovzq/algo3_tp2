package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Parser.Parser;
import edu.fiuba.algo3.modelo.Parser.ParserRanking;
import edu.fiuba.algo3.modelo.Ranking.Puntaje;
import edu.fiuba.algo3.modelo.Ranking.Ranking;
import edu.fiuba.algo3.vista.PantallasPrincipales.ContenedorRanking;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class mostrarRanking implements EventHandler<ActionEvent> {
    private final Stage stage;

    public mostrarRanking(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ParserRanking parser = new ParserRanking("saves/ranking.txt");
        parser.parsear();
        Ranking ranking = parser.getEntidadParseada();
        List<Puntaje> top10 = ranking.devolverListaDeLosPrimeros( 10 );
        List< Pair<String,String> > listado = new ArrayList();

        for(Puntaje puntaje : top10){
            String[] s = puntaje.imprimir().split(Puntaje.DELIMITADOR);
            listado.add( new Pair<>(s[0], s[1]));
        }

        new ContenedorRanking(this.stage, listado);
    }
}
