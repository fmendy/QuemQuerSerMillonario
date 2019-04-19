/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario;




import java.util.List;
import quemquersermillonario.dao.interfaces.ConexionDAO;
import quemquersermillonario.dao.interfaces.GenericDAO;
import quemquersermillonario.dao.interfaces.UsuarioDAO;
import quemquersermillonario.dao.interfaces.implementation.ConexionDAOImplHibernate;
import quemquersermillonario.dao.interfaces.implementation.EstudiosDAOImplHibernate;
import quemquersermillonario.dao.interfaces.implementation.UsuarioDAOImplHibernate;
import quemquersermillonario.dto.Conexion;
import quemquersermillonario.dto.Estudios;
import quemquersermillonario.dto.Usuario;
import sun.net.www.content.text.Generic;

/**
 *
 * @author alvaro
 */
public class Test {
    public static void main(String[] args){
        Estudios estudios= new Estudios();
        
        estudios.setNombre("FP");
        estudios.setActivo(1);
        estudios.setIdEstudios(21);
        
      // SessionFactory  SESSION_FACTORY =  (SessionFactory) new AnnotationConfiguration().configure().buildSessionFactory();
        UsuarioDAO usuarioDAO = new UsuarioDAOImplHibernate();
        ConexionDAO conexionDAO = new ConexionDAOImplHibernate();
        
   
      // genericDAO.guardar(estudios);
        
       // List<Estudios> lista = estudiosDAOImplHibernate.obtenerTodos(estudios);
      
        Usuario usuario = new Usuario();
        usuario.setNombre("prueb");
        usuario.setApellidos("hola");
        usuario.setEstudios(estudios);
        usuario.setEmail("conexion4");
        usuario.setAnoNacimiento(1900);
        usuario.setIdUsuario(2);
        usuario.setPassword("aaa");

        /*
        Conexion conexion = new Conexion();
        conexion.setDispositivo("pc");
        conexion.setIp("12345");
        conexion.setIdConexion(6);
        Conexion conexion1 = new Conexion();
        conexion1.setDispositivo("movil");
        conexion1.setIp("2456");
      /*  conexion1.setUsuario(usuario);
        usuario.aniadirConexion(conexion1);*/
        
       /* usuario.aniadirConexion(conexion);
        conexion.setUsuario(usuario);*/
        usuario=usuarioDAO.buscarId(usuario);
        
        System.out.println(usuarioDAO.listaPreguntasActivas(usuario).size());
        System.out.println();
       // usuarioDAO.borrar(usuario);
        //System.out.println(usuario.getListaPreguntas().size());
        //usuario = usuarioDAO.buscarId(usuario);
        //System.out.println(usuario);
       // usuarioDAO.borrar(usuario);
       //usuarioDAO.guardar(usuario);
       // conexionDAO.borrar(conexion);
      //  conexionDAO.guardar(conexion);
       // usuario = genericDAO.buscarUsuarioEmail(usuario);
       // System.out.println(usuario.getListaConexiones().size());
    }
}
