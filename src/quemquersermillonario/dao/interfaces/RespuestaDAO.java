/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.interfaces;

import quemquersermillonario.dto.Respuesta;

/**
 *
 * @author alvaro
 */
public interface RespuestaDAO extends GenericDAO<Respuesta> {
    public void desactivarRespuestas(Respuesta respuesta); 
    
}
