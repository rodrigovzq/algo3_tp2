package edu.fiuba.algo3.modelo.Lector;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class LectorScannerTest {
    @Test
    public void leoUnLineaDeUnArchivoDeTest(){
        String pathTestFile = "saves/test.txt";
        LectorScanner lector = new LectorScanner(pathTestFile);

        String texto = lector.leerLinea();
        String esperado = "Hola mundo!";

        assertEquals(esperado, texto);
    }

    @Test
    public void leoUnLineaDeUnArchivoQueNoExiste(){
        String pathTestFile = "saves/test1.txt";
        LectorScanner lector = assertDoesNotThrow( () -> new LectorScanner(pathTestFile) );

        String texto = lector.leerLinea();
        String esperado = "";

        assertEquals(esperado, texto);

        File archivoABorrar = new File( pathTestFile );
        archivoABorrar.delete();
    }



}