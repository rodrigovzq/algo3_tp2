package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoInvalido;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoValido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MotoTest {
    @Test
    public void avanzarSobreUnPozoPenalizaTresMovimiento() {
        Moto moto = new Moto();

        Movimiento resultado = moto.avanzarPozo();
        Movimiento esperado = new MovimientoValido(3);

        assertEquals(esperado, resultado);
    }

    @Test
    public void avanzarSobreUnPiquetePenalizaDosMovimientos() {
        Moto moto = new Moto();

        Movimiento resultado = moto.avanzarPiquete();
        Movimiento esperado = new MovimientoValido(2);

        assertEquals(esperado, resultado);
    }

    @Test
    public void avanzarSobreUnControlPolicialPenalizaConUnaProbabilidad() {
        // Inyectar la dependencia del que tiene la responsabilidad de sortea
        // la probabilidad ?
    }

    @Test
    public void avanzarSobreUnaCeldaSinObstaculosNoPenaliza() {
        Moto moto = new Moto();

        Movimiento resultado = moto.avanzarComun();
        Movimiento esperado = new MovimientoValido(1);

        assertEquals(esperado, resultado);
    }

}