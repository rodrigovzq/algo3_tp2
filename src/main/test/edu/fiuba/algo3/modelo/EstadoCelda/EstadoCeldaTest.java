package edu.fiuba.algo3.modelo.EstadoCelda;

import edu.fiuba.algo3.modelo.Excepcion.EstadoCeldaInvalido;
import edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorAleatorio;
import edu.fiuba.algo3.modelo.Obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.Obstaculo.Piquete;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Sorpresa.CambioVehiculo;
import edu.fiuba.algo3.modelo.Sorpresa.Desfavorable;
import edu.fiuba.algo3.modelo.Sorpresa.Favorable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class EstadoCeldaTest {
    @Test
    public void esCapazDeIdentificarYCrearDesdeUnStringElEstadoCeldaCorrespondiente(){
        String estado = "Piquete";
        IEstadoCelda estadoCelda = EstadoCelda.crearDesdeString(estado);
        assertEquals( new Piquete(), estadoCelda );

        estado = "Pozo";
        estadoCelda = EstadoCelda.crearDesdeString(estado);
        assertEquals( new Pozo(), estadoCelda );

        estado = "Control_policial";
        estadoCelda = EstadoCelda.crearDesdeString(estado);
        GeneradorAleatorio mockGenerador = mock(GeneradorAleatorio.class);
        assertEquals( new ControlPolicial( mockGenerador ), estadoCelda );

        estado = "Favorable";
        estadoCelda = EstadoCelda.crearDesdeString(estado);
        assertEquals( new Favorable(), estadoCelda );

        estado = "Desfavorable";
        estadoCelda = EstadoCelda.crearDesdeString(estado);
        assertEquals( new Desfavorable(), estadoCelda );

        estado = "Cambio_vehiculo";
        estadoCelda = EstadoCelda.crearDesdeString(estado);
        assertEquals( new CambioVehiculo(), estadoCelda );

        estado = "meta";
        estadoCelda = EstadoCelda.crearDesdeString(estado);
        assertEquals( new Meta(), estadoCelda );

        assertThrows( EstadoCeldaInvalido.class, ()->EstadoCelda.crearDesdeString("Controlpolicial"));
    }

}