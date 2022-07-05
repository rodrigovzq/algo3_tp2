package edu.fiuba.algo3.vista.PantallasPrincipales;

import edu.fiuba.algo3.controlador.CampoTextoEnter;
import edu.fiuba.algo3.controlador.Selectores.SelectorMapa;
import edu.fiuba.algo3.controlador.Selectores.SelectorVehiculo.SelectorVehiculo;
import edu.fiuba.algo3.controlador.IniciarJuegoControlador;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.paint.Color.*;

public class ContenedorConfiguracion {
    private final static Pair<String, String> EMPTY_PAIR = new Pair<>("", "");
    private final ComboBox<Pair<String, String>> account = new ComboBox<>();
    private Mapa mapaJuego;

    Jugador jugador;
    Stage stage;

    Label nombre = new Label("Nombre");
    Label mapa = new Label("Mapas");
    TextField campoNombre = new TextField();
    GridPane panel = new GridPane();

    Button botonCancelar = new Button("Cancelar");
    Button botonJugar = new Button("Jugar");
    Button boton10X20 = new Button("10x20");
    Button boton20X30 = new Button("20X30");
    Button boton30X30 = new Button("30X30");
    Button boton30X40 = new Button("30X40");
    HBox listaVehiculo;



    public ContenedorConfiguracion(Stage stage) {
        this.stage = stage;
        //Valor default de mapa.
        this.mapaJuego = new Mapa(10,20);
        this.mapaJuego.generarMapa();
        //Valor default del jugador.
        this.jugador = new Jugador("DefaultName", null , new Auto());
        this.iniciar();

        //TODO: ¿Que pasa si el usuario no elije nada y va directo a jugar?
        // hay dos opciones:
        // opcion1 = por default el programa elige el mapa (creo que ya se hizo eso xD)
        // opcion2 = el programa no se ejecuta hasta que el usuario eliga algo!!

    }


    private void iniciar(){
        //Se genera el mapa, le sortea una celda al jugador y DEBERIA cambiar la ventana a la del juego.
        botonJugar.setOnAction( new IniciarJuegoControlador( this.stage, this.jugador, this.mapaJuego ));
        botonCancelar.setOnAction( e -> new ContenedorMenu( this.stage )  );//cambio de vista.

        inicializarAparienciaLabelsPrincipal(nombre);
        inicializarAparienciaLabelsPrincipal(mapa);

        //CampoTextoEnter detecta el ENTER y "valida" si es valido el nombre
        //TODO: Validaciones nombres en CampoTextoEnter.
        CampoTextoEnter enterNombre = new CampoTextoEnter(campoNombre, this.jugador);
        enterNombre.setMensajeIncorrecto("Ingresá un nombre válido.");
        campoNombre.setOnKeyPressed( enterNombre );
        campoNombre.setMinWidth(200);
        campoNombre.setPromptText("Ingrese un nombre");

        listaVehiculo = emitirListaDeOpciones();

        inicializarAparienciaBotonesMapas(boton10X20);
        inicializarAparienciaBotonesMapas(boton20X30);
        inicializarAparienciaBotonesMapas(boton30X30);
        inicializarAparienciaBotonesMapas(boton30X40);

        controlBotonesMapa(); //CUIDADO: falta ver la forma de solo escoger un solo boton del mapa
        iniciarTabulacionesDeLosBoxs();

        panel.setAlignment(Pos.CENTER);
        panel.setBackground(new Background(new BackgroundFill(web("#172631"), new CornerRadii(0), new Insets(0))));
        Scene config = new Scene(panel, 640,480);
        this.stage.setScene( config );
        this.stage.show();
    }

