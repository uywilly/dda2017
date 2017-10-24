/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dominio.IMesa;
import dominio.Mesa;
import dominio.Mozo;
import dominio.RestaurantException;
import dominio.Sistema;
import dominio.Transferencia;
import java.util.Observable;
import java.util.Observer;
import vista.VistaMozo;

/**
 *
 * @author william
 */
public class ControladorMozo implements Observer{
    
    private Sistema modelo = Sistema.getInstancia();
    
    private IMesa mesaSeleccionada;
    private Mozo origen;
    
    private VistaMozo vista; 

    public ControladorMozo(VistaMozo vista, Mozo unM) {
        this.vista = vista;
        this.origen = unM;
        modelo.addObserver(this);
    }

    public void mostrarMesa(IMesa m) {
        vista.mostrarMesa(m);
    }
    
    //REVISAR
    public void guardarSeleccionada(IMesa m) {
        mesaSeleccionada = m;
    }
    
    public void abrirMesa() {
        if(mesaSeleccionada !=null && !mesaSeleccionada.estaAbierta()){
            try{ 
                mesaSeleccionada.abrirMesa();
                // mover aviso al abrir 
                modelo.abrirMesa(mesaSeleccionada);
            }catch (RestaurantException ex){
                vista.error(ex.getMessage());
            }  
        }else{
            vista.error("Verifique la mesa!");
        }
    }
    
    public void cerrarMesa() {
        if(mesaSeleccionada !=null && mesaSeleccionada.estaAbierta()){
            //validar que los pedidos esten ya procesados
            try{
                mesaSeleccionada.cerrarMesa();
                modelo.cerrarrMesa(mesaSeleccionada);
            }catch (RestaurantException ex){
                vista.error(ex.getMessage());
            }
        }else{
            vista.error("Verifique la mesa!");
        }
    }
    
    public void agregarPedido(IMesa mesaSeleccionada) throws RestaurantException{
        if(mesaSeleccionada!= null && mesaSeleccionada.estaAbierta()) vista.agregarPedido(mesaSeleccionada);
        else throw new RestaurantException("Debe abrir la mesa primero!");
    }
    
    public void comenzarTransferenciaMesa(IMesa mesaSeleccionada) throws RestaurantException{
        //Le pide a VentanaPrincipalMozo 
        //que abra la ventana de transferencia
        if(mesaSeleccionada!= null){
            this.mesaSeleccionada = mesaSeleccionada;
            vista.transferirMesa(mesaSeleccionada);
        }else throw new RestaurantException("Debe seleccionar una mesa!");
    }
    
    public void aceptarTransferencia(Transferencia trans) {
        modelo.aceptarTransferencia(trans);                
    }
    public void rechazarTransferencia(Transferencia trans) {
        modelo.rechazarTransferencia(trans);
    }
    
    public void salir() {
        boolean b = modelo.logout(origen);
        vista.cerrar(b,origen);
    }

    @Override
    public void update(Observable o, Object arg) {
        // o = origen / arg = evento
        if(o == modelo){
            if(arg.equals(Sistema.Eventos.abrirMesa)){
                //mandar a la vista que hacer
                vista.actualizarMesas(origen);
                vista.mostrarMesa(mesaSeleccionada);
            }
            if(arg.equals(Sistema.Eventos.cerrarMesa)){
                //mandar a la vista que hacer
                vista.actualizarMesas(origen);
                vista.mostrarMesa(mesaSeleccionada);
            }
            if(arg.equals(Sistema.Eventos.agregarPedido)){
                //mandar a la vista que hacer
                vista.actualizarMesas(origen);
                vista.mostrarMesa(mesaSeleccionada);
            }
            if(arg.equals(Sistema.Eventos.cerrarPedido)){
                //mandar a la vista que hacer
                vista.actualizarMesas(origen);
                vista.mostrarMesa(mesaSeleccionada);
            }
            if(arg.equals(Sistema.Eventos.comenzarTransferencia)){
                //toma la primer transferencia pendiente 
                //y le pide a la viste que le muestra el mensaje al mozo destino
                Transferencia trans = modelo.verTransferenciasPendientes();
                if(trans!=null && trans.getDestino().equals(origen)) vista.mostrarMensajeTransferenciaPendiente(trans);
                
                
            }
            if(arg.equals(Sistema.Eventos.aceptarTransferencia)){
                //toma la primer transferencia pendiente 
                //y le pide a la viste que le muestra el mensaje al mozo origen
                vista.actualizarMesas(origen);
                vista.limpiar();
                if(mesaSeleccionada!=null && !mesaSeleccionada.verMozo().equals(origen)){
                    vista.mostrarMensajeMesaAceptada();
                    mesaSeleccionada = null;
                }
                

            }
            if(arg.equals(Sistema.Eventos.rechazarTransferencia)){
                //toma la primer transferencia pendiente 
                //y le pide a la viste que le muestra el mensaje al mozo destino
                if(mesaSeleccionada!=null && mesaSeleccionada.verMozo().equals(origen)) vista.mostrarMensajeTransferenciaRechazada();
                
            }
            
        }
    }



    

    

    

    
    
    
  
}
