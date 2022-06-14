package edu.fiuba.algo3.Entregas;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.Comun;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Celda.Obstaculo.Piquete;
import edu.fiuba.algo3.modelo.Celda.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.NoCambiarPosicion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.NoCambiarPuntaje;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.Penalizacion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.SinPenalizar;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.NoCambiarVehiculo;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CasosDeUsosEntrega1Tests {
    @Test
    public void UnaMotoAvanzaYSeEncuentraConUnPozoSePenalizaEnTresMovimientos (){
        Moto moto = new Moto();
        Celda celdaAdyacente = new Celda( new Pozo() );
        Celda posicionInicial = new Celda( new Comun(), celdaAdyacente, celdaAdyacente,celdaAdyacente,celdaAdyacente );
        Jugador jugador = new Jugador("Pedro", posicionInicial, moto);

        Evento resultado = jugador.avanzarHaciaLaDireccion(Direccion.ESTE, moto );
        Evento esperado = new Evento( new Penalizacion(3), new NoCambiarVehiculo(), new Avanzar() );

        assertEquals(esperado, resultado);
    }

    @Test
    public void UnAutoAvanzaYSeEncuentraConUnPozoSePenalizaEnTresMovimientos (){
        Auto auto = new Auto();
        Celda celdaAdyacente = new Celda( new Pozo() );
        Celda posicionInicial = new Celda( new Comun(), celdaAdyacente, celdaAdyacente,celdaAdyacente,celdaAdyacente );
        Jugador jugador = new Jugador("Pedro", posicionInicial, auto);

        Evento resultado = jugador.avanzarHaciaLaDireccion(Direccion.ESTE, auto );
        Evento esperado = new Evento( new Penalizacion(3), new NoCambiarVehiculo(), new Avanzar() );

        assertEquals(esperado, resultado);
    }

    @Test
    public void UnaCuatroPorCuatroAvanzaYSeEncuentraConUnPozoYNoSePenaliza () {
        CuatroPorCuatro cxc = new CuatroPorCuatro();
        Celda celdaAdyacente = new Celda( new Pozo() );
        Celda posicionInicial = new Celda( new Comun(), celdaAdyacente, celdaAdyacente,celdaAdyacente,celdaAdyacente );
        Jugador jugador = new Jugador("Pedro", posicionInicial, cxc);

        Evento resultado = jugador.avanzarHaciaLaDireccion(Direccion.ESTE, cxc );
        Evento esperado = new Evento( new SinPenalizar(), new NoCambiarVehiculo(), new Avanzar() );

        assertEquals(esperado, resultado);
    }

    @Test
    public void UnaCuatroPorCuatroAvanzaYSeEncuentraConTresPozosSePenalizaEnDosMovimientos (){
        CuatroPorCuatro cxc = new CuatroPorCuatro();
        Celda celdaAdyacente = new Celda( new Pozo() );
        Celda posicionInicial = new Celda( new Comun(), celdaAdyacente, celdaAdyacente,celdaAdyacente,celdaAdyacente );
        Jugador jugador = new Jugador("Pedro", posicionInicial, cxc);

        jugador.avanzarHaciaLaDireccion(Direccion.ESTE, cxc);
        jugador.avanzarHaciaLaDireccion(Direccion.ESTE, cxc);
        Evento resultado = jugador.avanzarHaciaLaDireccion(Direccion.ESTE, cxc );
        Evento esperado = new Evento( new Penalizacion(2), new NoCambiarVehiculo(), new Avanzar() );


        assertEquals(esperado, resultado);
    }

    @Test
    public void UnAutoAvanzaYSeEncuentraConUnPiqueteYNoPuedePasar () {
        Auto auto = new Auto();
        Celda celdaAdyacente = new Celda( new Piquete() );
        Celda posicionInicial = new Celda( new Comun(), celdaAdyacente, celdaAdyacente,celdaAdyacente,celdaAdyacente );
        Jugador jugador = new Jugador("Pedro", posicionInicial, auto);

        Evento resultado = jugador.avanzarHaciaLaDireccion(Direccion.ESTE, auto );
        Evento esperado = new Evento( new NoCambiarPuntaje(), new NoCambiarVehiculo(), new NoCambiarPosicion() );

        assertEquals(esperado, resultado);

    }
}