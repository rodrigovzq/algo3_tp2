package edu.fiuba.algo3.modelo.Parser;

import edu.fiuba.algo3.modelo.Mapa.Mapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserMapaTest {
    @Test
    public void leerDeUnArchivoYSeGeneraElMapa(){
        String pathFile = "saves/mapa_test.txt";
        Parser parser = new ParserMapa( pathFile );

        String resultado = parser.parsear().imprimir();
        String esperado = "3x3;\nCOMUN-FAVORABLE-DESFAVORABLE;\nCAMBIO_VEHICULO-POZO-PIQUETE;\nCONTROL_POLICIAL-COMUN-COMUN;\n";

        assertEquals(esperado, resultado);
    }

}