/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.gui.comboboxmodel;

import javax.swing.DefaultComboBoxModel;

import quemquersermillonario.dto.Estudios;
import quemquersermillonario.dto.complejas.OpcionesFijas;

/**
 *
 * @author alvaro
 */
public class ComboBoxModelEstudios {

    public static DefaultComboBoxModel getEstudiosComboBoxModel() {
        DefaultComboBoxModel cbm = new DefaultComboBoxModel();
        for (Estudios estudios : OpcionesFijas.listaEstudios) {
            cbm.addElement(estudios);
        }
        return cbm;
    }

    public static int getIndexOfEstudios(Estudios estudios) {
        DefaultComboBoxModel cbm = getEstudiosComboBoxModel();
        int index = 0;
        for (int i = 0; i < cbm.getSize(); i++) {
            Estudios es = (Estudios) cbm.getElementAt(i);
            if (es.getIdEstudios() == estudios.getIdEstudios()) {
                index = i;
            }
        }
        return index;
    }
}
