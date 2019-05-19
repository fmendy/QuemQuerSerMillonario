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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author alvaro
 */
@Entity
@Table(name = "MovimientoPuntos")
public class MovimientoPuntos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDMovimientoPuntos", unique = true, nullable = false)
    private int idMovimientoPuntos;

    @Column(name = "Puntos")
    private int puntos;

    @Column(name = "Descripcion", length = 40)
    private String descripcion;

    @Column(name = "FechaCreacion", insertable = false)
    private Date fechaCreacion;

    @Column(name = "FechaModificacion", insertable = false)
    private Date fechaModificacion;

    @ManyToOne
    @JoinColumn(name = "Usuario_IDUsuario")
    private Usuario usuario;

    @OneToOne()
    @JoinColumn(name = "RespuestaUsuario_IDRespuesta")
    private RespuestaUsuario respuestaUsuario;

    @OneToOne()
    @JoinColumn(name = "UsuarioComodines_IDUsuarioComodines")
    private UsuarioComodines usuarioComodines;

    public MovimientoPuntos() {
    }

    public RespuestaUsuario getRespuestaUsuario() {
        return respuestaUsuario;
    }

    public void setRespuestaUsuario(RespuestaUsuario respuestaUsuario) {
        this.respuestaUsuario = respuestaUsuario;
    }

    public int getIdMovimientoPuntos() {
        return idMovimientoPuntos;
    }

    public void setIdMovimientoPuntos(int idMovimientoPuntos) {
        this.idMovimientoPuntos = idMovimientoPuntos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioComodines getUsuarioComodines() {
        return usuarioComodines;
    }

    public void setUsuarioComodines(UsuarioComodines usuarioComodines) {
        this.usuarioComodines = usuarioComodines;
    }

}
