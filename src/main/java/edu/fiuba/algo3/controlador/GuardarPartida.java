package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vista.Ventanas.VentanaPopUp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class GuardarPartida implements EventHandler<ActionEvent> {
    private final Juego juego;

    public GuardarPartida(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("Guardando partida...");
        juego.guardarPartida();
        VentanaPopUp.mostrar("Guardar partida", "Partida guardada");

    }
}
