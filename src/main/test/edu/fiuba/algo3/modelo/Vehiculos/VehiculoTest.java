package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Excepcion.VehiculoInvalido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehiculoTest {
    @Test
    public void esCapazDeCrearClasesIVehiculoDesdeUnString(){
        String nombre = "Moto";
        IVehiculo vehiculo = Vehiculo.crearVehiculoDesdeString(nombre);
        assertEquals( new Moto(), vehiculo);
        nombre = "Auto";
        vehiculo = Vehiculo.crearVehiculoDesdeString(nombre);
        assertEquals( new Auto(), vehiculo);
        nombre = "CuatroPorCuatro";
        vehiculo = Vehiculo.crearVehiculoDesdeString(nombre);
        assertEquals( new CuatroPorCuatro(), vehiculo);
        nombre = "CuatroPorCuatroo";
        assertThrows( VehiculoInvalido.class, () -> Vehiculo.crearVehiculoDesdeString("CuatroPorCuatroo"));
    }

    @Test
    public void enCasoDeNoExistirElArgumentoLanzaVehiculoInvalido(){
        String nombre = "CuatroPorCuatroo";
        assertThrows( VehiculoInvalido.class, () -> Vehiculo.crearVehiculoDesdeString(nombre));
    }
}