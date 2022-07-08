package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Excepcion.ArchivoInexistente;
import edu.fiuba.algo3.modelo.Excepcion.ArchivoMalformado;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LectorScanner implements Lector{
    File file;
    Scanner lectora;

    public LectorScanner(String pathFile) throws ArchivoInexistente{
        this.file = new File( pathFile );
        try {
            this.lectora = new Scanner(this.file);
        } catch (FileNotFoundException e) {
            throw new ArchivoInexistente(pathFile);
        }

    }
    @Override
    public String leerLinea() {
       if( lectora.hasNextLine() ){
           return lectora.nextLine().trim();
       }else{
           return "";
       }
    }

    @Override
    public String leerTodoElArchivo(){
        String resultado = "";
        String linea = leerLinea();
        while( !linea.equals("") ){
            resultado += linea + "\n";
            linea = leerLinea();
        }
        return resultado;
    }

}
