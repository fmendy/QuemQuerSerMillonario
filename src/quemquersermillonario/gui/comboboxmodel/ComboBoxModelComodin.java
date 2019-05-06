/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.gui.comboboxmodel;

import javax.swing.DefaultComboBoxModel;
import quemquersermillonario.dto.Comodin;
import quemquersermillonario.dto.complejas.OpcionesFijas;

/**
 *
 * @author alvaro
 */
public class ComboBoxModelComodin {
    public static DefaultComboBoxModel getCategoriaComboBoxModel() {
        DefaultComboBoxModel cbm = new DefaultComboBoxModel();
        for (Comodin comodin : OpcionesFijas.listaComodines) {
            cbm.addElement(comodin);
        }
        return cbm;
    }

    public static int getIndexOfCategoria(Comodin comodin) {
        DefaultComboBoxModel cbm = getCategoriaComboBoxModel();
        int index = 0;
        for (int i = 0; i < cbm.getSize(); i++) {
            Comodin co = (Comodin) cbm.getElementAt(i);
            if (co.getIdComodin()== comodin.getIdComodin()) {
                index = i;
            }
        }
        return index;
    }
}
