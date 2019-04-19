/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.gui.tablemodels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import quemquersermillonario.dto.Pregunta;

/**
 *
 * @author alvaro
 */
public class UsuarioPreguntasTableModel extends AbstractTableModel {

    public List<Pregunta> listaPreguntas;

    public UsuarioPreguntasTableModel(List<Pregunta> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }

    @Override
    public int getRowCount() {
        return this.listaPreguntas.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listaPreguntas.get(rowIndex).getNombre();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        String[] nombres = new String[1];
        nombres[0] = "Pregunta";
        return nombres[column];

    }

}
