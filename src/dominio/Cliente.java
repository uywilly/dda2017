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
public class Cliente extends Usuario{
    
    private String email;
    private int idCliente;
    private TipoCliente tipo; 
    
    public Cliente(String nombre, String clave, String nombreCompleto, String email) {
        super(nombre, clave, nombreCompleto);
        this.email = "";
        this.idCliente = 0;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }
    public int calcularDescuentoProducto(Pedido unP) {
        return tipo.calcularDescuentoProducto(unP);
    }

    public int calcularDescuentoTotal(int subtotal) {
        return tipo.calcularDescuentoTotal(subtotal);
    }
    
}
