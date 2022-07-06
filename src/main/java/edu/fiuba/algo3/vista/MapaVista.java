package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.Cerrar.CerrarJuegoBoton;
import edu.fiuba.algo3.controlador.Cerrar.CerrarJuegoVentana;
import edu.fiuba.algo3.controlador.TecladoControlador;
import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.EstadoCelda.EstadoCelda;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.vista.PantallasPrincipales.ContenedorInstrucciones;
import edu.fiuba.algo3.vista.PantallasPrincipales.ContenedorMenu;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MapaVista implements Observador {

    private Mapa mapa;
    private BorderPane panelGlobal = new BorderPane();
    private GridPane vista;
    private Stage stage;
    private HBox cajaBotones;

    private StackPane contenedor; // Se le puede colocar la capa que oculta arriba a partir de este pane
    private Canvas figuras;

    private PorcionMapaVista niebla;

    private PuntajeVista puntaje = new PuntajeVista();
    Button botonVolverMenu = new Button("Volver al menu");
    Button botonInstrucciones = new Button("Instrucciones");
    Button botonSalir = new Button("Salir");

    public MapaVista(Mapa mapa, PorcionMapaVista porcion, Stage stage) {
        this.vista = new GridPane();
        this.mapa = mapa;
        mapa.agregarObservador(this);
        for (int i = 0; i < mapa.getAncho(); i++) {
            for (int j = 0; j < mapa.getAltura(); j++) {
                Rectangle manzana = new Rectangle(50, 50, Color.GREY);
                manzana.setStroke(Color.WHITE);
                manzana.setStrokeWidth(5);
                this.vista.add(manzana, i, j);
            }
        }
        this.vista.setPadding(new Insets(15, 15, 15, 15));
        this.vista.setAlignment(Pos.CENTER);
        this.stage = stage;
        this.niebla = porcion;

        cajaBotones = emitirBotonesSugerencia();
        cajaBotones.setSpacing(30.0d);
        cajaBotones.setAlignment(Pos.TOP_CENTER);
        HBox.setMargin(botonVolverMenu, new Insets(10, 10, 10, 10));
        HBox.setMargin(botonInstrucciones, new Insets(10, 10, 10, 10));
        HBox.setMargin(botonSalir, new Insets(10, 10, 10, 10));
        HBox.setMargin(puntaje, new Insets(15, 10, 10, 10));
        cajaBotones.prefWidthProperty().bind(stage.widthProperty());

        contenedor = new StackPane(vista);
        figuras = new Canvas(55 * mapa.getAncho() + 5, 55 * mapa.getAltura() + 5);

        contenedor.getChildren().addAll(figuras, niebla);
        contenedor.setAlignment(Pos.CENTER);
        panelGlobal.setCenter(contenedor);
        panelGlobal.setTop(cajaBotones);
        panelGlobal.prefHeightProperty().bind(stage.heightProperty());
        panelGlobal.prefWidthProperty().bind(stage.widthProperty());
        panelGlobal.setBackground(new Background(new BackgroundFill(Color.web("#24333e"), new CornerRadii(0), new Insets(0))));
        //dibujar();
        stage.setScene(new Scene(panelGlobal, 435, 472));
        stage.show();
    }

    private HBox emitirBotonesSugerencia() {

        HBox cajaHorizontal = new HBox();

        botonVolverMenu.setOnAction(e -> new ContenedorMenu(this.stage));
        botonInstrucciones.setOnAction(e -> new ContenedorInstrucciones().mostrar());
        CerrarJuegoVentana cerrarVentana = new CerrarJuegoVentana(botonSalir);
        CerrarJuegoBoton cerrarBoton = new CerrarJuegoBoton(this.stage);
        stage.setOnCloseRequest(cerrarVentana);
        botonSalir.setOnAction(cerrarBoton);
        cajaHorizontal.getChildren().addAll(botonVolverMenu, botonInstrucciones, botonSalir, puntaje);
        return cajaHorizontal;
    }

    @Override
    public void actualizar() {
        dibujar();
    }

    public void agregarVistaEnMapa(Image icono, Coordenada coordenada) {
        GraphicsContext contexto = figuras.getGraphicsContext2D();
        contexto.drawImage(icono, 52.5 * (coordenada.getPosX() + 1), 49 * (coordenada.getPosY() + 1), 25, 25);
    }

    public void limpiarRectangulo(Coordenada coordenada, double ancho, double alto) {
        GraphicsContext contexto = figuras.getGraphicsContext2D();
        contexto.clearRect(52.5 * (coordenada.getPosX() + 1), 49 * (coordenada.getPosY() + 1), ancho, alto);
    }

    public void modificarPuntaje(Movimiento movimientos) {
        puntaje.actualizar(movimientos);
    }

    public void dibujar() {
        GraphicsContext contexto = figuras.getGraphicsContext2D();
        for (int i = 0; i < mapa.getAncho(); i++) {
            for (int j = 0; j < mapa.getAltura(); j++) {
                Celda celda = mapa.getCelda(new Coordenada(i, j));
                if (celda.imprimir() != EstadoCelda.COMUN.name()) {
                    Image icono = new Image("file:src/main/java/edu/fiuba/algo3/vista/assets/obstaculos/" + celda.imprimir() + ".png");
                    contexto.drawImage(icono, 52.5 * (i + 1), 49 * (j + 1), 20, 20); // TODO: AJUSTAR ESTOS VALORES
                }
            }
        }
    }

    public void redibujarEn(Coordenada coordenada) {
        Celda celda = mapa.getCelda(coordenada);
        if (celda.imprimir() != EstadoCelda.COMUN.name()) {
            Image icono = new Image("file:src/main/java/edu/fiuba/algo3/vista/assets/obstaculos/" + celda.imprimir() + ".png");
            GraphicsContext contexto = figuras.getGraphicsContext2D();

            contexto.drawImage(icono, 52.5 * (coordenada.getPosX() + 1), 49 * (coordenada.getPosY() + 1), 20, 20); // TODO: AJUSTAR ESTOS VALORESs
        }
    }

    public void accion(Jugador j) {
        panelGlobal.setOnKeyPressed(new TecladoControlador(j));
    }
}
