package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.Cerrar.CerrarJuegoBoton;
import edu.fiuba.algo3.controlador.Cerrar.CerrarJuegoVentana;
import edu.fiuba.algo3.controlador.GuardarPartida;
import edu.fiuba.algo3.controlador.GuardarYMenu;
import edu.fiuba.algo3.controlador.GuardarYSalir;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vista.PantallasPrincipales.ContenedorInstrucciones;
import edu.fiuba.algo3.vista.PantallasPrincipales.ContenedorMenu;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CajaMapaVista extends HBox {
    private PuntajeVista puntaje;
    private Juego juego;
    private Button botonVolverMenu = new Button("Volver al menu");
    private Button botonGuardar = new Button("Guardar partida");
    private Button botonInstrucciones = new Button("Instrucciones");
    private Button botonSalir = new Button("Salir del Juego");

    private Stage stage;

    public CajaMapaVista(PuntajeVista p, Stage stage, Juego juego) {
        this.puntaje = p;
        this.juego = juego;
        this.stage = stage;
        configurarBotones();
        setSpacing(30.0d);
        setAlignment(Pos.TOP_CENTER);
        CajaMapaVista.setMargin(botonVolverMenu, new Insets(10, 10, 10, 10));
        CajaMapaVista.setMargin(botonInstrucciones, new Insets(10, 10, 10, 10));
        CajaMapaVista.setMargin(botonSalir, new Insets(10, 10, 10, 10));
        CajaMapaVista.setMargin(puntaje, new Insets(15, 10, 10, 10));
        prefWidthProperty().bind(stage.widthProperty());
    }

    private void configurarBotones() {
        GuardarYMenu guardarYMenu = new GuardarYMenu(this.juego, this.stage);
        botonVolverMenu.setOnAction( guardarYMenu );
        botonInstrucciones.setOnAction(e -> new ContenedorInstrucciones().mostrar());
        GuardarPartida guardarPartida = new GuardarPartida(this.juego);
        botonGuardar.setOnAction( guardarPartida );
        CerrarJuegoVentana cerrarVentana = new CerrarJuegoVentana(botonSalir);
        stage.setOnCloseRequest(cerrarVentana);
        GuardarYSalir guardarYSalir = new GuardarYSalir(this.juego, this.stage);
        botonSalir.setOnAction(guardarYSalir);

        getChildren().addAll(botonVolverMenu, botonGuardar, botonInstrucciones, botonSalir, puntaje);
    }
}
