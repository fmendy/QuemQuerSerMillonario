/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.gui.comboboxmodel;

import javax.swing.DefaultComboBoxModel;
import quemquersermillonario.dto.Dificultad;
import quemquersermillonario.dto.Estudios;
import quemquersermillonario.dto.complejas.OpcionesFijas;
import static quemquersermillonario.gui.comboboxmodel.ComboBoxModelEstudios.getEstudiosComboBoxModel;

/**
 *
 * @author alvaro
 */
public class ComboBoxModelDificultad {
    public static DefaultComboBoxModel getDificultadComboBoxModel() {
        DefaultComboBoxModel cbm = new DefaultComboBoxModel();
        for (Dificultad dificultad : OpcionesFijas.listaDificultad) {
            cbm.addElement(dificultad);
        }
        return cbm;
    }
    
    public static int getIndexOfEstudios(Dificultad dificultad) {
        DefaultComboBoxModel cbm = getDificultadComboBoxModel();
        int index = 0;
        for (int i = 0; i < cbm.getSize(); i++) {
            Dificultad dif = (Dificultad) cbm.getElementAt(i);
            if (dif.getIdDificultad() == dificultad.getIdDificultad()) {
                index = i;
            }
        }
        return index;
    }
}
