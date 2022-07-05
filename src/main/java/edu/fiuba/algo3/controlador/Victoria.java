package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.io.File;

public class Victoria implements EventHandler<ActionEvent> {

    private final Stage stage;

    public Victoria(Stage stage){
        this.stage = stage;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //No se si se necesitará un ActionHandler igual.

        //Mostrar pantalla ganador.

        String pathJugador = "saves/jugador.txt";
        String pathMapa = "saves/jugadorMapa.txt";

        File file = new File("saves/jugador.txt");
        file.delete();
        file = new File("saves/mapa.txt");
        file.delete();
    }
}
