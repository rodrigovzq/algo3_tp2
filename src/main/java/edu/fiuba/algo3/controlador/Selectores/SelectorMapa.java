package edu.fiuba.algo3.controlador.Selectores;

import edu.fiuba.algo3.modelo.Mapa.Mapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SelectorMapa implements EventHandler<ActionEvent> {

    private Mapa mapa;
    private final Integer ancho;
    private final Integer alto;

    public SelectorMapa(Mapa mapa, Integer ancho, Integer alto) {
        this.mapa = mapa;
        this.ancho = ancho;
        this.alto = alto;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        mapa.setAltura(this.alto);
        mapa.setAncho(this.ancho);
    }
}
