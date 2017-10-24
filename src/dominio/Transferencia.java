/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Observable;

/**
 *
 * @author william
 */
public class Transferencia{
    private Mozo origen;
    private Mozo destino;
    private IMesa mesa;
    private boolean aceptada;

    public Transferencia(Mozo origen, Mozo destino, IMesa mesa, boolean aceptada) {
        this.origen = origen;
        this.destino = destino;
        this.mesa = mesa;
        this.aceptada = aceptada;
    }
    
    public Mozo getOrigen() {
        return origen;
    }

    public void setOrigen(Mozo origen) {
        this.origen = origen;
    }

    public Mozo getDestino() {
        return destino;
    }

    public void setDestino(Mozo destino) {
        this.destino = destino;
    }

    public IMesa getMesa() {
        return mesa;
    }

    public void setMesa(IMesa mesa) {
        this.mesa = mesa;
    }

    public boolean isAceptada() {
        return aceptada;
    }

    public void setAceptada(boolean aceptada) {
        this.aceptada = aceptada;
    }

    public boolean isValida() {
        return !this.origen.equals(this.destino);
    }
    
    
    
}
