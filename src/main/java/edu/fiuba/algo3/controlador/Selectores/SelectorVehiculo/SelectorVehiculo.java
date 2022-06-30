package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

public class SelectorVehiculo implements EventHandler<ActionEvent> {
    private IVehiculo eleccionVehiculo;
    private final ComboBox lista;

    public SelectorVehiculo(ComboBox lista , IVehiculo vehiculoJugador) {
        this.lista = lista;
        this.eleccionVehiculo = vehiculoJugador;
        System.out.println("Valor inicial lista:" + lista.getValue());
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if( !lista.getValue().equals(null) ){
            String valor = String.valueOf(lista.getValue());
            if( valor == "Auto"){
                eleccionVehiculo = new Auto();
            }else if( valor == "Moto"){
                eleccionVehiculo = new Moto();
            }else if( valor == "4x4"){
                eleccionVehiculo = new CuatroPorCuatro();
            }
        }
    }
}
