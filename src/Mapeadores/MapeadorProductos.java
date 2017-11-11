/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeadores;

import Persistencia.Mapeador;
import dominio.Producto;
import dominio.Sistema;
import dominio.UnidadProcesadora;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author william
 */
public class MapeadorProductos implements Mapeador{
    
    private Producto unP;

    public void setUnP(Producto unP) {
        this.unP = unP;
    }

    @Override
    public int getOid() {
        return unP.getOid();
    }

    @Override
    public void setOid(int oid) {
        unP.setOid(oid);
    }

    @Override
    public String[] getSqlInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getSqlUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getSqlDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlRestaurar() {
        return "SELECT * FROM productos where productos.oid=" + unP.getOid();
    }

    @Override
    public void leer(ResultSet rs) throws SQLException {
        unP.setOid(rs.getInt("oid"));
        unP.setNombre(rs.getString("nombre"));
        unP.setStock(rs.getInt("stock"));
        unP.setPrecioUni(rs.getInt("precioUni"));
        unP.setCodigo(rs.getString("codigo"));
        unP.setUpp(Sistema.getInstancia().buscarUPPoid(rs.getInt("upp")));
    }

    @Override
    public String getSqlSelect() {
        return "SELECT * FROM productos";
    }

    @Override
    public void crearNuevo() {
        unP = new Producto();
    }

    @Override
    public Object getObjeto() {
        return unP;
    }
    
    
}
