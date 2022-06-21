package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorConfiguracion {
    VBox root = new VBox();

    Stage stage;
    public ContenedorConfiguracion(Stage stage) {
        this.stage = stage;

        Button botonJugar = new Button("Jugar");
        botonJugar.setOnAction( e -> new ContenedorJuego( this.stage )  );
        Button botonCancelar = new Button("Cancelar");
        botonCancelar.setOnAction( e -> new ContenedorMenu( this.stage )  );

        Label nombre = new Label("Nombre");
        nombre.setFont(new Font(15));


        Label vehiculo = new Label("Vehiculo");
        vehiculo.setFont(new Font(15));


        Label mapa = new Label("Mapas");
        mapa.setFont(new Font(15));

        //campo de texto
        TextField nombreJugador = new TextField();
        nombreJugador.setMaxWidth(150);
        nombreJugador.setPromptText("Ingrese un nombre");
        TextField tipoVehiculo = new TextField();


        Button boton20X20 = new Button("20x20");
        boton20X20.setCursor(Cursor.HAND);
        boton20X20.setPrefSize(100,100);

        Button boton25X25 = new Button("25X25");
        boton25X25.setCursor(Cursor.HAND);
        boton25X25.setPrefSize(100,100);

        Button boton30X30 = new Button("30X30");
        boton30X30.setCursor(Cursor.HAND);
        boton30X30.setPrefSize(100,100);

        Button boton35X35 = new Button("35X35");
        boton35X35.setCursor(Cursor.HAND);
        boton35X35.setPrefSize(100,100);

        HBox rootH1 = new HBox();
        HBox rootH2 = new HBox();
        HBox rootH3 = new HBox();
        HBox rootH4 = new HBox();
        HBox rootH5 = new HBox();

        rootH1.getChildren().addAll(nombre, nombreJugador);
        rootH1.setAlignment(Pos.CENTER);

        rootH2.getChildren().addAll(vehiculo, tipoVehiculo);
        rootH2.setAlignment(Pos.CENTER);

        rootH3.getChildren().addAll(boton20X20, boton25X25);
        rootH3.setAlignment(Pos.CENTER);

        rootH4.getChildren().addAll(boton30X30, boton35X35);
        rootH4.setAlignment(Pos.CENTER);

        rootH5.getChildren().addAll(botonCancelar, botonJugar);

        root.getChildren().addAll(rootH1,rootH2,mapa,rootH3,rootH4,rootH5);

        HBox.setMargin(boton20X20,new Insets(10,10,10,10));
        HBox.setMargin(boton25X25,new Insets(15,10,10,10));
        HBox.setMargin(boton30X30,new Insets(15,10,10,10));
        HBox.setMargin(boton35X35,new Insets(15,10,10,10));

        HBox.setMargin(botonCancelar, new Insets(10,100,10,10));
        HBox.setMargin(botonJugar, new Insets(10,10,10,350));

        HBox.setMargin(nombre,new Insets(10,10,10,10));
        HBox.setMargin(nombreJugador,new Insets(10,10,10,10));
        HBox.setMargin(vehiculo,new Insets(10,10,10,10));
        HBox.setMargin(tipoVehiculo,new Insets(10,10,10,10));
        root.setAlignment(Pos.CENTER);

        Scene config = new Scene(root, 640,480);

        this.stage.setScene( config );
        this.stage.show();
    }
}
