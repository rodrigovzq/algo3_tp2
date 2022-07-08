package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Excepcion.ArchivoInexistente;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vista.GanadorVista;
import edu.fiuba.algo3.vista.Ventanas.VentanaPopUp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.io.File;

public class Victoria implements EventHandler<ActionEvent> {

    private final Juego juego;

    public Victoria(Stage stage, Juego juego){
        this.juego = juego;
        new GanadorVista(stage).mostrar();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        juego.borrarPartida();
        try {
            juego.actualizarRanking();
        }catch( ArchivoInexistente e){
            VentanaPopUp.mostrar("Error", "No pudo persistirse la puntuación.");
        }
    }
}
