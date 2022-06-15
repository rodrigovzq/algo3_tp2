package edu.fiuba.algo3.modelo.Celda.Obstaculo;

import edu.fiuba.algo3.modelo.Celda.Obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.Celda.Obstaculo.GeneradorAleatorio;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class ControlPolicialTest {
  @Test
  public void seDecideSiElVehiculoQuedaDemoradoConUnaProbabilidadDeterminada() {
      GeneradorAleatorio mockGenerador = mock(GeneradorAleatorio.class);
      ControlPolicial control = new ControlPolicial(mockGenerador);
      IVehiculo vehiculoMock = mock(IVehiculo.class);
      when(vehiculoMock.obtenerProbabilidadDeSerDetenido()).thenReturn(0.8f);
      control.avanzarEn(vehiculoMock);
      verify(mockGenerador).aplicar(0.8f);
  }
}