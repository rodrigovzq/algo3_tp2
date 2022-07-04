package edu.fiuba.algo3.modelo.Vehiculos;

public enum Vehiculo {
    AUTO{
        @Override
        public IVehiculo crear(){ return new Auto();}
    },
    MOTO{
        @Override
         public IVehiculo crear(){ return new Moto();}
    },
    CUATROPORCUATRO{
        @Override
        public IVehiculo crear(){ return new CuatroPorCuatro();}
    };

    public abstract IVehiculo crear();
    public static IVehiculo crearVehiculoDesdeString(String s){
        return valueOf( s.toUpperCase() ).crear();
    }
}
