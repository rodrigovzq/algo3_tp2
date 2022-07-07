package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Excepcion.DireccionInvalida;
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
        Evento resultado = null;
        try{
            if(keyEvent.getCode() == KeyCode.W ){
                resultado = jugador.avanzarHaciaLaDireccion(Direccion.NORTE);
            }else if(keyEvent.getCode() == KeyCode.A ){
                resultado = jugador.avanzarHaciaLaDireccion(Direccion.OESTE);
            }else if(keyEvent.getCode() == KeyCode.S ){
                resultado = jugador.avanzarHaciaLaDireccion(Direccion.SUR);
            }else if(keyEvent.getCode() == KeyCode.D ){
                resultado = jugador.avanzarHaciaLaDireccion(Direccion.ESTE);
            }
            if(resultado != null)
                jugador.actualizar(resultado);
        }catch (DireccionInvalida e){
            System.out.println("Ha alcanzado uno de los bordes del mapa, no puede avanzar.");
        }catch (Exception e){
            System.out.println("Que?");
        }

    }
}
