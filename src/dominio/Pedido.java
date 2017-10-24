/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author william
 */
public class Pedido {
    private String nombre;
    private int cantidad;
    private Producto producto;
    private boolean finalizado;

    public Pedido(int cantidad, Producto p) {
        this.nombre = p.getNombre();
        this.cantidad = cantidad;
        this.producto = p;
        this.finalizado = false;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    

    @Override
    public String toString() {
        return "Pedido{" + "nombre=" + nombre + ", cantidad=" + cantidad + " estado= " + finalizado + '}';
    }

    public boolean isValido() {
        return (this.cantidad <= this.producto.getStock());
    }
    
    
    
}
