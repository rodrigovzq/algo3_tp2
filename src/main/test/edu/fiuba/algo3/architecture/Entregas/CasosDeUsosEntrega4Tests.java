package edu.fiuba.algo3.architecture.Entregas;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CasosDeUsosEntrega4Tests {
    @Test
    public void seGeneraUnMapaAleatoriamenteMeMuevoEnDiagonalConLaMotoYTengoMasMovimientosQueAvances(){
        //TODO: Mockear. Para quitar lo estocástico.
        //TODO: Testear generadores aleatorios.
        Mapa mapa = new Mapa( 20, 20);
        mapa.generarMapa();
        Celda posicionJugador = mapa.sortearCeldaJugador();
        Jugador jugador1 = new Jugador( "Grupo3", posicionJugador, new Moto());
        Jugador jugador2 = new Jugador( "Grupo3", posicionJugador, new Moto());

        for(int i = 0; i < 10; i++) {
            Evento ev = jugador1.avanzarHaciaLaDireccion(Direccion.ESTE);
            jugador1.actualizar(ev);
            ev = jugador1.avanzarHaciaLaDireccion(Direccion.SUR);
            jugador1.actualizar(ev);
        }

        mapa.sortearEstadosMapa();

        for(int i = 0; i < 10; i++) {
            Evento ev = jugador2.avanzarHaciaLaDireccion(Direccion.ESTE);
            jugador2.actualizar( ev );
            ev = jugador2.avanzarHaciaLaDireccion(Direccion.SUR);
            jugador2.actualizar(ev);
        }
        assertNotEquals(jugador2, jugador1);
    }

}