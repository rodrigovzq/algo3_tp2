package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.Penalizacion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.SinPenalizar;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.NoCambiarVehiculo;
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
    public void avanzarSobreUnControlPolicialPenalizaConUnaProbabilidad() {
        // Inyectar la dependencia del que tiene la responsabilidad de sortea
        // la probabilidad ?
    }

    @Test
    public void avanzarSobreUnaCeldaSinObstaculosNoPenaliza() {
        Moto moto = new Moto();

        Evento resultado = moto.avanzarComun();
        Evento esperado =  new Evento( new SinPenalizar(),new NoCambiarVehiculo(), new Avanzar());

        assertEquals(esperado, resultado);
    }

}