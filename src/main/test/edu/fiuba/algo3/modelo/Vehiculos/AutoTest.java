package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoInvalido;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoValido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutoTest {
    @Test
    public void avanzarSobreUnPozoPenalizaTresMovimiento(){
        Auto auto = new Auto();

        Movimiento esperado = auto.avanzarPozo();
        Movimiento resultado = new MovimientoValido( 3 );

        assertEquals(esperado, resultado);
    }
    @Test
    public void avanzarSobreUnPiqueteEsUnMovimientoInvalido(){
        Auto auto = new Auto();

        Movimiento esperado = auto.avanzarPiquete();
        Movimiento resultado = new MovimientoInvalido();

        assertEquals(esperado, resultado);
    }
    @Test
    public void avanzarSobreUnControlPolicialPenalizaConUnaProbabilidad(){
        // Inyectar la dependencia del que tiene la responsabilidad de sortea
        // la probabilidad ?
    }
    @Test
    public void avanzarSobreUnaCeldaSinObstaculosNoPenaliza(){
        Auto auto = new Auto();

        Movimiento esperado = auto.avanzarComun();
        Movimiento resultado = new MovimientoValido( 1 );

        assertEquals(esperado, resultado);
    }
}