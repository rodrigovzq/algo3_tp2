package edu.fiuba.algo3.modelo.Evento.EventoPuntaje;

import edu.fiuba.algo3.modelo.Evento.EventoPosicion.NoCambiarPosicion;
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
    @Test
    public void comparacionEntreDosEventosAumento(){
        AumentoPorcentaje evento1 = new AumentoPorcentaje(2.0F);
        AumentoPorcentaje evento2 = new AumentoPorcentaje(2.0F);
        assertEquals(evento1, evento2);

        evento1 = new AumentoPorcentaje(6.0F);
        evento2 = new AumentoPorcentaje(4.0F);
        assertNotEquals(evento1, evento2);
    }
}