package edu.fiuba.algo3.modelo.Sorpresa;

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
        return valueOf( s.toUpperCase() ).crear();
    }

    public abstract ISorpresa crear();

}
