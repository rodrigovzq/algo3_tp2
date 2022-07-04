package UnitTest.Vehiculos;

import edu.fiuba.algo3.modelo.Evento.Evento;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.Avanzar;
import edu.fiuba.algo3.modelo.Evento.EventoPosicion.NoCambiarPosicion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.NoCambiarPuntaje;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.Penalizacion;
import edu.fiuba.algo3.modelo.Evento.EventoPuntaje.SinPenalizar;
import edu.fiuba.algo3.modelo.Evento.EventoVehiculo.NoCambiarVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuatroPorCuatroTest {

    @Test
    public void avanzarSobreDosPozosNoPenaliza(){
        CuatroPorCuatro cxc = new CuatroPorCuatro();

        cxc.avanzarPozo();
        Evento resultado = cxc.avanzarPozo();
        Evento esperado = new Evento( new SinPenalizar(), new NoCambiarVehiculo(), new Avanzar());

        assertEquals(esperado, resultado);
    }

    @Test
    public void avanzarSobreTresPozosPenalizaConDosMovimientos(){
        CuatroPorCuatro cxc = new CuatroPorCuatro();

        cxc.avanzarPozo();
        cxc.avanzarPozo();
        Evento resultado = cxc.avanzarPozo();

        Evento esperado = new Evento( new Penalizacion(2), new NoCambiarVehiculo(), new Avanzar());


        assertEquals(esperado, resultado);
    }
    @Test
    public void avanzarSobreCuatroPozosPenalizaUnaVez(){
        CuatroPorCuatro cxc = new CuatroPorCuatro();

        cxc.avanzarPozo();
        cxc.avanzarPozo();
        Evento resultado = cxc.avanzarPozo();

        Evento esperado = new Evento( new Penalizacion(2), new NoCambiarVehiculo(), new Avanzar());

        assertEquals(esperado, resultado);

        resultado = cxc.avanzarPozo();

        esperado = new Evento( new SinPenalizar(), new NoCambiarVehiculo(), new Avanzar());

        assertEquals(esperado, resultado);
    }

    @Test
    public void avanzarSobreUnPiqueteEsUnMovimientoInvalido(){
        CuatroPorCuatro cxc = new CuatroPorCuatro();

        Evento resultado = cxc.avanzarPiquete();

        Evento esperado = new Evento( new NoCambiarPuntaje(), new NoCambiarVehiculo(), new NoCambiarPosicion());

        assertEquals(esperado, resultado);
    }

    @Test
    public void avanzarSobreUnaCeldaSinObstaculosNoPenaliza(){
        CuatroPorCuatro cxc = new CuatroPorCuatro();

        Evento resultado = cxc.avanzarComun();
        Evento esperado = new Evento( new SinPenalizar(), new NoCambiarVehiculo(), new Avanzar());

        assertEquals(esperado, resultado);
    }
    @Test
    public void anteUnCambioDeVehiculoSecuencialElAutoSeConvierteEnCuatroPorCuatro(){
        Auto auto = new Auto();

        assertEquals( new CuatroPorCuatro(), auto.siguiente());
    }

    @Test
    public void esImprimible(){
        CuatroPorCuatro cxc = new CuatroPorCuatro();
        assertEquals("CuatroPorCuatro", cxc.imprimir());
    }
}