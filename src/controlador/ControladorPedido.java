/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dominio.IMesa;
import dominio.Pedido;
import dominio.Producto;
import dominio.RestaurantException;
import dominio.Sistema;
import java.util.Observable;
import java.util.Observer;
import vista.VistaMozo;
import vista.VistaPedido;

/**
 *
 * @author william
 */
public class ControladorPedido implements Observer{

    private Sistema modelo = Sistema.getInstancia();
    private IMesa mesaSeleccionada;
    private VistaPedido vista;

    public ControladorPedido(VistaPedido vista) {
        this.vista = vista;
        modelo.addObserver(this);
    }

    public void cargarProductos() {
        vista.cargarProductos(modelo.listarProductos());
    }

    public void agregarPedido(Producto prod, int cantidad, IMesa mesaSeleccionada) throws RestaurantException {
        Pedido unP = new Pedido(cantidad,prod);
        modelo.agregarPedido(unP, mesaSeleccionada);
        //mesaSeleccionada.agregarPedido(unP);
    }

    @Override
    public void update(Observable o, Object arg) {
        // o = origen / arg = evento
        if(o == modelo){
            if(arg.equals(Sistema.Eventos.agregarPedido)){
                //mandar a la vista que hacer
                cargarProductos();
            }
        }
    }

}
