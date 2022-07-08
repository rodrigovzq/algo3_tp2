package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.NoCambiarPosicion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.NoCambiarPuntaje;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.Penalizacion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.SinPenalizar;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.NoCambiarVehiculo;
import edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorAleatorio;
import edu.fiuba.algo3.modelo.Obstaculo.ControlPolicial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

public class ReliantRobinTest {
    @Test
    void elSiguienteVehiculoAlEncontrarseUnaSorpresaCambioDeVehiculoEsUnAuto() {
        GeneradorAleatorio mockGenerador = mock(GeneradorAleatorio.class);
        when(mockGenerador.aplicar(0.6f)).thenReturn(true);
        ReliantRobin r = new ReliantRobin(mockGenerador);
        IVehiculo v = r.siguiente();
        assertEquals(new Auto(), v);
    }

    @Test
    public void seDecideSiElReliantRobinSeComportaComoAutoOMotoConUnaProbabilidadDeterminada() {
        GeneradorAleatorio mockGenerador = mock(GeneradorAleatorio.class);
        when(mockGenerador.aplicar(0.6f)).thenReturn(true);
        ReliantRobin r = new ReliantRobin(mockGenerador);
        verify(mockGenerador).aplicar(0.6f);
    }

    @Test
    public void avanzarSobreUnPozoPenalizaTresMovimiento(){
        GeneradorAleatorio mockGenerador = mock(GeneradorAleatorio.class);
        when(mockGenerador.aplicar(0.6f)).thenReturn(true);
        ReliantRobin r = new ReliantRobin(mockGenerador);
        Evento resultado = r.avanzarPozo();
        Evento esperado = new Evento( new Penalizacion(3), new NoCambiarVehiculo(), new Avanzar());

        assertEquals(esperado, resultado);
    }
    @Test
    public void avanzarSobreUnPiqueteEsUnMovimientoInvalido(){
        GeneradorAleatorio mockGenerador = mock(GeneradorAleatorio.class);
        when(mockGenerador.aplicar(0.6f)).thenReturn(true);

        ReliantRobin r = new ReliantRobin(mockGenerador);

        Evento resultado = r.avanzarPiquete();
        Evento esperado = new Evento( new NoCambiarPuntaje(), new NoCambiarVehiculo(), new NoCambiarPosicion());

        assertEquals(esperado, resultado);
    }

    @Test
    public void avanzarSobreUnaCeldaSinObstaculosNoPenaliza(){
        GeneradorAleatorio mockGenerador = mock(GeneradorAleatorio.class);
        when(mockGenerador.aplicar(0.6f)).thenReturn(true);

        ReliantRobin r = new ReliantRobin(mockGenerador);

        Evento resultado = r.avanzarComun();
        Evento esperado = new Evento( new SinPenalizar(), new NoCambiarVehiculo(), new Avanzar());

        assertEquals(esperado, resultado);
    }

    @Test
    public void laProbabilidadDeSerDetenidoPorUnControlPolicialEsObtenible() {
        GeneradorAleatorio mockGenerador = mock(GeneradorAleatorio.class);
        when(mockGenerador.aplicar(0.6f)).thenReturn(true);

        ReliantRobin r = new ReliantRobin(mockGenerador);

        Float resultado = r.obtenerProbabilidadDeSerDetenido();
        Float esperado = 0.5F;

        assertEquals(esperado, resultado);
    }

    @Test
    public void avanzarSobreUnControlPolicialSignificaSerDetenidoYPenalizaTresMovimientos() {
        GeneradorAleatorio mockGenerador = mock(GeneradorAleatorio.class);
        when(mockGenerador.aplicar(0.6f)).thenReturn(true);

        ReliantRobin r = new ReliantRobin(mockGenerador);

        Evento resultado = r.avanzarControlPolicial();
        Evento esperado =  new Evento( new Penalizacion(3),new NoCambiarVehiculo(), new Avanzar());

        assertEquals(esperado, resultado);
    }

    @Test
    public void avanzarSobreUnPozoPenalizaTresMovimientoMoto() {
        GeneradorAleatorio mockGenerador = mock(GeneradorAleatorio.class);
        when(mockGenerador.aplicar(0.6f)).thenReturn(false);
        ReliantRobin r = new ReliantRobin(mockGenerador);;

        Evento resultado = r.avanzarPozo();
        Evento esperado =  new Evento( new Penalizacion(3),new NoCambiarVehiculo(), new Avanzar());

        assertEquals(esperado, resultado);
    }

    @Test
    public void avanzarSobreUnPiquetePenalizaDosMovimientosMoto() {
        GeneradorAleatorio mockGenerador = mock(GeneradorAleatorio.class);
        when(mockGenerador.aplicar(0.6f)).thenReturn(false);
        ReliantRobin r = new ReliantRobin(mockGenerador);

        Evento resultado = r.avanzarPiquete();
        Evento esperado =  new Evento( new Penalizacion(2),new NoCambiarVehiculo(), new Avanzar());

        assertEquals(esperado, resultado);
    }

    @Test
    public void avanzarSobreUnaCeldaSinObstaculosNoPenalizaMoto() {
        GeneradorAleatorio mockGenerador = mock(GeneradorAleatorio.class);
        when(mockGenerador.aplicar(0.6f)).thenReturn(false);
        ReliantRobin r = new ReliantRobin(mockGenerador);

        Evento resultado = r.avanzarComun();
        Evento esperado =  new Evento( new SinPenalizar(),new NoCambiarVehiculo(), new Avanzar());

        assertEquals(esperado, resultado);
    }

    @Test
    public void laProbabilidadDeSerDetenidoPorUnControlPolicialEsObtenibleMoto() {
        GeneradorAleatorio mockGenerador = mock(GeneradorAleatorio.class);
        when(mockGenerador.aplicar(0.6f)).thenReturn(false);
        ReliantRobin r = new ReliantRobin(mockGenerador);

        Float resultado = r.obtenerProbabilidadDeSerDetenido();
        Float esperado = 0.8F;

        assertEquals(esperado, resultado);
    }

    @Test
    public void avanzarSobreUnControlPolicialSignificaSerDetenidoYPenalizaTresMovimientosMoto() {
        GeneradorAleatorio mockGenerador = mock(GeneradorAleatorio.class);
        when(mockGenerador.aplicar(0.6f)).thenReturn(false);
        ReliantRobin r = new ReliantRobin(mockGenerador);

        Evento resultado = r.avanzarControlPolicial();
        Evento esperado =  new Evento( new Penalizacion(3),new NoCambiarVehiculo(), new Avanzar());

        assertEquals(esperado, resultado);
    }
}
