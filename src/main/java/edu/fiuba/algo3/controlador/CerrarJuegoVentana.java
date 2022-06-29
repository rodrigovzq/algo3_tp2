package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.VentanaConfirmacion;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class CerrarJuegoVentana implements EventHandler<WindowEvent> {

    private Button boton;

    public CerrarJuegoVentana(Button boton){
        this.boton = boton;
    }

    @Override
    public void handle(WindowEvent e) {
        e.consume();
        Event.fireEvent(boton, new ActionEvent());
    }
}
