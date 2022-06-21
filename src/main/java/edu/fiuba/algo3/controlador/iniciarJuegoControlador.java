package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.Comun;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.vista.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class iniciarJuegoControlador implements EventHandler<ActionEvent> {
    private final Stage stage;
    String nombreJugador;
    IVehiculo vehiculo;

    //Mapa mapa;

    //Responsable de crear al jugador y cambiar la escena en la ventana.
    public iniciarJuegoControlador(Stage stage, String nombreJugador, IVehiculo vehiculo ) {
        this.nombreJugador = nombreJugador;
        this.vehiculo = vehiculo;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        if( nombreJugador.equals("") || nombreJugador.equals( null ) ){
            //No iniciar juego.
            //TODO: Deberia avisarle al jugador que le falta ingresar un nombre
        }
        if(  vehiculo.equals( null ) ){
            //No iniciar juego.
            //TODO: Deberia avisarle al jugador que le falta seleccionar un vehiculo
        }
        /* TODO: Clase Mapa que se encargue de tener la configuración para la creacion del grafo.
        if(  mapa.equals( null ) ){
            //No iniciar juego.
            //TODO: Deberia avisarle al jugador que le falta seleccionar un tamanio de mapa
        }
        */
        //TODO: Crear el mapa (grafo)


        //Crea el jugador. Falta crear el mapa (grafo) para poder darle una celda al jugador.
        Jugador jugador = new Jugador(nombreJugador, new Celda(new Comun()) , this.vehiculo);

        //Cambiar de escena
        new ContenedorJuego(this.stage, jugador);
    }

}
