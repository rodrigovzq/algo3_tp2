package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Observador;
import javafx.scene.image.Image;

public class JugadorVista implements Observador {

    private MapaVista mapa;
    private Jugador jugador;

    private Image vehiculo;

    public JugadorVista(Jugador jugador, MapaVista vista) {
        this.jugador = jugador;
        this.mapa = vista;
    }
    @Override
    public void actualizar() {

    }
}
