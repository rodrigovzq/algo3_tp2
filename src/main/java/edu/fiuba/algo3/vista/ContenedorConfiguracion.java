package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.CampoTextoEnter;
import edu.fiuba.algo3.controlador.Selectores.SelectorMapa;
import edu.fiuba.algo3.controlador.Selectores.SelectorVehiculo.SelectorAuto;
import edu.fiuba.algo3.controlador.Selectores.SelectorVehiculo.SelectorCuatroPorCuatro;
import edu.fiuba.algo3.controlador.Selectores.SelectorVehiculo.SelectorMoto;
import edu.fiuba.algo3.controlador.Selectores.SelectorVehiculo.SelectorVehiculo;
import edu.fiuba.algo3.controlador.iniciarJuegoControlador;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorConfiguracion {
    VBox root = new VBox();
    Jugador jugador;
    Stage stage;
    private Mapa mapaJuego;

    public ContenedorConfiguracion(Stage stage) {
        this.stage = stage;
        //Valor default de mapa.
        this.mapaJuego = new Mapa(2,2);
        this.mapaJuego.generarMapa();
        //Valor default del jugador.
        this.jugador = new Jugador("", mapaJuego.sortearCeldaJugador(), new Auto());
        this.iniciar();

        //TODO: ¿Que pasa si el usuario no elije nada y va directo a jugar?
        // Es un estado valido, pero una mierda de juego jajaja
    }


    private void iniciar(){
        Button botonJugar = new Button("Jugar");
        //Se genera el mapa, le sortea una celda al jugador y DEBERIA cambiar la ventana a la del juego.
        botonJugar.setOnAction( new iniciarJuegoControlador( this.stage, this.jugador, this.mapaJuego ));

        Button botonCancelar = new Button("Cancelar");
        //Usamos la f. anonima para hacer el cambio de vista.
        botonCancelar.setOnAction( e -> new ContenedorMenu( this.stage )  );

        Label nombre = new Label("Nombre");
        nombre.setFont(new Font(15));


        Label vehiculo = new Label("Vehiculo");
        vehiculo.setFont(new Font(15));


        Label mapa = new Label("Mapas");
        mapa.setFont(new Font(15));

        TextField campoNombre = new TextField();
        //CampoTextoEnter la gracia es que detecta el ENTER y "valida" si es valido el
        //nombre
        //TODO: Validaciones nombres en CampoTextoEnter.
        CampoTextoEnter enterNombre = new CampoTextoEnter(campoNombre, this.jugador);
        enterNombre.setMensajeIncorrecto("Ingresá un nombre válido.");
        campoNombre.setOnKeyPressed( enterNombre );
        campoNombre.setMinWidth(200);
        campoNombre.setPromptText("Ingrese un nombre");


        Group listaVehiculo = emitirOpcionesVehiculos();

        //Cada selector de mapa, sabe setear el ancho y el alto del mapa
        //NO se vuelve a generar el mapa en cada selector, se genera recien
        //cuando el usuario clickea "Jugar".
        Button boton10X20 = new Button("10x20"); ;
        boton10X20.setOnAction(new SelectorMapa(mapaJuego, 10 ,20 ));
        boton10X20.setCursor(Cursor.HAND);
        boton10X20.setPrefSize(100,100);

        Button boton20X30 = new Button("20X30");
        boton20X30.setOnAction(new SelectorMapa(mapaJuego, 20 ,30 ));
        boton20X30.setCursor(Cursor.HAND);
        boton20X30.setPrefSize(100,100);

        Button boton30X30 = new Button("30X30");
        boton30X30.setOnAction(new SelectorMapa(mapaJuego, 30 ,30 ));
        boton30X30.setCursor(Cursor.HAND);
        boton30X30.setPrefSize(100,100);

        Button boton30X40 = new Button("30X40");
        boton30X40.setOnAction(new SelectorMapa(mapaJuego, 30 ,40 ));
        boton30X40.setCursor(Cursor.HAND);
        boton30X40.setPrefSize(100,100);

        HBox layout_nombre = new HBox();
        HBox layout_vehiculo = new HBox();
        HBox layout_mapas_1 = new HBox();
        HBox layout_mapas2 = new HBox();
        HBox layout_salir_jugar = new HBox();

        layout_nombre.getChildren().addAll(nombre, campoNombre);
        layout_nombre.setAlignment(Pos.CENTER);

        layout_vehiculo.getChildren().addAll(vehiculo, listaVehiculo);
        layout_vehiculo.setAlignment(Pos.CENTER);

        layout_mapas_1.getChildren().addAll(boton10X20, boton20X30);
        layout_mapas_1.setAlignment(Pos.CENTER);

        layout_mapas2.getChildren().addAll(boton30X30, boton30X40);
        layout_mapas2.setAlignment(Pos.CENTER);

        layout_salir_jugar.getChildren().addAll(botonCancelar, botonJugar);

        root.getChildren().addAll(layout_nombre,layout_vehiculo,mapa,layout_mapas_1,layout_mapas2, layout_salir_jugar);

        HBox.setMargin(boton10X20,new Insets(10,10,10,10));
        HBox.setMargin(boton20X30,new Insets(15,10,10,10));
        HBox.setMargin(boton30X30,new Insets(15,10,10,10));
        HBox.setMargin(boton30X40,new Insets(15,10,10,10));

        HBox.setMargin(botonCancelar, new Insets(10,100,10,10));
        HBox.setMargin(botonJugar, new Insets(10,10,10,350));

        HBox.setMargin(nombre,new Insets(10,10,10,10));
        HBox.setMargin(campoNombre,new Insets(10,10,10,10));
        HBox.setMargin(vehiculo,new Insets(10,10,10,10));
        HBox.setMargin(listaVehiculo,new Insets(10,10,10,10));
        root.setAlignment(Pos.CENTER);

        Scene config = new Scene(root, 640,480);

        this.stage.setScene( config );
        this.stage.show();
    }

    private Group emitirOpcionesVehiculos() {
        Menu fileMenu = new Menu("Vehiculo");

        // Basicamente cada selector sabe como inicializar el vehiculo del jugador
        // y modificar el texto de fileMenu.
        SelectorVehiculo selectorItem1 = new SelectorAuto( fileMenu, this.jugador);
        SelectorVehiculo selectorItem2 = new SelectorMoto( fileMenu, this.jugador);
        SelectorVehiculo selectorItem3 = new SelectorCuatroPorCuatro( fileMenu, this.jugador);

        MenuItem item1 = new MenuItem("Auto");
        item1.setOnAction( selectorItem1 );

        MenuItem item2 = new MenuItem("Moto");
        item2.setOnAction( selectorItem2 );

        MenuItem item3 = new MenuItem("4 X 4");
        item3.setOnAction( selectorItem3 );

        fileMenu.getItems().addAll(item1, item2, item3);
        MenuBar menuBar = new MenuBar(fileMenu);

        menuBar.setTranslateX(200);
        menuBar.setTranslateY(20);

        Group root = new Group(menuBar);
        return root;

    }
}
