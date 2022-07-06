package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Observador;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PorcionMapaVista extends Canvas implements Observador {

    private Jugador jugador;

    public PorcionMapaVista(Mapa mapa, Jugador jugador) {
        super(55 * mapa.getAncho() + 5, 55 * mapa.getAltura() + 5);
        this.jugador = jugador;
        jugador.agregarObservador(this);
        GraphicsContext contexto = getGraphicsContext2D();
        contexto.setFill(Color.BLACK);
        contexto.fillRect(0, 0, 55 * mapa.getAncho() + 5, 55 * mapa.getAltura() + 5);
        contexto.clearRect((jugador.getPosicion().getPosX() + 1) * 52.5 - 250/2,  (jugador.getPosicion().getPosY() + 1) * 49 - 250/2, 250, 250);
    }

    @Override
    public void actualizar() {
        GraphicsContext contexto = getGraphicsContext2D();
        contexto.clearRect(0,0, getWidth(), getHeight());
        contexto.fillRect(0, 0, getWidth(), getHeight());
        contexto.clearRect((jugador.getPosicion().getPosX() + 1) * 52.5 - 250/2,  (jugador.getPosicion().getPosY() + 1) * 49 - 250/2, 250, 250);
    }
}
