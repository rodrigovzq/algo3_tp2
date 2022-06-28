package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Excepcion.DireccionInvalida;
import edu.fiuba.algo3.modelo.Excepcion.MapaInvalido;
import edu.fiuba.algo3.modelo.Excepcion.PosicionInvalida;
import javafx.geometry.Pos;

import java.util.Objects;

public class Coordenada {
    private Integer posY;
    private Integer posX;
    // El (0,0) es la esquina izquierda.

    public Coordenada(Integer posX, Integer posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public boolean esValidaEnMapa( Integer ancho, Integer altura){
        //El ancho mínimo del mapa es 2x2.
        //TODO: no debería estar aca seguramente esta validación.
        if( ancho < 2 || altura < 2){
            throw new MapaInvalido();
        }

        if( posY < altura && posX < ancho )
            return true;

        return false;
    }

    public void mover(Direccion direccion) {
        if( direccion == Direccion.NORTE){
            this.posY -= 1;
        }else if( direccion == Direccion.SUR){
            this.posY += 1;
        }else if( direccion == Direccion.ESTE){
            this.posX += 1;
        }else if( direccion == Direccion.OESTE){
            this.posX -= 1;
        }

        if( posX < 0 || posY < 0)
            throw new PosicionInvalida();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordenada that = (Coordenada) o;
        return Objects.equals(posY, that.posY) && Objects.equals(posX, that.posX);
    }

    public boolean esEsquina(Integer ancho, Integer altura) {
        //TODO: no debería estar aca seguramente esta validación.
        if( ancho < 2 || altura < 2){
            throw new MapaInvalido();
        }
        if( (posX - ancho >= 0) || (posX - ancho >= 0)){
            throw new PosicionInvalida();
        }
        if( (posX == 0) || (posX == ancho - 1) ){
            if((this.posY == 0)  || (this.posY == altura - 1)){
                return true;
            }
        }

        return false;
    }

    public boolean esBorde(Integer ancho, Integer altura) {
        if( !this.esEsquina(ancho, altura) ) {
            if ((posX == 0) || (this.posY == 0) || (posX == ancho - 1) || (this.posY == altura - 1)) {
                return true;
            }
        }
        return false;
    }

    public Direccion determinarEsquina(Integer ancho, Integer altura) {
        if( this.posY == 0 && this.posX == 0){
            return Direccion.NOROESTE;
        }else if( this.posY == 0 && this.posX == ancho-1){
            return Direccion.NORESTE;
        }else if( this.posY == altura-1 && this.posX == 0){
            return Direccion.SUDOESTE;
        }else if( this.posY == altura-1 && this.posX == ancho-1){
            return Direccion.SUDESTE;
        }else {
            throw new DireccionInvalida( "determinarEsquina :");
        }
    }

    public Direccion determinarBorde(Integer ancho, Integer altura) {
        // Si yo le paso una esquina, no va a lanzar una excepcion, lo va a detectar como un borde ESTE o OESTE.
        if(this.posX == 0){
            return Direccion.OESTE;
        }else if (this.posX == ancho-1) {
            return Direccion.ESTE;
        }else if(this.posY == 0) {
            return Direccion.NORTE;
        }else if(this.posY == altura-1){
            return Direccion.SUR;
        }else{
            throw new DireccionInvalida("determinarBorde :");
        }
    }
}
