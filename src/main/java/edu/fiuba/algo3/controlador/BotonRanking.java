package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class BotonRanking {
    private Button botonRanking;

    public void iniciar(){


        this.botonRanking = new Button();
        this.botonRanking.setText("Ranking");
        this.botonRanking.setCursor(Cursor.HAND);
        /*this.botonRanking.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Acá se debe vincular con el codigo del modelo
            }
        });*/
    }
    public Button obtenerBoton(){
        return this.botonRanking;
    }
}
