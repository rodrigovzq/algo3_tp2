package edu.fiuba.algo3.modelo.Mapa;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.CeldaInterna;
import edu.fiuba.algo3.modelo.EstadoCelda.EstadoCelda;
import edu.fiuba.algo3.modelo.EstadoCelda.IEstadoCelda;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCelda;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCeldaBorde;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCeldaEsquina;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCeldaInterna;
import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.EstadoCelda.Meta;
import edu.fiuba.algo3.modelo.Excepcion.MapaInvalido;
import edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorEstadosAleatorio.GeneradorEstadosAleatorio;
import edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorEstadosAleatorio.GeneradorObstaculo;
import edu.fiuba.algo3.modelo.GeneradorAleatorio.GeneradorEstadosAleatorio.GeneradorSorpresa;
import edu.fiuba.algo3.modelo.EstadoCelda.Comun;
import edu.fiuba.algo3.modelo.Impresora.Imprimible;
import edu.fiuba.algo3.modelo.Observable;

import java.util.*;

// Clase con la responsabilidad de generar el escenario.
public class Mapa extends Observable implements Imprimible {
    public static final float PROPORCION_MAPA_APARICION = 0.25F;
    private static final String DELIMITADOR_COLUMNA = "-";
    private static final String DELIMITADOR_FILA = ";\n";
    private static final String DELIMITADOR_TAMANIO = "x";
    private Celda posicionJugador;
    private Integer ancho;
    private Integer altura;
    private Celda esquinaSuperiorIzquierda;
    private FabricaCelda fabrica;

    private GeneradorEstadosAleatorio generador;

    private final Float PROBABILIDAD_OBSTACULO = 0.5F;
    private final Float PROBABILIDAD_SORPRESA = 0.5F;
    private Coordenada coordenadaMeta;

    public Mapa( Mapa mapa ){
        this.ancho = mapa.ancho;
        this.altura = mapa.altura;
        this.generador = new GeneradorObstaculo();
        generarMapa();
        this.coordenadaMeta = getMeta();
        this.posicionJugador = getCeldaJugador();
    }

    public Mapa(Integer ancho, Integer altura) throws MapaInvalido {
        this.ancho = ancho;
        this.altura = altura;
        if (!this.esValido()) {
            throw new MapaInvalido();
        }

        this.generador = new GeneradorObstaculo();
        generarMapa();
        this.coordenadaMeta = getMeta();
        this.posicionJugador = getCeldaJugador();
    }

    public Mapa(Integer ancho, Integer altura, Coordenada posJugador, List<IEstadoCelda> estados) throws MapaInvalido {
        this.ancho = ancho;
        this.altura = altura;
        if (!this.esValido()) {
            throw new MapaInvalido();
        }

        this.generador = new GeneradorObstaculo();
        this.coordenadaMeta = buscarMetaEnListaEstados(estados);
        generarMapa(estados);
        this.posicionJugador = getCelda(posJugador);
    }

    private boolean esValido() {
        return this.altura >= 2 && this.ancho >= 2;
    }

    public Celda getEsquinaSuperiorIzquierda() {
        return esquinaSuperiorIzquierda;
    }

    //La implementacion del metodo generarMapa está acoplada con la entidad Coordenada

    private void generarMapa(List<IEstadoCelda> estados){
        generarMapaVacio();
        setEstadosMapa(estados);
    }

    private void generarMapa(){
        generarMapaVacio();
        setEstadosMapa();
    }
    private void generarMapaVacio() {
        Coordenada coord = new Coordenada(0, 0);
        Celda anteriorCelda = this.generarEsquinaMapa(coord);
        esquinaSuperiorIzquierda = anteriorCelda;

        Direccion dirX = Direccion.ESTE;
        Direccion dirY = Direccion.SUR;

        Celda nuevaCelda;
        Celda filaAnteriorCelda = null;
        boolean setDirY = false;
        boolean esElBorde = false;
        boolean esCeldaInterna = true;

        //Inicializo la primera fila.
        do {
            coord = new Coordenada(coord);
            coord.mover(dirX);

            nuevaCelda = this.generarNuevaCelda(coord);
            //Seteo en el sentido X la nueva Celda.
            anteriorCelda.setCelda(nuevaCelda, dirX);
            anteriorCelda = nuevaCelda;

            esElBorde = coord.esEsquina(this.ancho, this.altura);
            if (esElBorde)
                esElBorde = (coord.determinarEsquina(this.ancho, this.altura) == Direccion.NORESTE);

        } while (!esElBorde);

        //Continua construyendo el resto de filas.
        do {
            //Cuando llega al final de una fila.
            dirX = dirX.opuesto(); //Recorremos al reves.

            //Seteo unicamente en direccion Y.
            setDirY = true;
            // Bajo una fila
            coord = new Coordenada(coord);
            coord.mover(dirY);

            //Seteo el "pivot" de la fila de arriba. (Permite conectar verticalmente las celdas)
            filaAnteriorCelda = anteriorCelda;

            do {
                if (setDirY) {
                    setDirY = false;
                    nuevaCelda = this.generarNuevaCelda(coord);
                } else {
                    coord = new Coordenada(coord);
                    coord.mover(dirX);
                    nuevaCelda = this.generarNuevaCelda(coord);
                    anteriorCelda.setCelda(nuevaCelda, dirX);
                }

                //Seteo verticalmente con la celda de la fila anterior.
                filaAnteriorCelda.setCelda(nuevaCelda, dirY);

                esCeldaInterna = esCeldaInterna(coord);
                //Si no es celda interna chequeo si llegue al borde.
                if (!esCeldaInterna) {
                    esElBorde = (coord.determinarBorde(this.ancho, this.altura) == dirX);
                }

                //Si es celda interna o no es EL borde, me muevo en la fila anterior.
                //Cuando llego al borde hacia donde me dirijo, no puedo pedir la celda adyacente.
                if (!esElBorde || esCeldaInterna)
                    filaAnteriorCelda = filaAnteriorCelda.getCelda(dirX);

                anteriorCelda = nuevaCelda;
            } while (!esElBorde);

        } while (!esFinRecorrido(coord));
    }

