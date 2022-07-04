package edu.fiuba.algo3.modelo.Parser;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCeldaInterna;
import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Excepcion.ArchivoMalformado;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Lector.LectorScanner;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserJugador implements Parser {
    private final String PATRON_NOMBRE = "(\\w+\\s?\\w*)";
    private final String PATRON_UBICACION = "\\((\\d+),(\\d+)\\)";
    private final String PATRON_VEHICULO = "(\\w+)";
    private final String PATRON_PUNTAJE = "(\\d+)+";
    private final String texto;

    public ParserJugador(String pathFile) {
        this.texto = new LectorScanner(pathFile).leerTodoElArchivo();

    }

    public Jugador parsear() {
        String patron_grupo =  PATRON_NOMBRE + Jugador.DELIMITADOR +  PATRON_UBICACION + Jugador.DELIMITADOR +  PATRON_VEHICULO  + Jugador.DELIMITADOR  + PATRON_PUNTAJE ;
        Pattern patron = Pattern.compile( patron_grupo );
        Matcher matcher = patron.matcher(this.texto);

        String nombreJugador;
        IVehiculo vehiculoJugador;
        Celda posicionJugador;
        Integer puntajeJugador;
        FabricaCeldaInterna fabrica = new FabricaCeldaInterna();

        //En caso de que exista el archivo y este bien formado
        if( matcher.find() ){
            nombreJugador = matcher.group(1);

            //El problema es que leemos una coordenada y necesitamos la celda.
            //(!!!!) Necesitamos tener el mapa ya formado.
            Integer posX = Integer.parseInt( matcher.group(2) );
            Integer posY = Integer.parseInt( matcher.group(3) );
            Coordenada coord = new Coordenada(posX,posY);

            //TODO: Como leer la ubicacion y dar la celda del mapa.
            posicionJugador = fabrica.crearCelda(coord);

            String vehiculo = matcher.group(4);
            vehiculoJugador = Vehiculo.crearVehiculoDesdeString(vehiculo);

            puntajeJugador = Integer.parseInt( matcher.group(5) );

        }else{
            throw new ArchivoMalformado();
        }

        return new Jugador(nombreJugador, posicionJugador, vehiculoJugador, puntajeJugador);
    }

}
