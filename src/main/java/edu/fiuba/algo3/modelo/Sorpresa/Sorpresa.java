package edu.fiuba.algo3.modelo.Sorpresa;

import edu.fiuba.algo3.modelo.Excepcion.ObstaculoInvalido;
import edu.fiuba.algo3.modelo.Excepcion.SorpresaInvalida;

public enum Sorpresa {
    FAVORABLE{
        @Override
        public ISorpresa crear(){ return new Favorable();}
    },
    DESFAVORABLE{
        @Override
        public ISorpresa crear(){ return new Desfavorable();}
    },
    CAMBIO_VEHICULO{
        @Override
        public ISorpresa crear(){ return new CambioVehiculo();}
    };

    public static ISorpresa crearSorpresaDesdeString(String s){
        try {
            return valueOf(s.toUpperCase()).crear();
        }catch(IllegalArgumentException e){
            throw new SorpresaInvalida("No existe la Sorpresa que se desea crear.");
        }
    }

    public abstract ISorpresa crear();

}