    private void controlBotonesMapa() {
        /*
         * Cada selector de mapa, sabe setear el ancho y el alto del mapa
         * NO se vuelve a generar el mapa en cada selector,
         * se genera recien cuando el usuario clickea "Jugar".
         * */

        boton10X20.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                boton10X20.setOnAction(new SelectorMapa(mapaJuego, 10 ,20 ));
                boton10X20.setBackground(new Background(new BackgroundFill(Color.web("#4c5c67"), new CornerRadii(0), new Insets(0))));

            }
        });

        boton20X30.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                boton20X30.setOnAction(new SelectorMapa(mapaJuego, 20 ,30 ));
                boton20X30.setBackground(new Background(new BackgroundFill(Color.web("#4c5c67"), new CornerRadii(0), new Insets(0))));

            }
        });

        boton30X30.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                boton30X30.setOnAction(new SelectorMapa(mapaJuego, 30 ,30 ));
                boton30X30.setBackground(new Background(new BackgroundFill(Color.web("#4c5c67"), new CornerRadii(0), new Insets(0))));

            }
        });

        boton30X40.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                boton30X40.setOnAction(new SelectorMapa(mapaJuego, 30 ,40 ));
                boton30X40.setBackground(new Background(new BackgroundFill(Color.web("#4c5c67"), new CornerRadii(0), new Insets(0))));

            }
        });


    }

    private void iniciarTabulacionesDeLosBoxs() {

        VBox rootVertical = new VBox();
        HBox rootNombreJugador = new HBox();
        HBox rootVehiculos = new HBox();
        HBox rootBotonesDeVeinte = new HBox();
        HBox rootBotonesDeTreinta = new HBox();
        HBox rootBotonesLaterales = new HBox();

        rootNombreJugador.getChildren().addAll(nombre, campoNombre);
        rootNombreJugador.setAlignment(Pos.CENTER);
        rootVehiculos.getChildren().add(listaVehiculo);
        rootVehiculos.setAlignment(Pos.CENTER);
        rootBotonesDeVeinte.getChildren().addAll(boton10X20, boton20X30);
        rootBotonesDeVeinte.setAlignment(Pos.CENTER);
        rootBotonesDeTreinta.getChildren().addAll(boton30X30, boton30X40);
        rootBotonesDeTreinta.setAlignment(Pos.CENTER);
        rootBotonesLaterales.getChildren().addAll(botonCancelar, botonJugar);
        rootVertical.getChildren().addAll(rootNombreJugador,rootVehiculos,mapa,rootBotonesDeVeinte,rootBotonesDeTreinta,rootBotonesLaterales);
        rootVertical.setAlignment(Pos.CENTER);

        HBox.setMargin(boton10X20,new Insets(10,10,10,10));
        HBox.setMargin(boton20X30,new Insets(15,10,10,10));
        HBox.setMargin(boton30X30,new Insets(15,10,10,10));
        HBox.setMargin(boton30X40,new Insets(15,10,10,10));
        HBox.setMargin(botonCancelar,new Insets(10,100,10,10));
        HBox.setMargin(botonJugar,new Insets(10,10,10,350));

        rootNombreJugador.setSpacing( 5.0d );
        rootNombreJugador.setAlignment(Pos.CENTER );
        rootNombreJugador.setPadding( new Insets(15) );

        rootVehiculos.setSpacing( 5.0d );
        rootVehiculos.setAlignment(Pos.CENTER );
        rootVehiculos.setPadding( new Insets(2) );

        panel.getChildren().add(rootVertical);

    }

    private void inicializarAparienciaBotonesMapas(Button boton) {

        boton.setBackground(new Background(new BackgroundFill(TRANSPARENT, new CornerRadii(8), new Insets(0))));
        boton.setTextFill(WHITE);
        boton.setBorder(new Border(new BorderStroke(WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), BorderStroke.DEFAULT_WIDTHS)));
        boton.setCursor(Cursor.HAND);
        boton.setPrefSize(100,100);

    }

    private void inicializarAparienciaLabelsPrincipal(Label label) {
        label.setFont(new Font(15));
        label.setTextFill(WHITE);
    }

    private HBox emitirListaDeOpciones() {

        Menu fileMenu = new Menu("Vehiculo");
        Label vehiculo = new Label("Vehiculo");
        this.inicializarAparienciaLabelsPrincipal(vehiculo);
        account.setPrefWidth(80);
        Button saveButton = new Button("Guardar");

        HBox hbox = new HBox(
                vehiculo,
                account,
                saveButton);
        hbox.setSpacing( 10.0d );
        hbox.setAlignment(Pos.CENTER );
        hbox.setPadding( new Insets(20) );

        iniciarCombo();

        saveButton.setOnAction( (evt) -> {
            if( account.getValue().equals(EMPTY_PAIR ) ) {
                System.out.println("No hay ningún elemento seleccionado");
            } else {
                System.out.println("guardando " + account.getValue());

                String seleccionado = account.getValue().getValue();
                EventHandler handler = new SelectorVehiculo( fileMenu, seleccionado , this.jugador);
                handler.handle(evt);
            }
        });

        return hbox;
    }
    private void iniciarCombo() {

        List<Pair<String,String>> accounts = new ArrayList<>();

        accounts.add( new Pair<>("Auto", "Auto") );
        accounts.add( new Pair<>("Moto", "Moto") );
        accounts.add( new Pair<>("4X4", "CuatroPorCuatro") );

        account.getItems().add( EMPTY_PAIR );
        account.getItems().addAll( accounts );
        account.setValue( EMPTY_PAIR );

        Callback<ListView<Pair<String,String>>, ListCell<Pair<String,String>>> factory =
                (lv) ->
                        new ListCell<Pair<String,String>>() {
                            @Override
                            protected void updateItem(Pair<String, String> item, boolean empty) {
                                super.updateItem(item, empty);
                                if( empty ) {
                                    setText("");
                                } else {
                                    setText( item.getKey() );
                                }
                            }
                        };

        account.setCellFactory( factory );
        account.setButtonCell( factory.call( null ) );
    }
}
