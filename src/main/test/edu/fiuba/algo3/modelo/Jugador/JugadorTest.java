package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Excepcion.JugadorInvalido;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class JugadorTest {
    @Test
    public void elJugadorEsCapazDeImprimirEnUnStringSuInformacion(){
        Celda mockCelda = mock( Celda.class );
        when( mockCelda.imprimir()).thenReturn("ESTADO-(0,0)");
        IVehiculo mockVehiculo = mock( IVehiculo.class );
        when( mockVehiculo.imprimir()).thenReturn("Auto");
        Jugador jugador = new Jugador("Grupo3", mockCelda, mockVehiculo );

        String resultado = jugador.imprimir();
        String esperado = "Grupo3;(0,0);Auto;0";

        assertEquals(esperado, resultado);
    }

    @Test
    public void elVehiculoEsSeteable(){
        Celda mockCelda = mock( Celda.class );
        IVehiculo mockVehiculo = mock( IVehiculo.class );
        Jugador jugador = new Jugador("Grupo3", mockCelda, mockVehiculo );

        IVehiculo mockNuevoVehiculo = mock( IVehiculo.class );
        jugador.setVehiculo( mockNuevoVehiculo );
        Jugador esperado = new Jugador( "Grupo3", mockCelda, mockNuevoVehiculo);

        assertEquals( esperado, jugador);
    }
    @Test
    public void elNombreEsSeteable(){
        Celda mockCelda = mock( Celda.class );
        IVehiculo mockVehiculo = mock( IVehiculo.class );
        Jugador jugador = new Jugador("Grupo3", mockCelda, mockVehiculo );

        jugador.setNombre( "3-Grupo" );
        Jugador esperado = new Jugador( "3-Grupo", mockCelda, mockVehiculo);

        assertEquals( esperado, jugador);
    }
    @Test
    public void laPosicionEsSeteable(){
        Celda mockCelda = mock( Celda.class );
        IVehiculo mockVehiculo = mock( IVehiculo.class );
        Jugador jugador = new Jugador("Grupo3", mockCelda, mockVehiculo );

        Celda mockNuevaCelda = mock( Celda.class );
        jugador.setPosicion( mockNuevaCelda );
        Jugador esperado = new Jugador( "Grupo3", mockNuevaCelda, mockVehiculo);

        assertEquals( esperado, jugador);
    }

    @Test
    public void mapaEsObservable(){
        Celda mockCelda = mock( Celda.class );
        IVehiculo mockVehiculo = mock( IVehiculo.class );
        Jugador jugador = new Jugador("Grupo3", mockCelda, mockVehiculo );
        Observador mockObservador = mock( Observador.class );

        jugador.agregarObservador(mockObservador);
        jugador.agregarObservador(mockObservador);
        jugador.agregarObservador(mockObservador);

        jugador.notificarATodos();

        verify( mockObservador, times(3)).actualizar();
    }

    @Test
    public void alActualizarConUnEventoSeActualizaElPuntajeLaPosicionYElVehiculo(){
        Celda mockCelda = mock( Celda.class );
        IVehiculo mockVehiculo = mock( IVehiculo.class );
        Jugador jugador = new Jugador("Grupo3", mockCelda, mockVehiculo );

        Evento mockEvento = mock(Evento.class);
        jugador.actualizar(mockEvento);

        verify( mockEvento ).actualizarPuntaje( new Movimiento(0));
        verify( mockEvento ).actualizarVehiculo( mockVehiculo );
        verify( mockEvento ).actualizarPosicion( mockCelda );
    }

    @Test
    public void alPedirleLaPosicionMeDevuelveLasCoordenadas(){
        Celda mockCelda = mock( Celda.class );
        IVehiculo mockVehiculo = mock( IVehiculo.class );
        Jugador jugador = new Jugador("Grupo3", mockCelda, mockVehiculo );
        jugador.getPosicion();

        verify( mockCelda ).getCoordenada();
    }

    @Test
    public void alAvanzarParaLasDireccionesAdyacentesDelegaALaCeldaYDevuelveUnEvento(){
        Celda mockCelda = mock( Celda.class );
        Celda mockCeldaAdyacente = mock( Celda.class );

        IVehiculo mockVehiculo = mock( IVehiculo.class );
        Jugador jugador = new Jugador("Grupo3", mockCelda, mockVehiculo );

        Direccion mockDireccion = mock( Direccion.class );
        when( mockCelda.getCelda( mockDireccion ) ).thenReturn(mockCeldaAdyacente);

        Evento mockEvento = mock( Evento.class );
        when( mockCeldaAdyacente.avanzarEn(mockVehiculo) ).thenReturn(mockEvento);

        jugador.avanzarHaciaLaDireccion( mockDireccion );

        verify( mockCeldaAdyacente ).avanzarEn( mockVehiculo );
        verify( mockEvento ).setDireccion( mockDireccion );
    }

    @Test
    public void noEsPosibleCrearUnJugadorConPuntajeNegativo(){
        Celda mockCelda = mock( Celda.class );
        IVehiculo mockVehiculo = mock( IVehiculo.class );
        assertDoesNotThrow( () -> new Jugador("Grupo3", mockCelda, mockVehiculo, 4 ) );
        assertDoesNotThrow( () -> new Jugador("Grupo3", mockCelda, mockVehiculo, 0 ) );
        assertThrows( JugadorInvalido.class,  () -> new Jugador("Grupo3", mockCelda, mockVehiculo, -1 ) );
        assertThrows( JugadorInvalido.class,  () -> new Jugador("Grupo3", mockCelda, mockVehiculo, -4 ) );
    }


    @Test
    public void noEsPosibleCrearUnJugadorConValoresNull(){
        Celda mockCelda = mock( Celda.class );
        IVehiculo mockVehiculo = mock( IVehiculo.class );
        assertDoesNotThrow( () -> new Jugador("Grupo3", mockCelda, mockVehiculo, 4 ) );
        assertThrows( JugadorInvalido.class,  () -> new Jugador("Grupo3", mockCelda, mockVehiculo, null ) );
        assertThrows( JugadorInvalido.class,  () -> new Jugador("Grupo3", mockCelda, null ) );
        assertThrows( JugadorInvalido.class,  () -> new Jugador("Grupo3", null, mockVehiculo ) );
        assertThrows( JugadorInvalido.class,  () -> new Jugador(null, mockCelda, mockVehiculo ) );
    }
}