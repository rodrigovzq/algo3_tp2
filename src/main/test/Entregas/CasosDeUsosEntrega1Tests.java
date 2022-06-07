package Entregas;

import edu.fiuba.algo3.modelo.Jugador.Celda.Celda;
//import edu.fiuba.algo3.modelo.Direccion;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoValido;
import edu.fiuba.algo3.modelo.Obstaculo.Piquete;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CasosDeUsosEntrega1Tests {
    @Test
    public void UnaMotoAvanzaYSeEncuentraConUnPozoSePenalizaEnTresMovimientos (){
        Moto moto = new Moto();
        Posicion posicionInicial = new Posicion( new Celda() );
        Jugador jugador = new Jugador("Pedro", posicionInicial, moto);

        Movimiento resultado = jugador.avanzarHaciaLaDireccion( "Este", moto );
        Movimiento esperado = new MovimientoValido(3);

        assertEquals(esperado, resultado);



    }

    @Test
    public void UnAutoAvanzaYSeEncuentraConUnPozoSePenalizaEnTresMovimientos (){

       // assertEquals(3, jugador.avanzarHaciaLaDireccion( este, auto ) );
    }

    @Test
    public void UnaCuatroPorCuatroAvanzaYSeEncuentraConUnPozoYNoSePenaliza (){

        //assertEquals(1, jugador.avanzarHaciaLaDireccion( este, cxc ) );
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
