package edu.fiuba.algo3.vista.PantallasPrincipales;

import edu.fiuba.algo3.controlador.Cerrar.CerrarJuegoBoton;
import edu.fiuba.algo3.controlador.Cerrar.CerrarJuegoVentana;
import edu.fiuba.algo3.controlador.Musica.ControladorMusica;
import edu.fiuba.algo3.controlador.Musica.Musica;
import edu.fiuba.algo3.controlador.Musica.ReproductorMusica;
import edu.fiuba.algo3.vista.Ventanas.VentanaPopUp;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ContenedorMenu {

    private Stage stage;

    Button botonJugar = new Button("Jugar");
    Button botonRanking = new Button("Ranking");
    Button botonSalir = new Button("Salir");
    Button botonInstruciones = new Button("Instrucciones");
    Button botonHelpPls = new Button("help pls");
    GridPane panel = new GridPane();




    public ContenedorMenu(Stage stage) {
        this.stage = stage;
        this.iniciar();

    }


    private void iniciar(){


        botonJugar.setOnAction( e -> new ContenedorConfiguracion( this.stage )  );
        botonRanking.setOnAction( e -> new ContenedorRanking( this.stage ));
        //TODO: La idea es que sea una ventana Pop Up que muestre las instrucciones.
        botonInstruciones.setOnAction( e -> ContenedorInstrucciones.mostrar());

        //Creo los controladores
        CerrarJuegoVentana cerrarVentana = new CerrarJuegoVentana( botonSalir );
        CerrarJuegoBoton cerrarBoton = new CerrarJuegoBoton( this.stage );
        //Accion al cerrar la ventana con la X
        stage.setOnCloseRequest( cerrarVentana );
        botonSalir.setOnAction( cerrarBoton );

        //TODO: Ver si sirve para algo o no.
        botonHelpPls.setOnAction( e -> VentanaPopUp.mostrar("Help", "No se como ayudarte") );


        VBox root = new VBox();
        root.getChildren().addAll(botonJugar,botonRanking,botonInstruciones,botonSalir,botonHelpPls);
        root.setAlignment(Pos.BASELINE_CENTER);

        VBox.setMargin(botonJugar,new Insets(80,10,10,10));
        VBox.setMargin(botonRanking,new Insets(15,10,10,10));
        VBox.setMargin(botonInstruciones,new Insets(15,10,10,10));
        VBox.setMargin(botonSalir,new Insets(15,10,10,10));
        VBox.setMargin(botonHelpPls,new Insets(150,0,0,500));

        panel.getChildren().add(root);
        panel.setAlignment(Pos.CENTER);

        /*
         * Para las paletas de colores usé de esta pagina:
         *  https://paletadecolores.online/colors/172631/
         * */
        panel.setBackground(new Background(new BackgroundFill(Color.web("#081218"), new CornerRadii(0), new Insets(0))));

        Scene menu = new Scene(panel, 640,480);
        this.stage.setScene(menu);
        this.stage.show();
    }



}
