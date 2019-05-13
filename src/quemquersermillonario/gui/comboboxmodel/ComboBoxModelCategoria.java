/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.gui.comboboxmodel;

import javax.swing.DefaultComboBoxModel;
import quemquersermillonario.dto.Categoria;
import quemquersermillonario.dto.complejas.OpcionesFijas;

/**
 *
 * @author alvaro
 */
public class ComboBoxModelCategoria {

    public static DefaultComboBoxModel getCategoriaComboBoxModel() {
        DefaultComboBoxModel cbm = new DefaultComboBoxModel();
        for (Categoria categoria : OpcionesFijas.listaCategorias) {
            cbm.addElement(categoria);
        }
        return cbm;
    }

    public static int getIndexOfCategoria(Categoria categoria) {
        DefaultComboBoxModel cbm = getCategoriaComboBoxModel();
        int index = 0;
        for (int i = 0; i < cbm.getSize(); i++) {
            Categoria ca = (Categoria) cbm.getElementAt(i);
            if (ca.getIdCategoria() == categoria.getIdCategoria()) {
                index = i;
            }
        }
        return index;
    }
    
    public static DefaultComboBoxModel getCategoriaWithDefaultComboBoxModel() {
        DefaultComboBoxModel cbm = new DefaultComboBoxModel();
        Categoria cat = new Categoria();
        cat.setIdCategoria(0);
        cat.setNombre("TODAS");
        cbm.addElement(cat);
        for (Categoria categoria : OpcionesFijas.listaCategorias) {
            cbm.addElement(categoria);
        }
        return cbm;
    } 
}
