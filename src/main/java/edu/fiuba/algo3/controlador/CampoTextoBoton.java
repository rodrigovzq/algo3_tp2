package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class CampoTextoBoton implements EventHandler<ActionEvent> {

    private final TextField campoTexto;
    private final Label label;
    Jugador jugador;
    String msj_incorrecto;
    public CampoTextoBoton(TextField campoTexto, Jugador jugador, Label label) {
        this.campoTexto = campoTexto;
        this.jugador = jugador;
        this.msj_incorrecto = ": Inválido. Ingrese un nombre no vacío y con longitud menor a 25 caracteres.";
        this.label = label;
    }

    @Override
    public void handle(ActionEvent action) {
            if( campoTexto.getText().equals("") || campoTexto.getText().length() > 25) {
                campoTexto.setText("");
                label.setText(msj_incorrecto);
                label.setStyle("-fx-text-inner-color: #EF3030;");
                campoTexto.setStyle("-fx-background-color: rgba(255, 0, 0, 0.6);");
            }else {
                jugador.setNombre( campoTexto.getText() );
                label.setText("OK.");
                label.setStyle("-fx-text-inner-color: #7d9707;");
                campoTexto.setStyle("-fx-text-inner-color: #7d9707;");
            }
        }


    public void setMensajeIncorrecto(String msj){
        this.msj_incorrecto = msj;
    }
}
