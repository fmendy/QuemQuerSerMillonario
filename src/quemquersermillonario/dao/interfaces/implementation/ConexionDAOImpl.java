/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.interfaces.implementation;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import quemquersermillonario.dao.interfaces.ConexionDAO;
import quemquersermillonario.dto.Conexion;
import quemquersermillonario.dto.Usuario;
import quemquersermillonario.dto.complejas.OpcionesFijas;

/**
 *
 * @author alvaro
 */
public class ConexionDAOImpl extends GenericDAOImpl<Conexion> implements ConexionDAO {
    
    @Override
    public Conexion buscarId(Conexion object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public  Conexion optenerDatosConexion(Usuario usuario) {
        Conexion conexion = new Conexion();
        conexion.setUsuario(usuario);
        conexion.setFechaCreacion(OpcionesFijas.fechaActual());
        conexion.setFechaModificacion(OpcionesFijas.fechaActual());
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            conexion.setDispositivo(inetAddress.getHostName());
            System.out.println(conexion.getDispositivo());
            conexion.setIp(inetAddress.getHostAddress());
            System.out.println(conexion.getIp());
        } catch (UnknownHostException ex) {
            Logger.getLogger(ConexionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
        
    }
    
}
