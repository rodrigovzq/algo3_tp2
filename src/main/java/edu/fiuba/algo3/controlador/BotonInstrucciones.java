package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class BotonInstrucciones {
    private Button botonInstrucciones;

    public void iniciar(){

        this.botonInstrucciones = new Button();
        this.botonInstrucciones.setText("Instrucciones");
        this.botonInstrucciones.setCursor(Cursor.HAND);
        /*this.botonInstrucciones.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });*/
    }
    public Button obtenerBoton(){
        return this.botonInstrucciones;
    }
}
