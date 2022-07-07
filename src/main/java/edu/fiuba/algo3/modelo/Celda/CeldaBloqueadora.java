package edu.fiuba.algo3.modelo.Celda;

import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Excepcion.DireccionInvalida;
import edu.fiuba.algo3.modelo.EstadoCelda.Comun;

public class CeldaBloqueadora extends Celda {
    //TODO: Ojo con los valores default.
    public CeldaBloqueadora() {
        super(new Comun() , new Coordenada( 100, 100 ));
    }

    @Override
    public Celda getCelda(Direccion direccion) throws DireccionInvalida {
        return this;
    }

    @Override
    public void setCelda(Celda nuevaCelda, Direccion direccion) throws DireccionInvalida {
        //No hace nada, esta celda no conecta a nada.
    }

    @Override
    public boolean equals(Object o){
            if (this == o) return true;
            if (o == null || this.getClass() != o.getClass()) return false;
            return true;
    }
}
