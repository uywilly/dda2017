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
public class TipoClientePreferencial extends TipoCliente{

    public TipoClientePreferencial(String nombreTipo, int descuentoXproducto, int descuentoXtotal) {
        super(nombreTipo, descuentoXproducto, descuentoXtotal);
    }

    @Override
    public void setProductoConDescuento(Producto productoConDescuento) throws RestaurantException{
        if(productoConDescuento.getNombre().equalsIgnoreCase("agua mineral")) this.setProductoConDescuento(productoConDescuento);
        else throw new RestaurantException("producto incorrecto");
    }
    
    @Override
    public int calcularDescuentoProducto(Pedido unP) {
        int retorno = 0;
        if(unP.getProducto().equals(this.getProductoConDescuento())){
            retorno = unP.getCantidad() * unP.getProducto().getPrecioUni();
        }
        return retorno;
    }

    @Override
    public int calcularDescuentoTotal(int subtotal) {
        if(subtotal>2000) return Math.toIntExact(Math.round(subtotal*0.5));
        return 0;
    }
    
}
