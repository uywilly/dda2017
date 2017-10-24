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
public class Mesa implements IMesa{
    private int numero;
    private boolean abierta;
    private Mozo mozo;
    private ArrayList<Pedido> servicio;

    public Mesa(int numero, boolean abierta, Mozo mozo) {
        this.numero = numero;
        this.abierta = abierta;
        this.mozo = mozo;
        servicio = new ArrayList<Pedido>();
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


    public void setMozo(Mozo mozo) {
        this.mozo = mozo;
    }
    
    @Override
    public int verNumero() {
        return this.numero;
    }

    @Override
    public boolean estaAbierta() {
        return this.abierta;
    }

    @Override
    public Mozo verMozo() {
        return this.mozo;
    }

    @Override
    public int calcularTotalServicio() {
        int salida = 0;
        for(Pedido unP : this.servicio){
            salida+=unP.getCantidad()*unP.getProducto().getPrecioUni();
        }
        return salida;
    }

    @Override
    public ArrayList<Pedido> listarServicio() {
        return this.servicio;
    }

    @Override
    public void abrirMesa() throws RestaurantException{
        if(this.abierta) throw new RestaurantException("Mesa ya abierta!");
        else abierta = true;
    }

    @Override
    public void cerrarMesa() throws RestaurantException{
        if(!this.hayPedidosSinFinalizar()){
            abierta = false;
        }else throw new RestaurantException("La mesa tiene pedidos abiertos!");
    }

    @Override
    public String toString() {
        return "# " + numero + " , abierta= " + abierta + " , mozo= " + mozo.getNombre() + '}';
    }

    @Override
    public void agregarPedido(Pedido unP) {
        if(this.estaAbierta()){
            if(unP.isValido()){
                this.servicio.add(unP);
                int stock = unP.getProducto().getStock();
                int cantidad = unP.getCantidad();
                unP.getProducto().setStock(stock - cantidad);
                Sistema.getInstancia().avisar(Sistema.Eventos.agregarPedido);
            }
        }
    }

    private boolean hayPedidosSinFinalizar() {
        for(Pedido unP : this.servicio){
            if(!unP.isFinalizado()) return true;
        }
        return false;
    }
    
    
}
