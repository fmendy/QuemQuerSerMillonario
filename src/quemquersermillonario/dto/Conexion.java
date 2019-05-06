/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author alvaro
 */
@Entity 
@Table (name = "Conexion")
public class Conexion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDConexion", unique = true, nullable = false)
    private int idConexion;
    
    @Column(name = "Dispositivo")
    private String dispositivo;
    
    @Column(name = "IP")
    private String ip;
    
    @Column(name = "FechaCreacion", insertable = false)
    private Date fechaCreacion;

    @Column(name = "FechaModificacion", insertable = false)
    private Date fechaModificacion;
    
    @ManyToOne
    @JoinColumn(name = "Usuario_IDUsuario", nullable = false)
    private Usuario usuario;

    public Conexion() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getIdConexion() {
        return idConexion;
    }

    public void setIdConexion(int idConexion) {
        this.idConexion = idConexion;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    
    
}
