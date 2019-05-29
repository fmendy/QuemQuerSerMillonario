/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.logica;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.border.Border;

/**
 *
 * @author alvaro
 */
public class VentanasLogica {

    public static void estilizarVentaja(JDialog jd) {
        jd.setResizable(false);
        jd.setDefaultCloseOperation(0);
        jd.setLocationRelativeTo(null);
    }
    
    public static Popup mensajePopup(Popup popup, String s, MouseEvent evt){
        s = Lenguaje.getString(s);
        JLabel label = new JLabel(s);
        label.setForeground(Color.blue);
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        Border border = BorderFactory.createLineBorder(Color.BLUE, 3);
        label.setBorder(border);
        popup = PopupFactory.getSharedInstance().getPopup(evt.getComponent(), label, evt.getXOnScreen(), evt.getYOnScreen());
        return popup;
    }
    
    public void botonClicado(JButton jb){
        String nombre = jb.getAccessibleContext().getAccessibleName();
        String resource="/resources/imagenes/"+ nombre+"_clicado.png";
        jb.setIcon(new javax.swing.ImageIcon(getClass().getResource(resource)));   
    }
    
    public void botonDesclicado(JButton jb){
        String nombre = jb.getAccessibleContext().getAccessibleName();
        String resource="/resources/imagenes/"+ nombre+"_normal.png";
        jb.setIcon(new javax.swing.ImageIcon(getClass().getResource(resource)));  
    }
}
