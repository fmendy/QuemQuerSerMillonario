/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.gui;

import ch.randelshofer.quaqua.QuaquaManager;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import org.apache.commons.codec.digest.DigestUtils;
import quemquersermillonario.dao.interfaces.UsuarioDAO;
import quemquersermillonario.dao.logica.ComprobacionText;
import quemquersermillonario.dao.logica.Lenguaje;
import quemquersermillonario.dao.logica.OpcionesFijasLogica;
import quemquersermillonario.dto.complejas.OpcionesFijas;
import quemquersermillonario.gui.usuario.PantallaUsuarioOpciones;
import quemquersermillonario.gui.usuario.PantallaUsuarioDatos;

/**
 *
 * @author alvaro
 * @since 2019-04-10
 */
public class PantallaInicio extends javax.swing.JFrame {

    /**
     * Creates new form PantallaIncio
     * En el momento de la creacion se cargan las opciones las cuales seran fijas
     */
    
    private UsuarioDAO usuarioDAO;
    
    public PantallaInicio() {
        try{
            UIManager.setLookAndFeel(QuaquaManager.getLookAndFeel());
        }
        catch (Exception e){
            System.out.println(e);
        }
        initComponents();
        new OpcionesFijasLogica();
        Locale.setDefault(new Locale("es", "ES"));
        this.setTitle(Lenguaje.getString("Bienvenido"));
        this.jButtonIniciar.setText(Lenguaje.getString("IniciarSesion"));
        this.jButtonIrRegistro.setText(Lenguaje.getString("Registrarse"));
        this.jLabelEmail.setText(Lenguaje.getString("Email"));
        this.jLabelPassword.setText(Lenguaje.getString("Password"));
        this.jButtonSalir.setText(Lenguaje.getString("Salir"));
        setLocationRelativeTo(null);
        this.setResizable(false);
        //setDefaultCloseOperation(0);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonIrRegistro = new javax.swing.JButton();
        jLabelEmail = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextFieldEmail = new javax.swing.JTextField();
        jButtonIniciar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonIrRegistro.setBackground(new java.awt.Color(0, 0, 0));
        jButtonIrRegistro.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButtonIrRegistro.setForeground(new java.awt.Color(0, 51, 204));
        jButtonIrRegistro.setText("REGISTRARSE");
        jButtonIrRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIrRegistroActionPerformed(evt);
            }
        });

        jLabelEmail.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabelEmail.setText("Email:");

        jLabelPassword.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabelPassword.setText("Password:");

        jPasswordField1.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jPasswordField1.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jPasswordField1.setSelectionColor(new java.awt.Color(255, 255, 0));
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tamanoMaximo(evt);
            }
        });

        jTextFieldEmail.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jTextFieldEmail.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldEmail.setSelectionColor(new java.awt.Color(255, 255, 0));
        jTextFieldEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tamanoMaximo(evt);
            }
        });

        jButtonIniciar.setBackground(new java.awt.Color(0, 0, 0));
        jButtonIniciar.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButtonIniciar.setForeground(new java.awt.Color(0, 51, 204));
        jButtonIniciar.setText("INICIAR");
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });

        jButtonSalir.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSalir.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(0, 51, 204));
        jButtonSalir.setText("SALIR");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonIrRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonIniciar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPasswordField1)
                        .addComponent(jTextFieldEmail)
                        .addComponent(jLabelPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPasswordField1)
                .addGap(18, 18, 18)
                .addComponent(jButtonIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonIrRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIrRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIrRegistroActionPerformed
        // TODO add your handling code here:
        PantallaUsuarioDatos pur= new PantallaUsuarioDatos(this, true, false);
        
        pur.setVisible(true);
    }//GEN-LAST:event_jButtonIrRegistroActionPerformed

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarActionPerformed
        // TODO add your handling code here:
        OpcionesFijas.usuario.setEmail(jTextFieldEmail.getText());
        
        OpcionesFijas.usuario.setPassword(DigestUtils.md5Hex(jPasswordField1.getText()));
        
        if (OpcionesFijas.usuarioDAO.iniciarSesion(OpcionesFijas.usuario)){
            PantallaUsuarioOpciones puo = new PantallaUsuarioOpciones(this, true);
            jTextFieldEmail.setText("");
            jPasswordField1.setText("");
            puo.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this, Lenguaje.getString("DatosIntroducidosIncorrectos"), Lenguaje.getString("Error"), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonIniciarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void tamanoMaximo(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tamanoMaximo
        // TODO add your handling code here:
        if (evt.getComponent() instanceof JPasswordField) {
            JPasswordField jtf = (JPasswordField) evt.getComponent();
            if (!ComprobacionText.comprobacionTamanoJPassword(jtf, 40)) {
                JOptionPane.showMessageDialog(this, Lenguaje.getString("Error.Texto.Longitud"), Lenguaje.getString("Error"), JOptionPane.ERROR_MESSAGE);
            }
        } else if (evt.getComponent() instanceof JTextField) {
            JTextField jtf = (JTextField) evt.getComponent();
            if (!ComprobacionText.comprobacionTamanoJTextField(jtf, 40)) {
                JOptionPane.showMessageDialog(this, Lenguaje.getString("Error.Texto.Longitud"), Lenguaje.getString("Error"), JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_tamanoMaximo

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JButton jButtonIrRegistro;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextFieldEmail;
    // End of variables declaration//GEN-END:variables
}
