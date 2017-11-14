/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeadores;

import Persistencia.Mapeador;
import dominio.IMesa;
import dominio.Pedido;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author william
 */
public class MapeadorServicio implements Mapeador{
    
    private IMesa m;

    public void setM(IMesa m) {
        this.m = m;
    }

    @Override
    public int getOid() {
        return m.getOid();
    }

    @Override
    public void setOid(int oid) {
        m.setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlInsert() {
        ArrayList<String> sqls = new ArrayList();        
        sqls.add(
                "INSERT INTO mesas values (" + getOid() + "," + m.verNumero() +
                 ")"
        );
        generarSqlLineas(sqls);
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlUpdate() {
        ArrayList<String> sqls = new ArrayList();        
        /*sqls.add(
                "INSERT INTO mesas values (" + getOid() + "," + m.verNumero() +
                 ")"
        );*/
        generarSqlLineas(sqls);
        return sqls;
    }

    @Override
    public String getSqlDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlSelect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearNuevo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cargarDatos(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getObjeto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private void generarSqlLineas(ArrayList<String> sqls) {
       Pedido p;
       for(int x=0;x<m.listarServicio().size();x++){
           p = m.listarServicio().get(x);
           sqls.add( "INSERT INTO pedidos (`oid`,`mesa`,`nombre`,`cantidad`,`producto`,`finalizado`) values (" 
                   + getOid()+1 + "," +
                   m.verNumero() + ",'" + p.getNombre() + "',"+ 
                   p.getCantidad() + "," + p.getProducto().getOid() 
                   + "," + 1 +")"
           );
       }
    }
    
}
