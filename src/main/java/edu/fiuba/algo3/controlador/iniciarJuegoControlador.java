package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Impresora.Impresora;
import edu.fiuba.algo3.modelo.Impresora.ImpresoraFile;
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
        this.jugador.setPosicion( mapa.getCeldaJugador() ) ;

        System.out.println("Posicionando meta...");
        Celda meta = mapa.getMeta();

        //Agregar observador al Juego
        //meta.agregarObservador( juego )

        System.out.println("Guardando partida...");
        new ImpresoraFile( "saves/jugador.txt").imprimir(jugador);
        new ImpresoraFile( "saves/mapa.txt").imprimir(mapa);


        //TODO: Cambiar de pantalla al juego, al iniciar el juego, usamos los parser.
        //TODO: HACER JUEGO.
    }


}
