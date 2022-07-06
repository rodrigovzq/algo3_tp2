package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

// TODO: Hacer algo mas bonito
public class PuntajeVista extends Label {
    public PuntajeVista() {
        super();
        this.setText("Puntaje: 0");
        this.maxHeight(15);
        this.setMaxWidth(100);
        this.setAlignment(Pos.CENTER);
        this.setScaleX(2);
        this.setScaleY(2);
        this.setTextFill(Color.WHITE);
    }

    public void actualizar(Movimiento nuevoPuntaje) {
        this.setText("Puntaje" + nuevoPuntaje.imprimir());
    }
}
