package edu.fiuba.algo3.modelo.Lector;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class LectorScannerTest {
    @Test
    public void leoLineasDeUnArchivo(){
        String pathTestFile = "saves/test.txt";
        LectorScanner lector = new LectorScanner(pathTestFile);

        String texto = lector.leerLinea();
        String esperado = "Hola mundo1!";
        assertEquals(esperado, texto);

        texto = lector.leerLinea();
        esperado = "Hola mundo2!";
        assertEquals(esperado, texto);
    }

    @Test
    public void leoUnaLineaDeUnArchivoQueNoExiste(){
        String pathTestFile = "saves/testLecturaNoExiste.txt";
        LectorScanner lector = assertDoesNotThrow( () -> new LectorScanner(pathTestFile) );

        String texto = lector.leerLinea();
        String esperado = "";

        assertEquals(esperado, texto);

        File archivoABorrar = new File( pathTestFile );
        archivoABorrar.delete();
    }



}