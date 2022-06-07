package Entregas;

import edu.fiuba.algo3.modelo.Celda.Celda;
//import edu.fiuba.algo3.modelo.Direccion;
import edu.fiuba.algo3.modelo.Celda.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
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

        Movimiento resultado = jugador.avanzarHaciaLaDireccion( "este", moto );
        Movimiento esperado = new MovimientoValido(3);

        assertEquals(esperado, resultado);
    }

    @Test
    public void UnAutoAvanzaYSeEncuentraConUnPozoSePenalizaEnTresMovimientos (){
        Auto auto = new Auto();
        Posicion posicionInicial = new Posicion( new Celda( new Pozo() ) );
        Jugador jugador = new Jugador("Pedro", posicionInicial, auto);

        Movimiento resultado = jugador.avanzarHaciaLaDireccion( "este", auto );
        Movimiento esperado = new MovimientoValido(3);

        assertEquals(esperado, resultado);
    }

    @Test
    public void UnaCuatroPorCuatroAvanzaYSeEncuentraConUnPozoYNoSePenaliza () {
        CuatroPorCuatro cxc = new CuatroPorCuatro();
        Posicion posicionInicial = new Posicion(new Celda( new Pozo() ));
        Jugador jugador = new Jugador("Pedro", posicionInicial, cxc);

        Movimiento resultado = jugador.avanzarHaciaLaDireccion("este", cxc);
        Movimiento esperado = new MovimientoValido(1);

        assertEquals(esperado, resultado);
    }

    @Test
    public void UnaCuatroPorCuatroAvanzaYSeEncuentraConTresPozosSePenalizaEnDosMovimientos (){

        //assertEquals(2, jugador.avanzarHaciaLaDireccion( este, cxc ) );

    }

    @Test
    public void UnAutoAvanzaYSeEncuentraConUnPiqueteYNoPuedePasar () {

        //assertEquals(0, jugador.avanzarHaciaLaDireccion( este, auto ) );

    }
}
