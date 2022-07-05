package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.Penalizacion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.SinPenalizar;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.NoCambiarVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MotoTest {
    @Test
    public void avanzarSobreUnPozoPenalizaTresMovimiento() {
        Moto moto = new Moto();

        Evento resultado = moto.avanzarPozo();
        Evento esperado =  new Evento( new Penalizacion(3),new NoCambiarVehiculo(), new Avanzar());

        assertEquals(esperado, resultado);
    }

    @Test
    public void avanzarSobreUnPiquetePenalizaDosMovimientos() {
        Moto moto = new Moto();

        Evento resultado = moto.avanzarPiquete();
        Evento esperado =  new Evento( new Penalizacion(2),new NoCambiarVehiculo(), new Avanzar());

        assertEquals(esperado, resultado);
    }

    @Test
    public void avanzarSobreUnaCeldaSinObstaculosNoPenaliza() {
        Moto moto = new Moto();

        Evento resultado = moto.avanzarComun();
        Evento esperado =  new Evento( new SinPenalizar(),new NoCambiarVehiculo(), new Avanzar());

        assertEquals(esperado, resultado);
    }

    @Test
    public void anteUnCambioDeVehiculoSecuencialLaMotoSeConvierteEnAuto(){
        Moto moto = new Moto();

        assertEquals( new Auto(), moto.siguiente());
    }

    @Test
    public void esImprimible(){
        Moto moto = new Moto();
        assertEquals("Moto", moto.imprimir());
    }

    @Test
    public void laProbabilidadDeSerDetenidoPorUnControlPolicialEsObtenible() {
        Moto moto = new Moto();

        Float resultado = moto.obtenerProbabilidadDeSerDetenido();
        Float esperado = 0.8F;

        assertEquals(esperado, resultado);
    }

    @Test
    public void dosMotosSonIgualesConSerDeLaMismaClase() {
        Moto moto1 = new Moto();
        Moto moto2 = new Moto();

        assertEquals(moto1, moto2);
        assertEquals(moto1, moto1);

        moto2 = null;
        assertNotEquals(moto1, moto2);
    }

    @Test
    public void avanzarSobreUnControlPolicialSignificaSerDetenidoYPenalizaTresMovimientos() {
        Moto moto = new Moto();

        Evento resultado = moto.avanzarControlPolicial();
        Evento esperado =  new Evento( new Penalizacion(3),new NoCambiarVehiculo(), new Avanzar());

        assertEquals(esperado, resultado);
    }
}