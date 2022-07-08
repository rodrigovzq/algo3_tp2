package edu.fiuba.algo3.modelo.Parser;

import edu.fiuba.algo3.modelo.Celda.Celda;
import edu.fiuba.algo3.modelo.Celda.FabricaCelda.FabricaCeldaInterna;
import edu.fiuba.algo3.modelo.Coordenada.Coordenada;
import edu.fiuba.algo3.modelo.Excepcion.ArchivoInexistente;
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

    private String nombre;
    private String vehiculo;
    private String posX;
    private String posY;
    private String movimientos;
    public ParserJugador(String pathFile) throws ArchivoInexistente {
        this.texto = new LectorScanner(pathFile).leerTodoElArchivo();
        nombre="";
        vehiculo="";
        posX="-1";
        posY="-1";
        movimientos="-1";
    }

    public void parsear() throws ArchivoMalformado{
        String patron_grupo =  PATRON_NOMBRE + Jugador.DELIMITADOR +  PATRON_UBICACION + Jugador.DELIMITADOR +  PATRON_VEHICULO  + Jugador.DELIMITADOR  + PATRON_PUNTAJE ;
        Pattern patron = Pattern.compile( patron_grupo );
        Matcher matcher = patron.matcher(this.texto);

        if( matcher.find() ){
            nombre = matcher.group(1);
            posX =  matcher.group(2);
            posY  =  matcher.group(3);
            vehiculo = matcher.group(4);
            movimientos = matcher.group(5);
        }else{
            throw new ArchivoMalformado("Jugador sin los atributos necesarios");
        }

    }

    public Jugador getEntidadParseada() throws ArchivoMalformado {
        IVehiculo vehiculoJugador = null;
        Coordenada coord = null;
        Integer puntajeJugador;
        try{
            puntajeJugador = Integer.parseInt( movimientos );
            Integer x = Integer.parseInt(posX);
            Integer y = Integer.parseInt( posY);
            coord = new Coordenada(x,y);
            vehiculoJugador = Vehiculo.crearVehiculoDesdeString(vehiculo);
        }catch( RuntimeException e){
            throw new ArchivoMalformado(e.getMessage() + "\nLos valores leídos no son válidos");
        }
        String nombreJugador = nombre;

        //TODO: No me gusta esto.

        Celda posicionJugador;
        FabricaCeldaInterna fabrica = new FabricaCeldaInterna();
        posicionJugador = fabrica.crearCelda(coord);

        return new Jugador(nombreJugador, posicionJugador, vehiculoJugador, puntajeJugador);
    }
}
