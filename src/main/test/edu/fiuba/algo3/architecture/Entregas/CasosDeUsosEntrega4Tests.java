package edu.fiuba.algo3.architecture.Entregas;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CasosDeUsosEntrega4Tests {
    @Test
    public void seGeneraUnMapaAleatoriamenteMeMuevoEnCirculoConElAutoYTengoMasMovimientosQueAvances(){
        //TODO: Mockear. Para quitar lo estocástico.
        //TODO: Testear generadores aleatorios.
        //TODO: Implementar sortearCeldaJugador.
        Mapa mapa1 = new Mapa( 20, 20);
        mapa1.generarMapa();
        mapa1.sortearEstadosMapa();
        Jugador jugador1 = new Jugador( "Grupo3", mapa1.sortearCeldaJugador(), new Auto());

        Mapa mapa2 = new Mapa( 20, 20);
        mapa2.generarMapa();
        Jugador jugador2 = new Jugador( "Grupo3", mapa2.sortearCeldaJugador(), new Auto());

        Evento ev = jugador1.avanzarHaciaLaDireccion(Direccion.ESTE);
        jugador1.actualizar( ev );
        ev = jugador1.avanzarHaciaLaDireccion(Direccion.SUR);
        jugador1.actualizar( ev );
        ev = jugador1.avanzarHaciaLaDireccion(Direccion.OESTE);
        jugador1.actualizar( ev );
        ev = jugador1.avanzarHaciaLaDireccion(Direccion.NORTE);
        jugador1.actualizar( ev );

        ev = jugador2.avanzarHaciaLaDireccion(Direccion.ESTE);
        jugador2.actualizar( ev );
        ev = jugador2.avanzarHaciaLaDireccion(Direccion.SUR);
        jugador2.actualizar( ev );
        ev = jugador2.avanzarHaciaLaDireccion(Direccion.OESTE);
        jugador2.actualizar( ev );
        ev = jugador2.avanzarHaciaLaDireccion(Direccion.NORTE);
        jugador2.actualizar( ev );

        assertNotEquals(jugador2, jugador1);
    }

}