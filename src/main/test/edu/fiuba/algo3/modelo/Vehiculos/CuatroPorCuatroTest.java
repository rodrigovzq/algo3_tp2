package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoInvalido;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoValido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuatroPorCuatroTest {

    @Test
    public void avanzarSobreDosPozosNoPenaliza(){
        CuatroPorCuatro cxc = new CuatroPorCuatro();

        cxc.avanzarPozo();
        Movimiento esperado = cxc.avanzarPozo();
        Movimiento resultado = new MovimientoValido( 1 );

        assertEquals(esperado, resultado);
    }

    @Test
    public void avanzarSobreTresPozosPenalizaConDosMovimientos(){
        CuatroPorCuatro cxc = new CuatroPorCuatro();

        cxc.avanzarPozo();
        cxc.avanzarPozo();
        Movimiento resultado = cxc.avanzarPozo();

        Movimiento esperado = new MovimientoValido( 2 );

        assertEquals(esperado, resultado);
    }
    @Test
    public void avanzarSobreCuatroPozosPenalizaUnaVez(){
        CuatroPorCuatro cxc = new CuatroPorCuatro();

        cxc.avanzarPozo();
        cxc.avanzarPozo();
        Movimiento resultado = cxc.avanzarPozo();

        Movimiento esperado = new MovimientoValido( 2 );

        assertEquals(esperado, resultado);

        resultado = cxc.avanzarPozo();
        esperado = new MovimientoValido( 1 );

        assertEquals(esperado, resultado);
    }

    @Test
    public void avanzarSobreUnPiqueteEsUnMovimientoInvalido(){
        CuatroPorCuatro cxc = new CuatroPorCuatro();

        Movimiento resultado = cxc.avanzarPiquete();
        Movimiento esperado = new MovimientoInvalido();

        assertEquals(esperado, resultado);
    }
    @Test
    public void avanzarSobreUnControlPolicialPenalizaConUnaProbabilidad(){
        // Inyectar la dependencia del que tiene la responsabilidad de sortea
        // la probabilidad ?
    }
    @Test
    public void avanzarSobreUnaCeldaSinObstaculosNoPenaliza(){
        CuatroPorCuatro cxc = new CuatroPorCuatro();

        Movimiento resultado = cxc.avanzarComun();
        Movimiento esperado = new MovimientoValido( 1 );

        assertEquals(esperado, resultado);
    }
}