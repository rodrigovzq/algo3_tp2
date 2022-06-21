package edu.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorRanking {
    private Stage stage;
    public ContenedorRanking(Stage stage) {
        this.stage = stage;
        this.iniciar();
    }

    private void iniciar(){
        // Implementar contenido de la ventana del ranking
        Button botonVolverMenu = new Button( "Volver al menu.");
        botonVolverMenu.setOnAction( e -> new ContenedorMenu(this.stage) );

        VBox layout = new VBox();

        layout.getChildren().addAll(botonVolverMenu);
        layout.setAlignment(Pos.CENTER);

        // Va a tener la lista de ranking. como diferenciamos por tamaño del mapa??
        Scene contenido = new Scene( layout );
        this.stage.setScene( contenido );
    }
}
