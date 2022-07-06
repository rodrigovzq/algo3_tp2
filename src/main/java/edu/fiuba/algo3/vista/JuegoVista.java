package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JuegoVista extends BorderPane {
    private Stage stage;
    public JuegoVista(CajaMapaVista caja, Stage stage) {
        super();
        this.stage = stage;
        setTop(caja);
        prefHeightProperty().bind(stage.heightProperty());
        prefWidthProperty().bind(stage.widthProperty());
        setBackground(new Background(new BackgroundFill(Color.web("#24333e"), new CornerRadii(0), new Insets(0))));
    }
}
