package edu.fiuba.algo3.modelo.Celda.Obstaculo.Evento.EventoVehiculo;

import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.NoCambiarVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoCambiarVehiculoTest {
    @Test
    public void actualizarVehiculoYElVehiculoSigueSiendoElMismo(){
        NoCambiarVehiculo cambioVehiculo = new NoCambiarVehiculo();
        IVehiculo v = new Auto();

        IVehiculo resultado = cambioVehiculo.actualizarVehiculo(v);
        IVehiculo esperado = v;

        assertEquals(esperado, resultado);
    }
}