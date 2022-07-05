package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.Excepcion.ObstaculoInvalido;
import edu.fiuba.algo3.modelo.Excepcion.SorpresaInvalida;
import edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorAleatorio;
import edu.fiuba.algo3.modelo.Sorpresa.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ObstaculoTest {
    @Test
    public void esCapazDeCrearLaSorpresaDeseadaDesdeUnString(){
        String obstaculo = "piquete";
        IObstaculo o = Obstaculo.crearObstaculoDesdeString(obstaculo);
        assertEquals(new Piquete(), o);

        obstaculo = "pozo";
        o = Obstaculo.crearObstaculoDesdeString(obstaculo);
        assertEquals(new Pozo(), o);

        obstaculo = "Control_policial";
        GeneradorAleatorio mockGenerador = mock( GeneradorAleatorio.class );
        o = Obstaculo.crearObstaculoDesdeString(obstaculo);
        assertEquals(new ControlPolicial( mockGenerador ), o);

        assertThrows( ObstaculoInvalido.class, ()->Obstaculo.crearObstaculoDesdeString("ControlPolicial"));
    }
}