package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorMenu {

    BotonJugar botonJugar = new BotonJugar();
    BotonRanking botonRanking = new BotonRanking();
    BotonInstrucciones botonInstruciones = new BotonInstrucciones();
    BotonSalir botonSalir = new BotonSalir();
    BotonHelpPls botonHelpPls = new BotonHelpPls();

    private Stage stage;
    public ContenedorMenu(Stage stage) {
        this.stage=stage;
    }


    public void mostrar() {

        botonJugar.iniciar();
        botonRanking.iniciar();
        botonInstruciones.iniciar();
        botonSalir.iniciar();
        botonHelpPls.iniciar();


        VBox root = new VBox();
        root.getChildren().addAll(botonJugar.obtenerBoton(),botonRanking.obtenerBoton(),botonInstruciones.obtenerBoton(),botonSalir.obtenerBoton(),botonHelpPls.obtenerBoton());
        root.setAlignment(Pos.BASELINE_CENTER);
        Scene menu = new Scene(root, 640,480);
        VBox.setMargin(botonJugar.obtenerBoton(),new Insets(80,10,10,10));
        VBox.setMargin(botonRanking.obtenerBoton(),new Insets(15,10,10,10));
        VBox.setMargin(botonInstruciones.obtenerBoton(),new Insets(15,10,10,10));
        VBox.setMargin(botonSalir.obtenerBoton(),new Insets(15,10,10,10));
        VBox.setMargin(botonHelpPls.obtenerBoton(),new Insets(150,0,0,500));


        stage.setScene(menu);
        stage.show();

    }
}
