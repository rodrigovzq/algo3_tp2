package edu.fiuba.algo3.controlador.Musica;

public class Musica {

    public void play(String rutaMusica, String nombreMusica) {
        new ControladorMusica(rutaMusica + nombreMusica,new ReproductorMusica());
    }
}
