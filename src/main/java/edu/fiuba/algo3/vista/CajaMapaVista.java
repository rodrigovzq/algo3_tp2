package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.Cerrar.CerrarJuegoBoton;
import edu.fiuba.algo3.controlador.Cerrar.CerrarJuegoVentana;
import edu.fiuba.algo3.vista.PantallasPrincipales.ContenedorInstrucciones;
import edu.fiuba.algo3.vista.PantallasPrincipales.ContenedorMenu;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CajaMapaVista extends HBox {
    private PuntajeVista puntaje;
    private Button botonVolverMenu = new Button("Volver al menu");
    private Button botonInstrucciones = new Button("Instrucciones");
    private Button botonSalir = new Button("Salir");

    private Stage stage;

    public CajaMapaVista(PuntajeVista p, Stage stage) {
        this.puntaje = p;
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
        botonVolverMenu.setOnAction(e -> new ContenedorMenu(this.stage));
        botonInstrucciones.setOnAction(e -> new ContenedorInstrucciones().mostrar());
        CerrarJuegoVentana cerrarVentana = new CerrarJuegoVentana(botonSalir);
        CerrarJuegoBoton cerrarBoton = new CerrarJuegoBoton(this.stage);
        stage.setOnCloseRequest(cerrarVentana);
        botonSalir.setOnAction(cerrarBoton);

        getChildren().addAll(botonVolverMenu, botonInstrucciones, botonSalir, puntaje);
    }
}
