package edu.fiuba.algo3.modelo.Evento.EventoPuntaje;

import edu.fiuba.algo3.modelo.Movimiento.Movimiento;

public class NoCambiarPuntaje implements EventoPuntaje{
    @Override
    public Movimiento actualizarPuntaje(Movimiento m) {
        return m;
    }
}
