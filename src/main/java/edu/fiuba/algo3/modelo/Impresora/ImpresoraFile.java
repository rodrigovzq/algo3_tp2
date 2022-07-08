package edu.fiuba.algo3.modelo.Impresora;

import edu.fiuba.algo3.modelo.Excepcion.ArchivoInexistente;

import java.io.*;

public class ImpresoraFile implements Impresora {

    private PrintWriter impresora;
    private final File file;

    public ImpresoraFile(String pathTestFile) throws ArchivoInexistente{
        this.file = new File(pathTestFile);
        this.crearNuevoArchivo();
        try {
            this.impresora = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            throw new ArchivoInexistente(pathTestFile);
        }

    }

    private boolean crearNuevoArchivo() {
        try {
            return file.createNewFile();
        } catch (IOException e) {
            System.out.println("Error al crear un nuevo archivo.");
        }
        return false;
    }

    @Override
    public void escribirNuevaLinea(String s) {
        this.impresora.append(s);
    }

    @Override
    public void finalizarEscritura() {
        this.impresora.close();
    }

    @Override
    public void imprimir(Imprimible elemento) {
        String resultado = elemento.imprimir();
        this.escribirNuevaLinea(resultado);
        this.finalizarEscritura();
    }

}
