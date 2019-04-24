/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.logica;

import quemquersermillonario.dao.interfaces.implementation.CategoriaDAOImpl;
import quemquersermillonario.dao.interfaces.implementation.DificultadDAOImpl;
import quemquersermillonario.dao.interfaces.implementation.EstudiosDAOImpl;
import quemquersermillonario.dto.Categoria;
import quemquersermillonario.dto.Dificultad;
import quemquersermillonario.dto.Estudios;
import quemquersermillonario.dto.Usuario;
import quemquersermillonario.dto.complejas.OpcionesFijas;

/**
 *
 * @author alvaro
 */
public class OpcionesFijasLogica {

    public OpcionesFijasLogica() {
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
        EstudiosDAOImpl estudiosDAOImplHibernate = new EstudiosDAOImpl();
        OpcionesFijas.listaEstudios = estudiosDAOImplHibernate.obtenerTodos(new Estudios());
    }

    /**
     * @since 2019-04-14 
     * Se encarga de cargar todos los diferentes niveles de dificultad que
     * hay en la base de datos en las variables estaticas
     */
    private void cargarDificultad() {
        DificultadDAOImpl dificultadDAOImplHibernate = new DificultadDAOImpl();
        OpcionesFijas.listaDificultad = dificultadDAOImplHibernate.obtenerTodos(new Dificultad());
    }

    /**
     * @since 2019-04-14 
     * Se encarga de cargar todos las diferentes categorias que
     * hay en la base de datos en las variables estaticas
     */
    private void cargarCategoria() {
        CategoriaDAOImpl categoriaDAOImplHibernate = new CategoriaDAOImpl();
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
