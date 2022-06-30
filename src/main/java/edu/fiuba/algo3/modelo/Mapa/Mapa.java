package edu.fiuba.algo3.modelo.Mapa;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.EstadoCelda;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCelda;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCeldaBorde;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCeldaEsquina;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCeldaInterna;
import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Excepcion.MapaInvalido;
import edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorEstadosAleatorio.GeneradorEstadosAleatorio;
import edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorEstadosAleatorio.GeneradorObstaculo;
import edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorEstadosAleatorio.GeneradorSorpresa;
import edu.fiuba.algo3.modelo.Obstaculo.Comun;

// Clase con la responsabilidad de generar el escenario.
public class Mapa {
    private Integer ancho;
    private Integer altura;
    private Celda esquinaSuperiorIzquierda;
    private FabricaCelda fabrica;

    private GeneradorEstadosAleatorio generador;

    private final Float PROBABILIDAD_OBSTACULO = 0.5F;
    private final Float PROBABILIDAD_SORPRESA = 0.5F;
    public Mapa(Integer ancho, Integer altura) throws MapaInvalido {
        this.ancho = ancho;
        this.altura = altura;
        //ValorPorDefault
        this.generador = new GeneradorObstaculo();

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

        Celda nuevaCelda;
        Celda filaAnteriorCelda = null;
        boolean setDirY = false;
        boolean condCorte = false;
        //Inicializo la primera fila.
        do{
            coord = new Coordenada(coord);
            coord.mover(dirX);

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

            condCorte = esFinRecorrido( coord );

        }while( !condCorte );

    }

    private Direccion direccionRecorridoFinal() {
        Direccion esquinaFIN = Direccion.SUDOESTE;
        if( this.altura % 2 == 1 )
            esquinaFIN = Direccion.SUDESTE;
        return esquinaFIN;
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
        return esquinaSuperiorIzquierda;
    }

    public void sortearEstadosMapa() {
        Coordenada coordenada = new Coordenada(0,0);
        Celda celdaSeleccionada = esquinaSuperiorIzquierda;
        Direccion dirX = Direccion.ESTE;
        Direccion dirY = Direccion.SUR;
        boolean condCorte = false;
        EstadoCelda estado;

        while( !condCorte ){

            estado = sortearEstadoCelda();

            celdaSeleccionada.setEstado( estado );

            condCorte = esFinRecorrido(coordenada);

            if( !condCorte) {
                if (coordenada.esEsquina(this.ancho, this.altura) || coordenada.esBorde(this.ancho, this.altura)) {
                    if (coordenada.determinarBorde(this.ancho, this.altura) == dirX) {
                        dirX = dirX.opuesto();
                        coordenada.mover(dirY);
                        celdaSeleccionada = celdaSeleccionada.getCelda(dirY);
                    } else {
                        celdaSeleccionada = celdaSeleccionada.getCelda(dirX);
                        coordenada.mover(dirX);
                    }
                }else{
                    celdaSeleccionada = celdaSeleccionada.getCelda(dirX);
                    coordenada.mover(dirX);
                }

            }

        }

    }

    private boolean esFinRecorrido(Coordenada coordenada) {
        boolean condCorte = false;
        if( coordenada.esEsquina(this.ancho, this.altura ) )
            condCorte = ( coordenada.determinarEsquina(this.ancho, this.altura) == direccionRecorridoFinal());
        return condCorte;
    }

    private EstadoCelda sortearEstadoCelda() {
        EstadoCelda estado;
        if( generador.aplicar( PROBABILIDAD_OBSTACULO ) ){
            this.generador = new GeneradorObstaculo();
            estado = generador.sortearEstadoCelda();

        }else if( generador.aplicar( PROBABILIDAD_SORPRESA ) ){
            this.generador = new GeneradorSorpresa();
            estado = generador.sortearEstadoCelda();
        }else{
            estado = new Comun();
        }
        return estado;
    }
}
