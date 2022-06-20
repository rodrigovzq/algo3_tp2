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



        /* Este codigo debe estar en controlador/BotonJugar  */
        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        botonJugar.setCursor(Cursor.HAND);
        botonJugar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                /*Acá se debe vincular con el codigo del modelo*/
            }
        });






        /* Este codigo debe estar en controlador/BotonRanking  */
        Button botonRanking = new Button();
        botonRanking.setText("Ranking");
        botonRanking.setCursor(Cursor.HAND);
        botonRanking.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                /*Acá se debe vincular con el codigo del modelo*/
            }
        });




        /* Este codigo debe estar en controlador/BotonInstrucciones  */
        Button botonInstrucciones = new Button();
        botonInstrucciones.setText("Instrucciones");
        botonInstrucciones.setCursor(Cursor.HAND);
        botonInstrucciones.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                /*Acá se debe vincular con el codigo del modelo*/
            }
        });




        /* Este codigo debe estar en controlador/BotonSalir  */
        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        botonSalir.setCursor(Cursor.HAND);
        botonSalir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                /*Acá se debe vincular con el codigo del modelo*/
            }
        });




        /* Este codigo debe estar en controlador/BotonHelpPls  */
        Button botonHelpPls = new Button();
        botonHelpPls.setText("HelpPls");
        botonHelpPls.setCursor(Cursor.HAND);
        botonHelpPls.setFont(new Font(10));
        botonHelpPls.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                /*Acá se debe vincular con el codigo del modelo*/
            }
        });



        /* Este codigo debe estar en Vista/ContenedorMenu  */
        VBox root = new VBox();
        root.getChildren().addAll(botonJugar,botonRanking,botonInstrucciones,botonSalir,botonHelpPls);
        root.setAlignment(Pos.BASELINE_CENTER);
        Scene menu = new Scene(root, 640,480);
        VBox.setMargin(botonJugar,new Insets(80,10,10,10));
        VBox.setMargin(botonRanking,new Insets(15,10,10,10));
        VBox.setMargin(botonInstrucciones,new Insets(15,10,10,10));
        VBox.setMargin(botonSalir,new Insets(15,10,10,10));
        VBox.setMargin(botonHelpPls,new Insets(150,0,0,500));


        stage.setScene(menu);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }



}