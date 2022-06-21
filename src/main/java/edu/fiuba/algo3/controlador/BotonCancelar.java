package edu.fiuba.algo3.controlador;

import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class BotonCancelar {
    Button cancelar = new Button();

    public void iniciar() {

        this.cancelar.setText("Cancelar");
        this.cancelar.setCursor(Cursor.HAND);
    }
    public Button obtenerBoton(){
        return this.cancelar;
    }
}
