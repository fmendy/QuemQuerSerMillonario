/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.interfaces.implementation;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import quemquersermillonario.dao.interfaces.ComodinDAO;
import quemquersermillonario.dao.interfaces.MovimientoPuntosDAO;
import quemquersermillonario.dao.interfaces.UsuarioComodinesDAO;
import quemquersermillonario.dto.Comodin;
import quemquersermillonario.dto.MovimientoPuntos;
import quemquersermillonario.dto.UsuarioComodines;
import quemquersermillonario.dto.complejas.OpcionesFijas;

/**
 *
 * @author alvaro
 */
public class UsuarioComodinesDAOImpl extends GenericDAOImpl<UsuarioComodines> implements UsuarioComodinesDAO {

    @Override
    public void comprar(Comodin comodin) {
        //Se guarda la compra en el listado de comodines del usuario
        UsuarioComodines usuarioComodines = new UsuarioComodines();
        usuarioComodines.setComodin(comodin);
        usuarioComodines.setUsado(0);
        usuarioComodines.setUsuario(OpcionesFijas.usuario);
        this.guardar(usuarioComodines);
        System.out.println("PASA");
        //Se guarda la compra en el registro de movimientos
        MovimientoPuntos mp = new MovimientoPuntos();
        mp.setDescripcion("Compra Comodin " + comodin.getNombre());
        mp.setUsuario(OpcionesFijas.usuario);
        mp.setPuntos(-comodin.getCoste());
        mp.setUsuarioComodines(usuarioComodines);
        MovimientoPuntosDAO mpd = new MovimientoPuntosDAOImpl();
        mpd.guardar(mp);
    }

    @Override
    public int comodinesActivos(Comodin comodin) {
        iniciar();
        int activos = 0;
        String query = "SELECT count(comodin) from UsuarioComodines where usado=0 and usuario.idUsuario=:usuario and comodin.idComodin=:comodin";
        Query q = session.createQuery(query);
        q.setInteger("comodin", comodin.getIdComodin());
        q.setInteger("usuario", OpcionesFijas.usuario.getIdUsuario());
        List l = q.list();
        if (l.get(0) != null) {
            long g = (long) l.get(0);
            activos = Integer.parseInt(Long.toString(g));
        }

        finalizar();
        return activos;

        /* Query  query= session.createQuery("SELECT sum (puntos)from MovimientoPuntos where usuario.id=:usuario");
        query.setInteger("usuario", OpcionesFijas.usuario.getIdUsuario());
        long g =(long)  query.list().get(0);
        puntos = Integer.parseInt(Long.toString(g));
        finalizar();*/
    }

    @Override
    public List<UsuarioComodines> listarComodinesActivos() {
        List<UsuarioComodines> listaComodines = new ArrayList<>();
        iniciar();
        String query = "from UsuarioComodines where usado=0 and usuario.idUsuario=:usuario";
        Query q = session.createQuery(query);
        q.setInteger("usuario", OpcionesFijas.usuario.getIdUsuario());
        listaComodines = q.list();
        OpcionesFijas.usuario.setListaComodines(listaComodines);
        finalizar();
        return listaComodines;
    }

    @Override
    public void utilizarComodin(Comodin comodin) {
        iniciar();
        int posicionUtilizado = 0;
        UsuarioComodines aux = null;
        for (UsuarioComodines uc : OpcionesFijas.usuario.getListaComodines()) {
            if (comodin.getIdComodin() == uc.getComodin().getIdComodin()) {
                aux = uc;
            }
        }
        aux.setFechaModificacion(OpcionesFijas.fechaActual());
        aux.setUsado(1);
        session.merge(aux);
        finalizar();
    }
}