    private Direccion direccionRecorridoFinal() {
        Direccion esquinaFIN = Direccion.SUDOESTE;
        if (this.altura % 2 == 1)
            esquinaFIN = Direccion.SUDESTE;
        return esquinaFIN;
    }


    private Celda generarEsquinaMapa(Coordenada coordenada) {
        Celda nuevaCelda;
        fabrica = new FabricaCeldaEsquina();
        Direccion dir = coordenada.determinarEsquina(this.ancho, this.altura);
        nuevaCelda = fabrica.crearCelda(dir, coordenada);

        return nuevaCelda;
    }

    private Celda generarBordeMapa(Coordenada coordenada) {
        Celda nuevaCelda;
        fabrica = new FabricaCeldaBorde();
        Direccion dir = coordenada.determinarBorde(this.ancho, this.altura);
        nuevaCelda = fabrica.crearCelda(dir, coordenada);

        return nuevaCelda;
    }

    private Celda generarInternaMapa(Coordenada coordenada) {
        fabrica = new FabricaCeldaInterna();
        Celda nuevaCelda = fabrica.crearCelda(Direccion.ESTE, coordenada); //no importa la direccion
        return nuevaCelda;
    }

    public Celda generarNuevaCelda(Coordenada coordenada) {
        Celda celda;
        if (coordenada.esEsquina(this.ancho, this.altura)) {
            celda = this.generarEsquinaMapa(coordenada);
        } else if (coordenada.esBorde(this.ancho, this.altura)) {
            celda = this.generarBordeMapa(coordenada);
        } else {
            celda = this.generarInternaMapa(coordenada);
        }
        return celda;
    }

