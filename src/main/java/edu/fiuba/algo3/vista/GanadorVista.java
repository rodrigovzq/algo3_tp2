package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.Musica.Musica;
import edu.fiuba.algo3.modelo.Juego.Juego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.TRANSPARENT;
import static javafx.scene.paint.Color.WHITE;

public class GanadorVista extends StackPane {

    private final Stage stage;

    Label label = new Label();
    private BorderPane pantalla;

    public GanadorVista(Stage stage) {
        super();
        this.stage = stage;
        this.pantalla = new BorderPane();
    }

    public void mostrar() {
        Image fondo = new Image("file:" + System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/Recursos/imagenes/confeti.gif");
        ImageView fondoPapel = new ImageView(fondo);
        fondoPapel.setFitHeight(stage.getHeight());
        fondoPapel.setFitWidth(stage.getWidth());

        label.setText("      ¡Felicitaciones! \n Has llegado a la meta!");
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font(35));
        label.setBackground(new Background(new BackgroundFill(TRANSPARENT, new CornerRadii(8), new Insets(0))));
        label.setTextFill(WHITE);

        setAlignment(Pos.CENTER);
        setBackground(new Background(new BackgroundFill(TRANSPARENT, new CornerRadii(8), new Insets(0))));
        pantalla.setCenter(label);
        pantalla.setBottom(new OpcionesGanadorVista(stage));
        getChildren().addAll(fondoPapel,pantalla);
        setBackground(new Background(new BackgroundFill(Color.web("#081218"), new CornerRadii(0), new Insets(0))));

        Scene ganador = new Scene(this, 640,480);
        this.stage.setScene(ganador);
        this.stage.show();

    }
}
