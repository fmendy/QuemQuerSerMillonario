/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.interfaces;

import quemquersermillonario.dto.Conexion;
import quemquersermillonario.dto.Usuario;

/**
 *
 * @author alvaro
 */
public interface ConexionDAO extends GenericDAO<Conexion>{
    public Conexion optenerDatosConexion(Usuario Usuario);
}
