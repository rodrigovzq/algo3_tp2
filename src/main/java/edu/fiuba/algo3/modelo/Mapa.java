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

        //Inicializo la primera fila.
        while( !(coord.determinarEsquina( this.ancho, this.altura ) == Direccion.NORESTE )){
            coord.mover(dirX);
            //Creo la Celda que necesito
            //coord = new Coordenada(columna, fila);
            nuevaCelda = this.generarNuevaCelda( coord );
            //Seteo en el sentido X la nueva Celda.
            anteriorCelda.setCelda(nuevaCelda, dirX);
            anteriorCelda = nuevaCelda;

        }
        //Cuando llega al final de una fila.
        dirX = dirX.opuesto(); //Recorremos al reves.

        //Seteo unicamente en direccion Y.
        setDirY = true;
        // Bajo una fila
        coord.mover(dirY);

        //Seteo el "pivot" de la fila de arriba. (Permite conectar verticalmente las celdas)
        filaAnteriorCelda = anteriorCelda;

        //Continua construyendo el resto de filas.
        while( !( coord.determinarEsquina(this.ancho, this.altura) == esquinaFIN ) ) {
            // TODO: Celda tendrá coordenada? Si es así, hay que inicalizar una nueva coordenada
            //  en cada iteracion.
            do{
                if( setDirY ) {
                    setDirY = false;
                    nuevaCelda = this.generarNuevaCelda( coord );
                }else {
                    coord.mover(dirX);
                    nuevaCelda = this.generarNuevaCelda( coord );
                    anteriorCelda.setCelda(nuevaCelda, dirX);
                }

                //Seteo verticalmente con la celda de la fila anterior.
                filaAnteriorCelda.setCelda(nuevaCelda, dirY);

                //Cuando llego a un borde, no puedo pedir la celda adyacente.
                if(!coord.esBorde(this.ancho, this.altura))
                        filaAnteriorCelda = filaAnteriorCelda.getCelda(dirX);

                anteriorCelda = nuevaCelda;

            }while( !(coord.determinarBorde( this.ancho, this.altura ) == dirX ));

            dirX = dirX.opuesto();

            setDirY = true;
            coord.mover(dirY);

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
