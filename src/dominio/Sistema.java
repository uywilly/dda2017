/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author william
 */
public class Sistema extends Observable {

    private SistemaUsuario su = new SistemaUsuario();
    private SistemaProductos sp = new SistemaProductos();
    private SistemaTransferencias st = new SistemaTransferencias();
    private SistemaUnidadProcesadora supp = new SistemaUnidadProcesadora();

    

    public enum Eventos {
        abrirMesa, cerrarMesa, agregarPedido, comenzarTransferencia, aceptarTransferencia, rechazarTransferencia, procesarPedido, cerrarPedido};

    /////////////////Singleton/////////////////
    private static Sistema instancia = new Sistema();
    private Sistema() {}
    public static Sistema getInstancia() {return instancia;}
    /////////////////fin del singleton///////////////// 

    
    public Mozo loginMozo(String nombre, String clave) throws RestaurantException {
        return su.loginMozo(nombre, clave);
    }
    public Gestor loginGestor(String nombre, String clave) throws RestaurantException {
        return su.loginGestor(nombre, clave);
    }
    public boolean logout() {
        boolean salida = true;
        if(supp.hayPedidosNoFinalizados()){
            salida = false;
        }
        return salida;
    }
    public void logout(Gestor ges) {
        su.logoutGestor(ges);
    }
    
    public boolean logout(Mozo m) {
        return su.logoutMozo(m);
    }
    
    public void cargarDatosPrueba() {
        su.cargarDatosPrueba();
    }
    
    ////////////////acceso a listados////////////////
    public ArrayList<Producto> listarProductos(){
        return sp.getProductos();
    }
    public ArrayList<Mozo> verMozosLoguados(){
        return su.getMozosLogueados();
    }
    public ArrayList<UnidadProcesadora> verUnidadesProcesadoras(){
        return supp.getUnidadesProcesadoras();
    }
    public ArrayList<Pedido> verPedidosPorUnidadProcesadora(UnidadProcesadora u){
        return supp.verPedidosPorUnidadProcesadora(u);
    }
    public ArrayList<Pedido> verPedidosPorGestorEnUnidadProcesadora(UnidadProcesadora u, Gestor g){
        return su.verPedidosPorGestorEnUnidadProcesadora(u,g);
    }
    public ArrayList<Pedido> verPedidosCompletadosPorGestor(Gestor g){
        return su.verPedidosCompletadosPorGestor(g);
    }
    public Transferencia verTransferenciasPendientesPorMozo(Mozo m){
        return st.verTransferenciasPendientesPorMozo(m);
    }
    public Transferencia verTransferenciasPendientes(){
        // aca salta el error
        //return st.getTransferenciasPendientes().get(0);
        return st.verTransferenciasPendientes();
    }
    ////////////////////////////////AVISOS////////////////////////////////
    public void avisar(Object evento) {
        setChanged();
        notifyObservers(evento);
    }

    public void agregarPedido(Pedido unP, IMesa mesaSeleccionada) throws RestaurantException {
        //experto la mesa
        mesaSeleccionada.agregarPedido(unP);
    }
    
    public void transferir(Transferencia trans) throws RestaurantException{
        st.agregarTransferenciaPendiente(trans);
        avisar(Sistema.Eventos.comenzarTransferencia);
    }
    public void aceptarTransferencia(Transferencia trans) {
        st.aceptarTransferencia(trans);
        avisar(Sistema.Eventos.aceptarTransferencia);
    }
    public void rechazarTransferencia(Transferencia trans) {
        st.rechazarTransferencia(trans);
        avisar(Sistema.Eventos.rechazarTransferencia);
    }
    public void procesarPedido(Gestor ges, Pedido p) {
        supp.procesarPedido(ges,p);
        avisar(Sistema.Eventos.procesarPedido);
    }
    public void finalizarPedido(Gestor ges, Pedido p) {
        supp.finalizarPedido(ges,p);
        avisar(Sistema.Eventos.cerrarPedido);
    }
    
    ////////////////////////////////////////////////////////////////

}
