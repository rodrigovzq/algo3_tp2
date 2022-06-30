package edu.fiuba.algo3.modelo.Celda.FabricaCelda;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.CeldaEsquina;
import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Obstaculo.Comun;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Excepcion.DireccionInvalida;

public class FabricaCeldaEsquina implements FabricaCelda{
    //dir es la direccion BLOQUEADA.
    @Override
    public Celda crearCelda(Direccion dir, Coordenada coordenada) throws DireccionInvalida {
        Celda celda = null;
        if( dir == Direccion.NORESTE){
            celda = new CeldaEsquina(  new Comun(), coordenada, Direccion.SUR, Direccion.OESTE );
        }else if( dir == Direccion.SUDESTE){
            celda = new CeldaEsquina(  new Comun(), coordenada, Direccion.NORTE, Direccion.OESTE );
        }else if( dir == Direccion.NOROESTE){
            celda = new CeldaEsquina(  new Comun(), coordenada, Direccion.SUR, Direccion.ESTE );
        }else if( dir == Direccion.SUDOESTE){
            celda = new CeldaEsquina(  new Comun(), coordenada, Direccion.NORTE, Direccion.ESTE );
        }else{
            throw new DireccionInvalida("creaCelda :");
        }

        return celda;
    }
}
