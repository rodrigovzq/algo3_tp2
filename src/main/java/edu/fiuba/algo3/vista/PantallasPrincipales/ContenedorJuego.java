package edu.fiuba.algo3.vista.PantallasPrincipales;

import edu.fiuba.algo3.controlador.TecladoControlador;
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
import edu.fiuba.algo3.vista.*;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorJuego {
    private Stage stage;
    private MapaVista mapaVista;
    private JugadorVista jugadorVista;
    private Juego juego;
    public ContenedorJuego(Stage stage, Juego juego) {
        this.stage = stage;
        this.juego = juego;
        this.iniciar();
    }

    public void iniciar(){
        VBox layout = new VBox();

        Mapa m = juego.getMapa();
        Jugador j = juego.getJugador();

        PorcionMapaVista porcionVista = new PorcionMapaVista(m, j);
        MapaVista mapaVista = new MapaVista(m,porcionVista,stage);
        JugadorVista jugadorVista = new JugadorVista(j, mapaVista);
        CajaMapaVista cajaMapaVista = new CajaMapaVista(new PuntajeVista(j), stage, this.juego);
        JuegoVista juegoVista = new JuegoVista(cajaMapaVista, stage);
        juegoVista.setCenter(mapaVista);
        juegoVista.setOnKeyPressed(new TecladoControlador(j));
        stage.setResizable(false);
        stage.setMaximized(true);

        stage.setScene(new Scene(juegoVista, 435, 472));
        stage.show();
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
