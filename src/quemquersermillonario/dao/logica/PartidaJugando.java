/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.logica;

import java.util.ArrayList;
import java.util.List;
import quemquersermillonario.dao.interfaces.MovimientoPuntosDAO;
import quemquersermillonario.dao.interfaces.PartidaDAO;
import quemquersermillonario.dao.interfaces.PreguntaDAO;
import quemquersermillonario.dao.interfaces.RespuestaUsuarioDAO;
import quemquersermillonario.dao.interfaces.UsuarioComodinesDAO;
import quemquersermillonario.dao.interfaces.implementation.MovimientoPuntosDAOImpl;
import quemquersermillonario.dao.interfaces.implementation.PartidaDAOImpl;
import quemquersermillonario.dao.interfaces.implementation.PreguntaDAOImpl;
import quemquersermillonario.dao.interfaces.implementation.RespuestaUsuarioDAOImpl;
import quemquersermillonario.dao.interfaces.implementation.UsuarioComodinesDAOImpl;
import quemquersermillonario.dto.Categoria;
import quemquersermillonario.dto.Comodin;
import quemquersermillonario.dto.Dificultad;
import quemquersermillonario.dto.ModoJuego;
import quemquersermillonario.dto.MovimientoPuntos;
import quemquersermillonario.dto.Partida;
import quemquersermillonario.dto.Pregunta;
import quemquersermillonario.dto.Respuesta;
import quemquersermillonario.dto.RespuestaUsuario;
import quemquersermillonario.dto.UsuarioComodines;
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
    public static Dificultad dificultad;
    public static Categoria categoria;

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
            listaPregunta = PREGUNTA_DAO.obtenerTodasPreguntasActivas();
        }
        else if (partida.getModoJuego().getNombre().equals("SUPERVIVENCIA")){
            pregunta = new Pregunta();
            listaPregunta = PREGUNTA_DAO.obtenerPreguntasCategoriaDificultad(categoria, dificultad);
        }
    }

    public static Pregunta seleccionarPregunta() {
        int azar = (int) (Math.random() * listaPregunta.size());
        Pregunta p = listaPregunta.get(azar);
        listaPregunta.remove(p);
        desordenarRespuestas(p);
        return p;
    }

    public static void desordenarRespuestas(Pregunta p) {
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
        String mensaje;
        int puntos;
        if (acierta) {
            puntos = 100;
            ru.setCorrecta(1);
            ru.getPartida().setPuntuacion(ru.getPartida().getPuntuacion() + puntos);
            mensaje = "Pregunta Acertada";
        } else {
            puntos = 200;
            ru.setCorrecta(0);
            ru.getPartida().setPuntuacion(ru.getPartida().getPuntuacion() - puntos);
            mensaje = "Pregunta Fallada";
        }
        ru.setCorrecta((acierta ? 1 : 0));
        RESPUESTA_USUARIO_DAO.guardar(ru);
        MovimientoPuntosDAO mpdao = new MovimientoPuntosDAOImpl();
        MovimientoPuntos mp = new MovimientoPuntos();
        mp.setDescripcion(mensaje);
        mp.setUsuario(OpcionesFijas.usuario);
        mp.setPuntos(puntos);
        mp.setRespuestaUsuario(ru);
        mpdao.guardar(mp);
        return acierta;
    }

    /**
     * Devuelve un array con 2 integer, los cuales indican la posicion de la
     * respuesta correcta y de otra de las preguntas.
     *
     * @param p pregunta
     * @return List Integer
     */
    public static List<Integer> usarComodin50(Pregunta p) {
        List<Integer> lista = new ArrayList<>();

        int i = 0, correcta = 0, azar;
        for (Respuesta r : p.getListaRespuestas()) {
            if (r.getCorrecta() == 1) {

                lista.add(i);
                correcta = i;
            }
            i++;
        }
        azar = (int) (Math.random() * 3);
        while (azar == correcta) {
            azar = (int) (Math.random() * 3);
        }
        lista.add(azar);
        return lista;
    }

    public static boolean tieneComodines50() {
        UsuarioComodinesDAO ucdao = new UsuarioComodinesDAOImpl();
        ucdao.listarComodinesActivos();
        for (UsuarioComodines c : OpcionesFijas.usuario.getListaComodines()) {
            if (c.getComodin().getIdComodin() == 1) {
                System.out.println(c);
                return true;
            }
        }
        return false;
    }

    public static boolean tieneComodinesCambio() {
        UsuarioComodinesDAO ucdao = new UsuarioComodinesDAOImpl();
        ucdao.listarComodinesActivos();
        for (UsuarioComodines c : OpcionesFijas.usuario.getListaComodines()) {
            if (c.getComodin().getIdComodin() == 2) {
                System.out.println(c);
                return true;
            }
        }
        return false;
    }
    
    public static void partidaGanada(){
        MovimientoPuntosDAO mpdao = new MovimientoPuntosDAOImpl();
        MovimientoPuntos mp = new MovimientoPuntos();
        mp.setDescripcion("Partida ganada");
        mp.setUsuario(OpcionesFijas.usuario);
        mp.setPuntos(1000);
        mpdao.guardar(mp);
    }

}
