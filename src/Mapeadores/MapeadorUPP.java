/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeadores;

import Persistencia.Mapeador;
import dominio.UnidadProcesadora;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author william
 */
public class MapeadorUPP implements Mapeador{

    private UnidadProcesadora upp;
    
    @Override
    public int getOid() {
       return upp.getOid();
    }

    @Override
    public void setOid(int oid) {
        upp.setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getSqlUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlSelect() {
        return "SELECT * FROM upp";
    }

    @Override
    public void crearNuevo() {
        upp = new UnidadProcesadora();
    }

    @Override
    public void cargarDatos(ResultSet rs) throws SQLException {
        upp.setOid(rs.getInt("oid"));
        upp.setNombre(rs.getString("nombre"));
    }

    @Override
    public Object getObjeto() {
        return upp;
    }
    
}
