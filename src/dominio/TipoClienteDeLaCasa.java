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

    public TipoClienteDeLaCasa(String nombreTipo) {
        super(nombreTipo);
    }

    @Override
    public int calcularDescuentoProducto(Pedido unP) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int calcularDescuentoTotal(int subtotal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
