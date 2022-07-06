package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Observador;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

// TODO: Hacer algo mas bonito
public class PuntajeVista extends Label implements Observador {
    private Jugador jugador;

    public PuntajeVista(Jugador j) {
        super();
        this.jugador = j;
        this.jugador.agregarObservador(this);
        this.setText("Puntaje: 0");
        this.maxHeight(15);
        this.setMaxWidth(100);
        this.setAlignment(Pos.CENTER);
        this.setScaleX(2);
        this.setScaleY(2);
        this.setTextFill(Color.WHITE);
    }

    @Override
    public void actualizar() {
        setText("Puntaje: " + jugador.getPuntaje().imprimir());
    }
}
