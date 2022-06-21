package edu.fiuba.algo3.architecture.Entregas;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.Obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.Celda.Obstaculo.GeneradorAleatorio;
import edu.fiuba.algo3.modelo.Celda.Sorpresa.Favorable;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.Penalizacion;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.NoCambiarVehiculo;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasosDeUsosEntrega3Tests {

    @Test
    public void UnVehiculoAvanzaYEsDetenidoPorUnControlPolicial (){
        IVehiculo mockIVehiculo = mock(IVehiculo.class);
        GeneradorAleatorio mockGenerador = mock(GeneradorAleatorio.class);

        Celda celdaAdyacente = new Celda( new Favorable() );
        Celda posicionInicial = new Celda( new ControlPolicial(mockGenerador), celdaAdyacente, celdaAdyacente,celdaAdyacente,celdaAdyacente );

        when(mockGenerador.aplicar(mockIVehiculo.obtenerProbabilidadDeSerDetenido())).thenReturn(true);

        Jugador jugador1 = new Jugador("Pedro", posicionInicial, mockIVehiculo);
        Jugador jugador2 = new Jugador("Pedro", posicionInicial, mockIVehiculo);

        Evento resultado = jugador1.avanzarHaciaLaDireccion(Direccion.ESTE, mockIVehiculo);
        Evento esperado = new Evento( new Penalizacion(3), new NoCambiarVehiculo(), new Avanzar() );

        esperado.setDireccion(Direccion.ESTE);
        jugador1.actualizar(resultado);
        jugador2.actualizar(esperado);

        assertEquals(jugador1, jugador2);
    }
}
