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
        try{
            return valueOf( s.toUpperCase() ).crear();
        }catch (IllegalArgumentException e){
            //TODO: Caso posible: Puede que esté malformado el archivo y entrar aca.
            throw new VehiculoInvalido();
        }
    }
}
