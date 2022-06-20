package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class BotonHelpPls {

    private Button botonHelpPls;

    public void iniciar(){


        this.botonHelpPls = new Button();
        this.botonHelpPls.setText("HelpPls");
        this.botonHelpPls.setCursor(Cursor.HAND);
        this.botonHelpPls.setFont(new Font(10));
        /*this.botonHelpPls.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Acá se debe vincular con el codigo del modelo
            }
        });*/
    }

    public Button obtenerBoton(){
        return this.botonHelpPls;
    }
}
