/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.logica;

import java.util.ArrayList;
import java.util.List;
import quemquersermillonario.dao.interfaces.PartidaDAO;
import quemquersermillonario.dao.interfaces.PreguntaDAO;
import quemquersermillonario.dao.interfaces.RespuestaUsuarioDAO;
import quemquersermillonario.dao.interfaces.implementation.PartidaDAOImpl;
import quemquersermillonario.dao.interfaces.implementation.PreguntaDAOImpl;
import quemquersermillonario.dao.interfaces.implementation.RespuestaUsuarioDAOImpl;
import quemquersermillonario.dto.ModoJuego;
import quemquersermillonario.dto.Partida;
import quemquersermillonario.dto.Pregunta;
import quemquersermillonario.dto.Respuesta;
import quemquersermillonario.dto.RespuestaUsuario;
import quemquersermillonario.dto.complejas.OpcionesFijas;

/**
 *
 * @author alvaro
 */
public class PartidaJugando {

    public static Partida partida;
    private static final PartidaDAO PARTIDA_DAO = new PartidaDAOImpl();
    private static final PreguntaDAO PREGUNTA_DAO = new PreguntaDAOImpl();
    private static final RespuestaUsuarioDAO RESPUESTA_USUARIO_DAO = new RespuestaUsuarioDAOImpl();
    private static Pregunta pregunta;
    private static List<Pregunta> listaPregunta;

    public static void inicializarPartida(ModoJuego modoJuego) {
        partida = new Partida();
        partida.setFechaCreacion(OpcionesFijas.fechaActual());
        partida.setFechaModificacion(OpcionesFijas.fechaActual());
        partida.setModoJuego(modoJuego);
        partida.setUsuario(OpcionesFijas.usuario);
        partida.setPuntuacion(0);
        PARTIDA_DAO.guardar(partida);

        if (partida.getModoJuego().getNombre().equals("NORMAL")) {
            pregunta = new Pregunta();
            listaPregunta = PREGUNTA_DAO.obtenerTodos(pregunta);
        }
    }

    public static Pregunta seleccionarPregunta() {
        int azar = (int) (Math.random() * listaPregunta.size());
        Pregunta p = listaPregunta.get(azar);
        listaPregunta.remove(p);
        desordenarRespuestas(p);
        return p;
    }

    private static void desordenarRespuestas(Pregunta p) {
        List<Respuesta> listAux1 = p.getListaRespuestas();
        List<Respuesta> listAux2 = new ArrayList<>();

        while (listAux1.size() > 0) {
            int azar = (int) (Math.random() * listAux1.size());
            Respuesta r = listAux1.get(azar);
            listAux1.remove(r);
            listAux2.add(r);
        }

        p.setListaRespuestas(listAux2);
    }

    public static boolean comprobarRespuesta(RespuestaUsuario ru, int elegida) {
        boolean acierta = (ru.getPregunta().getListaRespuestas().get(elegida).getCorrecta() == 1);
        if (acierta){
            ru.setCorrecta(1);
            ru.getPartida().setPuntuacion(ru.getPartida().getPuntuacion()+100);
        }else{
            ru.setCorrecta(0);
            ru.getPartida().setPuntuacion(ru.getPartida().getPuntuacion()-200);
        }
        ru.setCorrecta((acierta?1:0));
        RESPUESTA_USUARIO_DAO.guardar(ru);
        return acierta;
    }

}
