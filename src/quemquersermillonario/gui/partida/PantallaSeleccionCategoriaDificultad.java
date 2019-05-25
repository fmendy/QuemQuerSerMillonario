/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.gui.partida;

import java.awt.Frame;
import quemquersermillonario.dao.interfaces.ModoJuegoDAO;
import quemquersermillonario.dao.interfaces.implementation.ModoJuegoDAOImpl;
import quemquersermillonario.dao.logica.Lenguaje;
import quemquersermillonario.dao.logica.PartidaJugando;
import quemquersermillonario.dao.logica.VentanasLogica;
import quemquersermillonario.dto.Categoria;
import quemquersermillonario.dto.Dificultad;
import quemquersermillonario.dto.ModoJuego;
import quemquersermillonario.gui.comboboxmodel.ComboBoxModelCategoria;
import quemquersermillonario.gui.comboboxmodel.ComboBoxModelDificultad;


/**
 *
 * @author alvaro
 */
public class PantallaSeleccionCategoriaDificultad extends javax.swing.JDialog {

    /**
     * Creates new form PantallaSeleccionCategoriaDificultad
     */
    private Frame parent;

    public PantallaSeleccionCategoriaDificultad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.jComboBoxCategoria.setModel(ComboBoxModelCategoria.getCategoriaWithDefaultComboBoxModel());
        this.jComboBoxDificultad.setModel(ComboBoxModelDificultad.getDificultadWithDefaultComboBoxModel());
        this.parent = parent;
        this.setTitle(Lenguaje.getString("Seleccion"));
        this.jLabelCategoria.setText(Lenguaje.getString("Categoria"));
        this.jLabelDificultad.setText(Lenguaje.getString("Dificultad"));
        VentanasLogica.estilizarVentaja(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jComboBoxDificultad = new javax.swing.JComboBox<>();
        jButtonJugar = new javax.swing.JButton();
        jLabelCategoria = new javax.swing.JLabel();
        jLabelDificultad = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jComboBoxCategoria.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxDificultad.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jComboBoxDificultad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonJugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/jugar_normal_1.png"))); // NOI18N
        jButtonJugar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/jugar_clicadol_1.png"))); // NOI18N
        jButtonJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJugarActionPerformed(evt);
            }
        });

        jLabelCategoria.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabelCategoria.setText("jLabel1");

        jLabelDificultad.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabelDificultad.setText("jLabel1");

        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/salir_normal.png"))); // NOI18N
        jButtonSalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/salir_clicado.png"))); // NOI18N
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCategoria)
                    .addComponent(jLabelDificultad)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxDificultad, 0, 167, Short.MAX_VALUE)
                    .addComponent(jComboBoxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonJugar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCategoria))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jComboBoxDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabelDificultad)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jButtonJugar.getAccessibleContext().setAccessibleName("Jugar");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonJugarActionPerformed
        // TODO add your handling code here:
        PartidaJugando.categoria = (Categoria) jComboBoxCategoria.getSelectedItem();
        PartidaJugando.dificultad = (Dificultad) jComboBoxDificultad.getSelectedItem();
        ModoJuegoDAO mjdao = new ModoJuegoDAOImpl();
        ModoJuego mj = mjdao.buscarModoJuego("SUPERVIVENCIA");
        PantallaResponderPregunta prp = new PantallaResponderPregunta(parent, true, mj);
        prp.setVisible(true);
    }//GEN-LAST:event_jButtonJugarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButtonSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonJugar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JComboBox<String> jComboBoxDificultad;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelDificultad;
    // End of variables declaration//GEN-END:variables
}
