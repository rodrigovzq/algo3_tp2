package edu.fiuba.algo3.modelo.Celda.Obstaculo.Evento.EventoPuntaje;

import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.Penalizacion;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PenalizacionTest {
    @Test
    public void actualizarPuntajeYSeAplicaLaPenalizacion(){
        Penalizacion penalizacion = new Penalizacion(5);
        Movimiento puntaje = new Movimiento(0);

        Movimiento resultado = penalizacion.actualizarPuntaje(puntaje);
        Movimiento esperado = new Movimiento(5);

        assertEquals(esperado, resultado);
    }
}