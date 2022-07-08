package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Parser.ParserJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class CampoTextoEnter implements EventHandler<KeyEvent> {

    private final TextField campoTexto;
    private final Label label;
    Jugador jugador;
    String msj_incorrecto;
    public CampoTextoEnter(TextField campoTexto, Jugador jugador, Label label) {
        this.campoTexto = campoTexto;
        this.jugador = jugador;
        this.msj_incorrecto = ": Inválido. Ingrese un nombre no vacío y con longitud menor a 25 caracteres.";
        this.label = label;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER ){
            new CampoTextoBoton(this.campoTexto, this.jugador, this.label ).handle( new ActionEvent());
        }
    }

    public void setMensajeIncorrecto(String msj){
        this.msj_incorrecto = msj;
    }
}
