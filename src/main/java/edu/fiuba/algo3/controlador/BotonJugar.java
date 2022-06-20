package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class BotonJugar {

    private Button botonJugar;

    public void iniciar(){


        this.botonJugar = new Button();
        this.botonJugar.setText("Jugar");
        this.botonJugar.setCursor(Cursor.HAND);
       /* this.botonJugar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Acá se debe vincular con el codigo del modelo
            }
        });*/
    }
    public Button obtenerBoton(){
        return this.botonJugar;
    }
}
