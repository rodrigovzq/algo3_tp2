package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Excepcion.DireccionInvalida;

import java.util.Objects;

public class CeldaEsquina extends Celda {
    //Al ser una esquina, tiene posibilidad de moverse en una de las dir. verticales; y en una de las direcciones laterales
    private Celda celdaVertical;
    private Celda celdaLateral;

    private Direccion direccionVertical;
    private Direccion direccionLateral;

    public CeldaEsquina(EstadoCelda estado, Coordenada coordenada, Direccion direccionVertical, Direccion direccionLateral) {
        super( estado, coordenada );
        //TODO: Inicializar en un estado válido. ¿CeldaAnemica?
        this.celdaVertical = null;
        this.celdaLateral = null;
        this.direccionVertical = direccionVertical;
        this.direccionLateral = direccionLateral;
    }

    public Celda getCelda(Direccion direccion) throws DireccionInvalida{
        Celda celdaAdyacente = null;

        if (direccion == direccionLateral) {
            celdaAdyacente = celdaLateral;
        } else if (direccion == direccionVertical) {
            celdaAdyacente = celdaVertical;
        } else{
            throw new DireccionInvalida("getCelda :");
        }
        return celdaAdyacente;
    }

    @Override
    public void setCelda(Celda nuevaCelda, Direccion direccion) throws DireccionInvalida {
        if (direccion == direccionLateral  ) {
            this.celdaLateral = nuevaCelda;
        } else if (direccion == direccionVertical  ) {
            this.celdaVertical = nuevaCelda;
        } else {
            throw new DireccionInvalida("setCelda :");
        }

        this.setCeldaOpuesta( nuevaCelda, direccion);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CeldaEsquina celda = (CeldaEsquina) o;
        return Objects.equals(celdaVertical, celda.celdaVertical) && Objects.equals(celdaLateral, celda.celdaLateral);
    }
}
