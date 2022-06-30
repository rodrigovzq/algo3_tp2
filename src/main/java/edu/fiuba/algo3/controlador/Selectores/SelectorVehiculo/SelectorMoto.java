package edu.fiuba.algo3.controlador.Selectores.SelectorVehiculo;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;

public class SelectorMoto extends SelectorVehiculo{
    public SelectorMoto(Menu lista, Jugador jugador) {
        super(lista, jugador);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        IVehiculo moto = new Moto();
        this.actualizarVehiculo( moto );
    }
}
