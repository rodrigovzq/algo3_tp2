package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.controlador.Cerrar.CerrarJuegoBoton;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vista.Ventanas.VentanaConfirmacion;
import edu.fiuba.algo3.vista.Ventanas.VentanaPopUp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import static edu.fiuba.algo3.vista.Ventanas.VentanaConfirmacion.resultado;

public class GuardarYSalir implements EventHandler<ActionEvent> {
    private final Juego juego;
    private Stage stage;

    @Override
    public void handle(ActionEvent actionEvent) {
        boolean resultado = VentanaConfirmacion.mostrar("Guardar Partida", "¿Desea guardar la partida?");
        if( resultado )
            new GuardarPartida(this.juego).handle(actionEvent);

        new CerrarJuegoBoton(this.stage).handle(actionEvent);
    }

    public GuardarYSalir(Juego juego, Stage stage) {
        this.juego = juego;
        this.stage = stage;
    }
}
