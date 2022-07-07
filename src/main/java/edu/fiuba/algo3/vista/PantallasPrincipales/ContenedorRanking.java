package edu.fiuba.algo3.vista.PantallasPrincipales;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.List;

import static javafx.scene.paint.Color.*;

public class ContenedorRanking {
    private Stage stage;
    private List<Pair<String,String>> ranking;

    public ContenedorRanking(Stage stage, List<Pair<String,String>> ranking) {
        this.stage = stage;
        this.ranking = ranking;
        this.iniciar();
    }

    private void iniciar(){
        Label participantes = new Label();
        Label movimientos = new Label();
        Separator lineaSeparador = new Separator();
        VBox cajaGlobal = new VBox();

        participantes.setText("Nombre");
        participantes.setFont(new Font(14));
        participantes.setAlignment(Pos.TOP_CENTER);
        participantes.setBackground(new Background(new BackgroundFill(TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        participantes.setTextFill(WHITE);
        participantes.setPadding(new Insets(5));

        movimientos.setText("Total Movimiento Usados");
        movimientos.setFont(new Font(14));
        movimientos.setAlignment(Pos.TOP_CENTER);
        movimientos.setBackground(new Background(new BackgroundFill(TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        movimientos.setTextFill(WHITE);
        movimientos.setPadding(new Insets(5));

        /*
         * guardé este espacio para ver la forma de mostrar
         * el texto ponderado de los jugadores
         * */
        VBox cajaDeTextoInformativo = new VBox();
        //TODO: Emprolijar.
        for(Pair<String,String> info : this.ranking){
            Text nombre = new Text( info.getKey() );
            Text puntaje = new Text( info.getValue() );
            HBox registro = new HBox();
            registro.getChildren().addAll(nombre, puntaje);
            registro.setSpacing(150);
            registro.setAlignment(Pos.CENTER);
            cajaDeTextoInformativo.getChildren().add(registro);
        }

        HBox cajaNombresPrincipales = new HBox();
        cajaNombresPrincipales.getChildren().addAll(participantes, movimientos);
        cajaNombresPrincipales.setSpacing(150);
        cajaNombresPrincipales.setAlignment(Pos.CENTER);

        Button btnVolver = new Button("Volver al Menu");

        HBox buttomControls = new HBox();
        VBox.setMargin( buttomControls, new Insets(10.0d) );
        buttomControls.setAlignment( Pos.BOTTOM_CENTER );
        btnVolver.setOnAction( e -> new ContenedorMenu(this.stage) );
        buttomControls.getChildren().add( btnVolver);

        /*
         *Cuando se rellene la cajaDeTextoInformativo se debe
         *cambiar el new Insets(0.0d, 10.0d, 10.0d, 10.0d) para mayor prolijidad.
         * */
        VBox.setMargin( cajaDeTextoInformativo, new Insets(0.0d, 10.0d, 10.0d, 10.0d) );
        VBox.setVgrow( cajaDeTextoInformativo, Priority.ALWAYS );

        cajaGlobal.getChildren().addAll(cajaNombresPrincipales, lineaSeparador, cajaDeTextoInformativo, buttomControls);
        cajaGlobal.setPadding(new Insets(10));

        GridPane panel = new GridPane();
        panel.getChildren().add(cajaGlobal);
        panel.setAlignment(Pos.TOP_CENTER);

        panel.setBackground(new Background(new BackgroundFill(web("#3e4e5a"), new CornerRadii(0), new Insets(0))));

        Scene confg = new Scene(panel, 640,480);
        this.stage.setScene(confg);
        this.stage.show();

    }

    /*
        CODIGO ANTERIOR:

            // Implementar contenido de la ventana del ranking.txt
            Button botonVolverMenu = new Button( "Volver al menu.");
            botonVolverMenu.setOnAction( e -> new ContenedorMenu(this.stage) );
            VBox layout = new VBox();
            layout.getChildren().addAll(botonVolverMenu);
            layout.setAlignment(Pos.CENTER);
            // Va a tener la lista de ranking.txt. como diferenciamos por tamaño del mapa??
            Scene contenido = new Scene( layout );
            this.stage.setScene( contenido );
            this.stage.show();
     */
}
