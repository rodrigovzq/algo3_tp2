package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.Comun;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.vista.ContenedorJuego;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class iniciarJuegoControlador extends EventHandler {
    private final Stage stage;
    String nombreJugador;
    String nombreVehiculo;

    //Responsable de crear al jugador y cambiar la escena en la ventana.
    public iniciarJuegoControlador(Stage stage, String nombreJugador, String nombreVehiculo ) {
        this.nombreJugador = nombreJugador;
        this.nombreVehiculo = nombreVehiculo;
        this.stage = stage;
    }

    @Override
    public void handle(Event event) {
        if( nombreJugador.equals("") || nombreJugador.equals( null ) ){
            //No iniciar juego.
        }

        IVehiculo vehiculoJugador = null;
        if( nombreVehiculo.equals("Moto")){
            vehiculoJugador = new Moto();
        }
        if( nombreVehiculo.equals("Auto")){
            vehiculoJugador = new Auto();
        }
        if( nombreVehiculo.equals("4x4")){
            vehiculoJugador = new CuatroPorCuatro();
        }
        //TODO: Crear el mapa (grafo)


        //Crea el jugador. Falta crear el mapa (grafo) para poder darle una celda al jugador.
        Jugador jugador = new Jugador(nombreJugador, new Celda(new Comun()) , vehiculoJugador);

        //Cambiar de escena
        new ContenedorJuego(this.stage, jugador);
    }
}
