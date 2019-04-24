/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.interfaces.implementation;

import org.hibernate.Query;
import quemquersermillonario.dao.interfaces.ModoJuegoDAO;
import quemquersermillonario.dto.ModoJuego;

/**
 *
 * @author alvaro
 */
public class ModoJuegoDAOImpl extends GenericDAOImpl<ModoJuego> implements ModoJuegoDAO {

    @Override
    public ModoJuego buscarModoJuego(String nombre) {
        ModoJuego mj;
        iniciar();
        Query query = session.createQuery("from ModoJuego mj where  mj.nombre=:modoJuegoNombre");
        query.setParameter("modoJuegoNombre", nombre.toUpperCase());
        mj = (ModoJuego) query.uniqueResult();
        finalizar();
        return mj;
    }

}
