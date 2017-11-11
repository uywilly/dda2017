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
public class TipoClienteDeLaCasa extends TipoCliente{

    public TipoClienteDeLaCasa(int descuentoXproducto, int descuentoXtotal) {
        super("DE LA CASA", descuentoXproducto, descuentoXtotal);
    }

    

    @Override
    public int calcularDescuentoProducto(Pedido unP) {
        int descuento = 0;
        if(this.getProductoConDescuento()!= null) return descuento;
        return descuento;
    }

    @Override
    public int calcularDescuentoTotal(int subtotal) {
        return 500;
    }
    
}
