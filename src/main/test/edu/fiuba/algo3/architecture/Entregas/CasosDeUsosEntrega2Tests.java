package edu.fiuba.algo3.architecture.Entregas;

import edu.fiuba.algo3.modelo.Celda.CeldaInterna;
import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.EstadoCelda.Comun;
import edu.fiuba.algo3.modelo.Sorpresa.Desfavorable;
import edu.fiuba.algo3.modelo.Sorpresa.Favorable;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.AumentoPorcentaje;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.DescuentoPorcentaje;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.SinPenalizar;
import edu.fiuba.algo3.modelo.Sorpresa.CambioVehiculo;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.NoCambiarVehiculo;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.SiguienteVehiculo;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasosDeUsosEntrega2Tests {

    @Disabled

    public void UnVehiculoAvanzaYEncuentraUnaSorpresaFavorable (){
        IVehiculo v = new Auto();
        Coordenada coordenada = new Coordenada(0,0);
        CeldaInterna celdaAdyacente = new CeldaInterna( new Favorable(), coordenada);
        CeldaInterna posicionInicial = new CeldaInterna( new Comun(), coordenada);

        posicionInicial.setCelda(celdaAdyacente, Direccion.NORTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.ESTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.OESTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.SUR);


        Jugador jugador1 = new Jugador("Pedro", posicionInicial, v);
        Jugador jugador2 = new Jugador("Pedro", posicionInicial, v);

        Evento resultado = jugador1.avanzarHaciaLaDireccion(Direccion.ESTE );
        Evento esperado = new Evento( new DescuentoPorcentaje(20.0F), new NoCambiarVehiculo(), new Avanzar() );
        esperado.setDireccion(Direccion.ESTE);

        jugador1.actualizar(resultado);
        jugador2.actualizar(esperado);

        assertEquals(jugador2, jugador1);
    }

    @Disabled

    public void UnAutoAvanzaYEncuentraUnaSorpresaDesfavorable (){
        IVehiculo v = new Auto();
        Coordenada coordenada = new Coordenada(0,0);
        CeldaInterna celdaAdyacente = new CeldaInterna( new Desfavorable(), coordenada);
        CeldaInterna posicionInicial = new CeldaInterna( new Comun(), coordenada);

        posicionInicial.setCelda(celdaAdyacente, Direccion.NORTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.ESTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.OESTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.SUR);


        Jugador jugador1 = new Jugador("Pedro", posicionInicial, v);
        Jugador jugador2 = new Jugador("Pedro", posicionInicial, v);

        Evento resultado = jugador1.avanzarHaciaLaDireccion(Direccion.ESTE );
        Evento esperado = new Evento( new AumentoPorcentaje(25.0F), new NoCambiarVehiculo(), new Avanzar() );
        esperado.setDireccion(Direccion.ESTE);

        jugador1.actualizar(resultado);
        jugador2.actualizar(esperado);

        assertEquals(jugador2, jugador1);
    }

    @Disabled

    public void UnaMotoAvanzaYEncuentraUnaSorpresaCambioDeVehiculo (){
        IVehiculo v = new Auto();
        Coordenada coordenada = new Coordenada(0,0);
        CeldaInterna celdaAdyacente = new CeldaInterna( new CambioVehiculo(), coordenada);
        CeldaInterna posicionInicial = new CeldaInterna( new Comun(), coordenada);

        posicionInicial.setCelda(celdaAdyacente, Direccion.NORTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.ESTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.OESTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.SUR);


        Jugador jugador1 = new Jugador("Pedro", posicionInicial, v);
        Jugador jugador2 = new Jugador("Pedro", posicionInicial, v);

        Evento resultado = jugador1.avanzarHaciaLaDireccion(Direccion.ESTE );
        Evento esperado = new Evento( new SinPenalizar(), new SiguienteVehiculo(), new Avanzar() );
        esperado.setDireccion(Direccion.ESTE);

        jugador1.actualizar(resultado);
        jugador2.actualizar(esperado);

        assertEquals(jugador2, jugador1);
    }
    @Disabled

    public void UnaCuatroPorCuatroAvanzaYEncuentraUnaSorpresaCambioDeVehiculo (){
        IVehiculo v = new CuatroPorCuatro();
        Coordenada coordenada = new Coordenada(0,0);
        CeldaInterna celdaAdyacente = new CeldaInterna( new CambioVehiculo(), coordenada);
        CeldaInterna posicionInicial = new CeldaInterna( new Comun(), coordenada);

        posicionInicial.setCelda(celdaAdyacente, Direccion.NORTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.ESTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.OESTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.SUR);


        Jugador jugador1 = new Jugador("Pedro", posicionInicial, v);
        Jugador jugador2 = new Jugador("Pedro", posicionInicial, v);

        Evento resultado = jugador1.avanzarHaciaLaDireccion(Direccion.ESTE );
        Evento esperado = new Evento( new SinPenalizar(), new SiguienteVehiculo(), new Avanzar() );
        esperado.setDireccion(Direccion.ESTE);

        jugador1.actualizar(resultado);
        jugador2.actualizar(esperado);

        assertEquals(jugador2, jugador1);
    }
    
    @Disabled

    public void UnMotoAvanzaYEncuentraUnaSorpresaCambioDeVehiculo (){
        IVehiculo v = new Moto();
        Coordenada coordenada = new Coordenada(0,0);
        CeldaInterna celdaAdyacente = new CeldaInterna( new CambioVehiculo(), coordenada);
        CeldaInterna posicionInicial = new CeldaInterna( new Comun(), coordenada);

        posicionInicial.setCelda(celdaAdyacente, Direccion.NORTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.ESTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.OESTE);
        posicionInicial.setCelda(celdaAdyacente, Direccion.SUR);


        Jugador jugador1 = new Jugador("Pedro", posicionInicial, v);
        Jugador jugador2 = new Jugador("Pedro", posicionInicial, v);

        Evento resultado = jugador1.avanzarHaciaLaDireccion(Direccion.ESTE );
        Evento esperado = new Evento( new SinPenalizar(), new SiguienteVehiculo(), new Avanzar() );
        esperado.setDireccion(Direccion.ESTE);

        jugador1.actualizar(resultado);
        jugador2.actualizar(esperado);

        assertEquals(jugador2, jugador1);
    }

}
