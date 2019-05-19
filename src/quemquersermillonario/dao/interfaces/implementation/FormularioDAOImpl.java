/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.interfaces.implementation;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import quemquersermillonario.dao.interfaces.FormularioDAO;
import quemquersermillonario.dao.logica.OpcionesFijasLogica;
import quemquersermillonario.dto.Formulario;
import quemquersermillonario.dto.complejas.OpcionesFijas;

/**
 *
 * @author alvaro
 */
public class FormularioDAOImpl extends GenericDAOImpl<Formulario> implements FormularioDAO {

    @Override
    public List<Formulario> getListaFormulariosActivos() {
        List<Formulario> listFormularios = new ArrayList<>();
        try {
            iniciar();
            Query query = session.createQuery("from Formulario f where f.usuario=:user and f.activo=1");
            query.setParameter("user", OpcionesFijas.usuario);
            listFormularios = query.list();
            finalizar();
        } catch (Exception e) {
        }
        return listFormularios;
    }

}
