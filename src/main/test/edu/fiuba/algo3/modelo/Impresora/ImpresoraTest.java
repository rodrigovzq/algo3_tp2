package edu.fiuba.algo3.modelo.Impresora;

import edu.fiuba.algo3.modelo.Excepcion.ArchivoInexistente;
import edu.fiuba.algo3.modelo.Lector.Lector;
import edu.fiuba.algo3.modelo.Lector.LectorScanner;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ImpresoraTest {
    @Test
    public void escriboLineasEnUnArchivoExistente() throws IOException {
        String pathTestFile = "saves/test.txt";
        Impresora impresora = new ImpresoraFile(pathTestFile);
        impresora.escribirNuevaLinea("Hola mundo1!\n");
        impresora.escribirNuevaLinea("Hola mundo2!\n");
        impresora.finalizarEscritura();
        String esperado = "Hola mundo1!";

        Lector lector = new LectorScanner( pathTestFile );
        String resultado = lector.leerLinea();
        assertEquals(esperado, resultado);

        esperado = "Hola mundo2!";
        resultado = lector.leerLinea();
        assertEquals(esperado, resultado);

    }
    @Test
    public void escriboUnaLineaDeUnArchivoQueNoExiste() throws ArchivoInexistente {
        String pathTestFile = "saves/testEscrituraNoExiste.txt";
        ImpresoraFile impresora = assertDoesNotThrow( () -> new ImpresoraFile(pathTestFile) );

        impresora.escribirNuevaLinea("Hola mundo1!");
        impresora.finalizarEscritura();
        String esperado = "Hola mundo1!";
        String resultado = new LectorScanner(pathTestFile).leerLinea();

        assertEquals(esperado, resultado);

        File archivoABorrar = new File( pathTestFile );
        archivoABorrar.delete();
    }



}