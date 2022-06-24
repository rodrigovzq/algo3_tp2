package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Excepcion.DireccionInvalida;

import java.util.Objects;

public class CeldaBorde extends Celda {
    //Tiene una de las direcciones bloqueadas
    private Celda celda1;
    private Celda celda2;
    private Celda celda3;
    private Direccion direccion1;
    private Direccion direccion2;
    private Direccion direccion3;
    
    public CeldaBorde(EstadoCelda estado, Direccion direccion1, Direccion direccion2, Direccion direccion3) {
        super( estado );
        this.direccion1 = direccion1;
        this.direccion2 = direccion2;
        this.direccion3 = direccion3;
    }

    public Celda getCelda(Direccion direccion){
        Celda celdaAdyacente = null;

        if (direccion == direccion1) {
            celdaAdyacente = celda1;
        } else if (direccion == direccion2) {
            celdaAdyacente = celda2;
        } else if (direccion == direccion3) {
            celdaAdyacente = celda3;
        } else {
            throw new DireccionInvalida("getCelda :");
        }
        return celdaAdyacente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CeldaBorde celda = (CeldaBorde) o;
        return Objects.equals(celda1, celda.celda1) && Objects.equals(celda2, celda.celda2) && Objects.equals(celda3, celda.celda3);
    }


    @Override
    public void setCelda(Celda nuevaCelda, Direccion direccion){
        if (direccion == direccion1  ) {
            this.celda1 = nuevaCelda;
        } else if (direccion == direccion2  ) {
            this.celda2 = nuevaCelda;
        } else if (direccion == direccion3  ) {
            this.celda3 = nuevaCelda;
        } else {
            throw new DireccionInvalida("setCelda :");
        }
    }
}
