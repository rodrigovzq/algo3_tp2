package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.ContenedorMenu;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    /*Me faltó agrupar a los codigos en sus respectivas clases*/
    @Override
    public void start(Stage stage) {
        stage.setTitle("Juego GPS Challenge");
        ContenedorMenu menu = new ContenedorMenu(stage);
        menu.mostrar();



    }



    public static void main(String[] args) {
        launch();
    }



}