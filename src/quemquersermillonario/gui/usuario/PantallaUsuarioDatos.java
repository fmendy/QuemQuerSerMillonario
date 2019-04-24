/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.gui.usuario;

import com.sun.java.swing.plaf.windows.WindowsBorders;
import java.sql.Date;
import javax.swing.JOptionPane;
import quemquersermillonario.dao.interfaces.GenericDAO;
import quemquersermillonario.dao.interfaces.UsuarioDAO;
import quemquersermillonario.dao.interfaces.implementation.UsuarioDAOImpl;
import quemquersermillonario.dao.logica.ComprobacionText;
import quemquersermillonario.dao.logica.OpcionesFijasLogica;
import quemquersermillonario.dto.Estudios;
import quemquersermillonario.dto.Usuario;
import quemquersermillonario.dto.complejas.OpcionesFijas;
import quemquersermillonario.gui.comboboxmodel.ComboBoxModelEstudios;

/**
 *
 * @author alvaro
 */
public class PantallaUsuarioDatos extends javax.swing.JDialog {

    /**
     * Creates new form PantallaUsuarioDatos
     */
    private Usuario usuario;
    private Boolean esModificacion = false;
    private UsuarioDAO usuarioDAO;

    public PantallaUsuarioDatos(java.awt.Frame parent, boolean modal, boolean actualizar) {
        super(parent, modal);
        initComponents();
        usuarioDAO = new UsuarioDAOImpl();
        this.esModificacion = actualizar;
        this.jComboBoxEstudios.setModel(ComboBoxModelEstudios.getEstudiosComboBoxModel());

        if (!esModificacion) {
            this.setTitle("Registro Usuario");
            usuario = new Usuario();
        } else {
            this.setTitle("Actualizar Usuario");
            usuario = OpcionesFijas.usuario;
            this.jTextFieldEmail.setEnabled(false);
            pasarObjetoACampos();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelApellidos = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelAnio = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jLabelEstudios = new javax.swing.JLabel();
        jButtonAceptar = new javax.swing.JButton();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellidos = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jComboBoxEstudios = new javax.swing.JComboBox<>();
        jTextFieldAno = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelApellidos.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabelApellidos.setText("Apellidos:");

        jLabelEmail.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabelEmail.setText("Email:");

        jLabelNombre.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabelNombre.setText("Nombre:");

        jLabelAnio.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabelAnio.setText("Año Nacimiento:");

        jLabelPassword.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabelPassword.setText("Password:");

        jLabelEstudios.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabelEstudios.setText("Estudios:");

        jButtonAceptar.setBackground(new java.awt.Color(0, 0, 0));
        jButtonAceptar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jTextFieldNombre.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        jTextFieldNombre.setSelectionColor(new java.awt.Color(255, 255, 0));

        jTextFieldApellidos.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        jTextFieldApellidos.setSelectionColor(new java.awt.Color(255, 255, 0));

        jTextFieldEmail.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        jTextFieldEmail.setSelectionColor(new java.awt.Color(255, 255, 0));

        jPasswordField1.setSelectionColor(new java.awt.Color(255, 255, 0));

        jPasswordField2.setSelectionColor(new java.awt.Color(255, 255, 0));

        jComboBoxEstudios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxEstudios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstudiosActionPerformed(evt);
            }
        });

        jTextFieldAno.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        jTextFieldAno.setSelectionColor(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelAnio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelEstudios, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldAno, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordField2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addGap(85, 85, 85))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxEstudios, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jTextFieldNombre))
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPasswordField1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEstudios, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEstudios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxEstudiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstudiosActionPerformed
        // TODO add your handling code here:
        //Cuando se cambia los estudios, se cambia en el usuario
    }//GEN-LAST:event_jComboBoxEstudiosActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        // TODO add your handling code here:

        //Registro de Nuevo usuario
        if (!esModificacion) {

            if (ComprobacionText.jTextFieldObligatorio(jTextFieldNombre) && ComprobacionText.jTextFieldObligatorio(jTextFieldApellidos)
                    && ComprobacionText.jTextFieldObligatorio(jTextFieldEmail) && ComprobacionText.jAno(jTextFieldAno)
                    && ComprobacionText.jTextFieldEmail(jTextFieldEmail) && ComprobacionText.jPassword(jPasswordField1, jPasswordField2)) {
                pasarCamposAObjeto();
                usuario.setFechaCreacion(OpcionesFijas.fechaActual());
                if (usuarioDAO.buscarUsuarioEmail(usuario) == null) {
                    try {
                        usuarioDAO.guardar(usuario);
                        JOptionPane.showMessageDialog(this, "Enhorabuena ya se ha registrado", "Registrado", JOptionPane.INFORMATION_MESSAGE);
                        this.setVisible(false);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this,
                                "Se ha producido un error al registrarse, "
                                + "por favor contacte con el servicio técnico"
                                + "indicando el siguente mensaje\n"
                                + "Clase: " + this.getClass().getName() + "\n"
                                + "Error: " + e.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El Email que ha introducido ya esta en uso, por favor intro"
                            + "duzca otro, gracias.", "Error al registrarse", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Los datos introducidos no son validos, por favor reviselos", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } //Actualizacion
        else {
            if (ComprobacionText.jTextFieldObligatorio(jTextFieldNombre) && ComprobacionText.jTextFieldObligatorio(jTextFieldApellidos)
                    && ComprobacionText.jTextFieldObligatorio(jTextFieldEmail) && ComprobacionText.jAno(jTextFieldAno)
                    && (((jPasswordField1.getText().length() > 0 && jPasswordField2.getText().length() > 0) && ComprobacionText.jPassword(jPasswordField1, jPasswordField2))
                    || (jPasswordField1.getText().length() == 0 && jPasswordField2.getText().length() == 0))) {
                try {
                    System.out.println("ID " + usuario.getIdUsuario());
                    pasarCamposAObjeto();
                    usuarioDAO.actualizar(usuario);
                    JOptionPane.showMessageDialog(this, "Los datos se han actualizado correctamente", "Actualizado", JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this,
                            "Se ha producido un error al actualizar, "
                            + "por favor contacte con el servicio técnico"
                            + "indicando el siguente mensaje\n"
                            + "Clase: " + this.getClass().getName() + "\n"
                            + "Error: " + e.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Los datos introducidos no son validos, por favor reviselos", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }


    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void pasarCamposAObjeto() {
        usuario.setNombre(jTextFieldNombre.getText());
        usuario.setApellidos(jTextFieldApellidos.getText());
        usuario.setEmail(jTextFieldEmail.getText());
        usuario.setAnoNacimiento(Integer.parseInt(jTextFieldAno.getText()));
        usuario.setActivo(1);
        if (!esModificacion || (esModificacion && jPasswordField1.getText().length() > 0)) {
            usuario.setPassword(jPasswordField1.getText());
        }
        usuario.setFechaModificacion(OpcionesFijas.fechaActual());
        usuario.setEstudios((Estudios) jComboBoxEstudios.getSelectedItem());

    }

    private void pasarObjetoACampos() {
        this.jTextFieldNombre.setText(usuario.getNombre());
        this.jTextFieldApellidos.setText(usuario.getApellidos());
        this.jTextFieldEmail.setText(usuario.getEmail());
        this.jTextFieldAno.setText(Integer.toString(usuario.getAnoNacimiento()));
        this.jComboBoxEstudios.setSelectedIndex(ComboBoxModelEstudios.getIndexOfEstudios(usuario.getEstudios()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JComboBox<String> jComboBoxEstudios;
    private javax.swing.JLabel jLabelAnio;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEstudios;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextFieldAno;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
