/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author alumnoFI
 */
public class Persistencia {
    
    private BaseDatos base;
    private static Persistencia instancia = new Persistencia();

    private Persistencia() {
        base = BaseDatos.getInstancia();
        base.conectar("jdbc:mysql://localhost:8889/tarea", "root", "root");
    }

    public static Persistencia getInstancia() {
        return instancia;
    }
    private int proximoOid(){
        try {
            String sql = "SELECT valor FROM oid";
            ResultSet rs = base.consultar(sql);
            rs.next();
            int oid = rs.getInt("valor");
            sql = "UPDATE oid set valor = " + (oid+1);
            base.actualizar(sql);
            return oid;
        } catch (SQLException ex) {
            System.out.println("Error al obtener el oid:" + ex.getMessage());
            return -1;
        }
    }
    public void guardar(Mapeador map){
        if(map.getOid()==0) insertar(map);
        else modificar(map);
    }

    private void insertar(Mapeador m) {
        int oid = proximoOid();
        m.setOid(oid);
        ArrayList<String> sqls = m.getSqlInsert();
        if (!base.transaccion(sqls)){
            m.setOid(0);
        }
        
    }
    private void modificar(Mapeador m) {
        ArrayList<String> sqls = m.getSqlUpdate();
        base.transaccion(sqls);
    }
    public void borrar(Mapeador m){
        String sql = m.getSqlDelete();
        int f = base.actualizar(sql);
        if(f>0) m.setOid(0);
    }
    
    public ArrayList obtenerTodos(Mapeador m){
        return buscar(m,null);
    }
    public ArrayList buscar(Mapeador map,String filtro){
        ArrayList lista = new ArrayList();
        String sql = map.getSqlSelect();
        if(filtro!=null) sql+= " WHERE " + filtro;
        ResultSet rs = base.consultar(sql);
        try {
            
            while(rs.next()){
                map.crearNuevo();
                map.setOid(rs.getInt("oid")); //Asumo que se llama
                map.cargarDatos(rs);
                lista.add(map.getObjeto());
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar:" + ex.getMessage());
            return null;
        }
        return lista;
    }
}
