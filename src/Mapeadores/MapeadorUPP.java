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

/**
 *
 * @author william
 */
public class MapeadorUPP implements Mapeador{
    
    private UnidadProcesadora upp;

    public void setUpp(UnidadProcesadora upp) {
        this.upp = upp;
    }

    @Override
    public int getOid() {
        return upp.getOid();
    }

    @Override
    public void setOid(int oid) {
        upp.setOid(oid);
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
        return "SELECT * FROM upp where upp.oid=" + upp.getOid();
    }

    @Override
    public void leer(ResultSet rs) throws SQLException {
        upp.setOid(rs.getInt("oid"));
        upp.setNombre(rs.getString("nombre"));
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
    public Object getObjeto() {
        return upp;
    }
    
}
