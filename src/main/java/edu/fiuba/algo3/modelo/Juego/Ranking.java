package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Impresora.Imprimible;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

//TODO: Podria hacerse una interfaz que obligue implementar
//agregar() y ordenar() para hacerlo más correcto y flexible.
//TODO: Jugador que sea rankeable, de manera que obligue
//a tener una forma de compararse. Acá estoy forzando que sea strings.
public class Ranking implements Imprimible {
    public static final String DELIMITADOR = ",";
    private List<String> ranking;

    public Ranking(List<String> lista) {
        this.ranking = lista;
    }
    public Ranking() {
        this.ranking = new ArrayList<String>() ;
    }

    public void agregar(Jugador jugador) {
        String resultado = jugador.imprimir();
        //TODO: Validar que no este vacio ni nada.
        String[] datos = resultado.split(Jugador.DELIMITADOR);
        String puntaje = datos[0] + this.DELIMITADOR + datos[3];
        ranking.add( puntaje );
        this.ordenar();
    }

    private void ordenar(){
        ranking.sort( (o1,o2) -> {
            Integer puntaje1 = Integer.parseInt(o1.split(this.DELIMITADOR)[1]);
            Integer puntaje2 = Integer.parseInt(o2.split(this.DELIMITADOR)[1]);
            return puntaje1.compareTo(puntaje2);
        });
    }

    public List<String> devolverListaDeLosPrimerosDiez() {
        Integer largo = ( ranking.size() > 10 )? 10:ranking.size();
        return this.ranking.subList(0,largo);
    }

    @Override
    public String imprimir() {
        String resultado = "";
        for(String puntaje : ranking){
            resultado += puntaje + "\n";
        }
        return resultado;
    }
}
