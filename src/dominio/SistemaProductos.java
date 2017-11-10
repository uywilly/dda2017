/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import Mapeadores.MapeadorUPP;
import Persistencia.BaseDatos;
import Persistencia.Persistencia;
import java.util.ArrayList;

/**
 *
 * @author william
 */
public class SistemaProductos {
    private ArrayList<Producto> productos = new ArrayList();; 

    public ArrayList<Producto> getProductos() {
        return productos;
    }
    public void agregarProductos(Producto p){
        productos.add(p);
    }
    public void eliminarProductos(Producto p){
        productos.remove(p);
    }

    public void cargarDatosPrueba() {
        // TODO Auto-generated method stub
        String strConn = "jdbc:mysql://localhost:8889/tarea";
        BaseDatos bd = BaseDatos.getInstancia();
        bd.conectar(strConn, "root", "root");
        Persistencia p = new Persistencia();
        MapeadorUPP mupp = new MapeadorUPP();
        productos = p.obtenerTodos(mupp);
        bd.desconectar();
    }
    
    
}
