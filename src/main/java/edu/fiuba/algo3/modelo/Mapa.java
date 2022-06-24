package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCelda;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCeldaBorde;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCeldaEsquina;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCeldaInterna;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Excepcion.CeldaIncorrecta;
import edu.fiuba.algo3.modelo.Excepcion.DireccionInvalida;

// Clase con la responsabilidad de generar el escenario.
public class Mapa {
    private Integer ancho;
    private Integer altura;

    private FabricaCelda fabrica;
    public Mapa(Integer ancho, Integer altura) {
        this.ancho = ancho-1;
        this.altura = altura-1;
    }

    //TODO: Test. ¿Como?
    public void generarMapa(){
        int columna = 0;
        int fila = 0;
        Celda anteriorCelda = this.generarEsquinaMapa(fila, columna);

        Direccion dirX = Direccion.ESTE;
        Direccion dirY = Direccion.SUR;

        Celda nuevaCelda;
        Celda filaAnteriorCelda = null;
        boolean setDirY = false;

        //TODO Refactor: Encapsular fila y columna en Coordenada?
        //Que Coordenada si es una esquina o borde o no, pasandole el tamaño del mapa.
        //Que sepa como mover los indices según la dirección que le pasemos.

        for(; fila < this.altura; fila++ ) {
            //TODO Refactor: Coordenada.mover(dirX)
            if(dirX == Direccion.ESTE)
                columna += 1;
            else
                columna -= 1;

            while( columna <= this.ancho && columna >= 0){
                //Creo la Celda que necesito
                nuevaCelda = this.generarNuevaCelda(fila, columna);

                if( setDirY ) {
                    //Comienza una nueva fila. Solo seteo en direccion Y.
                    //TODO Refactor: Usar filaAnterior. setDirY significa que no seteo en X.
                    anteriorCelda.setCelda(nuevaCelda, dirY);
                    setDirY = false;
                }else {
                    //Seteo en el sentido X la nueva Celda.
                    anteriorCelda.setCelda(nuevaCelda, dirX);

                    //Seteo verticalmente con la celda de la fila anterior.
                    if( filaAnteriorCelda != null)
                        filaAnteriorCelda.setCelda(nuevaCelda, dirY);
                }

                if( filaAnteriorCelda != null)
                    //TODO Refactor: Control de Flujo con excepcion.

                    // ¿Solucion?
                    // La solucion de agregar un if mas para chequear
                    // lo haría mas engorroso
                    try {
                        //Me muevo sobre la fila anterior.
                        filaAnteriorCelda = filaAnteriorCelda.getCelda(dirX);
                    }catch (DireccionInvalida e){
                        //Llegue al borde opuesto, pedir la celda de DirX rompe.
                        // No hago nada.
                    }

                //Me muevo sobre la misma fila.
                anteriorCelda = nuevaCelda;

                //TODO Refactor: Coordenada.mover(dirX)
                //El sentido del reccorrido debe coincidir con el mov en columnas
                if(dirX == Direccion.ESTE)
                    columna += 1;
                else
                    columna -= 1;

            }
            //Cuando llega al final de una fila.
            dirX = dirX.opuesto(); //Recorremos al reves.

            //Seteo en direccion Y. (Bajo una fila)
            setDirY = true;

            //Seteo el pivot de la fila de arriba. (Permite conectar verticalmente las celdas)
            filaAnteriorCelda = anteriorCelda;
        }
    }

    public boolean esEsquina(Integer fila, Integer columna){
        //TODO Refactor: Coordenada.esEsquina(anchoMapa, altoMapa)
        boolean res = false;
        if( fila == 0 && columna == 0){ //ESQUINA NOROESTE
            res = true;
        }else if( fila == 0 && columna == this.ancho){ //ESQUINA NORESTE
            res = true;
        }else if( fila == this.altura && columna == 0){ //ESQUINA SUDOESTE
            res = true;
        }else if( fila == this.altura && columna == this.ancho){ //ESQUINA SUDESTE
            res = true;
        }else if( !this.esCoordenadaValida(fila, columna)){
            throw new CeldaIncorrecta();
        }
        return res;
    }

    public boolean esBorde(Integer fila, Integer columna){
        boolean res = false;
        //TODO Refactor: Coordenada.esBorde(anchoMapa, altoMapa)
        if( !esEsquina(fila, columna))
            if(  fila == 0 || fila == this.altura){ //BORDE NORTE || SUR
                res = true;
            }else if(  columna == 0 || columna == this.ancho) { //BORDE OESTE || ESTE
                res = true;
            }else if( !this.esCoordenadaValida(fila, columna)){
                throw new CeldaIncorrecta();
            }
        return res;
    }
    private Celda generarEsquinaMapa(Integer fila, Integer columna){
        Celda nuevaCelda;
        fabrica = new FabricaCeldaEsquina();
        //TODO Refactor: Coordenada.determinarEsquina(anchoMapa, altoMapa)
        if( fila == 0 && columna == 0){
            nuevaCelda = fabrica.crearCelda(Direccion.NOROESTE);
        }else if( fila == 0 && columna == this.ancho){
            nuevaCelda = fabrica.crearCelda(Direccion.NORESTE);
        }else if( fila == this.altura && columna == 0){
            nuevaCelda = fabrica.crearCelda(Direccion.SUDOESTE);
        }else if( fila == this.altura && columna == this.ancho){
            nuevaCelda = fabrica.crearCelda(Direccion.SUDESTE);
        }else {
            throw new CeldaIncorrecta();
        }
        return nuevaCelda;
    }
    private Celda generarBordeMapa(Integer fila, Integer columna){
        Celda nuevaCelda;
        fabrica = new FabricaCeldaBorde();
        //TODO:  ¿Debo protegerme (de nuevo) de la CeldaEsquina?
        //TODO Refactor: Coordenada.determinarBorde(anchoMapa, altoMapa)
        if(fila == 0) {
            nuevaCelda = fabrica.crearCelda(Direccion.NORTE);
        }else if(fila == this.altura){
            nuevaCelda = fabrica.crearCelda(Direccion.SUR);
        }else if(columna == 0){
            nuevaCelda = fabrica.crearCelda(Direccion.OESTE);
        }else if (columna == this.ancho) {
            nuevaCelda = fabrica.crearCelda(Direccion.ESTE);
        }else{
            throw new CeldaIncorrecta();
        }

        return nuevaCelda;
    }

    private Celda generarInternaMapa(Integer fila, Integer columna){
        fabrica = new FabricaCeldaInterna();
        Celda nuevaCelda = fabrica.crearCelda(Direccion.ESTE); //no importa la direccion
        return nuevaCelda;
    }

    public Celda generarNuevaCelda( Integer fila, Integer columna){
        Celda celda;
        if( esEsquina(fila, columna) ){
            celda = this.generarEsquinaMapa(fila, columna);
        }else if( esBorde(fila, columna) ){
            celda = this.generarBordeMapa(fila, columna);
        }else{
            celda = this.generarInternaMapa(fila, columna);
        }
        return celda;
    }
    //TODO: Refactor Coordenada.
    private boolean esCoordenadaValida(Integer fila, Integer columna){
        if( fila < 0 || fila > this.altura || columna < 0 || columna > this.ancho)
            return false;
        return true;
    }

}