    public void setAncho(Integer ancho) {
        this.ancho = ancho;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public int getAncho() {
        return this.ancho;
    }

    public int getAltura() {
        return this.altura;
    }

    private Celda sortearCeldaJugador() {
        Integer fila = (int) (this.generador.sortearNumero() * this.altura * PROPORCION_MAPA_APARICION);
        Integer columna = (int) (this.generador.sortearNumero() * this.ancho * PROPORCION_MAPA_APARICION);
        return getCelda(new Coordenada(columna, fila));
    }

    public Integer sortearIndiceMeta() {
        Integer fila = (int) (this.altura * (1 - this.generador.sortearNumero() * PROPORCION_MAPA_APARICION));
        Integer columna = (int) (this.ancho * (1 - this.generador.sortearNumero() * PROPORCION_MAPA_APARICION));
        return fila * this.ancho + columna;
    }

    public Celda getCelda(Coordenada coordenada) {
        Celda celda = new CeldaInterna(new Comun(), coordenada);
        Integer diferenciaX = esquinaSuperiorIzquierda.distanciaHorizontal(celda);
        Integer diferenciaY = esquinaSuperiorIzquierda.distanciaVertical(celda);
        Celda celdaSeleccionada = esquinaSuperiorIzquierda;

        //como es el borde superior izquierdo siempre vamos a movernos para estas direcciones.
        while (diferenciaX > 0) {
            celdaSeleccionada = celdaSeleccionada.getCelda(Direccion.ESTE);
            diferenciaX -= 1;
        }
        while (diferenciaY > 0) {
            celdaSeleccionada = celdaSeleccionada.getCelda(Direccion.SUR);
            diferenciaY -= 1;
        }

        return celdaSeleccionada;
    }

    public Coordenada getMeta() {
        return coordenadaMeta;
    }

    private List<IEstadoCelda> sortearEstadosMapa() {
        List<IEstadoCelda> lista = new ArrayList<>();
        for (int i = 0; i < this.ancho; i++)
            for (int j = 0; j < this.altura; j++) {
                lista.add(sortearEstadoCelda());
            }

        lista.set(sortearIndiceMeta(), new Meta());
        return lista;
    }

    private Coordenada buscarMetaEnListaEstados( List<IEstadoCelda> estadosCelda ){
        Coordenada meta = null;
        int metas = 0;
        int indice = 0;

        for( IEstadoCelda estado : estadosCelda ){
            boolean encontrado = estado.equals( new Meta() );
            if( encontrado ){
                metas += 1;
                meta = numeroElementoACoordenada(indice);
            }
            indice += 1;
        }

        if( metas != 1)
            throw new MapaInvalido();

        return meta;
    }

    private void setEstadosMapa(List<IEstadoCelda> estados) {
        Coordenada coordenada = new Coordenada(0, 0);
        Celda celdaSeleccionada = esquinaSuperiorIzquierda;
        Direccion dirX = Direccion.ESTE;
        Direccion dirY = Direccion.SUR;
        
        if( coordenadaMeta == null){
            coordenadaMeta = buscarMetaEnListaEstados(estados);
        }
        
        IEstadoCelda estado;

        while (!esFinRecorrido(coordenada)) {

            estado = estados.remove(0);
            celdaSeleccionada.setEstado(estado);

            if (esCeldaInterna(coordenada) || !(coordenada.determinarBorde(this.ancho, this.altura) == dirX)) {
                celdaSeleccionada = celdaSeleccionada.getCelda(dirX);
                coordenada.mover(dirX);
            } else {
                dirX = dirX.opuesto();
                coordenada.mover(dirY);
                celdaSeleccionada = celdaSeleccionada.getCelda(dirY);
            }

        }
    }

    private Coordenada numeroElementoACoordenada(int indice) {
        Integer fila = indice / this.ancho;
        Integer columna = indice - fila * this.ancho;
        if( (fila % 2) != 0 ) {
            columna = (this.ancho-1) - indice%this.ancho;
        }
        return new Coordenada( columna, fila );
    }

    private void setEstadosMapa() {
        List<IEstadoCelda> estadosMapa = this.sortearEstadosMapa();
        setEstadosMapa(estadosMapa);
        notificarATodos();
    }

    private boolean esCeldaInterna(Coordenada coordenada) {
        return !(coordenada.esEsquina(this.ancho, this.altura) || coordenada.esBorde(this.ancho, this.altura));
    }

    private boolean esFinRecorrido(Coordenada coordenada) {
        boolean condCorte = false;
        if (coordenada.esEsquina(this.ancho, this.altura))
            condCorte = (coordenada.determinarEsquina(this.ancho, this.altura) == direccionRecorridoFinal());
        return condCorte;
    }

    private IEstadoCelda sortearEstadoCelda() {
        IEstadoCelda estado = new Comun();
        if (generador.aplicar(PROBABILIDAD_OBSTACULO)) {
            this.generador = new GeneradorObstaculo();
            estado = generador.sortearEstadoCelda();
        } else if (generador.aplicar(PROBABILIDAD_SORPRESA)) {
            this.generador = new GeneradorSorpresa();
            estado = generador.sortearEstadoCelda();
        }

        return estado;
    }

    //Guarda en zigzag, de la misma manera que construye.
    public String imprimir() {
        Coordenada coordenada = new Coordenada(0, 0);
        Celda celdaSeleccionada = esquinaSuperiorIzquierda;
        Direccion dirX = Direccion.ESTE;
        Direccion dirY = Direccion.SUR;

        String resultado = this.ancho + DELIMITADOR_TAMANIO + this.altura;
        resultado += DELIMITADOR_FILA;
        if (posicionJugador != null) {
            resultado += this.posicionJugador.imprimir().split(Celda.DELIMITADOR)[1];
            resultado += DELIMITADOR_FILA;
        }

        while (!esFinRecorrido(coordenada)) {
            resultado += celdaSeleccionada.imprimir().split(Celda.DELIMITADOR)[0];
            if (esCeldaInterna(coordenada) || !(coordenada.determinarBorde(this.ancho, this.altura) == dirX)) {
                celdaSeleccionada = celdaSeleccionada.getCelda(dirX);
                coordenada.mover(dirX);
                resultado += DELIMITADOR_COLUMNA;
            } else {
                dirX = dirX.opuesto();
                coordenada.mover(dirY);
                celdaSeleccionada = celdaSeleccionada.getCelda(dirY);
                resultado += DELIMITADOR_FILA;
            }

        }
        resultado += celdaSeleccionada.imprimir().split(Celda.DELIMITADOR)[0] + DELIMITADOR_FILA;
        return resultado;
    }

    public Celda getCeldaJugador() {
        Celda posicion = (this.posicionJugador == null) ? sortearCeldaJugador() : posicionJugador;
        this.posicionJugador = posicion;
        return posicion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mapa mapa = (Mapa) o;
        return ancho.equals(mapa.ancho) && altura.equals(mapa.altura) && PROBABILIDAD_OBSTACULO.equals(mapa.PROBABILIDAD_OBSTACULO) && PROBABILIDAD_SORPRESA.equals(mapa.PROBABILIDAD_SORPRESA);
    }

    public void setPosicionJugador(Coordenada posicionJugador) {
        this.posicionJugador = getCelda(posicionJugador);
    }
}
