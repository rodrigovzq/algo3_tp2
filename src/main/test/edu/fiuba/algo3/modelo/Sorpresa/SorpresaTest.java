package edu.fiuba.algo3.modelo.Sorpresa;

import edu.fiuba.algo3.modelo.Excepcion.SorpresaInvalida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SorpresaTest {
    @Test
    public void esCapazDeCrearLaSorpresaDeseadaDesdeUnString(){
        String sorpresa = "Favorable";
        ISorpresa s = Sorpresa.crearSorpresaDesdeString(sorpresa);
        assertEquals(new Favorable(), s);

        sorpresa = "Desfavorable";
        s = Sorpresa.crearSorpresaDesdeString(sorpresa);
        assertEquals(new Desfavorable(), s);

        sorpresa = "Cambio_Vehiculo";
        s = Sorpresa.crearSorpresaDesdeString(sorpresa);
        assertEquals(new CambioVehiculo(), s);

        assertThrows( SorpresaInvalida.class, ()->Sorpresa.crearSorpresaDesdeString("CambioVehiculo"));
    }

}