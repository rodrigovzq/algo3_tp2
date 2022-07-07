package edu.fiuba.algo3.modelo.Parser;

import edu.fiuba.algo3.modelo.Excepcion.ArchivoInexistente;
import edu.fiuba.algo3.modelo.Excepcion.ArchivoMalformado;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserMapaTest {
    @Test
    public void leerDeUnArchivoYSeGeneraElMapa(){
        String pathFile = "saves/test/mapa_test.txt";
        Parser parser = new ParserMapa( pathFile );
        parser.parsear();
        String resultado = parser.getEntidadParseada().imprimir();
        String esperado = "3x3;\n(1,1);\nCOMUN-FAVORABLE-DESFAVORABLE;\nCAMBIO_VEHICULO-POZO-PIQUETE;\nCONTROL_POLICIAL-META-COMUN;\n";

        assertEquals(esperado, resultado);
    }

    @Test
    public void verificaQueEsteBienFormadoElArchivoAlParsear(){
        assertThrows(ArchivoMalformado.class, () -> new ParserMapa( "saves/test/fail/mapa_test.txt").parsear() );
        assertThrows(ArchivoInexistente.class, () -> new ParserMapa( "saves/fail/mapa_test.txt").parsear() );
        assertDoesNotThrow(() -> new ParserMapa( "saves/test/mapa_test.txt").parsear() );
    }

}