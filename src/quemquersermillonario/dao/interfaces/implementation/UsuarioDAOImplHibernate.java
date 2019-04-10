/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.interfaces.implementation;

import quemquersermillonario.dao.interfaces.UsuarioDAO;
import quemquersermillonario.dto.Usuario;

/**
 *
 * @author alvaro
 */
public class UsuarioDAOImplHibernate extends GenericDAOImplHibernate<Usuario> implements UsuarioDAO{

    @Override
    public Usuario buscarUsuarioEmail(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
