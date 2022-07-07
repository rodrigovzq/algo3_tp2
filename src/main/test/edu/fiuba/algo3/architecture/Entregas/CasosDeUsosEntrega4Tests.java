package edu.fiuba.algo3.architecture.Entregas;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.EstadoCelda.Comun;
import edu.fiuba.algo3.modelo.EstadoCelda.IEstadoCelda;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorDemora;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.Obstaculo.Piquete;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Sorpresa.CambioVehiculo;
import edu.fiuba.algo3.modelo.Sorpresa.Desfavorable;
import edu.fiuba.algo3.modelo.Sorpresa.Favorable;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CasosDeUsosEntrega4Tests {
    @Test
    public void seGeneraUnMapaAleatoriamenteMeMuevoEnDiagonalConUnaCuatroPorCuatroYTengoMasMovimientosQueAvances(){
        //TODO: Mockear. Para quitar lo estocástico.
        //TODO: Testear generadores aleatorios.
        Mapa mapa = new Mapa( 20, 20);
        mapa.generarMapa();
        Celda posicionJugador = mapa.sortearCeldaJugador();
        Jugador jugador1 = new Jugador( "Grupo3", posicionJugador, new CuatroPorCuatro());
        Jugador jugador2 = new Jugador( "Grupo3", posicionJugador, new CuatroPorCuatro());

        for(int i = 0; i < 10; i++) {
            Evento ev = jugador1.avanzarHaciaLaDireccion(Direccion.ESTE);
            jugador1.actualizar(ev);
            ev = jugador1.avanzarHaciaLaDireccion(Direccion.SUR);
            jugador1.actualizar(ev);
        }

        mapa.setEstadosMapa();

        for(int i = 0; i < 10; i++) {
            Evento ev = jugador2.avanzarHaciaLaDireccion(Direccion.ESTE);
            jugador2.actualizar( ev );
            ev = jugador2.avanzarHaciaLaDireccion(Direccion.SUR);
            jugador2.actualizar(ev);
        }
        assertNotEquals(jugador2, jugador1);
    }

    @Test
    public void elJugadorSeMueveParaUnaSorpresaDosVecesPeroALaSegundaLaSorpresaDejoDeAfectar(){
        List<IEstadoCelda> estados = new ArrayList<>();
        estados.add( new Favorable() );
        estados.add( new Desfavorable() );
        estados.add( new CambioVehiculo() );
        estados.add( new ControlPolicial( new GeneradorDemora()));
        estados.add( new Piquete() );
        estados.add( new Pozo() );
        estados.add( new Comun() );
        estados.add( new Comun() );
        estados.add( new Comun() );

        Mapa mapa = new Mapa( 3, 3, new Coordenada(2,2), estados);
        Celda posicionJugador = mapa.getCeldaJugador();
        Jugador jugador1 = new Jugador( "Grupo3", posicionJugador, new CuatroPorCuatro());

        Evento ev = jugador1.avanzarHaciaLaDireccion(Direccion.NORTE);
        jugador1.actualizar(ev);
        ev = jugador1.avanzarHaciaLaDireccion(Direccion.NORTE);
        jugador1.actualizar(ev);

        ev = jugador1.avanzarHaciaLaDireccion(Direccion.OESTE);
        jugador1.actualizar(ev);

        ev = jugador1.avanzarHaciaLaDireccion(Direccion.SUR);
        jugador1.actualizar(ev);
        ev = jugador1.avanzarHaciaLaDireccion(Direccion.SUR);
        jugador1.actualizar(ev);

        ev = jugador1.avanzarHaciaLaDireccion(Direccion.OESTE);
        jugador1.actualizar(ev);

        ev = jugador1.avanzarHaciaLaDireccion(Direccion.NORTE);
        jugador1.actualizar(ev);
        ev = jugador1.avanzarHaciaLaDireccion(Direccion.NORTE);
        jugador1.actualizar(ev);

        String resultado = mapa.imprimir();
        //TODO: EL MAPA.TXT TIENE LA POSICION INICIAL DEL JUGADOR, NO LA ACTUAL !!!
        String esperado = "3x3;\n(2,2);\nCOMUN-COMUN-COMUN;\nCONTROL_POLICIAL-PIQUETE-POZO;\nCOMUN-COMUN-COMUN;\n";

        assertEquals(esperado,resultado);
    }

}