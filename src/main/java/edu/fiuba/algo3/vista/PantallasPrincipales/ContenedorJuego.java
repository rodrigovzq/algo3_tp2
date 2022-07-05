package edu.fiuba.algo3.vista.PantallasPrincipales;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Parser.Parser;
import edu.fiuba.algo3.modelo.Parser.ParserJugador;
import edu.fiuba.algo3.modelo.Parser.ParserMapa;
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
    public ContenedorJuego(Stage stage, Juego juego) {

        this.stage = stage;

        VBox layout = new VBox();
        //TODO: Implementar contenido de la ventana del juego
            //  Va a estar compuesta por JugadorVista, PuntajeVista, Mapavista
            //y un par de botones para volver al menu, ver intrucciones etc.

        //
        Scene contenido = new Scene( layout );
        this.stage.setScene( contenido );

        //Opciones
        //Salir -> Preguntar si quiere guardar la partida. NO: deja el archivo que estaba. SI: sobreescribe mapa.txt y jugador.txt.
        //Instrucciones -> Lo mismo que en el menu.
        //Ranking -> Lo mismo que en el menu. ¿Debería mostrarse su puntuación actual a comparacion del top mostrado?
        //Guardar -> Sobreescribir archivos mapa.txt y jugador.txt.

        //Cosas que pueden pasar:
        //Llegar a un borde -> Mostrar visualmente con algo que no puede pasar.
        //Ganar -> Mostrar menu de victoria. (Se guarda el ranking y ¿se borran los txt?)

    }
}
