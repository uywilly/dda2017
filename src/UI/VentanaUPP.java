/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import controlador.ControladorSeleccionUPP;
import dominio.Gestor;
import dominio.UnidadProcesadora;
import javax.swing.JOptionPane;
import vista.VistaSeleccionUPP;

/**
 *
 * @author william
 */
public class VentanaUPP extends javax.swing.JFrame implements VistaSeleccionUPP{

    /**
     * Creates new form VentanaUPP
     */
    private Gestor g;
    private ControladorSeleccionUPP controlador;
    
    public VentanaUPP() {
        initComponents();
        controlador = new ControladorSeleccionUPP(this);
        
    }
    public VentanaUPP(Gestor g) {
        initComponents();
        controlador = new ControladorSeleccionUPP(this);
        this.g = g;
        lstUPP.setListData(controlador.listarUPP().toArray());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstUPP = new javax.swing.JList();
        btnSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jScrollPane1.setViewportView(lstUPP);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 60, 340, 130);

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeleccionar);
        btnSeleccionar.setBounds(233, 240, 130, 23);

        setBounds(0, 0, 416, 339);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        UnidadProcesadora u = (UnidadProcesadora)lstUPP.getSelectedValue();
        if(u!= null){
            controlador.ingresar(g,u); 
        }else{
            JOptionPane.showMessageDialog(this, "Debe seleccionar una UPP");
        }
        
    }//GEN-LAST:event_btnSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstUPP;
    // End of variables declaration//GEN-END:variables

    @Override
    public void ingresarUPP(Gestor g) {
        new VentanaPrincipalGestor(g).setVisible(true);
        dispose();    
    }
}
