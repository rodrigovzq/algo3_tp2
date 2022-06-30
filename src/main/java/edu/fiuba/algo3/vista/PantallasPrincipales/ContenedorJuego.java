package edu.fiuba.algo3.vista.PantallasPrincipales;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.vista.JugadorVista;
import edu.fiuba.algo3.vista.MapaVista;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorJuego {
    private Stage stage;
    private MapaVista mapaVista;
    private JugadorVista jugadorVista;
    public ContenedorJuego(Stage stage, Jugador jugador) {
        this.stage = stage;


        VBox layout = new VBox();
        //TODO: Implementar contenido de la ventana del juego
            //  Va a estar compuesta por JugadorVista, PuntajeVista, Mapavista
            //y un par de botones para volver al menu, ver intrucciones etc.

        //
        Scene contenido = new Scene( layout );
        this.stage.setScene( contenido );
    }
}
