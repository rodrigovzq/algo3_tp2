package edu.fiuba.algo3.modelo.Parser;

import edu.fiuba.algo3.modelo.Lector.LectorScanner;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

public class ParserMapa implements Parser{

    private final String texto;

    public ParserMapa(String pathFile ) {
        this.texto = new LectorScanner( pathFile ).leerTodoElArchivo();
    }

    @Override
    public Mapa parsear() {
        return null;
    }
}
