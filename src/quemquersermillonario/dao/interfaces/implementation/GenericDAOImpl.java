/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.interfaces.implementation;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import quemquersermillonario.dao.interfaces.GenericDAO;
import quemquersermillonario.dao.HibernateUtils;

/**
 *
 * @author alvaro
 */
public class GenericDAOImpl<T> implements GenericDAO<T> {

    SessionFactory sessionFactory;
    Session session;
    Transaction tx;

    private final static Logger LOGGER = Logger.getLogger(GenericDAOImpl.class.getName());

    public GenericDAOImpl() {
        sessionFactory = HibernateUtils.getSESSION_FACTORY();
    }

    @Override
    public void iniciar() {
        try {
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();

        } catch (HibernateException e) {
            System.out.println(e);
            LOGGER.log(Level.SEVERE, "{0} error al iniciar session factory", this.getClass().getSimpleName());
        }
    }

    @Override
    public void finalizar() {
        try {
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e);
            LOGGER.log(Level.SEVERE, "{0} error al cerrar session factory", this.getClass().getSimpleName());
        }
    }

    @Override
    public void guardar(T object) {
        iniciar();
        try {
            session.save(object);
            LOGGER.log(Level.INFO, "{0} {1} guardado", new Object[]{this.getClass().getName(), object.getClass().getSimpleName()});
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "{0} error al guardar", this.getClass().getSimpleName());
        }
        finalizar();
    }

    @Override
    public T leer(T object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(T object) {
        iniciar();
            try{
                session.delete(object);
                LOGGER.log(Level.INFO, "{0} {1} borrado", new Object[]{this.getClass().getName(), object.getClass().getSimpleName()});
            }
            catch(Exception e){
                LOGGER.log(Level.SEVERE, "{0} error al borrar objeto de tipo {1}", new Object[]{this.getClass().getName(), object.getClass().getSimpleName()});
                System.out.println(e);
            }
        finalizar();
    }

    @Override
    public void actualizar(T object) {
        iniciar();
        try {
            session.merge(object);
            LOGGER.log(Level.INFO, "{0} {1} actuliazado", new Object[]{this.getClass().getName(), object.getClass().getSimpleName()});
        } catch (Exception e) {
            System.out.println(e);
            LOGGER.log(Level.SEVERE, "{0} error al actualizar", this.getClass().getName());
        }
        finalizar();
    }

    @Override
    public List<T> obtenerTodos(T object) {
        List<T> listaObjetos = new ArrayList<>();
        iniciar();
        try {
            listaObjetos = session.createQuery("from " + object.getClass().getName()).list();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "{0} error al buscar todos los objetos {1}", new Object[]{this.getClass().getName(), object.getClass().getName()});
        }
        finalizar();
        return listaObjetos;
    }

    @Override
    public T buscarId(T object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
