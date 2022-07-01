package edu.fiuba.algo3.modelo.Coordenada;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Excepcion.CoordenadaInvalida;
import edu.fiuba.algo3.modelo.Excepcion.DireccionInvalida;
import edu.fiuba.algo3.modelo.Excepcion.PosicionInvalida;

import java.util.Objects;

public class Coordenada {
    private Integer posY;
    private Integer posX;
    // El (0,0) es la esquina izquierda.

    public Coordenada(Integer posX, Integer posY) throws CoordenadaInvalida {
        this.posX = posX;
        this.posY = posY;
        if( !this.esValida() ){ throw new CoordenadaInvalida(); }
    }

    public Coordenada(Coordenada coord) {
        this.posX = coord.posX;
        this.posY = coord.posY;
    }

    public boolean esValidaEnMapa( Integer ancho, Integer altura){
        if( posY < altura && posX < ancho )
            return true;

        return false;
    }

    public void mover(Direccion direccion)  throws PosicionInvalida {
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

    public boolean esBorde(Integer ancho, Integer altura) {
        if( !this.esEsquina(ancho, altura) ) {
            if ((posX == 0) || (this.posY == 0) || (posX == ancho - 1) || (this.posY == altura - 1)) {
                return true;
            }
        }
        return false;
    }

    public boolean esEsquina(Integer ancho, Integer altura)  throws PosicionInvalida {
        if( ((posX - ancho) >= 0) || ((posX - ancho) >= 0)){
            throw new PosicionInvalida();
        }
        if( (posX == 0) || (posX == ancho - 1) ){
            if((this.posY == 0)  || (this.posY == (altura - 1))){
                return true;
            }
        }

        return false;
    }

    public Direccion determinarEsquina(Integer ancho, Integer altura) throws DireccionInvalida {
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

    public Direccion determinarBorde(Integer ancho, Integer altura) throws DireccionInvalida {
        // (Sacamos provecho de este "bug")
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

    private boolean esValida(){
        if( posY < 0  || posX < 0 )
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "(" + posX + " , " + posY + ')';
    }


    public Integer distanciaVertical(Coordenada coordenada) {
        return coordenada.posY - this.posY;
    }
    public Integer distanciaHorizontal(Coordenada coordenada) {
        return coordenada.posX - this.posX;
    }
}
