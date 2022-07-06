package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.vista.JugadorVista;
import edu.fiuba.algo3.vista.MapaVista;
import edu.fiuba.algo3.controlador.Musica.ControladorMusica;
import edu.fiuba.algo3.controlador.Musica.Musica;
import edu.fiuba.algo3.controlador.Musica.ReproductorMusica;
import edu.fiuba.algo3.vista.PantallasPrincipales.ContenedorMenu;
import edu.fiuba.algo3.vista.PorcionMapaVista;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {


    @Override
    public void start(Stage stage) {

        stage.setTitle("Juego GPS Challenge");

        /*
        * Para que no se pisen las musicas a la hora de
        * cambiar las ventanas se me ocurrió ponerlo tempñoralmente
        * por acá.
        * Cuando el codigo esté integrado junto con el mapa, la instancia de musica
        * tiene que pasarse por parametro.
        * */
       // String rutaMusica = "/src/main/java/edu/fiuba/algo3/Recursos/musicaa/";
       // Musica musica = new Musica();
       // musica.play(rutaMusica,"pantallasPrincipales.mp3");

        stage.setTitle("Juego GPS Challenge");
        //ContenedorMenu menu = new ContenedorMenu(stage);
        Mapa m = new Mapa(25,16);
        m.generarMapa();
        m.setEstadosMapa();
        Jugador j = new Jugador("Jugador 1", m.getCeldaJugador(), new Moto());
        PorcionMapaVista p = new PorcionMapaVista(m, j);
        MapaVista mapa = new MapaVista(m,p,stage);
        JugadorVista v = new JugadorVista(j, mapa);
        mapa.accion(j);
        stage.setResizable(false);
        stage.setMaximized(true);
        //ContenedorMenu menu = new ContenedorMenu(stage);
    }

    public static void main(String[] args) {
        launch();
    }



}