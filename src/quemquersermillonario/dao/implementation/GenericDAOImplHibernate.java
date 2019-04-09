/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.implementation;

import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import quemquersermillonario.dao.GenericDAO;
import quemquersermillonario.dao.HibernateUtils;

/**
 *
 * @author alvaro
 */
public class GenericDAOImplHibernate implements GenericDAO{

    SessionFactory sessionFactory;
    private Session session;
    private Transaction tx;
    
    private final static Logger LOGGER = Logger.getLogger(GenericDAOImplHibernate.class.getName());
    
    public GenericDAOImplHibernate() {
         sessionFactory=HibernateUtils.getSESSION_FACTORY();
     }
    
    @Override
    public void guardar(Object object) {
        iniciar();
        try {
            session.save(object);
            LOGGER.log(Level.INFO, this.getClass().getName()+" "+object.getClass().getName()+" guardado");
        } catch (Exception e) {
            
            LOGGER.log(Level.SEVERE, this.getClass().getName()+" error al iniciar session factory");
        }
        finalizar();
    }

    @Override
    public Object leer(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void iniciar() {
        try {
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            
        } catch (Exception e) {
            System.out.println(e);
            LOGGER.log(Level.SEVERE, this.getClass().getName()+" error al iniciar session factory");
        }
    }

    @Override
    public void finalizar() {
         try {
            tx.commit();
            session.close();
        } catch (Exception e) {
             System.out.println(e);
            LOGGER.log(Level.SEVERE, this.getClass().getName()+" error al cerrar session factory");
        }
    }
    
}
