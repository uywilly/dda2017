/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dominio.Gestor;
import dominio.Pedido;
import dominio.Sistema;
import dominio.UnidadProcesadora;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import vista.VistaGestionPedidos;

/**
 *
 * @author william
 */
public class ControladorUnidadProcesadora implements Observer{
    
    private Sistema modelo = Sistema.getInstancia();
    private VistaGestionPedidos vista;
    private Gestor unG; 
    private UnidadProcesadora unaUPP;

    public ControladorUnidadProcesadora(VistaGestionPedidos vista) {
        this.vista = vista;
        modelo.addObserver(this);
    }
    
    public ControladorUnidadProcesadora(VistaGestionPedidos vista, Gestor ges) {
        this.vista = vista;
        unG = ges;
        unaUPP = ges.getLogueadoEn();  
        modelo.addObserver(this);
    }
    
    
    public void cargarPedidosPendientes() {
        vista.cargarPedidosPendientes(modelo.verPedidosPorUnidadProcesadora(unaUPP));
    }

    public void cargarPedidosEnProcesoPorGestor() {
        vista.cargarPedidosEnProcesoPorGestor(modelo.verPedidosPorGestorEnUnidadProcesadora(unaUPP, unG));
    }
    public void procesarPedido(Pedido p) {
        modelo.procesarPedido(unG,p);
        
    }
    public void finalizarPedido(Pedido p) {
        modelo.finalizarPedido(unG,p);
    }
    public void logout() {
        modelo.logout(unG);
    }

    public void procesarPedido(Gestor ges, Pedido p) {
        modelo.procesarPedido(ges,p);
        
    }
    
    public void logout(Gestor ges) {
        modelo.logout(ges);
    }

    @Override
    public void update(Observable o, Object arg) {
        // o = origen / arg = evento
        if(o == modelo){
            if(arg.equals(Sistema.Eventos.agregarPedido)){
                //mandar a la vista que hacer
                vista.refrescarPantalla();
            }
            if(arg.equals(Sistema.Eventos.procesarPedido)){
                //mandar a la vista que hacer
                vista.refrescarPantalla();
            }
            if(arg.equals(Sistema.Eventos.cerrarPedido)){
                //mandar a la vista que hacer
                vista.refrescarPantalla();
            }
        }
    }

    public void nombreEnVentana() {
        vista.nombreEnVentana(unG);
    }

    

    

    
    
    
}
