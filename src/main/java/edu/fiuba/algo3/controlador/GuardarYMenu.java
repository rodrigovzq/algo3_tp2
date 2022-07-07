package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.controlador.Cerrar.CerrarJuegoBoton;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vista.PantallasPrincipales.ContenedorMenu;
import edu.fiuba.algo3.vista.Ventanas.VentanaConfirmacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class GuardarYMenu implements EventHandler<ActionEvent> {
    private final Juego juego;
    private Stage stage;

    public GuardarYMenu(Juego juego, Stage stage) {
        this.juego = juego;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        boolean resultado = VentanaConfirmacion.mostrar("Guardar Partida", "¿Desea guardar la partida?");
        if( resultado )
            new GuardarPartida(this.juego).handle(actionEvent);

        new ContenedorMenu(this.stage);
    }
}
