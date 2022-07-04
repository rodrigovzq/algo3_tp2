package edu.fiuba.algo3.modelo.Parser;

import edu.fiuba.algo3.modelo.EstadoCelda.Comun;
import edu.fiuba.algo3.modelo.EstadoCelda.EstadoCelda;
import edu.fiuba.algo3.modelo.EstadoCelda.IEstadoCelda;
import edu.fiuba.algo3.modelo.Excepcion.ArchivoMalformado;
import edu.fiuba.algo3.modelo.Lector.LectorScanner;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.Sorpresa.Sorpresa;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserMapa implements Parser{
    private final String PATRON_TAMANIO = "(\\d+),(\\d+);";
    private final String PATRON_FILA = "(([A-Z]+_?)+)";
    private final String texto;

    public ParserMapa(String pathFile ) {
        this.texto = new LectorScanner( pathFile ).leerTodoElArchivo();
    }

    @Override
    public Mapa parsear() {
        String patron_ =  PATRON_TAMANIO;
        Pattern patron = Pattern.compile( patron_ );
        Matcher matcher = patron.matcher(this.texto);
        Integer altoMapa;
        Integer anchoMapa;

        if( matcher.find() ){
            anchoMapa = Integer.parseInt(matcher.group(1));
            altoMapa = Integer.parseInt(matcher.group(2));
        }else{
            throw new ArchivoMalformado();
        }

        List<IEstadoCelda> estadosMapa = new ArrayList();

        patron_ =  PATRON_FILA;
        patron = Pattern.compile( patron_ );
        matcher  = patron.matcher(this.texto);
        //Leer todas las filas y adjuntarlo a una Lista de EstadoCelda
        for(int i = 0; i < altoMapa; i++){
            for( int j = 1; j <= anchoMapa; j++ ){
                matcher.find();
                String s = matcher.group(1);
                IEstadoCelda estado = EstadoCelda.crearDesdeString( s ) ;
                estadosMapa.add( estado );
            }
        }

        Mapa mapa = new Mapa(anchoMapa, altoMapa, estadosMapa);
        return mapa;
    }
}
