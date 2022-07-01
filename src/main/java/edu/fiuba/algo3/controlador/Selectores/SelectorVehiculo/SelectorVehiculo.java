package edu.fiuba.algo3.controlador.Selectores.SelectorVehiculo;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;

public abstract class SelectorVehiculo implements EventHandler<ActionEvent> {
    private final Menu lista;
    private final Jugador jugador;

    public SelectorVehiculo(Menu lista, Jugador jugador ) {
        this.lista = lista;
        this.jugador = jugador;
    }

    public void actualizarMenu( IVehiculo v){
        lista.setText( v.toString() );
    }

    public void actualizarVehiculo( IVehiculo v){
        this.jugador.setVehiculo( v );
        this.actualizarMenu( v );
    }
}
