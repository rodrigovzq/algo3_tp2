package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.NoCambiarPosicion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.NoCambiarPuntaje;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.Penalizacion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.SinPenalizar;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.NoCambiarVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutoTest {
    @Test
    public void avanzarSobreUnPozoPenalizaTresMovimiento(){
        Auto auto = new Auto();

        Evento resultado = auto.avanzarPozo();
        Evento esperado = new Evento( new Penalizacion(3), new NoCambiarVehiculo(), new Avanzar());

        assertEquals(esperado, resultado);
    }
    @Test
    public void avanzarSobreUnPiqueteEsUnMovimientoInvalido(){
        Auto auto = new Auto();

        Evento resultado = auto.avanzarPiquete();
        Evento esperado = new Evento( new NoCambiarPuntaje(), new NoCambiarVehiculo(), new NoCambiarPosicion());

        assertEquals(esperado, resultado);
    }

    @Test
    public void avanzarSobreUnaCeldaSinObstaculosNoPenaliza(){
        Auto auto = new Auto();

        Evento resultado = auto.avanzarComun();
        Evento esperado = new Evento( new SinPenalizar(), new NoCambiarVehiculo(), new Avanzar());

        assertEquals(esperado, resultado);
    }
    
    @Test
    public void anteUnCambioDeVehiculoSecuencialElAutoSeConvierteEnCuatroPorCuatro(){
        Auto auto = new Auto();

        assertEquals( new CuatroPorCuatro(), auto.siguiente());
    }

    @Test
    public void esImprimible(){
        Auto auto = new Auto();
        assertEquals("Auto", auto.imprimir());
    }
    @Test
    public void laProbabilidadDeSerDetenidoPorUnControlPolicialEsObtenible() {
        Auto auto = new Auto();

        Float resultado = auto.obtenerProbabilidadDeSerDetenido();
        Float esperado = 0.5F;

        assertEquals(esperado, resultado);
    }

    @Test
    public void dosAutosSonIgualesConSerDeLaMismaClase() {
        Auto auto1 = new Auto();
        Auto auto2 = new Auto();

        assertEquals(auto1, auto2);
        assertEquals(auto1, auto1);

        auto2 = null;
        assertNotEquals(auto1, auto2);
    }

    @Test
    public void avanzarSobreUnControlPolicialSignificaSerDetenidoYPenalizaTresMovimientos() {
        Auto auto = new Auto();

        Evento resultado = auto.avanzarControlPolicial();
        Evento esperado =  new Evento( new Penalizacion(3),new NoCambiarVehiculo(), new Avanzar());

        assertEquals(esperado, resultado);
    }

}