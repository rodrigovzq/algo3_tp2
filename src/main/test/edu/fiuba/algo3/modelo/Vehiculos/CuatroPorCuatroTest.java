package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.NoCambiarPosicion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.NoCambiarPuntaje;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.Penalizacion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.SinPenalizar;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.NoCambiarVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.Vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuatroPorCuatroTest {

    @Test
    public void avanzarSobreDosPozosNoPenaliza(){
        CuatroPorCuatro cxc = new CuatroPorCuatro();

        cxc.avanzarPozo();
        Evento resultado = cxc.avanzarPozo();
        Evento esperado = new Evento( new SinPenalizar(), new NoCambiarVehiculo(), new Avanzar());

        assertEquals(esperado, resultado);
    }

    @Test
    public void avanzarSobreTresPozosPenalizaConDosMovimientos(){
        CuatroPorCuatro cxc = new CuatroPorCuatro();

        cxc.avanzarPozo();
        cxc.avanzarPozo();
        Evento resultado = cxc.avanzarPozo();

        Evento esperado = new Evento( new Penalizacion(2), new NoCambiarVehiculo(), new Avanzar());


        assertEquals(esperado, resultado);
    }
    @Test
    public void avanzarSobreCuatroPozosPenalizaUnaVez(){
        CuatroPorCuatro cxc = new CuatroPorCuatro();

        cxc.avanzarPozo();
        cxc.avanzarPozo();
        Evento resultado = cxc.avanzarPozo();

        Evento esperado = new Evento( new Penalizacion(2), new NoCambiarVehiculo(), new Avanzar());

        assertEquals(esperado, resultado);

        resultado = cxc.avanzarPozo();

        esperado = new Evento( new SinPenalizar(), new NoCambiarVehiculo(), new Avanzar());

        assertEquals(esperado, resultado);
    }

    @Test
    public void avanzarSobreUnPiqueteEsUnMovimientoInvalido(){
        CuatroPorCuatro cxc = new CuatroPorCuatro();

        Evento resultado = cxc.avanzarPiquete();

        Evento esperado = new Evento( new NoCambiarPuntaje(), new NoCambiarVehiculo(), new NoCambiarPosicion());

        assertEquals(esperado, resultado);
    }

    @Test
    public void avanzarSobreUnaCeldaSinObstaculosNoPenaliza(){
        CuatroPorCuatro cxc = new CuatroPorCuatro();

        Evento resultado = cxc.avanzarComun();
        Evento esperado = new Evento( new SinPenalizar(), new NoCambiarVehiculo(), new Avanzar());

        assertEquals(esperado, resultado);
    }
    @Test
    public void anteUnCambioDeVehiculoSecuencialElAutoSeConvierteEnMoto(){
        CuatroPorCuatro cxc = new CuatroPorCuatro();

        assertEquals( new Moto(), cxc.siguiente());
    }

    @Test
    public void esImprimible(){
        CuatroPorCuatro cxc = new CuatroPorCuatro();
        assertEquals("CuatroPorCuatro", cxc.imprimir());
    }

    @Test
    public void laProbabilidadDeSerDetenidoPorUnControlPolicialEsObtenible() {
        CuatroPorCuatro cxc = new CuatroPorCuatro();

        Float resultado = cxc.obtenerProbabilidadDeSerDetenido();
        Float esperado = 0.3F;

        assertEquals(esperado, resultado);
    }

    @Test
    public void dosAutosSonIgualesConSerDeLaMismaClase() {
        CuatroPorCuatro cxc1 = new CuatroPorCuatro();
        CuatroPorCuatro cxc2 = new CuatroPorCuatro();

        assertEquals(cxc1, cxc2);
        assertEquals(cxc1, cxc1);

        cxc2 = null;
        assertNotEquals(cxc1, cxc2);
    }

    @Test
    public void avanzarSobreUnControlPolicialSignificaSerDetenidoYPenalizaTresMovimientos() {
        CuatroPorCuatro cxc = new CuatroPorCuatro();

        Evento resultado = cxc.avanzarControlPolicial();
        Evento esperado =  new Evento( new Penalizacion(3),new NoCambiarVehiculo(), new Avanzar());

        assertEquals(esperado, resultado);
    }
}