package edu.fiuba.algo3.modelo.Celda.Fabrica;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.CeldaEsquina;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Excepcion.DireccionInvalida;

public class FabricaCeldaEsquina implements FabricaCelda{
    @Override
    public Celda crearCelda(Direccion dir) {
        Celda celda = null;
        if( dir == Direccion.NORESTE){
            celda = new CeldaEsquina( null , Direccion.NORTE, Direccion.ESTE );
        }else if( dir == Direccion.SUDESTE){
            celda = new CeldaEsquina( null , Direccion.SUR, Direccion.ESTE );
        }else if( dir == Direccion.NOROESTE){
            celda = new CeldaEsquina( null , Direccion.NORTE, Direccion.ESTE );
        }else if( dir == Direccion.SUDOESTE){
            celda = new CeldaEsquina( null , Direccion.SUR, Direccion.OESTE );
        }else{
            throw new DireccionInvalida("creaCelda :");
        }

        return celda;
    }
}
