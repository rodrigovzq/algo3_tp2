package edu.fiuba.algo3.vista;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorJuego {
    private Stage stage;
    public ContenedorJuego(Stage stage) {
        this.stage = stage;
        VBox layout = new VBox();
        // Implementar contenido de la ventana del juego
            //  Va a estar compuesta por JugadorVista, PuntajeVista
            //y un par de botones para volver al menu, ver intrucciones etc.
        Scene contenido = new Scene( layout );
        this.stage.setScene( contenido );
    }
}
