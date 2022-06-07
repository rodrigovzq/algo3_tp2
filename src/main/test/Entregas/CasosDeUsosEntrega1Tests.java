package Entregas;

import edu.fiuba.algo3.modelo.Celda.Celda;
//import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Celda.Obstaculo.Piquete;
import edu.fiuba.algo3.modelo.Celda.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoInvalido;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoValido;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CasosDeUsosEntrega1Tests {
    @Test
    public void UnaMotoAvanzaYSeEncuentraConUnPozoSePenalizaEnTresMovimientos (){
        Moto moto = new Moto();
        Posicion posicionInicial = new Posicion( new Celda( new Pozo() ) );
        Jugador jugador = new Jugador("Pedro", posicionInicial, moto);

        Movimiento resultado = jugador.avanzarHaciaLaDireccion(Direccion.ESTE, moto );
        Movimiento esperado = new MovimientoValido(3);

        assertEquals(esperado, resultado);
    }

    @Test
    public void UnAutoAvanzaYSeEncuentraConUnPozoSePenalizaEnTresMovimientos (){
        Auto auto = new Auto();
        Posicion posicionInicial = new Posicion( new Celda( new Pozo() ) );
        Jugador jugador = new Jugador("Pedro", posicionInicial, auto);

        Movimiento resultado = jugador.avanzarHaciaLaDireccion( Direccion.NORTE, auto );
        Movimiento esperado = new MovimientoValido(3);

        assertEquals(esperado, resultado);
    }

    @Test
    public void UnaCuatroPorCuatroAvanzaYSeEncuentraConUnPozoYNoSePenaliza () {
        CuatroPorCuatro cxc = new CuatroPorCuatro();
        Posicion posicionInicial = new Posicion(new Celda( new Pozo() ));
        Jugador jugador = new Jugador("Pedro", posicionInicial, cxc);

        Movimiento resultado = jugador.avanzarHaciaLaDireccion(Direccion.SUR, cxc);
        Movimiento esperado = new MovimientoValido(1);

        assertEquals(esperado, resultado);
    }

    @Test
    public void UnaCuatroPorCuatroAvanzaYSeEncuentraConTresPozosSePenalizaEnDosMovimientos (){
        CuatroPorCuatro cxc = new CuatroPorCuatro();
        Posicion posicionInicial = new Posicion(new Celda( new Pozo() ));
        Jugador jugador = new Jugador("Pedro", posicionInicial, cxc);

        jugador.avanzarHaciaLaDireccion(Direccion.ESTE, cxc);
        jugador.avanzarHaciaLaDireccion(Direccion.ESTE, cxc);
        Movimiento resultado = jugador.avanzarHaciaLaDireccion(Direccion.ESTE, cxc);
        Movimiento esperado = new MovimientoValido(2);

        assertEquals(esperado, resultado);
    }

    @Test
    public void UnAutoAvanzaYSeEncuentraConUnPiqueteYNoPuedePasar () {
        Auto auto = new Auto();
        Posicion posicionInicial = new Posicion(new Celda( new Piquete() ));
        Jugador jugador = new Jugador("Pedro", posicionInicial, auto);

        Movimiento resultado = jugador.avanzarHaciaLaDireccion(Direccion.ESTE, auto);
        Movimiento esperado = new MovimientoInvalido();

        assertEquals(esperado, resultado);

    }
}
