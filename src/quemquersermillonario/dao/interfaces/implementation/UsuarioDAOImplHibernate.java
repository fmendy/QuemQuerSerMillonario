/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.interfaces.implementation;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import quemquersermillonario.dao.interfaces.ConexionDAO;
import quemquersermillonario.dao.interfaces.UsuarioDAO;
import quemquersermillonario.dto.Conexion;
import quemquersermillonario.dto.Pregunta;
import quemquersermillonario.dto.Usuario;
import quemquersermillonario.dto.complejas.OpcionesFijas;

/**
 *
 * @author alvaro
 */
public class UsuarioDAOImplHibernate extends GenericDAOImplHibernate<Usuario> implements UsuarioDAO {

    private final static Logger LOGGER = Logger.getLogger(UsuarioDAOImplHibernate.class.getName());

    @Override
    public Usuario buscarUsuarioEmail(Usuario usuario) {

        iniciar();
        Query query = session.createQuery("from Usuario u where  u.email =:usuarioEmail");
        query.setParameter("usuarioEmail", usuario.getEmail());
        usuario = (Usuario) query.uniqueResult();
        finalizar();

//        LOGGER.log(Level.INFO, "{0} {1}: metodo: buscarUsuarioEmail  Email: {2}", new Object[]{OpcionesFijas.fechaActual().toString(), this.getClass().getSimpleName(), usuario.getEmail()});
        return usuario;
    }

    /**
     *
     * @param usuario
     * @return devuelve el usuario en caso de contraseña y email coincidan el
     * usuario se pasa a la variable estatica la cual sera accesible desde todos
     * los sitios
     */
    @Override
    public Boolean iniciarSesion(Usuario usuario) {
        iniciar();
        Usuario buscado;

        Query query = session.createQuery("from Usuario u where u.email =:usuarioEmail and u.password =:usuarioPassword");
        query.setParameter("usuarioEmail", usuario.getEmail());
        query.setParameter("usuarioPassword", usuario.getPassword());
        buscado = (Usuario) query.uniqueResult();

        LOGGER.log(Level.INFO, "{0} {1}: metodo: iniciarSesion  Email: {2}", new Object[]{OpcionesFijas.fechaActual().toString(), this.getClass().getSimpleName(), usuario.getEmail()});

        if (buscado != null) {
            OpcionesFijas.usuario = buscado;
            ConexionDAO conexionDAO = new ConexionDAOImplHibernate();
            Conexion conexion = conexionDAO.optenerDatosConexion(OpcionesFijas.usuario);
            usuario.aniadirConexion(conexion);
            conexionDAO.guardar(conexion);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Usuario buscarId(Usuario object) {
        Usuario user;
        iniciar();
        user = (Usuario) session.get(Usuario.class, object.getIdUsuario());
        finalizar();
        return user;

    }

    @Override
    public List<Pregunta> listaPreguntasActivas(Usuario usuario) {
        List<Pregunta> listaPreguntas;
        iniciar();
        Query query = session.createQuery("from Pregunta p where p.activo = 1 and p.usuario=:usuario");
        query.setInteger("usuario", usuario.getIdUsuario());
        listaPreguntas = query.list();
        return listaPreguntas;
    }

}
