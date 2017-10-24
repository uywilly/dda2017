/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dominio.Pedido;
import java.util.ArrayList;

/**
 *
 * @author william
 */
public interface VistaGestionPedidos {

    public void cargarPedidosPendientes(ArrayList<Pedido> verPedidosPorUnidadProcesadora);

    public void cargarPedidosEnProcesoPorGestor(ArrayList<Pedido> verPedidosPorGestorEnUnidadProcesadora);

    public void refrescarPantalla();
    
}
