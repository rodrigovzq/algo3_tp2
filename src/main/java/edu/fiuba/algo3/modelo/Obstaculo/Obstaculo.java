package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorDemora;

public enum Obstaculo {
    CONTROL_POLICIAL{
        @Override
        public IObstaculo crear(){ return new ControlPolicial(new GeneradorDemora());}
    },
    PIQUETE{
        @Override
        public IObstaculo crear(){ return new Piquete();}
    },
    POZO{
        @Override
        public IObstaculo crear(){ return new Pozo();}
    };

    public static IObstaculo crearObstaculoDesdeString(String s){
        return valueOf( s.toUpperCase() ).crear();
    }

    public abstract IObstaculo crear();
}
