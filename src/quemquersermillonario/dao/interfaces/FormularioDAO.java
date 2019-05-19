/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.interfaces;

import java.util.List;
import quemquersermillonario.dto.Formulario;

/**
 *
 * @author alvaro
 */
public interface FormularioDAO extends GenericDAO<Formulario>{
    public List<Formulario> getListaFormulariosActivos();
}
