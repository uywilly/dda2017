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
public abstract class TipoCliente {
    private String nombreTipo;
    private Producto productoConDescuento;
    private int descuentoXproducto;
    private int descuentoXtotal;

    public TipoCliente(String nombreTipo, int descuentoXproducto, int descuentoXtotal) {
        this.nombreTipo = nombreTipo;
        this.descuentoXproducto = descuentoXproducto;
        this.descuentoXtotal = descuentoXtotal;
        this.productoConDescuento = null;
    }

    public Producto getProductoConDescuento() {
        return productoConDescuento;
    }

    public void setProductoConDescuento(Producto productoConDescuento) throws RestaurantException {
        this.productoConDescuento = productoConDescuento;
    }

    public int getDescuentoXproducto() {
        return descuentoXproducto;
    }

    public void setDescuentoXproducto(int descuentoXproducto) {
        this.descuentoXproducto = descuentoXproducto;
    }

    public int getDescuentoXtotal() {
        return descuentoXtotal;
    }

    public void setDescuentoXtotal(int descuentoXtotal) {
        this.descuentoXtotal = descuentoXtotal;
    }
    
    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public abstract int calcularDescuentoProducto(Pedido unP);
    public abstract int calcularDescuentoTotal(int subtotal);

}
