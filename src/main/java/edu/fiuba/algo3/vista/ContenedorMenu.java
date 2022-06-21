package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorMenu {
    private Stage stage;
    public ContenedorMenu(Stage stage) {
        this.stage=stage;
        this.iniciar();
    }
    private void iniciar(){
        Button botonJugar = new Button("Jugar");
        botonJugar.setOnAction( e -> new ContenedorConfiguracion( this.stage )  );

        Button botonRanking = new Button("Ranking");
        Button botonInstruciones = new Button("Instrucciones");
        Button botonSalir = new Button("Salir");
        Button botonHelpPls = new Button("help pls");

        VBox root = new VBox();
        root.getChildren().addAll(botonJugar,botonRanking,botonInstruciones,botonSalir,botonHelpPls);
        root.setAlignment(Pos.BASELINE_CENTER);
        Scene menu = new Scene(root, 640,480);
        VBox.setMargin(botonJugar,new Insets(80,10,10,10));
        VBox.setMargin(botonRanking,new Insets(15,10,10,10));
        VBox.setMargin(botonInstruciones,new Insets(15,10,10,10));
        VBox.setMargin(botonSalir,new Insets(15,10,10,10));
        VBox.setMargin(botonHelpPls,new Insets(150,0,0,500));

        this.stage.setScene(menu);
        this.stage.show();
    }

}
