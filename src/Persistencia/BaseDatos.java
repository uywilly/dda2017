/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumnoFI
 */
public class BaseDatos {
    
    private static BaseDatos instancia = new BaseDatos();
    private Connection conexion;
    private Statement stmt;

    public static BaseDatos getInstancia() {
        return instancia;
    }

    private BaseDatos() {
    }
    public void conectar(String url,String u,String p){
        try {
            conexion = DriverManager.getConnection(url, u, p);
            stmt = conexion.createStatement();
        } catch (SQLException ex) {
            System.out.println("Error al conectar:" + ex.getMessage());
        }
    }
    public void desconectar(){
        try {
            conexion.close();
        } catch (SQLException ex) {
        }
    }
    public int actualizar(String sql){
        try {
            return stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error al actualizar:" + ex.getMessage());
            System.out.println("SQL:" + sql);
            return -1;
        }
    }
    public ResultSet consultar(String sql){
        try {
            return stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Error al consultar:" + ex.getMessage());
            System.out.println("SQL:" + sql);
            return null;
        }
    }
    public boolean transaccion(ArrayList<String> sqls){
        try {
            conexion.setAutoCommit(false); //begin T
            for(String sql:sqls){
                if(actualizar(sql)==-1){
                    conexion.rollback();
                    return false;
                }
            }
            conexion.commit();
            return true;
                    
        } catch (SQLException ex) {
                System.out.println("Error en T:" + ex.getMessage());
                return false;
        }finally{
            try {
                conexion.setAutoCommit(true); //end T
            } catch (SQLException ex) {               
            }
        }
        
    }
}
