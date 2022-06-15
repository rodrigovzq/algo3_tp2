package edu.fiuba.algo3.modelo.Celda.Obstaculo.Evento.EventoPuntaje;

import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.NoCambiarPuntaje;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoCambiarPuntajeTest {
    @Test
    public void actulizoElPuntajeYElMovimientoNoFueAfectado(){
        Movimiento puntaje = new Movimiento(0);
        NoCambiarPuntaje cambioPuntaje = new NoCambiarPuntaje();

        Movimiento resultado = cambioPuntaje.actualizarPuntaje(puntaje);
        Movimiento esperado = puntaje;

        assertEquals(esperado, resultado);
    }
}