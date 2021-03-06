/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.gui.formulario;

import java.awt.Frame;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.Popup;
import quemquersermillonario.dao.interfaces.FormularioDAO;
import quemquersermillonario.dao.interfaces.PreguntaDAO;
import quemquersermillonario.dao.interfaces.implementation.FormularioDAOImpl;
import quemquersermillonario.dao.interfaces.implementation.PreguntaDAOImpl;
import quemquersermillonario.dao.logica.Lenguaje;
import quemquersermillonario.dao.logica.VentanasLogica;
import quemquersermillonario.dto.Categoria;
import quemquersermillonario.dto.Dificultad;
import quemquersermillonario.dto.Formulario;
import quemquersermillonario.dto.Pregunta;
import quemquersermillonario.dto.complejas.OpcionesFijas;
import quemquersermillonario.gui.comboboxmodel.ComboBoxModelCategoria;
import quemquersermillonario.gui.comboboxmodel.ComboBoxModelDificultad;;
import quemquersermillonario.gui.tablemodels.UsuarioPreguntasTableModel;

/**
 *
 * @author alvaro
 */
public class PantallaFormularioDatos extends javax.swing.JDialog {

    /**
     * Creates new form PantallaFormularioDatos
     */
    private Frame parent;
    private Popup popup;
    private Formulario formulario;
    private FormularioDAO fdao = new FormularioDAOImpl();
    private boolean esModificacion;
    private List<Pregunta> listPreguntasBuscadas;

    public PantallaFormularioDatos(java.awt.Frame parent, boolean modal, boolean esModificacion, Formulario formulario) {
        super(parent, modal);
        initComponents();
        this.esModificacion = esModificacion;
        this.formulario = formulario;
        this.parent = parent;
        this.jComboBoxCategoria.setModel(ComboBoxModelCategoria.getCategoriaWithDefaultComboBoxModel());
        this.jComboBoxDificultad.setModel(ComboBoxModelDificultad.getDificultadWithDefaultComboBoxModel());
        this.jRadioButtonPreguntasUsuario.setText(Lenguaje.getString("MisPreguntas"));
        this.jRadioButtonTodasPreguntas.setText(Lenguaje.getString("TodasPreguntas"));
        this.jLabelCategoria.setText(Lenguaje.getString("Categoria"));
        this.jLabelDificultad.setText(Lenguaje.getString("Dificultad"));
        this.jLabelNombreFormulario.setText(Lenguaje.getString("NombreFormulario"));
        this.jRadioButtonTodasPreguntas.setText(Lenguaje.getString("TodasPreguntas"));
        this.jRadioButtonPreguntasUsuario.setText(Lenguaje.getString("MisPreguntas"));
        VentanasLogica.estilizarVentaja(this);
        if (!esModificacion) {
            this.formulario = new Formulario();
            this.formulario.setUsuario(OpcionesFijas.usuario);
        }
        objetoACampos();
        buscarPreguntas();
    }

    public PantallaFormularioDatos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void objetoACampos() {
        this.jTextFieldNombre.setText(formulario.getNombre());
        this.jTablePreguntasFormulario.setModel(new UsuarioPreguntasTableModel(formulario.getListaPreguntas()));
    }

    private void buscarPreguntas() {
        Categoria cat = (Categoria) jComboBoxCategoria.getSelectedItem();
        Dificultad dif = (Dificultad) jComboBoxDificultad.getSelectedItem();
        PreguntaDAO pdao = new PreguntaDAOImpl();
        listPreguntasBuscadas = pdao.obtenerPreguntasCategoriaDificultadTodas(cat, dif, jRadioButtonTodasPreguntas.isSelected());
        listPreguntasBuscadas.removeAll(formulario.getListaPreguntas());

        jTablePreguntasBuscadas.setModel(new UsuarioPreguntasTableModel(listPreguntasBuscadas));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupBuscador = new javax.swing.ButtonGroup();
        jTextFieldNombre = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePreguntasFormulario = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePreguntasBuscadas = new javax.swing.JTable();
        jButtonAniadirPregunta = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();
        jButtonEliminarPregunta = new javax.swing.JButton();
        jLabelNombreFormulario = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelBuscadorPreguntas = new javax.swing.JLabel();
        jLabelDificultad = new javax.swing.JLabel();
        jComboBoxDificultad = new javax.swing.JComboBox<>();
        jLabelCategoria = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jRadioButtonPreguntasUsuario = new javax.swing.JRadioButton();
        jRadioButtonTodasPreguntas = new javax.swing.JRadioButton();
        jButtonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextFieldNombre.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N

        jTablePreguntasFormulario.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jTablePreguntasFormulario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTablePreguntasFormulario);

