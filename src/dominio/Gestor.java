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
public class Gestor extends Usuario{
    private ArrayList<Pedido> pedidosProcesados;
    private ArrayList<Pedido> pedidosFinalizados;
    private UnidadProcesadora logueadoEn;
    
    
    
    public Gestor(String nombre, String clave, String nombreCompleto) {
        super(nombre, clave, nombreCompleto);
        pedidosProcesados = new ArrayList<>();
        pedidosFinalizados = new ArrayList<>();
        logueadoEn = null;
    }

    public ArrayList<Pedido> getPedidosProcesados() {
        return pedidosProcesados;
    }
    public ArrayList<Pedido> getPedidosFinalizados() {
        return pedidosFinalizados;
    }
    
    public UnidadProcesadora getLogueadoEn() {
        return logueadoEn;
    }

    public void setLogueadoEn(UnidadProcesadora logueadoEn) {
        this.logueadoEn = logueadoEn;
    }

    public void procesarPedido(Pedido p) {
        this.pedidosProcesados.add(p);
        UnidadProcesadora u = p.getProducto().getUpp();
        u.getPedidos().remove(p);
        Sistema.getInstancia().avisar(Sistema.Eventos.procesarPedido);
    }

    public void finalizarPedido(Pedido p) {
        p.setFinalizado(true);
        this.pedidosFinalizados.add(p);
        this.pedidosProcesados.remove(p);
        Sistema.getInstancia().avisar(Sistema.Eventos.cerrarPedido);
    }
    
}
