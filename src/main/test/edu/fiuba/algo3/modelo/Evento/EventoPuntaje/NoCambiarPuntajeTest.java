package edu.fiuba.algo3.modelo.Evento.EventoPuntaje;

import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.NoCambiarPuntaje;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoCambiarPuntajeTest {
    @Test
    public void actualizarElPuntajeYElMovimientoNoFueAfectado(){
        Movimiento puntaje = new Movimiento(0);
        NoCambiarPuntaje cambioPuntaje = new NoCambiarPuntaje();

        Movimiento resultado = cambioPuntaje.actualizarPuntaje(puntaje);
        Movimiento esperado = puntaje;

        assertEquals(esperado, resultado);
    }
    @Test
    public void comparacionEntreDosEventosNoCambiarPuntaje(){
        NoCambiarPuntaje evento1 = new NoCambiarPuntaje();
        NoCambiarPuntaje evento2 = new NoCambiarPuntaje();
        assertEquals(evento1, evento2);

    }
}