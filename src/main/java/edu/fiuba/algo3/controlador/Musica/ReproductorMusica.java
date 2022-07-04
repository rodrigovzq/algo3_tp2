package edu.fiuba.algo3.controlador.Musica;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

import java.io.File;
import java.net.URI;

public class ReproductorMusica {
    private AudioClip temaEscuchandose;

    public ReproductorMusica(){
        String direccionMusicaInicio = "/src/main/java/edu/fiuba/algo3/Recursos/musicaa/pantallasPrincipales.mp3";
        temaEscuchandose = reproducirTema(direccionMusicaInicio);
    }

    public void escucharTema(String direccion) {//para cambiar la musica
        if(temaEscuchandose.isPlaying()){
            temaEscuchandose.stop();
        }
        if(!direccion.isEmpty()){
            temaEscuchandose = reproducirTema(direccion);
        }
    }

    private AudioClip reproducirTema(String direccion){
        File dir = new File(System.getProperty("user.dir") + direccion);
        URI path = dir.toURI();
        String direccionParaMedia = path.toString();
        Media musica = new Media(direccionParaMedia);
        AudioClip mediaPlayer = new AudioClip(musica.getSource());
        mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
        mediaPlayer.play();
        mediaPlayer.setVolume(4);
        return  mediaPlayer;
    }
}
