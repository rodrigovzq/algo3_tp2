package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Direccion.Direccion;

import java.util.Objects;

public class CeldaEsquina extends Celda {
    //Al ser una esquina, tiene posibilidad de moverse en una de las dir. verticales; y en una de las direcciones laterales
    private Celda celdaVertical;
    private Celda celdaLateral;

    private Direccion direccionVertical;
    private Direccion direccionLateral;

    public CeldaEsquina(EstadoCelda estado, Direccion direccionVertical, Direccion direccionLateral) {
        super( estado );
        //TODO: inicializar en un estado válido
        this.celdaVertical = null;
        this.celdaLateral = null;
        this.direccionVertical = direccionVertical;
        this.direccionLateral = direccionLateral;
    }

    public Celda getCelda(Direccion direccion){
        Celda celdaAdyacente = null;

        if (direccion == direccionLateral) {
            celdaAdyacente = celdaLateral;
        } else if (direccion == direccionVertical) {
            celdaAdyacente = celdaVertical;
        } else{
            //TODO: Lanzar excepcion.
        }
        return celdaAdyacente;
    }

    @Override
    public void setCelda(Celda nuevaCelda, Direccion direccion) {
        if (direccion == direccionLateral  ) {
            this.celdaLateral = nuevaCelda;
        } else if (direccion == direccionVertical  ) {
            this.celdaVertical = nuevaCelda;
        } else {
            //TODO: Lanzar excepcion
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CeldaEsquina celda = (CeldaEsquina) o;
        return Objects.equals(celdaVertical, celda.celdaVertical) && Objects.equals(celdaLateral, celda.celdaLateral);
    }
}
