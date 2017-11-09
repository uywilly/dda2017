/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dominio.Cliente;
import java.util.ArrayList;

/**
 *
 * @author william
 */
public interface VistaAsignacionCliente {

    public void cargarLista(ArrayList<Cliente> verClientesRegistrados);

    public void error(String message);
    
}
