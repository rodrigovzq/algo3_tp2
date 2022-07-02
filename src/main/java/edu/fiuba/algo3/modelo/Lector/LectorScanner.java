package edu.fiuba.algo3.modelo.Lector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LectorScanner implements Lector{
    File file;
    Scanner lectora;

    //TODO: Lector interface
    public LectorScanner(String pathFile) {
        this.file = new File( pathFile );
        this.crearNuevoArchivo(); //Lo creo aunque ya exista.
        try {
            this.lectora = new Scanner(this.file);
        } catch (FileNotFoundException e) {
            System.out.println("Lectura: problema al cargar el archivo.");

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

    private boolean crearNuevoArchivo(){
        try {
            return file.createNewFile();
        } catch (IOException e) {
            System.out.println("Ya existe el archivo " + file.getPath());
        }
        return false;
    }
}
