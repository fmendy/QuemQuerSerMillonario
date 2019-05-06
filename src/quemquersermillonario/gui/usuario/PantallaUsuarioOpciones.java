/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.gui.usuario;

import java.awt.Frame;
import quemquersermillonario.dao.interfaces.GenericDAO;
import quemquersermillonario.dao.interfaces.UsuarioDAO;
import quemquersermillonario.dao.interfaces.implementation.UsuarioDAOImpl;
import quemquersermillonario.dao.logica.OpcionesFijasLogica;
import quemquersermillonario.dto.Usuario;
import quemquersermillonario.dto.complejas.OpcionesFijas;
import quemquersermillonario.gui.comodines.PantallaComprarComodines;
import quemquersermillonario.gui.partida.PantallaSeleccionJuego;
import quemquersermillonario.gui.usuario.preguntas.PantallaUsuarioPreguntas;

/**
 *
 * @author alvaro
 */
public class PantallaUsuarioOpciones extends javax.swing.JDialog {

    /**
     * Creates new form PantallaUsuarioOpciones
     */
    private Frame parent;
    
    public PantallaUsuarioOpciones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSalir = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();
        jButtonMisPreguntas = new javax.swing.JButton();
        jButtonJugar = new javax.swing.JButton();
        jButtonTienda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonSalir.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSalir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalir.setText("SALIR");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jButtonActualizar.setBackground(new java.awt.Color(0, 0, 0));
        jButtonActualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonActualizar.setText("MIS DATOS");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jButtonMisPreguntas.setBackground(new java.awt.Color(0, 0, 0));
        jButtonMisPreguntas.setForeground(new java.awt.Color(255, 255, 255));
        jButtonMisPreguntas.setText("MIS PREGUNTAS");
        jButtonMisPreguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMisPreguntasActionPerformed(evt);
            }
        });

        jButtonJugar.setBackground(new java.awt.Color(0, 0, 0));
        jButtonJugar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonJugar.setText("JUGAR");
        jButtonJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJugarActionPerformed(evt);
            }
        });

        jButtonTienda.setBackground(new java.awt.Color(0, 0, 0));
        jButtonTienda.setForeground(new java.awt.Color(255, 255, 255));
        jButtonTienda.setText("TIENDA");
        jButtonTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTiendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonMisPreguntas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonJugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonTienda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(148, 148, 148))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(jButtonJugar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonMisPreguntas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSalir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonTienda)
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        OpcionesFijasLogica.deslogearse();
        this.setVisible(false);
        
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        // TODO add your handling code here:
        PantallaUsuarioDatos pad = new PantallaUsuarioDatos(parent, true,true);
        pad.setVisible(true);
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButtonMisPreguntasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMisPreguntasActionPerformed
        // TODO add your handling code here:
        PantallaUsuarioPreguntas pup = new PantallaUsuarioPreguntas(parent, true);
        pup.setVisible(true);
    }//GEN-LAST:event_jButtonMisPreguntasActionPerformed

    private void jButtonJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonJugarActionPerformed
        // TODO add your handling code here:
        PantallaSeleccionJuego psj = new PantallaSeleccionJuego(parent, true);
        psj.setVisible(true);
    }//GEN-LAST:event_jButtonJugarActionPerformed

    private void jButtonTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTiendaActionPerformed
        // TODO add your handling code here:
        
        PantallaComprarComodines pcc = new PantallaComprarComodines(parent,true);
        pcc.setVisible(true);
    }//GEN-LAST:event_jButtonTiendaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonJugar;
    private javax.swing.JButton jButtonMisPreguntas;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonTienda;
    // End of variables declaration//GEN-END:variables
}
