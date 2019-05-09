/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.interfaces;

import java.util.List;
import quemquersermillonario.dto.Pregunta;

/**
 *
 * @author alvaro
 */
public interface PreguntaDAO extends GenericDAO<Pregunta> {

    public Pregunta inicializarPregunta();

    public void desactivarPregunta(Pregunta pregunta);
    
    public List<Pregunta> obtenerTodasPreguntasActivas();
}
