/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.interfaces.implementation;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import quemquersermillonario.dao.interfaces.GenericDAO;
import quemquersermillonario.dao.HibernateUtils;

/**
 *
 * @author alvaro
 */
public class GenericDAOImplHibernate<T> implements GenericDAO<T> {

    SessionFactory sessionFactory;
    Session session;
    Transaction tx;

    private final static Logger LOGGER = Logger.getLogger(GenericDAOImplHibernate.class.getName());

    public GenericDAOImplHibernate() {
        sessionFactory = HibernateUtils.getSESSION_FACTORY();
    }

    @Override
    public void iniciar() {
        try {
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();

        } catch (Exception e) {
            System.out.println(e);
            LOGGER.log(Level.SEVERE, this.getClass().getName() + " error al iniciar session factory");
        }
    }

    @Override
    public void finalizar() {
        try {
            tx.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e);
            LOGGER.log(Level.SEVERE, this.getClass().getName() + " error al cerrar session factory");
        }
    }

    @Override
    public void guardar(T object) {
        iniciar();
        try {
            session.save(object);
            LOGGER.log(Level.INFO, this.getClass().getName() + " " + object.getClass().getName() + " guardado");
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, this.getClass().getName() + " error al iniciar session factory");
        }
        finalizar();
    }

    @Override
    public T leer(T object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(T object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(T object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> obtenerTodos(T object) {
        List<T> listaObjetos = new ArrayList<>();
        iniciar();
        try {
            listaObjetos = session.createQuery("from " + object.getClass().getName()).list();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, this.getClass().getName() + " error al buscar todos los objetos " + object.getClass().getName());
        }
        finalizar();
        return listaObjetos;
    }

    @Override
    public T buscarId(T object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
