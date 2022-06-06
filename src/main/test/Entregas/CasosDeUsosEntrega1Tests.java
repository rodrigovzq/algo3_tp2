package Entregas;

import edu.fiuba.algo3.modelo.Direccion;
import edu.fiuba.algo3.modelo.Obstaculo.Piquete;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CasosDeUsosEntrega1Tests {

    private Pozo obstaculo1;
    private Piquete obstaculo2;

    IVehiculo cxc = new CuatroPorCuatro();
    IVehiculo moto = new Moto();
    IVehiculo auto = new Auto();


    Jugador jugador = new Jugador("Pepe");
    Direccion este = new Direccion();





    @Test
    public void UnaMotoAvanzaYSeEncuentraConUnPozoSePenalizaEnTresMovimientos (){

        this.obstaculo1 = new Pozo(1);
        //assertEquals(3, jugador.avanzarHaciaLaDireccion( este, moto ) );
    }

    @Test
    public void UnAutoAvanzaYSeEncuentraConUnPozoSePenalizaEnTresMovimientos (){

        this.obstaculo1 = new Pozo(1);
       // assertEquals(3, jugador.avanzarHaciaLaDireccion( este, auto ) );
    }

    @Test
    public void UnaCuatroPorCuatroAvanzaYSeEncuentraConUnPozoYNoSePenaliza (){

        this.obstaculo1 = new Pozo(1);
        //assertEquals(1, jugador.avanzarHaciaLaDireccion( este, cxc ) );
    }

    @Test
    public void UnaCuatroPorCuatroAvanzaYSeEncuentraConTresPozosSePenalizaEnDosMovimientos (){

        this.obstaculo1 = new Pozo(3);
        //assertEquals(2, jugador.avanzarHaciaLaDireccion( este, cxc ) );

    }

    @Test
    public void UnAutoAvanzaYSeEncuentraConUnPiqueteYNoPuedePasar () {

        this.obstaculo2 = new Piquete(1);
        //assertEquals(0, jugador.avanzarHaciaLaDireccion( este, auto ) );

    }
}
