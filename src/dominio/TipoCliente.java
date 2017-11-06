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

    public TipoCliente(String nombreTipo) {
        this.nombreTipo = nombreTipo;
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
