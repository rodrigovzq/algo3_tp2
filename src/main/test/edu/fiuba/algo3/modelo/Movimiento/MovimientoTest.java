package edu.fiuba.algo3.modelo.Movimiento;

import edu.fiuba.algo3.modelo.Excepcion.MovimientoInvalido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovimientoTest {
    @Test
    public void sumaDeMovimientos(){
        Movimiento m1 = new Movimiento(0);
        Movimiento m2 = new Movimiento(1);

        Movimiento resultado = m1.sumarMovimiento(m2);
        Movimiento esperado = new Movimiento(1);

        assertEquals( esperado, resultado);

        m1 = new Movimiento(1);
        m2 = new Movimiento(0);

        resultado = m1.sumarMovimiento(m2);
        esperado = new Movimiento(1);

        assertEquals( esperado, resultado);

        m1 = new Movimiento(1);
        m2 = new Movimiento(1);

        resultado = m1.sumarMovimiento(m2);
        esperado = new Movimiento(2);

        assertEquals( esperado, resultado);
    }

    @Test
    public void noEsPosibleTenerMovimientosNegativos(){
        assertThrows( MovimientoInvalido.class, () -> new Movimiento(-1));
        assertDoesNotThrow( () -> new Movimiento(0));

    }

    @Test
    public void seCreaUnMovimientoYSeAplicanDistintosAumentos(){
        Movimiento m = new Movimiento(150 );

        Movimiento resultado = m.aplicarAumento(0.0F);
        Integer aumento = 0;
        Movimiento esperado = new Movimiento(150 + aumento);
        assertEquals( esperado, resultado);
        for(int i = 10; i <110; i+=10) {
            resultado = m.aplicarAumento((float) i);
            aumento = 150 * i / 100;
            esperado = new Movimiento(150 + aumento);
            assertEquals( esperado, resultado);
        }
    }

    @Test
    public void seCreaUnMovimientoYSeAplicanDistintosDescuentos(){
        Movimiento m = new Movimiento(150 );

        Movimiento resultado = m.aplicarAumento(0.0F);
        Integer descuento = 0;
        Movimiento esperado = new Movimiento(150 + descuento);
        assertEquals( esperado, resultado);
        for(float i = 10.0F; i <110; i+=10) {
            resultado = m.aplicarDescuento( i);
            descuento = (int) (150 * (i / 100) );
            esperado = new Movimiento(150 - descuento);
            assertEquals( esperado, resultado);
        }
    }

    @Test
    public void esImprimible(){
        Movimiento m = new Movimiento(0);
        String resultado = m.imprimir();
        String esperado = "0";
        assertEquals(esperado, resultado);

        for(Integer i = 10; i <110; i+=10) {
            m = new Movimiento(i);
            resultado = m.imprimir();
            esperado = i.toString();
            assertEquals(esperado, resultado);
        }
    }
}