/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author william
 */
public class Transferencia implements Runnable{
    private Mozo origen;
    private Mozo destino;
    private IMesa mesa;
    private boolean aceptada;

    //atributos para el thread
    private Thread hilo;
    boolean correr;
    int tiempo = 20;
    
    public Transferencia(Mozo origen, Mozo destino, IMesa mesa, boolean aceptada) {
        this.origen = origen;
        this.destino = destino;
        this.mesa = mesa;
        this.aceptada = aceptada;
        hilo = new Thread(this);
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

    public void aceptada() throws RestaurantException{
        this.aceptada = true;
        this.getOrigen().getMesas().remove(this.mesa);
        this.getDestino().getMesas().add(this.mesa);
        mesa.setMozo(destino);
        this.parar();
        Sistema.getInstancia().aceptarTransferenciaEnProceso(this);
        Sistema.getInstancia().avisar(Sistema.Eventos.aceptarTransferencia);

    }

    public void rechazada() {
        this.aceptada = false;
        this.parar();
        Sistema.getInstancia().rechazarTransferenciaEnProceso(this);
        Sistema.getInstancia().avisar(Sistema.Eventos.rechazarTransferencia);
    }

    public void comenzarTransferencia() throws RestaurantException{
        if(this.isValida()){
            Sistema.getInstancia().agregarTransferenciaEnProceso(this);
            Sistema.getInstancia().avisar(Sistema.Eventos.comenzarTransferencia);
            this.correr();
        }else throw new RestaurantException("Eror origen = destino");
    }
    
    public void correr() {
        correr = true;
        tiempo = 20;
        hilo.start();
    }

    public void parar() {
        correr = false;
    }

    public void reiniciar() {
        tiempo = 20;
        correr = true;
    }

    public int getTiempo() {
        return this.tiempo;
    }
    public void setTiempo(int t) {
        this.tiempo = t;
    }
    
    @Override
    public void run() {
        while (tiempo > 0 && correr) {
            try {
                Sistema.getInstancia().avisar(Sistema.Eventos.tiempo);
                hilo.sleep(1000);
                tiempo--;
                if(tiempo == 0 ) Sistema.getInstancia().avisar(Sistema.Eventos.rechazarTransferencia);

            } catch (InterruptedException ex) {
                Logger.getLogger(Transferencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
