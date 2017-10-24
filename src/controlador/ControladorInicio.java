/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dominio.Sistema;
import vista.VistaInicio;

/**
 *
 * @author william
 */
public class ControladorInicio {
    
    private Sistema modelo = Sistema.getInstancia();
	private VistaInicio vista; 
	
	public ControladorInicio(VistaInicio v) {
		this.vista = v;
		modelo.cargarDatosPrueba();
	}
	public void salir() {
		vista.cerrar(modelo.logout());
	}
    
}
