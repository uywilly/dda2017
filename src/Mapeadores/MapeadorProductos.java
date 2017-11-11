/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeadores;

import Persistencia.Mapeador;
import dominio.Producto;
import dominio.Sistema;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author william
 */
public class MapeadorProductos implements Mapeador{
    private Producto unP;
    
    @Override
    public int getOid() {
        return unP.getOid();
    }

    @Override
    public void setOid(int oid) {
        unP.setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlInsert() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add( "INSERT INTO productos (oid,nombre,stock,upp,precioUni,codigo) values (" 
                + getOid() + ",'" 
                + unP.getNombre() + "'," 
                + unP.getStock() +","
                + unP.getUpp().getOid()+","
                + unP.getPrecioUni()+",'"
                + unP.getCodigo() + "')");        
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlUpdate() {
       ArrayList<String> sqls = new ArrayList();
       sqls.add( "UPDATE productos set stock=" + unP.getStock()  
               + " WHERE oid=" + unP.getOid()
       );
       return sqls;
    }

    @Override
    public String getSqlDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void cargarDatos(ResultSet rs) throws SQLException {
        unP.setOid(rs.getInt("oid"));
        unP.setNombre(rs.getString("nombre"));
        unP.setStock(rs.getInt("stock"));
        unP.setPrecioUni(rs.getInt("precioUni"));
        unP.setCodigo(rs.getString("codigo"));
        unP.setUpp(Sistema.getInstancia().buscarUPPoid(rs.getInt("upp")));
    }

    @Override
    public Object getObjeto() {
        return unP;
    }
    
}
