package Entregas;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.Sorpresa.Desfavorable;
import edu.fiuba.algo3.modelo.Celda.Sorpresa.Favorable;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.AumentoPorcentaje;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.DescuentoPorcentaje;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.SinPenalizar;
import edu.fiuba.algo3.modelo.Celda.Sorpresa.CambioVehiculo;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.NoCambiarVehiculo;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.SiguienteVehiculo;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CasosDeUsosEntrega2Tests {

    @Test

    public void UnVehiculoAvanzaYEncuentraUnaSorpresaFavorable (){
        IVehiculo v = new Auto();
        Celda posicionInicial = new Celda( new Favorable() );
        Jugador jugador = new Jugador("Pedro", posicionInicial, v);

        Evento resultado = jugador.avanzarHaciaLaDireccion(Direccion.ESTE, v );
        Evento esperado = new Evento( new DescuentoPorcentaje(20), new NoCambiarVehiculo(), new Avanzar() );


        assertEquals(esperado, resultado);
    }

    @Test

    public void UnAutoAvanzaYEncuentraUnaSorpresaDesfavorable (){
        IVehiculo v = new Auto();
        Celda posicionInicial = new Celda( new Desfavorable() );
        Jugador jugador = new Jugador("Pedro", posicionInicial, v);

        Evento resultado = jugador.avanzarHaciaLaDireccion(Direccion.ESTE, v );
        Evento esperado = new Evento( new AumentoPorcentaje(25), new NoCambiarVehiculo(), new Avanzar() );


        assertEquals(esperado, resultado);
    }

    @Test

    public void UnaMotoAvanzaYEncuentraUnaSorpresaCambioDeVehiculo (){
        IVehiculo v = new Auto();
        Celda posicionInicial = new Celda( new CambioVehiculo() );
        Jugador jugador = new Jugador("Pedro", posicionInicial, v);

        Evento resultado = jugador.avanzarHaciaLaDireccion(Direccion.ESTE, v );
        Evento esperado = new Evento( new SinPenalizar(), new SiguienteVehiculo(), new Avanzar() );


        assertEquals(esperado, resultado);
    }
    @Test

    public void UnaCuatroPorCuatroAvanzaYEncuentraUnaSorpresaCambioDeVehiculo (){
        IVehiculo v = new Auto();
        Celda posicionInicial = new Celda( new CambioVehiculo() );
        Jugador jugador = new Jugador("Pedro", posicionInicial, v);

        Evento resultado = jugador.avanzarHaciaLaDireccion(Direccion.ESTE, v );
        Evento esperado = new Evento( new SinPenalizar(), new SiguienteVehiculo(), new Avanzar() );


        assertEquals(esperado, resultado);
    }
    
    @Test

    public void UnMotoAvanzaYEncuentraUnaSorpresaCambioDeVehiculo (){
        IVehiculo v = new Auto();
        Celda posicionInicial = new Celda( new CambioVehiculo() );
        Jugador jugador = new Jugador("Pedro", posicionInicial, v);

        Evento resultado = jugador.avanzarHaciaLaDireccion(Direccion.ESTE, v );
        Evento esperado = new Evento( new SinPenalizar(), new SiguienteVehiculo(), new Avanzar() );


        assertEquals(esperado, resultado);
    }

}
