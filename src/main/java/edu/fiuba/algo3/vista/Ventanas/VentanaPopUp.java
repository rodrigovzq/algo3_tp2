package edu.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaPopUp {


    public static void mostrar(String titulo, String mensaje){
        Stage nueva_ventana = new Stage();

        //Bloquea actividad en otras ventanas.
        nueva_ventana.initModality( Modality.APPLICATION_MODAL );
        nueva_ventana.setTitle( titulo );
        nueva_ventana.setMinWidth(500);
        nueva_ventana.setMinHeight(500);

        Label label = new Label();
        label.setText( mensaje );

        Button botonCerrar = new Button( "Cerrar");
        botonCerrar.setOnAction( e -> nueva_ventana.close() );

        VBox layout = new VBox();

        layout.getChildren().addAll(label, botonCerrar);
        layout.setAlignment(Pos.CENTER);

        Scene escena  = new Scene(layout);
        nueva_ventana.setScene( escena );
        //Para volver a la ventana anterior, pide cerrar la ventana.
        nueva_ventana.showAndWait();
    }
}
