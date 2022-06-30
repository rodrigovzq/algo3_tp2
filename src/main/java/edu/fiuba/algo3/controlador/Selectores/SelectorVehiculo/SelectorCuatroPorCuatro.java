package edu.fiuba.algo3.controlador.Selectores.SelectorVehiculo;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;

public class SelectorCuatroPorCuatro extends SelectorVehiculo{
    public SelectorCuatroPorCuatro(Menu lista, Jugador jugador) {
        super(lista, jugador);
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        IVehiculo cxc = new CuatroPorCuatro();
        this.actualizarVehiculo( cxc );
    }
}
