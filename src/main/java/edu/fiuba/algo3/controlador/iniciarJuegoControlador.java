package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class iniciarJuegoControlador implements EventHandler<ActionEvent> {
    private final Stage stage;
    private final Mapa mapa;
    String nombreJugador;
    IVehiculo vehiculo;

    //Mapa mapa;

    //Responsable de crear al jugador y cambiar la escena en la ventana.
    public iniciarJuegoControlador(Stage stage, String nombreJugador, Mapa mapa, IVehiculo vehiculo ) {
        this.nombreJugador = nombreJugador;
        this.vehiculo = vehiculo;
        this.stage = stage;
        this.mapa = mapa;
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
        // TODO: Clase Mapa que se encargue de tener la configuración para la creacion del grafo.
        if(  mapa.equals( null ) ){
            //No iniciar juego.
            //TODO: Deberia avisarle al jugador que le falta seleccionar un tamanio de mapa
        }

        //TODO: Crear el mapa (grafo)

        //Crea el jugador. Falta crear el mapa (grafo) para poder darle una celda al jugador.
        //Jugador jugador = new Jugador(nombreJugador, new CeldaInterna(new Comun()) , this.vehiculo);

        //Cambiar de escena
        //new ContenedorJuego(this.stage, jugador);
    }


}
