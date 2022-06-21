package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.CeldaBorde;
import edu.fiuba.algo3.modelo.Celda.CeldaEsquina;
import edu.fiuba.algo3.modelo.Celda.CeldaInterna;
import edu.fiuba.algo3.modelo.Celda.Obstaculo.Comun;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import edu.fiuba.algo3.vista.ContenedorJuego;
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
        /*
        int columna = 0;
        for( int fila = 0; fila < mapa.getAncho(); fila++ ){
            Celda nuevaCelda = null;
            //TODO: Refactor a un Factory.
            if( fila == 0 && columna == 0){
                nuevaCelda = new CeldaEsquina(new Comun(), Direccion.SUR, Direccion.ESTE);
            }
            else if( fila == mapa.getAltura() && columna == 0){
                nuevaCelda = new CeldaEsquina(new Comun(), Direccion.NORTE, Direccion.ESTE);
            }
            else if( fila == 0 && columna == mapa.getAltura()){
                nuevaCelda = new CeldaEsquina(new Comun(), Direccion.SUR, Direccion.OESTE);
            }
            else if( fila == mapa.getAltura() && columna == mapa.getAncho()){
                nuevaCelda = new CeldaEsquina(new Comun(), Direccion.NORTE, Direccion.OESTE);
            }
            else if( fila != 0 && columna == mapa.getAncho() ){
                nuevaCelda = new CeldaBorde(new Comun(), Direccion.NORTE, Direccion.ESTE, Direccion.SUR);
            }
            else if( fila != 0 && columna == 0 ){
                nuevaCelda = new CeldaBorde(new Comun(), Direccion.NORTE, Direccion.OESTE, Direccion.SUR);
            }
            else if( fila == 0 && columna != 0 ){
                nuevaCelda = new CeldaBorde(new Comun(), Direccion.ESTE, Direccion.OESTE, Direccion.SUR);
            }
            else if( fila == mapa.getAltura() && columna != 0 ){
                nuevaCelda = new CeldaBorde(new Comun(), Direccion.NORTE, Direccion.OESTE, Direccion.ESTE);
            }
            else{ nuevaCelda = new CeldaInterna( new Comun()); }

        }

        //Crea el jugador. Falta crear el mapa (grafo) para poder darle una celda al jugador.
        //Jugador jugador = new Jugador(nombreJugador, new CeldaInterna(new Comun()) , this.vehiculo);

        //Cambiar de escena
        new ContenedorJuego(this.stage, jugador);
    */
    }


}
