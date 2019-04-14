/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.logica;

import quemquersermillonario.dao.interfaces.implementation.CategoriaDAOImplHibernate;
import quemquersermillonario.dao.interfaces.implementation.DificultadDAOImplHibernate;
import quemquersermillonario.dao.interfaces.implementation.EstudiosDAOImplHibernate;
import quemquersermillonario.dto.Categoria;
import quemquersermillonario.dto.Dificultad;
import quemquersermillonario.dto.Estudios;
import quemquersermillonario.dto.Usuario;
import quemquersermillonario.dto.complejas.OpcionesFijas;

/**
 *
 * @author alvaro
 */
public class OpcionesFijasDAO {

    public OpcionesFijasDAO() {
        cargarEstudios();
        cargarDificultad();
        cargarCategoria();
    }

    /**
     * @since 2019-04-10 
     * Se encarga de cargar todos los diferentes estudios que
     * hay en la base de datos en las variables estaticas
     */
    private void cargarEstudios() {
        EstudiosDAOImplHibernate estudiosDAOImplHibernate = new EstudiosDAOImplHibernate();
        OpcionesFijas.listaEstudios = estudiosDAOImplHibernate.obtenerTodos(new Estudios());
    }

    /**
     * @since 2019-04-14 
     * Se encarga de cargar todos los diferentes niveles de dificultad que
     * hay en la base de datos en las variables estaticas
     */
    private void cargarDificultad() {
        DificultadDAOImplHibernate dificultadDAOImplHibernate = new DificultadDAOImplHibernate();
        OpcionesFijas.listaDificultad = dificultadDAOImplHibernate.obtenerTodos(new Dificultad());
    }

    /**
     * @since 2019-04-14 
     * Se encarga de cargar todos las diferentes categorias que
     * hay en la base de datos en las variables estaticas
     */
    private void cargarCategoria() {
        CategoriaDAOImplHibernate categoriaDAOImplHibernate = new CategoriaDAOImplHibernate();
        OpcionesFijas.listaCategorias = categoriaDAOImplHibernate.obtenerTodos(new Categoria());
    }

    /**
     * @since 2019-04-12 
     * Se encarga de deslogear al usuario
     */
    public static void deslogearse() {
        OpcionesFijas.usuario = new Usuario();
    }
}
