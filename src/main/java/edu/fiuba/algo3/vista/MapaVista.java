package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

public class MapaVista {

    public void mostrarMapa(Stage s) {
        GridPane mapa = new GridPane();
        int filas = 8;
        int columnas = 8;
        Background gris = new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY));
        BorderStroke blanco = new BorderStroke(Color.WHITE,
                new BorderStrokeStyle(StrokeType.OUTSIDE,StrokeLineJoin.BEVEL,StrokeLineCap.SQUARE,3.0,1.0,null),
                null,
                new BorderWidths(8.0));
        Border b = new Border(blanco);
        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                StackPane manzana = new StackPane();
//                manzana.setFill(Color.GRAY);
//                manzana.setStroke(Color.WHITE);
//                manzana.setStrokeWidth(3.0);
                manzana.prefWidthProperty().bind(mapa.widthProperty().divide(columnas));
                manzana.prefHeightProperty().bind(mapa.heightProperty().divide(filas));
                manzana.setBackground(gris);
                manzana.setBorder(b);
                mapa.add(manzana,i,j);
            }
        }
        s.setScene(new Scene(mapa, 400,400));
        s.show();
    }
}