        jTablePreguntasBuscadas.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jTablePreguntasBuscadas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTablePreguntasBuscadas);

        jButtonAniadirPregunta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/min/mas_normal_min.png"))); // NOI18N
        jButtonAniadirPregunta.setToolTipText("");
        jButtonAniadirPregunta.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/min/mas_clicado_min.png"))); // NOI18N
        jButtonAniadirPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAniadirPreguntaActionPerformed(evt);
            }
        });

        jButtonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/aceptar_normal.png"))); // NOI18N
        jButtonAceptar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/aceptar_clicado.png"))); // NOI18N
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonEliminarPregunta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/min/menos_normal_min.png"))); // NOI18N
        jButtonEliminarPregunta.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/min/menos_clicado_min.png"))); // NOI18N
        jButtonEliminarPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarPreguntaActionPerformed(evt);
            }
        });

        jLabelNombreFormulario.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabelNombreFormulario.setText("Nombre formulario");

        jPanel1.setLayout(new java.awt.GridLayout(4, 2, 10, 10));
        jPanel1.add(jLabel1);

        jLabelBuscadorPreguntas.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabelBuscadorPreguntas.setText("Buscar Preguntas");
        jPanel1.add(jLabelBuscadorPreguntas);

        jLabelDificultad.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabelDificultad.setText("Dificultad");
        jPanel1.add(jLabelDificultad);

        jComboBoxDificultad.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jComboBoxDificultad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxDificultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPreguntas(evt);
            }
        });
        jPanel1.add(jComboBoxDificultad);

        jLabelCategoria.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabelCategoria.setText("Categoria");
        jPanel1.add(jLabelCategoria);

        jComboBoxCategoria.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPreguntas(evt);
            }
        });
        jPanel1.add(jComboBoxCategoria);

        buttonGroupBuscador.add(jRadioButtonPreguntasUsuario);
        jRadioButtonPreguntasUsuario.setText("jRadioButton1");
        jRadioButtonPreguntasUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPreguntas(evt);
            }
        });
        jPanel1.add(jRadioButtonPreguntasUsuario);

        buttonGroupBuscador.add(jRadioButtonTodasPreguntas);
        jRadioButtonTodasPreguntas.setSelected(true);
        jRadioButtonTodasPreguntas.setText("jRadioButton2");
        jRadioButtonTodasPreguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPreguntas(evt);
            }
        });
        jPanel1.add(jRadioButtonTodasPreguntas);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelNombreFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(jTextFieldNombre)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jButtonEliminarPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jButtonAniadirPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(20, 20, 20)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jButtonAniadirPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButtonEliminarPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNombreFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jButtonAniadirPregunta.getAccessibleContext().setAccessibleName("Aniadir");
        jButtonEliminarPregunta.getAccessibleContext().setAccessibleName("Eliminar");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAniadirPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAniadirPreguntaActionPerformed
        // TODO add your handling code here:
        if (jTablePreguntasBuscadas.getSelectedRow() >= 0) {
            this.formulario.aniadirPegunta(listPreguntasBuscadas.get(jTablePreguntasBuscadas.getSelectedRow()));
        }
        actualizarTablas();
    }//GEN-LAST:event_jButtonAniadirPreguntaActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        // TODO add your handling code here:
        if (formulario.getListaPreguntas().size() > 0) {
            if (jTextFieldNombre.getText() != null && jTextFieldNombre.getText().length() < 40 && jTextFieldNombre.getText().trim().length() > 0) {
                formulario.setNombre(jTextFieldNombre.getText());
                if (!esModificacion) {
                    fdao.guardar(formulario);
                } else {
                    formulario.setFechaModificacion(OpcionesFijas.fechaActual());
                    fdao.actualizar(formulario);
                }
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, Lenguaje.getString("Error.Formulario.Nombre"), Lenguaje.getString("Error"), JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, Lenguaje.getString("Error.ListadoPreguntas.Tamano"), Lenguaje.getString("Error"), JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void buscarPreguntas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPreguntas
        // TODO add your handling code here:
        buscarPreguntas();
    }//GEN-LAST:event_buscarPreguntas

    private void jButtonEliminarPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarPreguntaActionPerformed
        int pos = jTablePreguntasFormulario.getSelectedRow();
        if (pos >= 0) {
            formulario.getListaPreguntas().remove(pos);
            actualizarTablas();
        } else {
            JOptionPane.showMessageDialog(this, Lenguaje.getString("SeleccionarPregunta"), Lenguaje.getString("Error"), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEliminarPreguntaActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        int opcion = JOptionPane.showConfirmDialog(this, Lenguaje.getString("Confirmacion.Salir"), Lenguaje.getString("Salir"), JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            this.setVisible(false);
        }

    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void actualizarTablas() {
        this.jTablePreguntasFormulario.setModel(new UsuarioPreguntasTableModel(formulario.getListaPreguntas()));
        buscarPreguntas();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupBuscador;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonAniadirPregunta;
    private javax.swing.JButton jButtonEliminarPregunta;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JComboBox<String> jComboBoxDificultad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelBuscadorPreguntas;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelDificultad;
    private javax.swing.JLabel jLabelNombreFormulario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonPreguntasUsuario;
    private javax.swing.JRadioButton jRadioButtonTodasPreguntas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTablePreguntasBuscadas;
    private javax.swing.JTable jTablePreguntasFormulario;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
