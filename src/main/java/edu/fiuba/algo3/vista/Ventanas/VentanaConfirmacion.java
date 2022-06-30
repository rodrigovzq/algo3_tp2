package edu.fiuba.algo3.vista.Ventanas;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaConfirmacion {
    public static boolean resultado = false;
    public static boolean mostrar(String titulo, String pregunta){
        Stage nueva_ventana = new Stage();
        //Bloquea actividad en otras ventanas.
        nueva_ventana.initModality( Modality.APPLICATION_MODAL );
        nueva_ventana.setTitle( titulo );
        nueva_ventana.setMinWidth(350);
        nueva_ventana.setMinHeight(60);

        Label label = new Label();
        label.setText( pregunta );

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

        HBox layout_botones = new HBox();
        VBox layout = new VBox();

        layout_botones.getChildren().addAll(botonSi, botonNo);
        layout_botones.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label, layout_botones);
        layout.setAlignment(Pos.CENTER);

        Scene escena  = new Scene(layout);
        nueva_ventana.setScene( escena );

        //Para volver a la ventana anterior, pide cerrar la ventana.
        nueva_ventana.showAndWait();
        return resultado;
    }
}
