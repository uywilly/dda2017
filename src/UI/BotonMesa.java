/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import dominio.IMesa;
import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author william
 */
public class BotonMesa extends JButton{
    
    private IMesa mesa;
    
    public BotonMesa(IMesa m) {
        //ficha.getValorI() + ":" + ficha.getValorD()
        super();
        this.mesa = m;
        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        String texto = "/img/table.jpg";
        if(m.estaAbierta()){
            texto = "/img/abierta.jpg";
        }else{
            texto = "/img/cerrada.jpg";
        }

        setIcon(new javax.swing.ImageIcon(getClass().getResource(texto)));
        setMinimumSize(new Dimension(89,91));
        texto = "";

    }

    public IMesa getMesa() {
        return mesa;
    }
    
    
    
}
