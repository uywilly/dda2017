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
        abrirMesa, cerrarMesa, agregarPedido, 
        comenzarTransferencia, aceptarTransferencia, 
        rechazarTransferencia, procesarPedido, cerrarPedido, clienteAgregado};

    /////////////////Singleton/////////////////
    private static Sistema instancia = new Sistema();
    private Sistema() {}
    public static Sistema getInstancia() {return instancia;}
    /////////////////fin del singleton///////////////// 

    public void cargarDatosPrueba() {
        su.cargarDatosPrueba();
    }
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
    
    public void asignarClienteSeleccionadoMesa(IMesa mesaSeleccionada, Cliente unC) throws RestaurantException {
        mesaSeleccionada.asignarClienteSeleccionado(unC);
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
    public ArrayList<Cliente> verClientesRegistrados(){
        return su.verClientesRegistrados();
    }
    public Transferencia verTransferenciasPendientesPorMozo(Mozo m){
        return st.verTransferenciasPendientesPorMozo(m);
    }
    public Transferencia verTransferenciasPendientes(){
        // aca salta el error
        //return st.getTransferenciasPendientes().get(0);
        return st.verTransferenciasPendientes();
    }
    public void agregarTransferenciaEnProceso(Transferencia trans) throws RestaurantException{
        st.agregarTransferenciaPendiente(trans); 
    }
    public void aceptarTransferenciaEnProceso(Transferencia trans) throws RestaurantException{
        st.aceptarTransferencia(trans); 
    }
    public void rechazarTransferenciaEnProceso(Transferencia trans){
        st.rechazarTransferencia(trans); 
    }
    ////////////////acceso a listados////////////////

    ////////////////////////////AVISOS////////////////////////////////
    public void avisar(Object evento) {
        setChanged();
        notifyObservers(evento);
    }
    public void agregarPedido(Pedido unP, IMesa mesaSeleccionada) throws RestaurantException {
        mesaSeleccionada.agregarPedido(unP);
    }
    public void transferir(Transferencia trans) throws RestaurantException{
        trans.comenzarTransferencia();
    }
    public void aceptarTransferencia(Transferencia trans) throws RestaurantException{
        trans.aceptada();
    }
    public void rechazarTransferencia(Transferencia trans) {
        trans.rechazada();
    }  
    public void procesarPedido(Gestor ges, Pedido p) {
        ges.procesarPedido(p);  
    }
    public void finalizarPedido(Gestor ges, Pedido p) {
        ges.finalizarPedido(p);
    }    
    //////////////////////////////////////////////////////////////////
    

}
