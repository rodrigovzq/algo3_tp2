package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.Victoria;
import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.EstadoCelda.EstadoCelda;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Observador;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Objects;

public class PorcionMapaVista extends Canvas implements Observador {

    private Jugador jugador;
    private Coordenada posicionMeta;
    private Stage stage;
    public PorcionMapaVista(Mapa mapa, Jugador jugador, Stage stage) {
        super(55 * mapa.getAncho() + 5, 55 * mapa.getAltura() + 5);
        this.jugador = jugador;
        this.stage = stage;

        jugador.agregarObservador(this);
        GraphicsContext contexto = getGraphicsContext2D();
        contexto.setFill(Color.BLACK);
        contexto.fillRect(0, 0, 55 * mapa.getAncho() + 5, 55 * mapa.getAltura() + 5);
        contexto.clearRect((jugador.getPosicion().getPosX() + 1) * 52.5 - 250/2,  (jugador.getPosicion().getPosY() + 1) * 49 - 250/2, 250, 250);
        posicionMeta = mapa.getMeta();
        contexto.clearRect((posicionMeta.getPosX() + 1) * 52.5 - 25, (posicionMeta.getPosY() + 1) * 49 - 25, 50,50);
    }

    @Override
    public void actualizar() {
        GraphicsContext contexto = getGraphicsContext2D();
        contexto.clearRect(0,0, getWidth(), getHeight());
        contexto.fillRect(0, 0, getWidth(), getHeight());
        contexto.clearRect((posicionMeta.getPosX() + 1) * 52.5 - 25, (posicionMeta.getPosY() + 1) * 49 - 25, 50,50);
        contexto.clearRect((jugador.getPosicion().getPosX() + 1) * 52.5 - 250/2,  (jugador.getPosicion().getPosY() + 1) * 49 - 250/2, 250, 250);
    }
}
