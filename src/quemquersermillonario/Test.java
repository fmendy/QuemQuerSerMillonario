/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario;




import java.util.List;
import quemquersermillonario.dao.interfaces.implementation.EstudiosDAOImplHibernate;
import quemquersermillonario.dto.Estudios;

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
        EstudiosDAOImplHibernate estudiosDAOImplHibernate = new EstudiosDAOImplHibernate();
      //  estudiosDAOImplHibernate.guardar(estudios);
        
        List<Estudios> lista = estudiosDAOImplHibernate.obtenerTodos(estudios);
        
        System.out.println(lista);
    }
}
