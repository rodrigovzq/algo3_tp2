package edu.fiuba.algo3.architecture.Entregas;

import edu.fiuba.algo3.modelo.Celda.CeldaInterna;
import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.EstadoCelda.Comun;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Obstaculo.Piquete;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
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

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CasosDeUsosEntrega1Tests {
    @Disabled
    public void UnaMotoAvanzaYSeEncuentraConUnPozoSePenalizaEnTresMovimientos (){
        Moto moto = new Moto();

        Coordenada coordenada = new Coordenada(0,0);
        CeldaInterna celdaAdyacente = new CeldaInterna( new Pozo(), coordenada);
        CeldaInterna posicionInicial = new CeldaInterna( new Comun(), coordenada);

        posicionInicial.setCelda(celdaAdyacente, Direccion.NORTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.ESTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.OESTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.SUR);

        Jugador jugador = new Jugador("Pedro", posicionInicial, moto);

        Evento resultado = jugador.avanzarHaciaLaDireccion(Direccion.ESTE);
        Evento esperado = new Evento( new Penalizacion(3), new NoCambiarVehiculo(), new Avanzar() );

        assertEquals(esperado, resultado);
    }

    @Disabled
    public void UnAutoAvanzaYSeEncuentraConUnPozoSePenalizaEnTresMovimientos (){
        Auto auto = new Auto();
        Coordenada coordenada = new Coordenada(0,0);
        CeldaInterna celdaAdyacente = new CeldaInterna( new Pozo(), coordenada);
        CeldaInterna posicionInicial = new CeldaInterna( new Comun(), coordenada);

        posicionInicial.setCelda(celdaAdyacente, Direccion.NORTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.ESTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.OESTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.SUR);

        Jugador jugador = new Jugador("Pedro", posicionInicial, auto);

        Evento resultado = jugador.avanzarHaciaLaDireccion(Direccion.ESTE);
        Evento esperado = new Evento( new Penalizacion(3), new NoCambiarVehiculo(), new Avanzar() );

        assertEquals(esperado, resultado);
    }

    @Disabled
    public void UnaCuatroPorCuatroAvanzaYSeEncuentraConUnPozoYNoSePenaliza () {
        CuatroPorCuatro cxc = new CuatroPorCuatro();
        Coordenada coordenada = new Coordenada(0,0);
        CeldaInterna celdaAdyacente = new CeldaInterna( new Pozo(), coordenada);
        CeldaInterna posicionInicial = new CeldaInterna( new Comun(), coordenada);

        posicionInicial.setCelda(celdaAdyacente, Direccion.NORTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.ESTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.OESTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.SUR);

        Jugador jugador = new Jugador("Pedro", posicionInicial, cxc);


        Evento resultado = jugador.avanzarHaciaLaDireccion(Direccion.ESTE);
        Evento esperado = new Evento( new SinPenalizar(), new NoCambiarVehiculo(), new Avanzar() );

        assertEquals(esperado, resultado);
    }

    @Disabled
    public void UnaCuatroPorCuatroAvanzaYSeEncuentraConTresPozosSePenalizaEnDosMovimientos (){
        CuatroPorCuatro cxc = new CuatroPorCuatro();
        Coordenada coordenada = new Coordenada(0,0);
        CeldaInterna celdaAdyacente = new CeldaInterna( new Pozo(), coordenada);
        CeldaInterna posicionInicial = new CeldaInterna( new Comun(), coordenada);

        posicionInicial.setCelda(celdaAdyacente, Direccion.NORTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.ESTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.OESTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.SUR);

        Jugador jugador = new Jugador("Pedro", posicionInicial, cxc);

        jugador.avanzarHaciaLaDireccion(Direccion.ESTE);
        jugador.avanzarHaciaLaDireccion(Direccion.ESTE);
        Evento resultado = jugador.avanzarHaciaLaDireccion(Direccion.ESTE);
        Evento esperado = new Evento( new Penalizacion(2), new NoCambiarVehiculo(), new Avanzar() );


        assertEquals(esperado, resultado);
    }

    @Disabled
    public void UnAutoAvanzaYSeEncuentraConUnPiqueteYNoPuedePasar () {
        Auto auto = new Auto();
        Coordenada coordenada = new Coordenada(0,0);
        CeldaInterna celdaAdyacente = new CeldaInterna( new Piquete(), coordenada);
        CeldaInterna posicionInicial = new CeldaInterna( new Comun(), coordenada);

        posicionInicial.setCelda(celdaAdyacente, Direccion.NORTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.ESTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.OESTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.SUR);

        Jugador jugador = new Jugador("Pedro", posicionInicial, auto);

        Evento resultado = jugador.avanzarHaciaLaDireccion(Direccion.ESTE);
        Evento esperado = new Evento( new NoCambiarPuntaje(), new NoCambiarVehiculo(), new NoCambiarPosicion() );

        assertEquals(esperado, resultado);

    }
}
