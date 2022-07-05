package edu.fiuba.algo3.controlador;

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
        String pathJugador = "saves/jugador.txt";
        String pathMapa = "saves/mapa.txt";
        File fileJugador = new File( pathJugador );
        File fileMapa = new File( pathMapa );

        boolean config = false;
        //if: existen los archivos jugador.txt y mapa.txt
        if( fileJugador.exists() && fileMapa.exists() ){
            //  pop up - preguntar si quiere renaudar la partida
            boolean resultado = VentanaConfirmacion.mostrar( "Renaudar partida", "Tiene una partida guardada ¿Desea renaudar la partida?");
            if( resultado ) {
                //TODO: inicializar partida
                System.out.println("Iniciar partida.");
                //Habria que llamar al mismo controlador que usa el Juego post configurar.
            }else{
                fileJugador.delete();
                fileMapa.delete();
            }
        }

        //si no entró, mando a Configuracion
        new ContenedorConfiguracion(this.stage);

    }
}
