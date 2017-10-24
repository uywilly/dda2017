/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author william
 */
public class UnidadProcesadora {
    private String nombre;
    private ArrayList<Pedido> pedidos;

    public UnidadProcesadora(){
        this.nombre = "";
        pedidos = new ArrayList<>();
    }
    public UnidadProcesadora(String nombre){
        this.nombre = nombre;
        pedidos = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    public void agregarPedido(Pedido p) throws RestaurantException{
        if(!p.isValido()) throw new RestaurantException("No hay stock suficiente");
        pedidos.add(p);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UnidadProcesadora other = (UnidadProcesadora) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UnidadProcesadora{ "  + nombre + '}';
    }
}
