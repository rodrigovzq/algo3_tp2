package edu.fiuba.algo3.vista.PantallasPrincipales;

import edu.fiuba.algo3.controlador.TecladoControlador;
import edu.fiuba.algo3.controlador.Victoria;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Parser.Parser;
import edu.fiuba.algo3.modelo.Parser.ParserJugador;
import edu.fiuba.algo3.modelo.Parser.ParserMapa;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.vista.*;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorJuego implements Observador {
    private Stage stage;
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

        j.agregarObservador(this);
        PorcionMapaVista porcionVista = new PorcionMapaVista(m, j, this.stage);
        MapaVista mapaVista = new MapaVista(m,porcionVista,stage);
        JugadorVista jugadorVista = new JugadorVista(j, mapaVista);
        CajaMapaVista cajaMapaVista = new CajaMapaVista(new PuntajeVista(j), stage, this.juego);
        JuegoVista juegoVista = new JuegoVista(cajaMapaVista, stage);
        juegoVista.setCenter(mapaVista);
        juegoVista.setOnKeyPressed(new TecladoControlador(j));

        stage.setScene(new Scene(juegoVista, 435, 472));
        stage.show();
    }

    public void actualizar(){
        if( juego.elJugadorLlegoAMeta() ){
            new Victoria(this.stage, juego).handle(new ActionEvent());
        }
    }
}
