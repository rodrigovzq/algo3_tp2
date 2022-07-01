package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

// Las clases pertenecientes al Modelo son observables y van a notificar la ocurrencia
// de cambios de estados cada vez que se cambie algo en el.
public abstract class Observable {
    private List<Observador> observadores;

    public Observable() {
        this.observadores = new ArrayList<>();
    }

    public void notificarATodos() {
        for (Observador o : observadores) {
            o.actualizar();
        }
    }

    public void agregarObservador(Observador o) {
        observadores.add(o);
    }
}
