package edu.fiuba.algo3.modelo.Evento.EventoPuntaje;

import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.Penalizacion;
import edu.fiuba.algo3.modelo.Excepcion.PenalizacionInvalida;
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

    @Test
    public void comparacionEntreDosEventosPenalizacion(){
        Penalizacion evento1 = new Penalizacion(2);
        Penalizacion evento2 = new Penalizacion(2);
        assertEquals(evento1, evento2);

        evento1 = new Penalizacion(6);
        evento2 = new Penalizacion(4);
        assertNotEquals(evento1, evento2);
    }

    @Test
    public void noEsPosibleCrearUnaPenalizacionConPenalidadNegativa(){
        assertDoesNotThrow( () -> new Penalizacion(2) );
        assertDoesNotThrow( () -> new Penalizacion(0) );
        assertThrows( PenalizacionInvalida.class, () -> new Penalizacion(-1) );
        assertThrows( PenalizacionInvalida.class, () -> new Penalizacion(-4) );
    }
}