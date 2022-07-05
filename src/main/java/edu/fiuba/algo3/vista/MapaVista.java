package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.Cerrar.CerrarJuegoBoton;
import edu.fiuba.algo3.controlador.Cerrar.CerrarJuegoVentana;
import edu.fiuba.algo3.vista.PantallasPrincipales.ContenedorInstrucciones;
import edu.fiuba.algo3.vista.PantallasPrincipales.ContenedorMenu;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

public class MapaVista {

    BorderPane panelGlobal = new BorderPane();
    GridPane mapa = new GridPane();
    private Stage stage;
    HBox cajaBotones;


    Button botonVolverMenu = new Button( "Volver al menu");
    Button botonInstrucciones = new Button( "Instrucciones");
    Button botonSalir = new Button( "Salir");

    public void mostrarMapa(Stage stage) {

        this.stage = stage;

        cajaBotones = emitirBotonesSugerencia();
        cajaBotones.setSpacing(30.0d);
        cajaBotones.setAlignment(Pos.TOP_CENTER);
        HBox.setMargin(botonVolverMenu,new Insets(10,10,10,10));
        HBox.setMargin(botonInstrucciones,new Insets(10,10,10,10));
        HBox.setMargin(botonSalir,new Insets(10,10,10,10));
        panelGlobal.setTop(cajaBotones);
        mapa.setHgap(2);   // separación entre columnas
        mapa.setVgap(2);   // separación entre filas
        mapa.setPadding(new Insets(15, 15, 15, 15));


        int filas = 8;
        int columnas = 8;
        Background gris = new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY));
        BorderStroke blanco = new BorderStroke(Color.WHITE, new BorderStrokeStyle(StrokeType.OUTSIDE, StrokeLineJoin.BEVEL, StrokeLineCap.SQUARE,3.0,1.0,null), null, new BorderWidths(8.0));
        Border b = new Border(blanco);
        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                StackPane manzana = new StackPane();
//              manzana.setFill(Color.GRAY);
//              manzana.setStroke(Color.WHITE);
//              manzana.setStrokeWidth(3.0);
                manzana.prefWidthProperty().bind(mapa.widthProperty().divide(columnas));
                manzana.prefHeightProperty().bind(mapa.heightProperty().divide(filas));
                manzana.setBackground(gris);
                manzana.setBorder(b);
                mapa.add(manzana,i,j);
            }
        }


        panelGlobal.setCenter(mapa);
        panelGlobal.setBackground(new Background(new BackgroundFill(Color.web("#24333e"), new CornerRadii(0), new Insets(0))));

        stage.setScene(new Scene(panelGlobal, 400,400));
        stage.show();
    }

    private HBox emitirBotonesSugerencia() {

        HBox cajaHorizontal = new HBox();

        botonVolverMenu.setOnAction( e -> new ContenedorMenu(this.stage) );
        botonInstrucciones.setOnAction( e -> new ContenedorInstrucciones().mostrar() );
        CerrarJuegoVentana cerrarVentana = new CerrarJuegoVentana( botonSalir );
        CerrarJuegoBoton cerrarBoton = new CerrarJuegoBoton( this.stage );
        stage.setOnCloseRequest( cerrarVentana );
        botonSalir.setOnAction( cerrarBoton );

        cajaHorizontal.getChildren().addAll(botonVolverMenu,botonInstrucciones,botonSalir);
        return cajaHorizontal;
    }
}
