/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.interfaces;

import quemquersermillonario.dto.Comodin;
import quemquersermillonario.dto.UsuarioComodines;

/**
 *
 * @author alvaro
 */
public interface UsuarioComodinesDAO extends GenericDAO<UsuarioComodines>{
    public void comprar(Comodin comodin);
    
    public int comodinesActivos(Comodin comodin);
}
