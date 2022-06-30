package edu.fiuba.algo3.controlador.Selectores.SelectorVehiculo;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;

public class SelectorAuto extends SelectorVehiculo{
    public SelectorAuto(Menu lista, Jugador jugador) {
        super(lista, jugador);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        IVehiculo auto = new Auto();
        this.actualizarVehiculo( auto );
    }
}
