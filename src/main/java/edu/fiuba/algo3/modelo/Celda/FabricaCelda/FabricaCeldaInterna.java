package edu.fiuba.algo3.modelo.Celda.FabricaCelda;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.CeldaInterna;
import edu.fiuba.algo3.modelo.Obstaculo.Comun;
import edu.fiuba.algo3.modelo.Direccion.Direccion;

public class FabricaCeldaInterna implements FabricaCelda{
    @Override
    public Celda crearCelda(Direccion dir) {
        return new CeldaInterna( new Comun() );
    }
    //Ruptura del contrato, no tiene sentido pasarle una direccion para la creación de una CeldaInterna.
    //TODO: Solución a la "ruptura" de interfaz? Sobrecarga de metodos.
    public Celda crearCelda() {
        return crearCelda( Direccion.NORTE );
    }
}