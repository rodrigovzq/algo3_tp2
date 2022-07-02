package edu.fiuba.algo3.modelo.Lector;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.SecureDirectoryStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class LectorTest {
    @Test
    public void leoUnLineaDeUnArchivoDeTest(){
        String pathTestFile = "saves/test.txt";
        Lector lector = new Lector(pathTestFile);

        String texto = lector.leerLinea();
        String esperado = "Hola mundo!";

        assertEquals(esperado, texto);
    }

    @Test
    public void leoUnLineaDeUnArchivoQueNoExiste(){
        String pathTestFile = "saves/test1.txt";
        Lector lector = assertDoesNotThrow( () -> new Lector(pathTestFile) );

        String texto = lector.leerLinea();
        String esperado = "";

        assertEquals(esperado, texto);

        File archivoABorrar = new File( pathTestFile );
        archivoABorrar.delete();
    }



}