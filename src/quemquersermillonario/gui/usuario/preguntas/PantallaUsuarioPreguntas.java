/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.gui.usuario.preguntas;

import java.awt.Frame;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Popup;
import quemquersermillonario.dao.interfaces.PreguntaDAO;
import quemquersermillonario.dao.interfaces.UsuarioDAO;
import quemquersermillonario.dao.interfaces.implementation.PreguntaDAOImpl;
import quemquersermillonario.dao.interfaces.implementation.UsuarioDAOImpl;
import quemquersermillonario.dao.logica.Lenguaje;
import quemquersermillonario.dao.logica.VentanasLogica;
import quemquersermillonario.dto.Pregunta;
import quemquersermillonario.dto.complejas.OpcionesFijas;
import quemquersermillonario.gui.tablemodels.UsuarioPreguntasTableModel;

/**
 *
 * @author alvaro
 */
public class PantallaUsuarioPreguntas extends javax.swing.JDialog {

    /**
     * Creates new form PantallaUsuarioPreguntas
     */
    private Frame parent;
    private UsuarioDAO usuarioDAO;
    private PreguntaDAO preguntaDAO;
    private List<Pregunta> listaPreguntas;
    private Popup popup;

    public PantallaUsuarioPreguntas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        usuarioDAO = new UsuarioDAOImpl();
        preguntaDAO = new PreguntaDAOImpl();
        initComponents();
        this.setTitle(Lenguaje.getString("MisPreguntas"));

        rellenarTabla();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuarioPreguntas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButtonAniadir = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableUsuarioPreguntas.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jTableUsuarioPreguntas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableUsuarioPreguntas);

        jPanel1.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        jButtonAniadir.setBackground(new java.awt.Color(0, 0, 0));
        jButtonAniadir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAniadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/min/aniadir_pregunta_normal_min.png"))); // NOI18N
        jButtonAniadir.setPreferredSize(new java.awt.Dimension(64, 64));
        jButtonAniadir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/min/aniadir_pregunta_clicado_min.png"))); // NOI18N
        jButtonAniadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ratonEntra(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ratonSale(evt);
            }
        });
        jButtonAniadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAniadirActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAniadir);
        jButtonAniadir.getAccessibleContext().setAccessibleName("Aniadir");

        jButtonModificar.setBackground(new java.awt.Color(0, 0, 0));
        jButtonModificar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/min/modificar_pregunta_normal_min.png"))); // NOI18N
        jButtonModificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/min/modificar_pregunta_clicado_min.png"))); // NOI18N
        jButtonModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ratonEntra(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ratonSale(evt);
            }
        });
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonModificar);
        jButtonModificar.getAccessibleContext().setAccessibleName("Modificar");
        jButtonModificar.getAccessibleContext().setAccessibleDescription("");

        jButtonEliminar.setBackground(new java.awt.Color(0, 0, 0));
        jButtonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/min/eliminar_normal_min.png"))); // NOI18N
        jButtonEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/min/eliminar_clicado_min.png"))); // NOI18N
        jButtonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ratonEntra(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ratonSale(evt);
            }
        });
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEliminar);
        jButtonEliminar.getAccessibleContext().setAccessibleName("Eliminar");

        jButtonSalir.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSalir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/min/salir_normal_min.png"))); // NOI18N
        jButtonSalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/min/salir_clicado_min.png"))); // NOI18N
        jButtonSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ratonEntra(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ratonSale(evt);
            }
        });
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSalir);
        jButtonSalir.getAccessibleContext().setAccessibleName("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAniadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAniadirActionPerformed
        // TODO add your handling code here:
        PantallaUsuarioPreguntaDatos pupd = new PantallaUsuarioPreguntaDatos(this.parent, true, false, null);
        popup.hide();
        pupd.setVisible(true);
        rellenarTabla();
    }//GEN-LAST:event_jButtonAniadirActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        popup.hide();
        if (jTableUsuarioPreguntas.getSelectedRow() >= 0) {
            int opc = JOptionPane.showConfirmDialog(this, "Esta seguro de que desea eliminar la pregunta ?", Lenguaje.getString("Confirmacion"), JOptionPane.YES_NO_OPTION);
            if (opc == JOptionPane.OK_OPTION) {
                this.preguntaDAO.desactivarPregunta(listaPreguntas.get(jTableUsuarioPreguntas.getSelectedRow()));
                rellenarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una pregubta", Lenguaje.getString("Error"), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        if (jTableUsuarioPreguntas.getSelectedRow() >= 0) {
            PantallaUsuarioPreguntaDatos pupd = new PantallaUsuarioPreguntaDatos(this.parent, true, true, listaPreguntas.get(jTableUsuarioPreguntas.getSelectedRow()));
            popup.hide();
            pupd.setVisible(true);
            rellenarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una pregubta", "error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void ratonEntra(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ratonEntra
        // TODO add your handling code here:
        JButton jb = (JButton) evt.getSource();
        popup = VentanasLogica.mensajePopup(popup, jb.getAccessibleContext().getAccessibleName(), evt);
        popup.show();
    }//GEN-LAST:event_ratonEntra

    private void ratonSale(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ratonSale
        // TODO add your handling code here:
        popup.hide();
    }//GEN-LAST:event_ratonSale

    private void rellenarTabla() {
        this.listaPreguntas = usuarioDAO.listaPreguntasActivas(OpcionesFijas.usuario);
        UsuarioPreguntasTableModel uptm = new UsuarioPreguntasTableModel(listaPreguntas);
        jTableUsuarioPreguntas.setModel(uptm);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAniadir;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuarioPreguntas;
    // End of variables declaration//GEN-END:variables
}
