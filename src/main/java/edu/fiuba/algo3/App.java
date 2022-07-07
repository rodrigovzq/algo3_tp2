package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.Musica.Musica;
import edu.fiuba.algo3.vista.PantallasPrincipales.ContenedorMenu;
import javafx.application.Application;

import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {


    @Override
    public void start(Stage stage) {

        stage.setTitle("Juego GPS Challenge");
        stage.setMaximized(true);
        //stage.setResizable(false);
        /*
        * Para que no se pisen las musicas a la hora de
        * cambiar las ventanas se me ocurrió ponerlo tempñoralmente
        * por acá.
        * Cuando el codigo esté integrado junto con el mapa, la instancia de musica
        * tiene que pasarse por parametro.
        * */
        String rutaMusica = "/src/main/java/edu/fiuba/algo3/Recursos/musicaa/";
        Musica musica = new Musica();
        musica.play(rutaMusica,"pantallasPrincipales.mp3");

        ContenedorMenu menu = new ContenedorMenu(stage);


    }

    public static void main(String[] args) {
        launch();
    }



}