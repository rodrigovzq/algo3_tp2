package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.GuardarYMenu;
import edu.fiuba.algo3.controlador.MostrarRanking;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vista.PantallasPrincipales.ContenedorMenu;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class OpcionesGanadorVista extends HBox {
    private Button volverMenu = new Button("Volver al menu");
    private Button ranking = new Button("Ver ranking");

    public OpcionesGanadorVista(Stage s) {
        setSpacing(30.0d);
        setAlignment(Pos.CENTER);
        OpcionesGanadorVista.setMargin(volverMenu, new Insets(10, 10, 10, 10));
        OpcionesGanadorVista.setMargin(ranking, new Insets(10, 10, 10, 10));
        volverMenu.setOnAction(e -> new ContenedorMenu(s));
        ranking.setOnAction(new MostrarRanking(s));
        getChildren().addAll(volverMenu, ranking);
    }
}
