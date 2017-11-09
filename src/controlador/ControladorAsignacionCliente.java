/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dominio.Cliente;
import dominio.IMesa;
import dominio.RestaurantException;
import dominio.Sistema;
import java.util.ArrayList;
import vista.VistaAsignacionCliente;

/**
 *
 * @author william
 */
public class ControladorAsignacionCliente {
    
    private Sistema modelo = Sistema.getInstancia();
    private VistaAsignacionCliente vista;
    private IMesa mesaSeleccionada;
    private Cliente clienteSeleccionado;

    public ControladorAsignacionCliente(IMesa mesaSeleccionada, VistaAsignacionCliente vista) {
        this.mesaSeleccionada = mesaSeleccionada;
        this.vista = vista;
    }

    public void cargarLista(ArrayList<Cliente> verClientesRegistrados) {
        vista.cargarLista(verClientesRegistrados);
    }

    public void asignarClienteMesa(Cliente unC) {
        try{
            modelo.asignarClienteSeleccionadoMesa(mesaSeleccionada,unC);
        }
        catch(RestaurantException ex){
            vista.error(ex.getMessage());
        }
    }
    
    
    
}
