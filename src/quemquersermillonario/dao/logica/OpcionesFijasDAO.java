/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.logica;

import quemquersermillonario.dao.interfaces.implementation.EstudiosDAOImplHibernate;
import quemquersermillonario.dto.Estudios;
import quemquersermillonario.dto.complejas.OpcionesFijas;

/**
 *
 * @author alvaro
 */
public class OpcionesFijasDAO {

    public OpcionesFijasDAO() {
        cargarEstudios();
    }
    /**
     * @since 2019-04-10
     * Se encarga de cargar todos los diferentes estudios que hay
     * en la base de datos en las variables estaticas
     */
    public void cargarEstudios(){
        EstudiosDAOImplHibernate estudiosDAOImplHibernate = new EstudiosDAOImplHibernate();
        OpcionesFijas.listaEstudios= estudiosDAOImplHibernate.obtenerTodos(new Estudios());
    }
}
