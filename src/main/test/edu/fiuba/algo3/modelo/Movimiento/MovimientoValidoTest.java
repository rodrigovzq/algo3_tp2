package edu.fiuba.algo3.modelo.Movimiento;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovimientoValidoTest {
    @Test
    public void sumoDosMovimientosYResultaUnoConLaSumaMovimientos(){
        Movimiento m1 = new MovimientoValido(1);
        Movimiento m2 = new MovimientoValido( 2);

        m1.sumarMovimiento(m2);
        Movimiento esperado = new MovimientoValido(3);

        assertEquals(esperado, m1);
    }

}