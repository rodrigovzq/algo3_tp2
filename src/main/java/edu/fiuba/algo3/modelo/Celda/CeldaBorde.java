package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.EstadoCelda.IEstadoCelda;
import edu.fiuba.algo3.modelo.Excepcion.DireccionInvalida;

public class CeldaBorde extends Celda {
    //Tiene una de las direcciones bloqueadas
    private Celda celda1;
    private Celda celda2;
    private Celda celda3;
    private Direccion direccion1;
    private Direccion direccion2;
    private Direccion direccion3;
    
    public CeldaBorde(IEstadoCelda estado, Coordenada coordenada, Direccion direccion1, Direccion direccion2, Direccion direccion3) {
        super( estado, coordenada );
        Celda celdaNula = new CeldaBloqueadora();
        this.celda1 = celdaNula;
        this.celda2 = celdaNula;
        this.celda3 = celdaNula;
        this.direccion1 = direccion1;
        this.direccion2 = direccion2;
        this.direccion3 = direccion3;
    }

    @Override
    public Celda getCelda(Direccion direccion) throws DireccionInvalida{
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
    public void setCelda(Celda nuevaCelda, Direccion direccion) throws DireccionInvalida{
        if (direccion == direccion1  ) {
            this.celda1 = nuevaCelda;
        } else if (direccion == direccion2  ) {
            this.celda2 = nuevaCelda;
        } else if (direccion == direccion3  ) {
            this.celda3 = nuevaCelda;
        } else {
            throw new DireccionInvalida("setCelda :");
        }

        this.setCeldaOpuesta( nuevaCelda, direccion);

    }
}
