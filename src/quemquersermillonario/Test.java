/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario;




import java.util.List;
import quemquersermillonario.dao.interfaces.GenericDAO;
import quemquersermillonario.dao.interfaces.UsuarioDAO;
import quemquersermillonario.dao.interfaces.implementation.EstudiosDAOImplHibernate;
import quemquersermillonario.dao.interfaces.implementation.UsuarioDAOImplHibernate;
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
        
      // SessionFactory  SESSION_FACTORY =  (SessionFactory) new AnnotationConfiguration().configure().buildSessionFactory();
        UsuarioDAO genericDAO = new UsuarioDAOImplHibernate();
      
      // genericDAO.guardar(estudios);
        
       // List<Estudios> lista = estudiosDAOImplHibernate.obtenerTodos(estudios);
        
        Usuario usuario = new Usuario();
        usuario.setNombre("prueb");
        usuario.setApellidos("hola");
        usuario.setEstudios(estudios);
        usuario.setEmail("bb");
        usuario.setAnoNacimiento(1900);
        usuario.setIdUsuario(1);
        usuario.setPassword("aaa");
        
        //genericDAO.guardar(usuario);
        usuario = genericDAO.buscarUsuarioEmail(usuario);
        System.out.println(usuario);
    }
}
