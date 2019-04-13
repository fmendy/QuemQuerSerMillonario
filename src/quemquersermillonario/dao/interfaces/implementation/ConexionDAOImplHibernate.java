/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.interfaces.implementation;

import quemquersermillonario.dao.interfaces.ConexionDAO;
import quemquersermillonario.dto.Conexion;

/**
 *
 * @author alvaro
 */
public class ConexionDAOImplHibernate extends GenericDAOImplHibernate<Conexion> implements ConexionDAO{

    @Override
    public Conexion buscarId(Conexion object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
