package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class iniciarJuegoControlador implements EventHandler<ActionEvent> {
    private final Stage stage;
    private final Mapa mapa;
    Jugador jugador;

    //Mapa mapa;

    //Responsable de crear al jugador y cambiar la escena en la ventana.
    public iniciarJuegoControlador(Stage stage, Jugador jugador, Mapa mapa) {
        this.jugador = jugador;
        this.stage = stage;
        this.mapa = mapa;
    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println("Generando mapa...");
        this.mapa.generarMapa();

        System.out.println("Posicionando jugador...");
        this.jugador.setPosicion( mapa.sortearCeldaJugador() ) ;

        System.out.println("Creando jugador...");
        System.out.println( this.jugador.toString());

        //TODO: Cambiar de pantalla al juego.
        //TODO: HACER JUEGO.
    }


}
