package edu.fiuba.algo3.modelo.Celda.FabricaCelda;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.CeldaBorde;
import edu.fiuba.algo3.modelo.Obstaculo.Comun;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Excepcion.DireccionInvalida;

public class FabricaCeldaBorde implements FabricaCelda{
    @Override
    public Celda crearCelda(Direccion dir) throws DireccionInvalida {
        Celda celda = null;
        if( dir == Direccion.NORTE){
            celda = new CeldaBorde( new Comun() , Direccion.OESTE, Direccion.SUR, Direccion.ESTE );
        }else if( dir == Direccion.SUR){
            celda = new CeldaBorde( new Comun() , Direccion.OESTE, Direccion.NORTE, Direccion.ESTE );
        }else if( dir == Direccion.ESTE){
            celda = new CeldaBorde( new Comun() , Direccion.NORTE, Direccion.SUR, Direccion.OESTE );
        }else if( dir == Direccion.OESTE){
            celda = new CeldaBorde( new Comun() , Direccion.NORTE, Direccion.SUR, Direccion.ESTE );
        }else{
            throw new DireccionInvalida("creaCelda :");
        }

        return celda;
    }
}
