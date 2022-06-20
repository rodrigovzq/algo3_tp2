package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class BotonSalir {

    private Button botonSalir;

    public void iniciar(){

        this.botonSalir = new Button();
        this.botonSalir.setText("Salir");
        this.botonSalir.setCursor(Cursor.HAND);
        /*this.botonSalir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Acá se debe vincular con el codigo del modelo
            }
        });*/
    }
    public Button obtenerBoton(){
        return this.botonSalir;
    }
}
