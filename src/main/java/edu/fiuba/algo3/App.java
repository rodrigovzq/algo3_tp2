package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.PantallasPrincipales.ContenedorMenu;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Juego GPS Challenge");
        ContenedorMenu menu = new ContenedorMenu(stage);
    }

    public static void main(String[] args) {
        launch();
    }



}