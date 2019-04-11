/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.interfaces;

import quemquersermillonario.dto.Usuario;

/**
 *
 * @author alvaro
 */
public interface UsuarioDAO extends GenericDAO<Usuario>{
    public Usuario buscarUsuarioEmail(Usuario usuario);
    
    public Boolean iniciarSesion(Usuario usuario);
}
