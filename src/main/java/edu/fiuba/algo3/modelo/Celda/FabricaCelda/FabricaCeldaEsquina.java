package edu.fiuba.algo3.modelo.Celda.FabricaCelda;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.CeldaEsquina;
import edu.fiuba.algo3.modelo.Celda.Obstaculo.Comun;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Excepcion.DireccionInvalida;

public class FabricaCeldaEsquina implements FabricaCelda{
    //dir es la direccion BLOQUEADA.
    @Override
    public Celda crearCelda(Direccion dir) {
        Celda celda = null;
        if( dir == Direccion.NORESTE){
            celda = new CeldaEsquina(  new Comun()  , Direccion.SUR, Direccion.OESTE );
        }else if( dir == Direccion.SUDESTE){
            celda = new CeldaEsquina(  new Comun()  , Direccion.NORTE, Direccion.OESTE );
        }else if( dir == Direccion.NOROESTE){
            celda = new CeldaEsquina(  new Comun()  , Direccion.SUR, Direccion.ESTE );
        }else if( dir == Direccion.SUDOESTE){
            celda = new CeldaEsquina(  new Comun()  , Direccion.NORTE, Direccion.ESTE );
        }else{
            throw new DireccionInvalida("creaCelda :");
        }

        return celda;
    }
}
