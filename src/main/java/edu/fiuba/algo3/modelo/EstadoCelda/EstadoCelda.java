package edu.fiuba.algo3.modelo.EstadoCelda;

import edu.fiuba.algo3.modelo.Excepcion.EstadoCeldaInvalido;
import edu.fiuba.algo3.modelo.Obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.Sorpresa.Sorpresa;

public enum EstadoCelda {
    OBSTACULO{
        @Override
        //TODO: Refactor
        public boolean identificar(String s){
            String estado = s.toUpperCase();
            return ( estado.equals("CONTROL_POLICIAL") ||  estado.equals("POZO") ||  estado.equals("PIQUETE") );
        }
    }, SORPRESA{
        @Override
        //TODO: Refactor
        public boolean identificar(String s){
            String estado = s.toUpperCase();
            return ( estado.equals("FAVORABLE") ||  estado.equals("DESFAVORABLE") ||  estado.equals("CAMBIO_VEHICULO") );
        }
    }, COMUN{
        @Override
        public boolean identificar(String s){
            String estado = s.toUpperCase();
            return estado.equals(this.name());
        }
    }, META{
        @Override
        public boolean identificar(String s){
            String estado = s.toUpperCase();
            return estado.equals(this.name());
        }
    };

    public static IEstadoCelda crearDesdeString(String s) {
        if (OBSTACULO.identificar(s)) {
            return Obstaculo.crearObstaculoDesdeString(s);
        } else if (SORPRESA.identificar(s)) {
            return Sorpresa.crearSorpresaDesdeString(s);
        } else if (COMUN.identificar(s)) {
            return new Comun();
        } else if (META.identificar(s)){
            return new Meta();
        }else{
            throw new EstadoCeldaInvalido("Ningun EstadoCelda pudo identificarse");
        }
    }
    public abstract boolean identificar( String s );

}
