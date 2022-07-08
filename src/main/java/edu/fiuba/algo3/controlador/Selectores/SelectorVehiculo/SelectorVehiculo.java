package edu.fiuba.algo3.controlador.Selectores.SelectorVehiculo;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;

public class SelectorVehiculo implements EventHandler<ActionEvent> {
    private final Menu lista;
    private final Jugador jugador;
    private IVehiculo vehiculo;

    public SelectorVehiculo(Menu lista, String vehiculoSeleccionado, Jugador jugador ) {
        this.lista = lista;
        this.jugador = jugador;
        //Esta bajo control debido a que nosotros ponemos que Vehiculos puede seleccionar.
        this.vehiculo = Vehiculo.crearVehiculoDesdeString(vehiculoSeleccionado);
    }

    public void actualizarMenu( IVehiculo v){
        lista.setText( v.toString() );
    }

    public void actualizarVehiculo( IVehiculo v){
        this.jugador.setVehiculo( v );
        this.actualizarMenu( v );
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.actualizarVehiculo( this.vehiculo );
    }
}
