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
        this.ancho = ancho;
        this.altura = altura;
    }

    //TODO: Test. ¿Como?
    //La implementacion del metodo generarMapa está acoplada con la entidad Coordenada
    public void generarMapa(){
        int columna = 0;
        int fila = 0;
        Coordenada coord = new Coordenada( columna , fila);
        Celda anteriorCelda = this.generarEsquinaMapa( coord );

        Direccion dirX = Direccion.ESTE;
        Direccion dirY = Direccion.SUR;
        //dependiendo de la cantidad de filas, la ultima
        //celda creada será una esquina.
        Direccion esquinaFIN = Direccion.SUDOESTE;
        if( this.altura % 2 == 1 )
            esquinaFIN = Direccion.SUDESTE;

        Celda nuevaCelda;
        Celda filaAnteriorCelda = null;
        boolean setDirY = false;

        //TODO Refactor: Encapsular fila y columna en Coordenada?
        //Que Coordenada si es una esquina o borde o no, pasandole el tamaño del mapa.
        //Que sepa como mover los indices según la dirección que le pasemos.

        while( !( coord.determinarEsquina(this.ancho, this.altura) == esquinaFIN ) ) {
            do{
                if( setDirY ) {
                    //coord = new Coordenada(columna, fila);
                    nuevaCelda = this.generarNuevaCelda( coord );
                    //Comienza una nueva fila. Solo seteo en direccion Y.
                    //TODO Refactor: Usar filaAnterior. setDirY significa que no seteo en X.
                    anteriorCelda.setCelda(nuevaCelda, dirY);
                    setDirY = false;
                }else {
                    coord.mover(dirX);
                    //Creo la Celda que necesito
                    //coord = new Coordenada(columna, fila);
                    nuevaCelda = this.generarNuevaCelda( coord );
                    //Seteo en el sentido X la nueva Celda.
                    anteriorCelda.setCelda(nuevaCelda, dirX);

                    //Seteo verticalmente con la celda de la fila anterior.
                    if( filaAnteriorCelda != null)
                        filaAnteriorCelda.setCelda(nuevaCelda, dirY);
                }

                if( filaAnteriorCelda != null && !coord.esBorde(this.ancho, this.altura))
                        filaAnteriorCelda = filaAnteriorCelda.getCelda(dirX);


                //Me muevo sobre la misma fila.
                anteriorCelda = nuevaCelda;

            }while( !(coord.determinarBorde( this.ancho, this.altura ) == dirX ));
            //Cuando llega al final de una fila.
            dirX = dirX.opuesto(); //Recorremos al reves.

            //Seteo en direccion Y. (Bajo una fila)
            setDirY = true;
            coord.mover(dirY);

            //Seteo el pivot de la fila de arriba. (Permite conectar verticalmente las celdas)
            filaAnteriorCelda = anteriorCelda;
        }
    }

     private Celda generarEsquinaMapa( Coordenada coordenada){
        Celda nuevaCelda;
        fabrica = new FabricaCeldaEsquina();
        Direccion dir = coordenada.determinarEsquina( this.ancho, this.altura );
        nuevaCelda = fabrica.crearCelda(dir);

        return nuevaCelda;
    }
    private Celda generarBordeMapa( Coordenada coordenada ){
        Celda nuevaCelda;
        fabrica = new FabricaCeldaBorde();
        //TODO:  ¿Debo protegerme (de nuevo) de la CeldaEsquina?
        Direccion dir = coordenada.determinarBorde( this.ancho, this.altura);
        nuevaCelda = fabrica.crearCelda( dir );

        return nuevaCelda;
    }

    private Celda generarInternaMapa( Coordenada coordenada ){
        fabrica = new FabricaCeldaInterna();
        Celda nuevaCelda = fabrica.crearCelda(Direccion.ESTE); //no importa la direccion
        return nuevaCelda;
    }

    public Celda generarNuevaCelda( Coordenada coordenada ){
        Celda celda;
        if( coordenada.esEsquina( this.ancho , this.altura ) ){
            celda = this.generarEsquinaMapa( coordenada );
        }else if( coordenada.esBorde( this.ancho , this.altura ) ){
            celda = this.generarBordeMapa( coordenada );
        }else{
            celda = this.generarInternaMapa( coordenada );
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
