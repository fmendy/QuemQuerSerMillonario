/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dto.complejas;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.rmi.CORBA.UtilDelegate;
import quemquersermillonario.dao.interfaces.UsuarioDAO;
import quemquersermillonario.dao.interfaces.implementation.UsuarioDAOImplHibernate;
import quemquersermillonario.dao.logica.OpcionesFijasDAO;
import quemquersermillonario.dto.Estudios;
import quemquersermillonario.dto.Usuario;

/**
 *
 * @author alvaro
 */
public class OpcionesFijas {

    public static List<Estudios> listaEstudios = new ArrayList<>();

    public static Usuario usuario = new Usuario();
    
    public static UsuarioDAO usuarioDAO = new UsuarioDAOImplHibernate();

    public static UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public static void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        OpcionesFijas.usuarioDAO = usuarioDAO;
    }

    public OpcionesFijas() {
    }

    public static List<Estudios> getListaEstudios() {
        return listaEstudios;
    }

    public static void setListaEstudios(List<Estudios> listaEstudios) {
        OpcionesFijas.listaEstudios = listaEstudios;
    }

    public static Date fechaActualSQL() {
        return new Date(new java.util.Date().getTime());
    }
    
    public static java.util.Date fechaActual(){
        return new java.util.Date();
    }
    

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        OpcionesFijas.usuario = usuario;
    }

}
