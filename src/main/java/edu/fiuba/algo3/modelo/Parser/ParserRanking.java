package edu.fiuba.algo3.modelo.Parser;

import edu.fiuba.algo3.modelo.Excepcion.ArchivoInexistente;
import edu.fiuba.algo3.modelo.Excepcion.ArchivoMalformado;
import edu.fiuba.algo3.modelo.Impresora.Imprimible;
import edu.fiuba.algo3.modelo.Ranking.Puntaje;
import edu.fiuba.algo3.modelo.Ranking.Ranking;
import edu.fiuba.algo3.modelo.Lector.LectorScanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserRanking implements Parser {
    //Solo acepta nombres con 1 o 2 palabras
    private final String PATRON_NOMBRE = "(\\w+\\s?\\w*)";

    //Solo acepta puntajes numericos
    private final String PATRON_PUNTAJE = "(\\d+)+";
    private final String texto;

    Ranking resultado = new Ranking();
    public ParserRanking(String filePath) throws ArchivoInexistente {
        this.texto = new LectorScanner(filePath).leerTodoElArchivo();
    }

    @Override
    public void parsear()  throws ArchivoMalformado {
        String patron_grupo = PATRON_NOMBRE + Ranking.DELIMITADOR  + PATRON_PUNTAJE + Ranking.DELIMITADOR_FIN;
        Pattern patron = Pattern.compile( patron_grupo );
        Matcher matcher = patron.matcher(this.texto);
        if( !this.texto.equals("")) {
            if(matcher.find()) {
                do {
                    String nombre = matcher.group(1);
                    String mov = matcher.group(2);
                    Integer movimientos = Integer.parseInt(mov);
                    Puntaje puntaje = new Puntaje(nombre, movimientos);
                    resultado.agregar(puntaje);
                } while (matcher.find());
            }else{
                throw new ArchivoMalformado("No existe ningún puntaje");
            }
        }
    }

    @Override
    public Ranking getEntidadParseada() {
        return resultado;
    }
}
