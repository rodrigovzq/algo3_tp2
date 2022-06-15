package edu.fiuba.algo3.modelo.Celda.Obstaculo.Evento.EventoPuntaje;

import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.AumentoPorcentaje;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AumentoPorcentajeTest {
    @Test
    public void actualizarPuntajeYSeAplicaElDescuento(){
        AumentoPorcentaje descuento = new AumentoPorcentaje(50.0F);
        Movimiento puntaje = new Movimiento(10);

        Movimiento resultado = descuento.actualizarPuntaje(puntaje);
        Movimiento esperado = new Movimiento(15);

        assertEquals(esperado, resultado);
    }
}