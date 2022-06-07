package edu.fiuba.algo3.modelo.Movimiento;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovimientoInvalidoTest {
    @Test
    public void sumoMovimientoInvalidoConUnoValidoYNoSeModificaLaCantidadDeMovimientos(){
        Movimiento m1 = new MovimientoInvalido();
        Movimiento m2 = new MovimientoValido(1);

        m2.sumarMovimiento(m1);
        Movimiento esperado = new MovimientoValido(1);

        assertEquals(esperado, m1);
    }
}