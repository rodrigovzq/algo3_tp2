package edu.fiuba.algo3.vista.PantallasPrincipales;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Pair;

import java.util.List;

import static javafx.scene.paint.Color.web;

public class ContenedorRanking {
    private Stage stage;
    private ObservableList<Pair<String, String>> ranking;
    private VBox panel;

    public ContenedorRanking(Stage stage, List<Pair<String, String>> ranking) {
        this.stage = stage;
        this.panel = new VBox();
        this.ranking = FXCollections.observableArrayList();
        for (Pair<String, String> par : ranking) {
            this.ranking.add(par);
        }
        this.iniciar();
    }

    private void iniciar() {

        Label titulo = new Label("RANKING");
        titulo.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        titulo.setAlignment(Pos.TOP_CENTER);
        titulo.setTextFill(Color.WHITE);
        titulo.setPadding(new Insets(10,10,10,10));
        titulo.setFont(new Font(35));

        TableColumn<Pair<String, String>, String> columnaNombre = new TableColumn<>("Nombre");
        columnaNombre.setMinWidth(100);
        columnaNombre.setCellValueFactory(p -> new ReadOnlyStringWrapper(p.getValue().getKey()));
        columnaNombre.setSortable(false);

        TableColumn<Pair<String, String>, String> columnaPuntaje = new TableColumn<>("Puntaje");
        columnaPuntaje.setMinWidth(100);
        columnaPuntaje.setCellValueFactory(p -> new ReadOnlyStringWrapper(p.getValue().getValue()));
        columnaPuntaje.setSortable(false);


        TableView<Pair<String, String>> tabla = new TableView<>();
        tabla.setItems(ranking);

        tabla.prefHeightProperty().bind(stage.heightProperty().divide(3.62));
        tabla.prefWidthProperty().bind(stage.widthProperty().divide(4));

        tabla.minHeightProperty().bind(tabla.prefHeightProperty());
        tabla.maxHeightProperty().bind(tabla.prefHeightProperty());

        tabla.getColumns().addAll(columnaNombre, columnaPuntaje);

        columnaNombre.prefWidthProperty().bind(tabla.widthProperty().divide(2)); // w * 1/4
        columnaPuntaje.prefWidthProperty().bind(tabla.widthProperty().divide(2)); // w * 1/2

        columnaNombre.setResizable(false);
        columnaPuntaje.setResizable(false);
        columnaNombre.setReorderable(false);
        columnaPuntaje.setReorderable(false);

        Button botonVolver = new Button("Volver al Menu");

        HBox cajaBoton = new HBox();
        VBox.setMargin(cajaBoton, new Insets(10.0d));
        cajaBoton.setAlignment(Pos.CENTER);
        botonVolver.setOnAction(e -> new ContenedorMenu(this.stage));
        cajaBoton.getChildren().add(botonVolver);

        panel.setAlignment(Pos.CENTER);
        panel.getChildren().addAll(titulo, tabla, cajaBoton);
        VBox.setMargin(tabla, new Insets(50,400,50,400));
        panel.setBackground(new Background(new BackgroundFill(web("#3e4e5a"), new CornerRadii(0), new Insets(0))));
        Scene config = new Scene(panel, 640, 480);
        this.stage.setScene(config);
        this.stage.show();

    }

}
