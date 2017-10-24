/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

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

    public void procesarPedido(Gestor ges, Pedido p) {
        ges.getPedidosProcesados().add(p);
        UnidadProcesadora u = p.getProducto().getUpp();
        u.getPedidos().remove(p);
        
    }
    public void finalizarPedido(Gestor ges, Pedido p) {
        p.setFinalizado(true);
        ges.getPedidosFinalizados().add(p);
        ges.getPedidosProcesados().remove(p);
        
    }

    void agregarPedido(Pedido unP) throws RestaurantException {
        UnidadProcesadora unaU = unP.getProducto().getUpp();
        unaU.agregarPedido(unP);
        
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
    

}
