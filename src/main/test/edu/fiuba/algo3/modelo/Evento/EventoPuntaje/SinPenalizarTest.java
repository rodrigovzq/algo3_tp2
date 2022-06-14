package edu.fiuba.algo3.modelo.Evento.EventoPuntaje;

import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinPenalizarTest {
    @Test
    public void actualizarPuntajeYSeIncrementaEnUnoElMovimiento(){
        SinPenalizar avanzar = new SinPenalizar();
        Movimiento puntaje = new Movimiento(0);

        Movimiento resultado = avanzar.actualizarPuntaje(puntaje);
        Movimiento esperado = new Movimiento(1);

        assertEquals(esperado, resultado);
    }
}