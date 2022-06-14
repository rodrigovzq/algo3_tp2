package Entregas;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.Comun;
import edu.fiuba.algo3.modelo.Celda.Obstaculo.Pozo;
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
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CasosDeUsosEntrega2Tests {

    @Test

    public void UnVehiculoAvanzaYEncuentraUnaSorpresaFavorable (){
        IVehiculo v = new Auto();
        Celda celdaAdyacente = new Celda( new Favorable() );
        Celda posicion1Inicial = new Celda( new Comun(), celdaAdyacente, celdaAdyacente,celdaAdyacente,celdaAdyacente );
        Celda posicion2Inicial = new Celda( new Comun(), celdaAdyacente, celdaAdyacente,celdaAdyacente,celdaAdyacente );

        Jugador jugador1 = new Jugador("Pedro", posicion1Inicial, v);
        Jugador jugador2 = new Jugador("Pedro", posicion2Inicial, v);

        Evento resultado = jugador1.avanzarHaciaLaDireccion(Direccion.ESTE, v );
        Evento esperado = new Evento( new DescuentoPorcentaje(20), new NoCambiarVehiculo(), new Avanzar() );
        esperado.setDireccion(Direccion.ESTE);

        jugador1.actualizar(resultado);
        jugador2.actualizar(esperado);

        assertEquals(jugador2, jugador1);
    }

    @Test

    public void UnAutoAvanzaYEncuentraUnaSorpresaDesfavorable (){
        IVehiculo v = new Auto();
        Celda celdaAdyacente = new Celda( new Desfavorable() );
        Celda posicion1Inicial = new Celda( new Comun(), celdaAdyacente, celdaAdyacente,celdaAdyacente,celdaAdyacente );
        Celda posicion2Inicial = new Celda( new Comun(), celdaAdyacente, celdaAdyacente,celdaAdyacente,celdaAdyacente );

        Jugador jugador1 = new Jugador("Pedro", posicion1Inicial, v);
        Jugador jugador2 = new Jugador("Pedro", posicion2Inicial, v);

        Evento resultado = jugador1.avanzarHaciaLaDireccion(Direccion.ESTE, v );
        Evento esperado = new Evento( new DescuentoPorcentaje(20), new NoCambiarVehiculo(), new Avanzar() );
        esperado.setDireccion(Direccion.ESTE);

        jugador1.actualizar(resultado);
        jugador2.actualizar(esperado);

        assertEquals(jugador2, jugador1);
    }

    @Test

    public void UnaMotoAvanzaYEncuentraUnaSorpresaCambioDeVehiculo (){
        IVehiculo v = new Auto();
        Celda celdaAdyacente = new Celda( new CambioVehiculo() );
        Celda posicion1Inicial = new Celda( new Comun(), celdaAdyacente, celdaAdyacente,celdaAdyacente,celdaAdyacente );
        Celda posicion2Inicial = new Celda( new Comun(), celdaAdyacente, celdaAdyacente,celdaAdyacente,celdaAdyacente );

        Jugador jugador1 = new Jugador("Pedro", posicion1Inicial, v);
        Jugador jugador2 = new Jugador("Pedro", posicion2Inicial, v);

        Evento resultado = jugador1.avanzarHaciaLaDireccion(Direccion.ESTE, v );
        Evento esperado = new Evento( new DescuentoPorcentaje(20), new NoCambiarVehiculo(), new Avanzar() );
        esperado.setDireccion(Direccion.ESTE);

        jugador1.actualizar(resultado);
        jugador2.actualizar(esperado);

        assertEquals(jugador2, jugador1);
    }
    @Test

    public void UnaCuatroPorCuatroAvanzaYEncuentraUnaSorpresaCambioDeVehiculo (){
        IVehiculo v = new Auto();
        Celda celdaAdyacente = new Celda( new CambioVehiculo() );
        Celda posicion1Inicial = new Celda( new Comun(), celdaAdyacente, celdaAdyacente,celdaAdyacente,celdaAdyacente );
        Celda posicion2Inicial = new Celda( new Comun(), celdaAdyacente, celdaAdyacente,celdaAdyacente,celdaAdyacente );

        Jugador jugador1 = new Jugador("Pedro", posicion1Inicial, v);
        Jugador jugador2 = new Jugador("Pedro", posicion2Inicial, v);

        Evento resultado = jugador1.avanzarHaciaLaDireccion(Direccion.ESTE, v );
        Evento esperado = new Evento( new DescuentoPorcentaje(20), new NoCambiarVehiculo(), new Avanzar() );
        esperado.setDireccion(Direccion.ESTE);

        jugador1.actualizar(resultado);
        jugador2.actualizar(esperado);

        assertEquals(jugador2, jugador1);
    }
    
    @Test

    public void UnMotoAvanzaYEncuentraUnaSorpresaCambioDeVehiculo (){
        IVehiculo v = new Moto();
        Celda celdaAdyacente = new Celda( new CambioVehiculo() );
        Celda posicion1Inicial = new Celda( new Comun(), celdaAdyacente, celdaAdyacente,celdaAdyacente,celdaAdyacente );
        Celda posicion2Inicial = new Celda( new Comun(), celdaAdyacente, celdaAdyacente,celdaAdyacente,celdaAdyacente );

        Jugador jugador1 = new Jugador("Pedro", posicion1Inicial, v);
        Jugador jugador2 = new Jugador("Pedro", posicion2Inicial, v);

        Evento resultado = jugador1.avanzarHaciaLaDireccion(Direccion.ESTE, v );
        Evento esperado = new Evento( new DescuentoPorcentaje(20), new NoCambiarVehiculo(), new Avanzar() );
        esperado.setDireccion(Direccion.ESTE);

        jugador1.actualizar(resultado);
        jugador2.actualizar(esperado);

        assertEquals(jugador2, jugador1);
    }

}
