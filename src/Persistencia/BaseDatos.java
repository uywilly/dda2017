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
/**
 *
 * @author william
 */
public class BaseDatos {
  private static BaseDatos instancia = new BaseDatos();
    private Connection conexion;
    private Statement sentencia;

    public static BaseDatos getInstancia() {
        return instancia;
    }
    private BaseDatos() {
    }
    public void conectar(String url,String usuario,String pass){
        try {
            conexion = DriverManager.getConnection(url, usuario, pass);
            sentencia = conexion.createStatement();
        } catch (SQLException ex) {
            System.out.println("Error al conectarse a la base:" + ex.getMessage());
        }
    }
    public void desconectar(){
        try {
            sentencia.close();
            conexion.close();
        } catch (SQLException ex) {
        }
    }
    public ResultSet consultar(String sql){
        try {
            ResultSet rs = sentencia.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            System.out.println("Error al consultar:" + ex.getMessage());
            System.out.println("SQL=" + sql);
            return null;
        }
    }
    public int modificar(String sql){
        try {
            return sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error al modificar:" + ex.getMessage());
            System.out.println("SQL=" + sql);
            return -1;
        }
    }
    
  
}
