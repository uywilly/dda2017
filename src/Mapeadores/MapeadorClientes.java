/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeadores;

import Persistencia.Mapeador;
import dominio.Cliente;
import dominio.TipoClienteComun;
import dominio.TipoClienteDeLaCasa;
import dominio.TipoClientePreferencial;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author william
 */
public class MapeadorClientes implements Mapeador{
    private Cliente unC;
    public void setUnC(Cliente unC) {
        this.unC = unC;
    }

    @Override
    public int getOid() {
        return unC.getOid();
    }

    @Override
    public void setOid(int oid) {
        unC.setOid(oid);
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
        return "SELECT * FROM clientes";
    }

    @Override
    public void crearNuevo() {
        unC = new Cliente("","","","");
    }

    @Override
    public void cargarDatos(ResultSet rs) throws SQLException {
        unC.setOid(rs.getInt("oid"));
        unC.setNombre(rs.getString("nombre"));
        unC.setClave(rs.getString("clave"));
        unC.setNombreCompleto(rs.getString("nombreCompleto"));
        unC.setEmail(rs.getString("email"));
        switch(rs.getString("tipo")){
            case "COMUN":
                TipoClienteComun tcc = new TipoClienteComun(100, 0);
                unC.setTipo(tcc);
            break;
            case "DE LA CASA":
                TipoClientePreferencial tcp = new TipoClientePreferencial(100, 5);
                unC.setTipo(tcp);
            break;
            case "PREFERENCIAL":
                TipoClienteDeLaCasa tcdc = new TipoClienteDeLaCasa(0, 500);
                unC.setTipo(tcdc);
            break;
        }
    }

    @Override
    public Object getObjeto() {
        return unC;
    }
    
}
