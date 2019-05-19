/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.gui.tablemodels;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import quemquersermillonario.dto.Formulario;

/**
 *
 * @author alvaro
 */
public class UsuarioFormulariosTableModel extends AbstractTableModel{
    
    public List<Formulario> listaFormularios = new ArrayList();

    public UsuarioFormulariosTableModel(List<Formulario> listaFormularios) {
        this.listaFormularios = listaFormularios;
    }
    
    @Override
    public int getRowCount() {
        return this.listaFormularios.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listaFormularios.get(rowIndex).getNombre();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        String[] nombres = new String[1];
        nombres[0] = "Nombre";
        return nombres[column];

    }
    
    
}
