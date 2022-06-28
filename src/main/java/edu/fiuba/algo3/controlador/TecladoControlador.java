package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

//Controlador que tiene el juego. Es decir, el ContenedorJuego va estar
//escuchando el teclado del usuario y este controlador sabe que hacer.
public class TecladoControlador implements EventHandler<KeyEvent> {
    private Jugador jugador;
    public TecladoControlador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        try{
            if(keyEvent.getCode() == KeyCode.W ){
                jugador.avanzarHaciaLaDireccion(Direccion.NORTE);
            }
            if(keyEvent.getCode() == KeyCode.A ){
                jugador.avanzarHaciaLaDireccion(Direccion.OESTE);
            }
            if(keyEvent.getCode() == KeyCode.S ){
                jugador.avanzarHaciaLaDireccion(Direccion.SUR);
            }
            if(keyEvent.getCode() == KeyCode.D ){
                jugador.avanzarHaciaLaDireccion(Direccion.ESTE);
            }
        }catch (Exception e){}

    }
}
