/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dominio.Producto;
import java.util.ArrayList;

/**
 *
 * @author william
 */
public interface VistaPedido {

    public void cargarProductos(ArrayList<Producto> listarProductos);
    
}
