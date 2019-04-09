/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao;

import java.util.logging.Level;
import java.util.logging.Logger;
import javassist.bytecode.Bytecode;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author alvaro
 */
public class HibernateUtils {
    private static final SessionFactory SESSION_FACTORY;
    private final static Logger LOGGER = Logger.getLogger("HibernateUtils");
    
     static {
        try 
        { 
            SESSION_FACTORY =  (SessionFactory) new AnnotationConfiguration().configure().buildSessionFactory(); 
        } catch (HibernateException he) 
        { 
            LOGGER.log(Level.SEVERE, HibernateUtils.class.getName()+" error  metodo static");
            throw new ExceptionInInitializerError(he); 
        } 
    }

    public static org.hibernate.SessionFactory getSESSION_FACTORY() {
        return SESSION_FACTORY;
    }
}
