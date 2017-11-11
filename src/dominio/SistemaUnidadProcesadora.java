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
public class SistemaUnidadProcesadora {
    
    private ArrayList<UnidadProcesadora> unidadesProcesadoras = new ArrayList<>();
    
    public void agregarUnidadProcesadora(UnidadProcesadora u){
        unidadesProcesadoras.add(u);
    }
    public void eliminarUnidadProcesadora(UnidadProcesadora u){
        unidadesProcesadoras.remove(u);
    }

    public ArrayList<UnidadProcesadora> getUnidadesProcesadoras() {
        return unidadesProcesadoras;
    }
    public UnidadProcesadora buscarUPPoid(int aInt) {
        for(UnidadProcesadora unaUPP : unidadesProcesadoras){
            if(unaUPP.getOid()==aInt) return unaUPP;
        }
        return null;
    }

    public ArrayList<Pedido> verPedidosPorUnidadProcesadora(UnidadProcesadora u) {
        ArrayList<Pedido> salida = new ArrayList<>();
        for(UnidadProcesadora aux : unidadesProcesadoras){
            if(aux.equals(u)){
               for(Pedido p : u.getPedidos()){
                   salida.add(p);
               }
            }
        }
        return salida;
    }
    public boolean hayPedidosNoFinalizados() {
        boolean salida = false;
        for(UnidadProcesadora aux : unidadesProcesadoras){
           for(Pedido p : aux.getPedidos())
           {
               if(!p.isFinalizado()){
                   return true;
               }
           }
        }
        return salida;
    }
    boolean hayPedidosNoFinalizadosDeMozo(Mozo m) {
        boolean salida = false;
        for(IMesa unaM : m.getMesas()){
           for(Pedido p : unaM.listarServicio())
           {
               if(!p.isFinalizado()){
                   return true;
               }
           }
        }
        return salida;
    }
    
    public void cargarDatosPrueba() {
        // TODO Auto-generated method stub
        /*String strConn = "jdbc:mysql://localhost:8889/tarea";
        BaseDatos bd = BaseDatos.getInstancia();
        bd.conectar(strConn, "root", "root");
        Persistencia p = new Persistencia();
        MapeadorUPP mupp = new MapeadorUPP();
        unidadesProcesadoras = p.obtenerTodos(mupp);
        bd.desconectar();*/
        Persistencia p = Persistencia.getInstancia();
        MapeadorUPP mupp = new MapeadorUPP();
        unidadesProcesadoras = p.obtenerTodos(mupp);
    }


    

}
