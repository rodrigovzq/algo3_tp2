package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Celda.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class Celda {
    private EstadoCelda estado;
    public Movimiento avanzarEn(IVehiculo vehiculo){
        return estado.avanzarEn( vehiculo );
    }

    public Celda(EstadoCelda estado) {
        this.estado = estado;
    }

    public Celda getCeldaEste() {
        EstadoCelda obstaculo = new Pozo();
        return new Celda( obstaculo );
    }
}
