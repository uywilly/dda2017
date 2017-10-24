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

    public ControladorSeleccionUPP(VistaSeleccionUPP vista) {
        this.vista = vista;
    }

    public ArrayList<UnidadProcesadora> listarUPP() {
       return modelo.verUnidadesProcesadoras();
    }

    public void ingresar(Gestor g, UnidadProcesadora u) {
        g.setLogueadoEn(u);
        vista.ingresarUPP(g);
    }
    
    
    
}
