/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.interfaces.implementation;


import quemquersermillonario.dao.interfaces.RespuestaDAO;
import quemquersermillonario.dto.Respuesta;
import quemquersermillonario.dto.complejas.OpcionesFijas;

/**
 *
 * @author alvaro
 */
public class RespuestaDAOImpl extends GenericDAOImpl<Respuesta> implements RespuestaDAO{

    @Override
    public void desactivarRespuestas(Respuesta respuesta) {
        iniciar();
        respuesta.setActivo(0);
        respuesta.setFechaModificacion(OpcionesFijas.fechaActual());
        session.merge(respuesta);
        finalizar();
    }
    
}
