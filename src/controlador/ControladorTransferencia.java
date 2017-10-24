/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dominio.IMesa;
import dominio.Mozo;
import dominio.RestaurantException;
import dominio.Sistema;
import dominio.Transferencia;
import java.util.Observable;
import java.util.Observer;
import vista.VistaTransferencia;

/**
 *
 * @author william
 */
public class ControladorTransferencia {
    
    private Sistema modelo = Sistema.getInstancia();
    private VistaTransferencia vista;
    
    private IMesa mesaSeleccionada;
    private Mozo origen;
    private Mozo destino;
    private Transferencia trans;
    
    public ControladorTransferencia(VistaTransferencia v, Mozo m, IMesa mesaSeleccionada){
        vista = v;
        this.origen = m;
        this.mesaSeleccionada = mesaSeleccionada;
    }

    public void cargarMozosLogueados() {
        vista.cargarMozosLogueados(modelo.verMozosLoguados());
    }

    public void avisarComienzoTransferencia(Mozo destino) {
        this.destino = destino;
        trans = new Transferencia(origen, destino, mesaSeleccionada, false);
        try{
            modelo.transferir(trans);
        }catch (RestaurantException ex){
            vista.error(ex.getMessage() );
        }
        
    }   
    
}
