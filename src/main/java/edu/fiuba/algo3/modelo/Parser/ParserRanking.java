package edu.fiuba.algo3.modelo.Parser;

import edu.fiuba.algo3.modelo.Ranking.Puntaje;
import edu.fiuba.algo3.modelo.Ranking.Ranking;
import edu.fiuba.algo3.modelo.Lector.LectorScanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserRanking implements Parser {
    //Solo acepta nombres con 1 o 2 palabras
    public static final String PATRON_NOMBRE = "(\\w+\\s{0,1}\\w*)";

    //Solo acepta puntajes numericos
    public static final String PATRON_PUNTAJE = "(\\d+)+";
    private final String texto;

    public ParserRanking(String filePath) {
        this.texto = new LectorScanner(filePath).leerTodoElArchivo();
    }

    @Override
    public Ranking parsear() {
        String patron_grupo = "(" + "(" + PATRON_NOMBRE + ")" + Ranking.DELIMITADOR + "(" + PATRON_PUNTAJE + ")" + ")";
        Pattern patron = Pattern.compile( patron_grupo );
        Matcher matcher = patron.matcher(this.texto);
        Ranking resultado = new Ranking();

        while( matcher.find() ){
            String nombre = matcher.group(2);
            String mov = matcher.group(4);
            Integer movimientos = Integer.parseInt(mov);
            Puntaje puntaje = new Puntaje( nombre , movimientos );
            resultado.agregar( puntaje );
        }

        return resultado;
    }
}