package edu.fiuba.algo3.modelo.Evento.EventoPosicion;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.CeldaInterna;
import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.EstadoCelda.Comun;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvanzarTest {
    @Test
    public void seteoLaDireccionParaElEsteYDevuelveLaCeldaInternaEste(){
        Avanzar avanzar = new Avanzar();
        avanzar.setDireccion(Direccion.ESTE);

        Coordenada coordenada = new Coordenada(0,0);
        CeldaInterna celdaEste = new CeldaInterna( new Comun(), coordenada);
        CeldaInterna celdaSur = new CeldaInterna( new Comun(), coordenada);
        CeldaInterna celdaNorte = celdaSur;
        CeldaInterna celdaOeste = celdaSur;

        CeldaInterna celdaActual = new CeldaInterna( new Comun(), coordenada);

        celdaActual.setCelda(celdaNorte, Direccion.NORTE);
        celdaActual.setCelda(celdaEste, Direccion.ESTE);
        celdaActual.setCelda(celdaOeste, Direccion.OESTE);
        celdaActual.setCelda(celdaSur, Direccion.SUR);

        Celda resultado = avanzar.actualizarPosicion( celdaActual );
        CeldaInterna esperado = celdaEste;
        
        assertEquals(esperado, resultado);
    }
    @Test
    public void seteoLaDireccionParaElNorteYDevuelveLaCeldaInternaNorte(){
        Avanzar avanzar = new Avanzar();
        avanzar.setDireccion(Direccion.NORTE);

        Coordenada coordenada = new Coordenada(0,0);
        CeldaInterna celdaNorte = new CeldaInterna( new Comun(), coordenada);
        CeldaInterna celdaEste = new CeldaInterna( new Comun(), coordenada);
        CeldaInterna celdaSur = celdaEste;
        CeldaInterna celdaOeste = celdaEste;

        CeldaInterna celdaActual = new CeldaInterna( new Comun(), coordenada);

        celdaActual.setCelda(celdaNorte, Direccion.NORTE);
        celdaActual.setCelda(celdaEste, Direccion.ESTE);
        celdaActual.setCelda(celdaOeste, Direccion.OESTE);
        celdaActual.setCelda(celdaSur, Direccion.SUR);

        Celda resultado = avanzar.actualizarPosicion( celdaActual );
        CeldaInterna esperado = celdaNorte;

        assertEquals(esperado, resultado);
    }
    @Test
    public void seteoLaDireccionParaElSurYDevuelveLaCeldaInternaSur(){
        Avanzar avanzar = new Avanzar();
        avanzar.setDireccion(Direccion.SUR);

        Coordenada coordenada = new Coordenada(0,0);
        CeldaInterna celdaSur = new CeldaInterna( new Comun(), coordenada);
        CeldaInterna celdaEste = new CeldaInterna( new Comun(), coordenada);
        CeldaInterna celdaNorte = celdaEste;
        CeldaInterna celdaOeste = celdaEste;

        CeldaInterna celdaActual = new CeldaInterna( new Comun(), coordenada);

        celdaActual.setCelda(celdaNorte, Direccion.NORTE);
        celdaActual.setCelda(celdaEste, Direccion.ESTE);
        celdaActual.setCelda(celdaOeste, Direccion.OESTE);
        celdaActual.setCelda(celdaSur, Direccion.SUR);

        Celda resultado = avanzar.actualizarPosicion( celdaActual );
        CeldaInterna esperado = celdaSur;

        assertEquals(esperado, resultado);
    }
    @Test
    public void seteoLaDireccionParaElOesteYDevuelveLaCeldaInternaOeste(){
        Avanzar avanzar = new Avanzar();
        avanzar.setDireccion(Direccion.OESTE);

        Coordenada coordenada = new Coordenada(0,0);
        CeldaInterna celdaOeste = new CeldaInterna( new Comun(), coordenada);
        CeldaInterna celdaEste = new CeldaInterna( new Comun(), coordenada);
        CeldaInterna celdaNorte = celdaEste;
        CeldaInterna celdaSur = celdaEste;

        CeldaInterna celdaActual = new CeldaInterna( new Comun(), coordenada);

        celdaActual.setCelda(celdaNorte, Direccion.NORTE);
        celdaActual.setCelda(celdaEste, Direccion.ESTE);
        celdaActual.setCelda(celdaOeste, Direccion.OESTE);
        celdaActual.setCelda(celdaSur, Direccion.SUR);

        Celda resultado = avanzar.actualizarPosicion( celdaActual );
        CeldaInterna esperado = celdaOeste;

        assertEquals(esperado, resultado);

    }

    @Test
    public void comparacionEntreDosEventosAvanzar(){
        Avanzar avanzar1 = new Avanzar();
        Avanzar avanzar2 = new Avanzar();
        assertEquals(avanzar1, avanzar2);
    }
}