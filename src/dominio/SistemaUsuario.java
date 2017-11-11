/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import Mapeadores.MapeadorClientes;
import Mapeadores.MapeadorUPP;
import Persistencia.BaseDatos;
import Persistencia.Persistencia;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author william
 */
public class SistemaUsuario {

    private ArrayList<Mozo> mozos = new ArrayList();
    private ArrayList<Gestor> gestores = new ArrayList();
    private ArrayList<Cliente> clientes = new ArrayList();

    private ArrayList<Mozo> mozosLogueados = new ArrayList();
    private ArrayList<Gestor> gestoresLogueados = new ArrayList();

    public ArrayList<Mozo> getMozosLogueados() {
        return mozosLogueados;
    }

    public ArrayList<Gestor> getGestoresLogueados() {
        return gestoresLogueados;
    }

    public ArrayList<Mozo> getMozos() {
        return mozos;
    }
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Mozo> getGestores() {
        return mozos;
    }

    public Mozo loginMozo(String nombre, String clave) throws RestaurantException {
        Mozo salida = null;
        for (Mozo m : mozos) {
            if (m.getNombre().equals(nombre) && m.getClave().equals(clave) && !mozosLogueados.contains(m)) {
                mozosLogueados.add(m);
                return m;
            }
        }
        if(salida==null) throw new RestaurantException("Error al ingresar");
        return salida;
    }

    public Gestor loginGestor(String nombre, String clave)throws RestaurantException {
        Gestor salida = null;
        for (Gestor g : gestores) {
            if (g.getNombre().equals(nombre) && g.getClave().equals(clave) && !gestoresLogueados.contains(g)) {
                gestoresLogueados.add(g);
                return g;
            }
        }
        if(salida==null) throw new RestaurantException("Error al ingresar");
        return salida;
    }
    public ArrayList<Pedido> verPedidosPorGestorEnUnidadProcesadora(UnidadProcesadora u, Gestor g) {
        ArrayList<Pedido> salida = new ArrayList<>();
        for (Gestor gest : gestoresLogueados) {
            if (gest.equals(g)) {
                for (Pedido ped : gest.getPedidosProcesados()) {
                    if (ped.getProducto().getUpp().equals(u)) {
                        salida.add(ped);
                        }
                    }
                }

            }
        return salida;
    }
    
    public ArrayList<Pedido> verPedidosCompletadosPorGestor(Gestor g) {
        ArrayList<Pedido> salida = new ArrayList<>();
        for (Gestor gest : gestoresLogueados) {
            if (gest.equals(g)) {
                for (Pedido ped : gest.getPedidosProcesados()) {
                    if (ped.isFinalizado()) {
                        salida.add(ped);
                        }
                    }
                }

            }
        return salida;
    }
    public ArrayList<Cliente> verClientesRegistrados() {
        return this.clientes;
    }
    
    public void logoutGestor(Gestor ges) {
        this.gestoresLogueados.remove(ges);
    }
    
    public boolean logoutMozo(Mozo m){
        if(!this.mozosLogueados.contains(m)) return true;
        if(m.getMesasAbiertas().isEmpty()){
            this.mozosLogueados.remove(m);
            return true;
        }        
        return false;
    }
    
    public boolean hayMesasAbiertas() {
        if(this.mozosLogueados.size()==0) return false;
        for(Mozo unM : this.mozosLogueados){
            for(IMesa unaM : unM.getMesas()){
                if(unaM.estaAbierta()) return true;
            }
        }
        return false;
    }
    
    public boolean hayMesasAbiertas(Mozo m) {
        if(m.getMesas().size()==0) return false;
        for(IMesa unaM : m.getMesas()){
            if(unaM.estaAbierta()) return true;
        }      
        return false;
    }

    public void cargarDatosPrueba() {
        // TODO Auto-generated method stub
        Mozo m1 = new Mozo("1", "1", "Juan Perez Mozo");
        Mesa mm1 = new Mesa(1,false,m1);  
        Mesa mm2 = new Mesa(2,false,m1);

        m1.getMesas().add(mm1);
        m1.getMesas().add(mm2);
        m1.getMesas().add(new Mesa(3,false,m1));
        m1.getMesas().add(new Mesa(4,false,m1));
        m1.getMesas().add(new Mesa(5,false,m1));
        
        Mozo m2 = new Mozo("11", "11", "Ana Lopez Mozo");
        m2.getMesas().add(new Mesa(1,false,m2));
        m2.getMesas().add(new Mesa(2,false,m2));
        
        Mozo m3 = new Mozo("3", "3", "Federico Moreira");
        m3.getMesas().add(new Mesa(100,false,m3));
        m3.getMesas().add(new Mesa(101,false,m3));
        
        mozos.add(m1);
        mozos.add(m2);
        mozos.add(m3);
        gestores.add(new Gestor("1", "1", "Fabian Mendez Gestor"));
        gestores.add(new Gestor("2", "2", "Lana Lopez Gestor"));
        gestores.add(new Gestor("3", "3", "Jose Cardozo Gestor"));
        gestores.add(new Gestor("4", "4", "Pepe Guerra Gestor"));
        
        /*String strConn = "jdbc:mysql://localhost:8889/tarea";
        BaseDatos bd = BaseDatos.getInstancia();
        bd.conectar(strConn, "root", "root");
        Persistencia p = new Persistencia();
        MapeadorClientes mpc = new MapeadorClientes();
        clientes = p.obtenerTodos(mpc);
        bd.desconectar();*/
        Persistencia p = Persistencia.getInstancia();
        MapeadorClientes mpc = new MapeadorClientes();
        clientes = p.obtenerTodos(mpc);
        
        /*
        Cliente c1 = new Cliente("Mike Client 1", "1", "Mike Cliente 1", "mike@mail.com");
        TipoClienteComun tcc = new TipoClienteComun(100, 0);
        c1.setTipo(tcc);
        
        Cliente c2 = new Cliente("Sue Client 2", "2", "Sue Client 2", "sue@mail.com");
        TipoClientePreferencial tcp = new TipoClientePreferencial(100, 5);
        c2.setTipo(tcp);

        Cliente c3 = new Cliente("Mary  Client 3", "3", "Mary  Client 3", "mary@mail.com");
        TipoClienteDeLaCasa tcdc = new TipoClienteDeLaCasa(0, 500);
        
        Sistema.getInstancia().verClientesRegistrados().add(c1);
        Sistema.getInstancia().verClientesRegistrados().add(c2);
        Sistema.getInstancia().verClientesRegistrados().add(c3);
        */
        /*
        try {
            tcc.setProductoConDescuento(prod9);
            tcp.setProductoConDescuento(prod10);
        } catch (RestaurantException ex) {
            Logger.getLogger(SistemaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
        
        /*Pedido pp1 = new Pedido(0, prod8);     
        mm1.listarServicio().add(new Pedido("mila",2));
        mm1.listarServicio().add(new Pedido("coca",3));
        mm1.listarServicio().add(new Pedido("pancho",1));
        mm1.listarServicio().add(new Pedido("papas4",2));

        
        mm2.listarServicio().add(new Pedido("mila",2));
        mm2.listarServicio().add(new Pedido("coca",3));
        */
       
    }



    





    

    

    

    

}
