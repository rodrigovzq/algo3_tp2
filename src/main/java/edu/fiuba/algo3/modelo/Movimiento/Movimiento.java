package edu.fiuba.algo3.modelo.Movimiento;

public abstract class Movimiento {
    private Integer cantidad;

    public Movimiento(Integer cantidad) {
        this.cantidad = cantidad;
    }

    private Integer getCantidad() {
        return cantidad;
    }

    public abstract boolean esPosible();
    public void sumarMovimiento( Movimiento m){
        this.cantidad += m.getCantidad();
    }
}
