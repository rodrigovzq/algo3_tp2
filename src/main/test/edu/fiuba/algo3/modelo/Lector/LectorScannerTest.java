package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Excepcion.ArchivoInexistente;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class LectorScannerTest {
    @Test
    public void leoLineasDeUnArchivo() throws ArchivoInexistente {
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
        assertThrows( ArchivoInexistente.class, () -> new LectorScanner(pathTestFile) );
    }



}