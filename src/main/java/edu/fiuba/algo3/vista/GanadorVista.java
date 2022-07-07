package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.Musica.Musica;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.TRANSPARENT;
import static javafx.scene.paint.Color.WHITE;

public class GanadorVista {

    private final Stage stage;

    GridPane panel = new GridPane();
    HBox caja = new HBox();
    Label label = new Label();

    public GanadorVista(Stage stage) {
        this.stage = stage;
    }

    public void mostrar() {


        Image imagenPapelPicado = new Image("file:" + System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/Recursos/imagenes/confeti.gif");
        ImageView imageviewpapel = new ImageView(imagenPapelPicado);
        imageviewpapel.setFitHeight(480);
        imageviewpapel.setFitWidth(640);

        label.setText("Felicidades Ganaste el juego!!!");
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font(20));
        label.setBackground(new Background(new BackgroundFill(TRANSPARENT, new CornerRadii(8), new Insets(0))));
        label.setTextFill(WHITE);

        caja.getChildren().add(label);
        caja.setSpacing(10.0d);
        caja.setAlignment(Pos.CENTER);
        caja.setBackground(new Background(new BackgroundFill(TRANSPARENT, new CornerRadii(8), new Insets(0))));

        panel.setBackground(new Background(new BackgroundFill(Color.web("#081218"), new CornerRadii(0), new Insets(0))));
        panel.getChildren().addAll(imageviewpapel, caja);

        Scene ganador = new Scene(panel, 640,480);
        this.stage.setScene(ganador);
        this.stage.show();

    }
}
