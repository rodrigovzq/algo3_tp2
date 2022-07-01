package edu.fiuba.algo3.vista.Ventanas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaConfirmacion {
    public static boolean resultado = false;


    public static boolean mostrar(String titulo, String pregunta){
        GridPane panel = new GridPane();
        Stage nueva_ventana = new Stage();
        //Bloquea actividad en otras ventanas.
        nueva_ventana.initModality( Modality.APPLICATION_MODAL );
        nueva_ventana.setTitle( titulo );
        nueva_ventana.setMinWidth(350);
        nueva_ventana.setMinHeight(350);


        Label label = new Label();
        label.setText( pregunta );
        label.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(0), new Insets(0))));
        label.setTextFill(Color.WHITE);
        label.setAlignment(Pos.CENTER);

        Button botonSi = new Button( "Si");
        botonSi.setOnAction( e -> {
            nueva_ventana.close();
            resultado = true;
        } );


        Button botonNo = new Button( "No");
        botonNo.setOnAction( e -> {
            nueva_ventana.close();
            resultado = false;
        } );

        botonNo.setPrefSize(100, 15);//ancho, largo
        botonSi.setPrefSize(100, 15);

        HBox layout_botones = new HBox();
        VBox layout = new VBox();

        layout_botones.getChildren().addAll(botonSi, botonNo);
        layout_botones.setAlignment(Pos.CENTER);
        layout_botones.setSpacing(10);
        layout.getChildren().addAll(label, layout_botones);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10.0d);

        panel.getChildren().add(layout);
        panel.setAlignment(Pos.CENTER);


        panel.setBackground(new Background(new BackgroundFill(Color.web("#788895"), new CornerRadii(0), new Insets(0))));


        Scene escena  = new Scene(panel);
        nueva_ventana.setScene( escena );

        //Para volver a la ventana anterior, pide cerrar la ventana.
        nueva_ventana.showAndWait();
        return resultado;
    }
}
