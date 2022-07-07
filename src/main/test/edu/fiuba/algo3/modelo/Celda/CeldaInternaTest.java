package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.EstadoCelda.Comun;
import edu.fiuba.algo3.modelo.EstadoCelda.IEstadoCelda;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CeldaInternaTest {
    @Test
    public void creoUnaCeldaInternaYInicializoEnLasCeldas() {
        // TODO: Mockear?
        Coordenada coordenada = new Coordenada(0,0);
        CeldaInterna celda = new CeldaInterna(new Comun(), coordenada);

        CeldaInterna c1 = new CeldaInterna(new Pozo(), coordenada);
        CeldaInterna c2 = new CeldaInterna(new Pozo(), coordenada);
        CeldaInterna c3 = new CeldaInterna(new Pozo(), coordenada);
        CeldaInterna c4 = new CeldaInterna(new Pozo(), coordenada);

        celda.setCelda(c1, Direccion.NORTE);
        celda.setCelda(c2, Direccion.SUR);
        celda.setCelda(c3, Direccion.ESTE);
        celda.setCelda(c4, Direccion.OESTE);

        Celda esperado =  celda.getCelda(Direccion.NORTE);
        assertEquals(esperado, c1);
        esperado =  celda.getCelda(Direccion.SUR);
        assertEquals(esperado, c2);
        esperado =  celda.getCelda(Direccion.ESTE);
        assertEquals(esperado, c3);
        esperado =  celda.getCelda(Direccion.OESTE);
        assertEquals(esperado, c4);
    }

    @Test
    public void verificoQueLaInicializacionDeCeldasSeaCoherente() {
        // TODO: Mockear?
        Coordenada coordenada = new Coordenada(0,0);
        CeldaInterna celda = new CeldaInterna(new Comun(), coordenada);

        CeldaInterna norte = new CeldaInterna(new Pozo(), coordenada);
        CeldaInterna sur = new CeldaInterna(new Pozo(), coordenada);
        CeldaInterna este = new CeldaInterna(new Pozo(), coordenada);
        CeldaInterna oeste = new CeldaInterna(new Pozo(), coordenada);

        celda.setCelda( norte , Direccion.NORTE);
        celda.setCelda( sur , Direccion.SUR);
        celda.setCelda( este  , Direccion.ESTE);
        celda.setCelda( oeste , Direccion.OESTE);


        assertEquals(celda, norte.getCelda( Direccion.SUR ) );
        assertEquals(celda, sur.getCelda( Direccion.NORTE ) );
        assertEquals(celda, este.getCelda( Direccion.OESTE ) );
        assertEquals(celda, oeste.getCelda( Direccion.ESTE ) );
    }

    @Test
    public void obtengoLaDistanciaEntreDosCeldasAdyacentes() {
        // TODO: Mockear?
        Coordenada coordenada = new Coordenada(1,1);
        CeldaInterna celda = new CeldaInterna(new Comun(), coordenada);

        coordenada = new Coordenada(1,0);
        CeldaInterna norte = new CeldaInterna(new Pozo(), coordenada);

        coordenada = new Coordenada(1,2);
        CeldaInterna sur = new CeldaInterna(new Pozo(), coordenada);

        coordenada = new Coordenada(2,1);
        CeldaInterna este = new CeldaInterna(new Pozo(), coordenada);

        coordenada = new Coordenada(0,1);
        CeldaInterna oeste = new CeldaInterna(new Pozo(), coordenada);

        assertEquals(0, celda.distanciaHorizontal(norte));
        assertEquals(0, celda.distanciaHorizontal(sur));
        assertEquals(1, celda.distanciaHorizontal(este));
        assertEquals(-1, celda.distanciaHorizontal(oeste));

        assertEquals(-1, celda.distanciaVertical(norte));
        assertEquals(1, celda.distanciaVertical(sur));
        assertEquals(0, celda.distanciaVertical(este));
        assertEquals(0, celda.distanciaVertical(oeste));
    }
    //Vale para todas las celdas ya que es un metodo implementado en Celda que es abstracta.
    @Test
    public void esImprimible(){
        Coordenada mockCoordenada = mock( Coordenada.class );
        IEstadoCelda mockEstadoCelda = mock( IEstadoCelda.class );
        Celda celda = new CeldaInterna( mockEstadoCelda, mockCoordenada );

        when(mockEstadoCelda.imprimir()).thenReturn("MOCK_ESTADO_CELDA");
        when(mockCoordenada.imprimir()).thenReturn("(posX,posY)");
        String resultado = celda.imprimir();
        String esperado = "MOCK_ESTADO_CELDA-(posX,posY)";

        assertEquals(esperado, resultado);
    }


    @Test
    public void elCalculoDeLaDistanciaEntreCeldasEsDelegadoACoordenada(){
        Coordenada mockCoordenada = mock( Coordenada.class );
        IEstadoCelda mockEstadoCelda = mock( IEstadoCelda.class );
        Celda celda1 = new CeldaInterna( mockEstadoCelda, mockCoordenada );
        Celda celda2 = new CeldaInterna( mockEstadoCelda, mockCoordenada );

        celda1.distanciaHorizontal(celda2);
        celda1.distanciaVertical(celda2);

        verify(mockCoordenada).distanciaHorizontal(mockCoordenada);
        verify(mockCoordenada).distanciaVertical(mockCoordenada);

    }
    @Test
    public void elEstadoEsExternamenteSeteable(){
        Coordenada mockCoordenada = mock( Coordenada.class );
        IEstadoCelda mockEstadoCelda1 = mock( IEstadoCelda.class );
        Celda celda1 = new CeldaInterna( mockEstadoCelda1, mockCoordenada );

        IEstadoCelda mockEstadoCelda2 = mock( IEstadoCelda.class );
        celda1.setEstado(mockEstadoCelda2);

        assertEquals( new CeldaInterna( mockEstadoCelda2, mockCoordenada), celda1);
    }

    @Test
    public void paraAvanzarAUnaCeldaAdyacenteDelegaAlEstadoCelda(){
            Coordenada mockCoordenada = mock( Coordenada.class );
            IEstadoCelda mockEstadoCelda = mock( IEstadoCelda.class );
            IVehiculo mockVehiculo = mock(IVehiculo.class);
            Celda celda1 = new CeldaInterna( mockEstadoCelda, mockCoordenada );

            celda1.avanzarEn( mockVehiculo );
            verify(mockEstadoCelda).avanzarEn(mockVehiculo);
    }

    @Test
    public void elEstadoCeldaEsObtenibleEnFormaDeString(){
        IEstadoCelda mockEstado = mock( IEstadoCelda.class );
        Coordenada mockCoordenada = mock( Coordenada.class );
        when( mockEstado.imprimir() ).thenReturn( "EstadoCelda" );
        Celda celda = new CeldaInterna( mockEstado, mockCoordenada );

        String resultado = celda.getEstadoCelda();
        String esperado = "EstadoCelda";

        assertEquals(esperado, resultado);

    }

    @Test
    public void laCoordenadaEsObtenible(){
        IEstadoCelda mockEstado = mock( IEstadoCelda.class );
        Coordenada mockCoordenada = mock( Coordenada.class );
        Celda celda = new CeldaInterna( mockEstado, mockCoordenada );

        Coordenada resultado = celda.getCoordenada();

        assertEquals(mockCoordenada, resultado);
    }


}