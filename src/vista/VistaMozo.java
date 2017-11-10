/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dominio.Cliente;
import dominio.IMesa;
import dominio.Mozo;
import dominio.Pedido;
import dominio.Transferencia;
import java.util.ArrayList;

/**
 *
 * @author william
 */
public interface VistaMozo {

    public void mostrarMesa(IMesa m);
    //public void actualizarMesas();

    public void agregarPedido(IMesa mesaSeleccionada);

    public void transferirMesa(IMesa mesaSeleccionada);

    public void mostrarMensajeTransferenciaPendiente(Transferencia trans);

    public void actualizarMesas(Mozo origen);

    public void cerrar(boolean b, Mozo origen);

    public void error(String message);

    public void mostrarMensajeMesaAceptada();

    public void mostrarMensajeTransferenciaRechazada();

    public void limpiar();

    public void nombreEnVentana(Mozo origen);

    public void mostrarClientesRegistrados(ArrayList<Cliente> verClientesRegistrados, IMesa mesaSeleccionada);

    public void actualizarTimer(Transferencia trans);
    
}
