package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class CampoTextoEnter implements EventHandler<KeyEvent> {

    private final TextField campoTexto;
    Jugador jugador;
    String msj_incorrecto;
    public CampoTextoEnter(TextField campoTexto, Jugador jugador) {
        this.campoTexto = campoTexto;
        this.jugador = jugador;
        this.msj_incorrecto = "Valor inválido.";
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER ){
            if( campoTexto.getText().equals("")) {
                //TODO: Podríamos agregar un botón al lado del TExtField para indicar que es un nombre valido.

                campoTexto.setText(msj_incorrecto);
                campoTexto.setStyle("-fx-text-inner-color: #EF3030;");
            }else {
                jugador.setNombre( campoTexto.getText() );
                campoTexto.setStyle("-fx-text-inner-color: #10AF30;");

            }
        }
    }

    public void setMensajeIncorrecto(String msj){
        this.msj_incorrecto = msj;
    }
}
