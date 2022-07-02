package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorAleatorio;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ControlPolicialTest {
  @Test
  public void seDecideSiElVehiculoQuedaDemoradoConUnaProbabilidadDeterminada() {
      GeneradorAleatorio mockGenerador = mock(GeneradorAleatorio.class);
      ControlPolicial control = new ControlPolicial(mockGenerador);
      IVehiculo mockVehiculo = mock(IVehiculo.class);
      when(mockVehiculo.obtenerProbabilidadDeSerDetenido()).thenReturn(0.8f);
      control.avanzarEn(mockVehiculo);
      verify(mockGenerador).aplicar(0.8f);
  }
    @Test
    public void siDecideQueQuedaDemoradoElVehiculoAvanzaControlPolicial() {
        GeneradorAleatorio mockGenerador = mock(GeneradorAleatorio.class);
        ControlPolicial control = new ControlPolicial(mockGenerador);
        IVehiculo mockVehiculo = mock(IVehiculo.class);
        when(mockVehiculo.obtenerProbabilidadDeSerDetenido()).thenReturn(0.8f);
        when(mockGenerador.aplicar(0.8f)).thenReturn(true);
        control.avanzarEn(mockVehiculo);
        verify(mockVehiculo).avanzarControlPolicial();
    }

    @Test
    public void siDecideQueQuedaDemoradoElVehiculoAvanzaComun() {
        GeneradorAleatorio mockGenerador = mock(GeneradorAleatorio.class);
        ControlPolicial control = new ControlPolicial(mockGenerador);
        IVehiculo mockVehiculo = mock(IVehiculo.class);
        when(mockVehiculo.obtenerProbabilidadDeSerDetenido()).thenReturn(0.8f);
        when(mockGenerador.aplicar(0.8f)).thenReturn(false);
        control.avanzarEn(mockVehiculo);
        verify(mockVehiculo).avanzarComun();
    }

  @Test
  public void esImprimible(){
      GeneradorAleatorio mockGenerador = mock(GeneradorAleatorio.class);
      ControlPolicial control = new ControlPolicial(mockGenerador);
      String resultado = control.imprimir();
      String esperado = "CONTROL_POLICIAL";
      assertEquals(esperado, resultado);
  }

}