/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.interfaces.implementation;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import quemquersermillonario.dao.interfaces.PreguntaDAO;
import quemquersermillonario.dao.interfaces.RespuestaDAO;
import quemquersermillonario.dto.Categoria;
import quemquersermillonario.dto.Dificultad;
import quemquersermillonario.dto.Pregunta;
import quemquersermillonario.dto.Respuesta;
import quemquersermillonario.dto.Usuario;
import quemquersermillonario.dto.complejas.OpcionesFijas;

/**
 *
 * @author alvaro
 */
public class PreguntaDAOImpl extends GenericDAOImpl<Pregunta> implements PreguntaDAO {

    @Override
    public Pregunta inicializarPregunta() {
        Pregunta p = new Pregunta();
        Respuesta r1, r2, r3, r4;
        r1 = new Respuesta();
        r2 = new Respuesta();
        r3 = new Respuesta();
        r4 = new Respuesta();
        p.aniadirRespuesta(r1);
        p.aniadirRespuesta(r2);
        p.aniadirRespuesta(r3);
        p.aniadirRespuesta(r4);

        return p;
    }

    @Override
    public void desactivarPregunta(Pregunta pregunta) {
        iniciar();
        pregunta.setActivo(0);
        pregunta.setFechaModificacion(OpcionesFijas.fechaActual());
        for (Respuesta rp : pregunta.getListaRespuestas()) {
            rp.setActivo(0);
        }
        session.merge(pregunta);
        finalizar();
    }

    @Override
    public Pregunta buscarId(Pregunta pregunta) {
        iniciar();
        pregunta = (Pregunta) session.get(Pregunta.class, pregunta.getIdPregunta());
        finalizar();
        return pregunta;

    }

    @Override
    public List<Pregunta> obtenerTodasPreguntasActivas() {
        List<Pregunta> listaPreguntas = new ArrayList<>();
        iniciar();
        listaPreguntas = session.createQuery("from Pregunta p where p.activo=1").list();
        finalizar();
        return listaPreguntas;
    }

    @Override
    public List<Pregunta> obtenerPreguntasCategoriaDificultad(Categoria cat, Dificultad dif) {
        List<Pregunta> listaPreguntas = new ArrayList<>();
        iniciar();
        String query = "from Pregunta p where p.activo = 1";
        if (cat.getIdCategoria() > 0) {
            query = query + " and p.categoria = " + cat.getIdCategoria();
        }
        if (dif.getIdDificultad() > 0) {
            query = query + " and p.dificultad = " + dif.getIdDificultad();
        }
        listaPreguntas = session.createQuery(query).list();
        finalizar();
        return listaPreguntas;
    }

    @Override
    public List<Pregunta> obtenerPreguntasCategoriaDificultadTodas(Categoria cat, Dificultad dif, boolean todas) {
        List<Pregunta> listaPreguntas = new ArrayList<>();
        try {
            iniciar();
            String query = "from Pregunta p where p.activo = 1";
            if (cat.getIdCategoria() > 0) {
                query = query + " and p.categoria =:categoria";
            }
            if (dif.getIdDificultad() > 0) {
                query = query + " and p.dificultad =:dificultad";
            }
            if (!todas) {
                query = query + " and p.usuario=:usuario";
            }
            Query cQuery = session.createQuery(query);
            if (cat.getIdCategoria() > 0) {
                cQuery.setParameter("categoria", cat);
            }
            if (dif.getIdDificultad() > 0) {
                cQuery.setParameter("dificultad", dif);
            }
            if (!todas) {
                cQuery.setParameter("usuario", OpcionesFijas.usuario);
            }
            listaPreguntas = cQuery.list();
            finalizar();
        } catch (Exception e) {
        };
        return listaPreguntas;
    }

}
