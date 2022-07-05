package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vista.PantallasPrincipales.ContenedorConfiguracion;
import edu.fiuba.algo3.vista.Ventanas.VentanaConfirmacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.io.File;

public class VerificarRenaudarPartida implements EventHandler<ActionEvent> {
    private final Stage stage;

    public VerificarRenaudarPartida(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String pathJugador = Juego.PATH_JUGADOR_TXT;
        String pathMapa = Juego.PATH_MAPA_TXT;
        File fileJugador = new File( pathJugador );
        File fileMapa = new File( pathMapa );

        //if: existen los archivos jugador.txt y mapa.txt
        if( fileJugador.exists() && fileMapa.exists() ){
            //  pop up - preguntar si quiere renaudar la partida
            boolean resultado = VentanaConfirmacion.mostrar( "Renaudar partida", "Tiene una partida guardada ¿Desea renaudar la partida?");
            if( resultado ) {
                EventHandler<ActionEvent> handler = new IniciarJuegoControlador(this.stage);
                handler.handle(actionEvent);
            }else{
                fileJugador.delete();
                fileMapa.delete();
                new ContenedorConfiguracion(this.stage);
            }
        }else{
            //si no entró, mando a Configuracion
            new ContenedorConfiguracion(this.stage);
        }


    }
}
