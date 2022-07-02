package edu.fiuba.algo3.modelo.Impresora;

import edu.fiuba.algo3.modelo.Juego.Ranking;

public interface Impresora {
    void escribirNuevaLinea(String s);

    void finalizarEscritura();

    void imprimir(Imprimible elemento);
}
