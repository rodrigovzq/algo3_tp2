package edu.fiuba.algo3.vista.PantallasPrincipales;

// Para mi este tiene que ser un popUp. Es decir que se abra una ventana aparte que bloquee
//el juego (no escucha las entradas que hace el jugador ni hace nada) hasta cerrar dicha ventana.

import edu.fiuba.algo3.vista.Ventanas.VentanaPopUp;

public class ContenedorInstrucciones {
    public static void mostrar(){
        VentanaPopUp.mostrar("Intrucciones", "Para moverte usá las teclas mayúsculas: W,A,S,D");

    }
}
