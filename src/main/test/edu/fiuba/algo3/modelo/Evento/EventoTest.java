package edu.fiuba.algo3.modelo.Evento;

import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.EventoPosicion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.EventoPuntaje;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.Penalizacion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.SinPenalizar;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.EventoVehiculo;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.SiguienteVehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventoTest {
    @Test
    public void comparandoEventos(){
        EventoPuntaje epuntaje1 = new SinPenalizar();
        EventoPuntaje epuntaje2 = new SinPenalizar();

        EventoVehiculo evehiculo1 = new SiguienteVehiculo();
        EventoVehiculo evehiculo2 = new SiguienteVehiculo();

        EventoPosicion eposicion1 = new Avanzar();
        EventoPosicion eposicion2 = new Avanzar();

        Evento evento1 = new Evento( epuntaje1, evehiculo1, eposicion1);
        Evento evento2 = new Evento( epuntaje2, evehiculo2, eposicion2);

        assertEquals(evento1, evento2);

        epuntaje1 = new Penalizacion(2);
        evento1 = new Evento( epuntaje1, evehiculo1, eposicion1);

        assertNotEquals(evento1, evento2);

        epuntaje2 = new Penalizacion(2);
        evento2 = new Evento( epuntaje2, evehiculo2, eposicion2);

        assertEquals(evento1, evento2);

    }

}