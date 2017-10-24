/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author william
 */
public class Mozo extends Usuario{
    
    private ArrayList<IMesa> mesas;
    
    public Mozo(String nombre, String clave, String nombreCompleto) {
        super(nombre, clave, nombreCompleto);
        mesas = new ArrayList<IMesa>();
    }
    public ArrayList<IMesa> getMesas() {
        return mesas;
    }

    public void agregarPedidoMesa(Pedido unP, IMesa mesaSeleccionada) {
        mesaSeleccionada.agregarPedido(unP);
    }

    public ArrayList<IMesa> getMesasAbiertas() {
        ArrayList<IMesa> salida = new ArrayList<IMesa>();
        for(IMesa unaM : this.mesas){
            if(unaM.estaAbierta())salida.add(unaM);
        }
        return salida;
    }
    

}
