package edu.fiuba.algo3.modelo.Parser;

import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.EstadoCelda.Comun;
import edu.fiuba.algo3.modelo.EstadoCelda.EstadoCelda;
import edu.fiuba.algo3.modelo.EstadoCelda.IEstadoCelda;
import edu.fiuba.algo3.modelo.Excepcion.ArchivoInexistente;
import edu.fiuba.algo3.modelo.Excepcion.ArchivoMalformado;
import edu.fiuba.algo3.modelo.Excepcion.EstadoCeldaInvalido;
import edu.fiuba.algo3.modelo.Impresora.Imprimible;
import edu.fiuba.algo3.modelo.Lector.LectorScanner;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.Sorpresa.Sorpresa;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserMapa implements Parser{
    private final String PATRON_TAMANIO = "(\\d+)x(\\d+);";
    private final String PATRON_CELDA = "\\((\\d+),(\\d+)\\);";
    private final String PATRON_FILA = "(([A-Z]+_?)+)";
    private final String texto;
    private Integer anchoMapa;
    private List<IEstadoCelda> estadosMapa;
    private Integer altoMapa;
    private Integer posicionJugadorX;
    private Integer posicionJugadorY;
    private Integer posicionMetaX;
    private Integer posicionMetaY;

    public ParserMapa(String pathFile ) throws ArchivoInexistente {
        this.texto = new LectorScanner( pathFile ).leerTodoElArchivo();
        estadosMapa = new ArrayList<>();
    }

    @Override
    public void parsear()  throws ArchivoMalformado {
        Pattern patron = Pattern.compile( PATRON_TAMANIO );
        Matcher matcher = patron.matcher(this.texto);

        if( matcher.find() ){
            anchoMapa = Integer.parseInt(matcher.group(1));
            altoMapa = Integer.parseInt(matcher.group(2));
        }else throw new ArchivoMalformado("Tamaño del mapa");

        patron = Pattern.compile( PATRON_CELDA );
        matcher = patron.matcher(this.texto);
        if( matcher.find() ) {
            posicionJugadorX = Integer.parseInt(matcher.group(1));
            posicionJugadorY = Integer.parseInt(matcher.group(2));
        }else throw new ArchivoMalformado("Posicion del Jugador");

        patron = Pattern.compile( PATRON_FILA );
        matcher  = patron.matcher(this.texto);
        //Leer todas las filas y adjuntarlo a una Lista de EstadoCelda
        for(int i = 0; i < altoMapa; i++){
            for( int j = 1; j <= anchoMapa; j++ ){
                if(matcher.find()) {
                    try {
                        String s = matcher.group(1);
                        IEstadoCelda estado = EstadoCelda.crearDesdeString(s);
                        estadosMapa.add(estado);
                    }catch(EstadoCeldaInvalido e){
                        throw new ArchivoMalformado("IEstadoCelda inexistente");
                    }
                }else{
                    throw new ArchivoMalformado("Mapa sin celdas");
                }
            }
        }

    }

    @Override
    public Mapa getEntidadParseada() throws ArchivoMalformado {
        try {
            Coordenada coordJugador = new Coordenada(posicionJugadorX, posicionJugadorY);
            Mapa mapa = new Mapa(anchoMapa, altoMapa, coordJugador, estadosMapa);
            return mapa;
        }catch( RuntimeException e){
            throw new ArchivoMalformado(e.getMessage() + "\nLos valores leídos no son válidos");
        }
    }
}
