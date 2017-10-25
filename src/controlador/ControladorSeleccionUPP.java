/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dominio.Gestor;
import dominio.Sistema;
import dominio.UnidadProcesadora;
import java.util.ArrayList;
import vista.VistaSeleccionUPP;

/**
 *
 * @author william
 */
public class ControladorSeleccionUPP {
    private Sistema modelo = Sistema.getInstancia();
    private VistaSeleccionUPP vista;
    private Gestor unG;

    public ControladorSeleccionUPP(VistaSeleccionUPP vista, Gestor g) {
        this.vista = vista;
        unG = g;
    }

    public ArrayList<UnidadProcesadora> listarUPP() {
       return modelo.verUnidadesProcesadoras();
    }

    public void ingresar(UnidadProcesadora u) {
        unG.setLogueadoEn(u);
        vista.ingresarUPP(unG);
    }

    public void cargarLista() {
        vista.cargarLista(listarUPP());
    }
    
    
    
}
