package edu.fiuba.algo3.modelo.Mapa;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCelda;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCeldaBorde;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCeldaEsquina;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCeldaInterna;
import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Excepcion.MapaInvalido;

// Clase con la responsabilidad de generar el escenario.
public class Mapa {
    private Integer ancho;
    private Integer altura;
    private Celda esquinaSuperiorIzquierda;
    private FabricaCelda fabrica;
    public Mapa(Integer ancho, Integer altura) throws MapaInvalido {
        this.ancho = ancho;
        this.altura = altura;
        if( !this.esValido() ){ throw new MapaInvalido(); }
    }

    private boolean esValido() {
        if( this.altura < 2 || this.ancho < 2)
            return false;
        return true;
    }

    public Celda getEsquinaSuperiorIzquierda() {
        return esquinaSuperiorIzquierda;
    }

    //La implementacion del metodo generarMapa está acoplada con la entidad Coordenada
    public void generarMapa(){
        Coordenada coord = new Coordenada( 0 , 0);
        Celda anteriorCelda = this.generarEsquinaMapa( coord );
        esquinaSuperiorIzquierda = anteriorCelda;

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
        boolean condCorte = false;
        //Inicializo la primera fila.
        do{
            coord = new Coordenada(coord);
            coord.mover(dirX);
            //Creo la Celda que necesito
            //coord = new Coordenada(columna, fila);
            nuevaCelda = this.generarNuevaCelda( coord );
            //Seteo en el sentido X la nueva Celda.
            anteriorCelda.setCelda(nuevaCelda, dirX);
            anteriorCelda = nuevaCelda;

            condCorte = coord.esEsquina( this.ancho, this.altura);
            if( condCorte )
                condCorte = ( coord.determinarEsquina( this.ancho, this.altura) == Direccion.NORESTE ) ;

        }while( !condCorte );

        //Continua construyendo el resto de filas.
        do{
            //Cuando llega al final de una fila.
            dirX = dirX.opuesto(); //Recorremos al reves.

            //Seteo unicamente en direccion Y.
            setDirY = true;
            // Bajo una fila
            coord = new Coordenada(coord);
            coord.mover(dirY);

            //Seteo el "pivot" de la fila de arriba. (Permite conectar verticalmente las celdas)
            filaAnteriorCelda = anteriorCelda;

            do{
                if( setDirY ) {
                    setDirY = false;
                    nuevaCelda = this.generarNuevaCelda( coord );
                }else {
                    coord = new Coordenada(coord);
                    coord.mover(dirX);
                    nuevaCelda = this.generarNuevaCelda( coord );
                    anteriorCelda.setCelda(nuevaCelda, dirX);
                }

                //Seteo verticalmente con la celda de la fila anterior.
                filaAnteriorCelda.setCelda(nuevaCelda, dirY);

                condCorte = ( coord.esEsquina(this.ancho, this.altura) || coord.esBorde(this.ancho, this.altura) );
                if( condCorte ) {
                    condCorte = coord.determinarBorde(this.ancho, this.altura) == dirX;
                }

                //Cuando llego al borde hacia donde me dirijo, no puedo pedir la celda adyacente.
                if(!condCorte)
                    filaAnteriorCelda = filaAnteriorCelda.getCelda(dirX);

                anteriorCelda = nuevaCelda;
            }while( !condCorte );

            condCorte = coord.esEsquina( this.ancho, this.altura);
            if( condCorte )
                condCorte = ( coord.determinarEsquina( this.ancho, this.altura) == esquinaFIN ) ;

        }while( !condCorte );

    }

     private Celda generarEsquinaMapa( Coordenada coordenada){
        Celda nuevaCelda;
        fabrica = new FabricaCeldaEsquina();
        Direccion dir = coordenada.determinarEsquina( this.ancho, this.altura );
        nuevaCelda = fabrica.crearCelda(dir, coordenada);

        return nuevaCelda;
    }
    private Celda generarBordeMapa( Coordenada coordenada ){
        Celda nuevaCelda;
        fabrica = new FabricaCeldaBorde();
        Direccion dir = coordenada.determinarBorde( this.ancho, this.altura);
        nuevaCelda = fabrica.crearCelda( dir, coordenada);

        return nuevaCelda;
    }

    private Celda generarInternaMapa(Coordenada coordenada){
        fabrica = new FabricaCeldaInterna();
        Celda nuevaCelda = fabrica.crearCelda(Direccion.ESTE, coordenada); //no importa la direccion
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

    //TODO: Borrar. Es solo para debugear.
    public String asString(){
        return "(" + this.ancho + " x " + this.altura + ")";
    }

    public void setAncho(Integer ancho) {
        this.ancho = ancho;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Celda sortearCeldaJugador() {
        //TODO: Sortear aleatoriamente una posicion del mapa.
        // Enum de Estados y con el numeros sorteado se elije que tipo de celda es?
        return esquinaSuperiorIzquierda;
    }
}
