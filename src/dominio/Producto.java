/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Objects;

/**
 *
 * @author william
 */
public class Producto {
    private String nombre;
    private String codigo;
    private int stock;
    private UnidadProcesadora upp;
    private int precioUni;

    public Producto(String nombre, String codigo, int stock, UnidadProcesadora upp, int precioUni) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.stock = stock;
        this.upp = upp;
        this.precioUni = precioUni;
    }
    public Producto() {
        this.nombre = "";
        this.codigo = "";
        this.stock = 0;
        this.upp = null;
        this.precioUni = 0;
    }

    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public UnidadProcesadora getUpp() {
        return upp;
    }

    public void setUpp(UnidadProcesadora upp) {
        this.upp = upp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(int precioUni) {
        this.precioUni = precioUni;
    }

    @Override
    public String toString() {
        return "Producto{ " + nombre + " , codigo= " + codigo + " , stock= " + stock + " , upp= " + upp + " , precioUni= " + precioUni + '}';
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
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.upp, other.upp)) {
            return false;
        }
        return true;
    }
    
    


    
    
}
