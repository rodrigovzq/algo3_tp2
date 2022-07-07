package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.TecladoControlador;
import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.EstadoCelda.EstadoCelda;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Observador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Objects;

public class MapaVista extends StackPane implements Observador {

    private Mapa mapa;
    private BorderPane panelGlobal = new BorderPane();
    private GridPane vista;
    private Canvas figuras;
    private PorcionMapaVista niebla;


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
        this.niebla = porcion;

        figuras = new Canvas(55 * mapa.getAncho() + 5, 55 * mapa.getAltura() + 5);

        getChildren().addAll(vista, figuras, niebla);
        setAlignment(Pos.CENTER);

        dibujar();
    }

    @Override
    public void actualizar() {
        dibujar();
    }

    public void agregarVistaEnMapa(Image icono, Coordenada coordenada) {
        GraphicsContext contexto = figuras.getGraphicsContext2D();
        contexto.drawImage(icono, 52.5 * (coordenada.getPosX() + 1), 49 * (coordenada.getPosY() + 1), 23, 23);
    }

    public void limpiarRectangulo(Coordenada coordenada, double ancho, double alto) {
        GraphicsContext contexto = figuras.getGraphicsContext2D();
        contexto.clearRect(52.5 * (coordenada.getPosX() + 1), 49 * (coordenada.getPosY() + 1), ancho, alto);
    }

    private void dibujar() {
        GraphicsContext contexto = figuras.getGraphicsContext2D();
        for (int i = 0; i < mapa.getAncho(); i++) {
            for (int j = 0; j < mapa.getAltura(); j++) {
                Celda celda = mapa.getCelda(new Coordenada(i, j));
                if (!Objects.equals(celda.getEstadoCelda(), EstadoCelda.COMUN.name())) {
                    Image icono = new Image("file:src/main/java/edu/fiuba/algo3/vista/assets/obstaculos/" + celda.getEstadoCelda() + ".png");
                    contexto.drawImage(icono, 52.5 * (i + 1), 49 * (j + 1), 19, 19); // TODO: AJUSTAR ESTOS VALORES
                }
            }
        }
    }

    public void redibujarEn(Coordenada coordenada) {
        Celda celda = mapa.getCelda(coordenada);
        if (!Objects.equals(celda.getEstadoCelda(), EstadoCelda.COMUN.name())) {
            Image icono = new Image("file:src/main/java/edu/fiuba/algo3/vista/assets/obstaculos/" + celda.getEstadoCelda() + ".png");
            GraphicsContext contexto = figuras.getGraphicsContext2D();
            contexto.drawImage(icono, 52.5 * (coordenada.getPosX() + 1), 49 * (coordenada.getPosY() + 1), 19, 19); // TODO: AJUSTAR ESTOS VALORESs
        }
    }

    public void accion(Jugador j) {
        panelGlobal.setOnKeyPressed(new TecladoControlador(j));
    }
}
