package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorJuego {
    private Stage stage;

    private MapaVista mapaVista;
    private JugadorVista jugadorVista;
    public ContenedorJuego(Stage stage, String nombreJugador, String nombreVehiculo) {
        this.stage = stage;

        //TODO: Crear el mapaVista y el mapa (grafo)

        //Crea el vehiculo
        IVehiculo vehiculoJugador;
        if( nombreVehiculo.equals("Moto")){
            vehiculoJugador = new Moto();
        }
        if( nombreVehiculo.equals("Auto")){
            vehiculoJugador = new Auto();
        }
        if( nombreVehiculo.equals("4x4")){
            vehiculoJugador = new CuatroPorCuatro();
        }

        //Crea el jugador. Falta crear el mapa (grafo) para poder darle una celda al jugador.
        //Jugador jugador = new Jugador(nombreJugador, nombreVehiculo);

        VBox layout = new VBox();
        //TODO: Implementar contenido de la ventana del juego
            //  Va a estar compuesta por JugadorVista, PuntajeVista
            //y un par de botones para volver al menu, ver intrucciones etc.


        Scene contenido = new Scene( layout );
        this.stage.setScene( contenido );
    }
}
