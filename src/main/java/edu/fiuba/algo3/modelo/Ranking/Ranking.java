package edu.fiuba.algo3.modelo.Ranking;

import edu.fiuba.algo3.modelo.Impresora.Imprimible;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//TODO: Podria hacerse una interfaz que obligue implementar
//agregar() y ordenar() para hacerlo más correcto y flexible.
//TODO: Jugador que sea rankeable, de manera que obligue
//a tener una forma de compararse. Acá estoy forzando que sea strings.
public class Ranking implements Imprimible {
    public static final String DELIMITADOR = ",";
    public static final String DELIMITADOR_FIN = ";\n";
    private final List<Puntaje> ranking;

    public Ranking(List<Puntaje> lista) {
        this.ranking = lista;
    }
    public Ranking() {
        this.ranking = new ArrayList<Puntaje>() ;
    }

    public void agregar(Jugador jugador) {
        this.agregar(new Puntaje(jugador));
        this.ordenar();
    }

    public void agregar(Puntaje puntaje) {
        ranking.add( puntaje );
        this.ordenar();
    }

    private void ordenar(){
        ranking.sort( (p1,p2) ->  p1.compareTo(p2));

    }

    public List<Puntaje> devolverListaDeLosPrimeros( Integer cantidad ) {
        Integer largo = Math.min( cantidad , ranking.size());
        return this.ranking.subList(0,largo);
    }

    @Override
    public String imprimir() {
        String resultado = "";
        for(Puntaje puntaje : ranking){
            resultado += puntaje.imprimir() + DELIMITADOR_FIN;
        }
        return resultado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ranking that = (Ranking) o;
        boolean resultado = (ranking.size() == that.ranking.size());
        if( resultado ){
            int i = 0;
            for(Puntaje puntaje : this.ranking) {
                resultado &= puntaje.equals(that.ranking.get(i));
                i += 1;
            }
        }
        return resultado;

    }

}
