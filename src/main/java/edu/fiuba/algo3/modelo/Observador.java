package edu.fiuba.algo3.modelo;

// Las vistas son observadores de los estados de las clases pertenecientes al Modelo
//   Cada vez que se realize un cambio en una de las clases Modelo, se les notificará
// el cambio y cada vista sabrá que datos pedir para actualizarse.
public interface Observador {
    void actualizar();
}
