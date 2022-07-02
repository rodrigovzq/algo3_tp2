package edu.fiuba.algo3.modelo.Evento.EventoPuntaje;

import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.DescuentoPorcentaje;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DescuentoPorcentajeTest {
    @Test
    public void actualizarPuntajeYSeAplicaElDescuento(){
        DescuentoPorcentaje descuento = new DescuentoPorcentaje(50.0F);
        Movimiento puntaje = new Movimiento(10);

        Movimiento resultado = descuento.actualizarPuntaje(puntaje);
        Movimiento esperado = new Movimiento(5);

        assertEquals(esperado, resultado);
    }

    @Test
    public void comparacionEntreDosEventosDescuento(){
        DescuentoPorcentaje evento1 = new DescuentoPorcentaje(2.0F);
        DescuentoPorcentaje evento2 = new DescuentoPorcentaje(2.0F);
        assertEquals(evento1, evento2);

        evento1 = new DescuentoPorcentaje(6.0F);
        evento2 = new DescuentoPorcentaje(4.0F);
        assertNotEquals(evento1, evento2);
    }
}