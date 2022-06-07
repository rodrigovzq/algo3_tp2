package edu.fiuba.algo3.modelo.Vehiculos;


import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoInvalido;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoValido;

public class CuatroPorCuatro implements IVehiculo {
    public static final int LIMITE_POZOS = 3;
    public static final int RESET_CONTADOR = 0;
    public static final int SIN_PENALIZAR_POZO = 1;
    public static final int PENALIZACION_POZO = 2;
    public static final int MOVIMIENTO_DEFAULT = 1;
    private Integer contadorPozosAtravesados;

    public CuatroPorCuatro() {
        this.contadorPozosAtravesados = RESET_CONTADOR;
    }

    private void resetearContadorPozos(){
        this.contadorPozosAtravesados = RESET_CONTADOR;
    }

    private void contarPozoAtravesado(){
        this.contadorPozosAtravesados++;
    }

    private boolean limiteDePozosExcedido(){
        return contadorPozosAtravesados.equals(LIMITE_POZOS);
    }
    @Override
    public Movimiento avanzarComun() {
        return new MovimientoValido(MOVIMIENTO_DEFAULT);
    }

    @Override
    public Movimiento avanzarPiquete() {
        return new MovimientoInvalido();
    }

    @Override
    public Movimiento avanzarControlPolicial() {
        /* se implementa algo*/
        return null;
    }

    @Override
    public Movimiento avanzarPozo() {
        Movimiento movimiento = new MovimientoValido(SIN_PENALIZAR_POZO);
        this.contarPozoAtravesado();

        if( this.limiteDePozosExcedido()){
            this.resetearContadorPozos();
            movimiento = new MovimientoValido(PENALIZACION_POZO);
        }

        return movimiento;
    }
}
