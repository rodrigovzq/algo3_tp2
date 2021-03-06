package edu.fiuba.algo3.architecture.Entregas;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.CeldaInterna;
import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorAleatorio;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.Penalizacion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.SinPenalizar;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.NoCambiarVehiculo;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasosDeUsosEntrega3Tests {

    @Disabled
    public void UnAutoAvanzaYEsDetenidoPorUnControlPolicialAh (){
        IVehiculo mockIVehiculo = new Auto();
        GeneradorAleatorio mockGenerador = mock(GeneradorAleatorio.class);

        Coordenada coordenada = new Coordenada(0,0);

        Celda celdaAdyacente = new CeldaInterna(new ControlPolicial(mockGenerador), coordenada);
        Celda posicionInicial = new CeldaInterna( new ControlPolicial(mockGenerador), coordenada);

        posicionInicial.setCelda(celdaAdyacente, Direccion.NORTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.ESTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.OESTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.SUR);

        when(mockGenerador.aplicar(mockIVehiculo.obtenerProbabilidadDeSerDetenido())).thenReturn(true);

        Jugador jugador1 = new Jugador("Pedro", posicionInicial, mockIVehiculo);
        Jugador jugador2 = new Jugador("Pedro", posicionInicial, mockIVehiculo);

        Evento resultado = jugador1.avanzarHaciaLaDireccion(Direccion.ESTE);
        Evento esperado = new Evento( new Penalizacion(3), new NoCambiarVehiculo(), new Avanzar() );

        esperado.setDireccion(Direccion.ESTE);
        jugador1.actualizar(resultado);
        jugador2.actualizar(esperado);

        assertEquals(jugador1, jugador2);
    }
    @Disabled
    public void UnAutoAvanzaYNoEsDetenidoPorUnControlPolicialAh (){
        IVehiculo mockIVehiculo = new Auto();
        GeneradorAleatorio mockGenerador = mock(GeneradorAleatorio.class);

        Coordenada coordenada = new Coordenada(0,0);

        Celda celdaAdyacente = new CeldaInterna(new ControlPolicial(mockGenerador), coordenada);
        Celda posicionInicial = new CeldaInterna( new ControlPolicial(mockGenerador), coordenada);

        posicionInicial.setCelda(celdaAdyacente, Direccion.NORTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.ESTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.OESTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.SUR);

        when(mockGenerador.aplicar(mockIVehiculo.obtenerProbabilidadDeSerDetenido())).thenReturn(false);

        Jugador jugador1 = new Jugador("Pedro", posicionInicial, mockIVehiculo);
        Jugador jugador2 = new Jugador("Pedro", posicionInicial, mockIVehiculo);

        Evento resultado = jugador1.avanzarHaciaLaDireccion(Direccion.ESTE);
        Evento esperado = new Evento( new SinPenalizar(), new NoCambiarVehiculo(), new Avanzar() );

        esperado.setDireccion(Direccion.ESTE);
        jugador1.actualizar(resultado);
        jugador2.actualizar(esperado);

        assertEquals(jugador1, jugador2);
    }
}
