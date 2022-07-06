package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Observador;
import javafx.scene.image.Image;

public class JugadorVista implements Observador {

    private MapaVista mapa;
    private Jugador jugador;

    private Coordenada posicion;

    private Image vehiculo;

    public JugadorVista(Jugador jugador, MapaVista vista) {
        this.jugador = jugador;
        this.posicion = jugador.getPosicion();
        this.mapa = vista;
        this.jugador.agregarObservador(this);

        vehiculo = new Image("file:src/main/java/edu/fiuba/algo3/vista/assets/vehiculos/" + jugador.getVehiculo().imprimir() + ".png");
        mapa.agregarVistaEnMapa(vehiculo, jugador.getPosicion());
    }

    private void dibujarVehiculo() {
        Image icono = new Image("file:src/main/java/edu/fiuba/algo3/vista/assets/vehiculos/" + jugador.getVehiculo().imprimir() + ".png");
        mapa.agregarVistaEnMapa(icono, jugador.getPosicion());
    }

    public void moverJugador() {
        mapa.limpiarRectangulo(posicion, 25, 25);
        mapa.redibujarEn(posicion);
        dibujarVehiculo();
        posicion = jugador.getPosicion();
    }
    @Override
    public void actualizar() {
        moverJugador();
        mapa.modificarPuntaje(jugador.getPuntaje());
    }
}
