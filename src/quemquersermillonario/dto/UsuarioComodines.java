/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author alvaro
 */
@Entity
@Table(name = "UsuarioComodines")
public class UsuarioComodines implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDUsuarioComodines", unique = true, nullable = false)
    private int idUsuarioComodin;

    @ManyToOne
    @JoinColumn(name = "Usuario_IDUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne()
    @JoinColumn(name = "Comodines_IDComodines", nullable = false)
    private Comodin comodin;

    @Column(name = "Usado")
    private int usado;

    @Column(name = "FechaCreacion", insertable = false, updatable = false)
    private Date fechaCreacion;

    @Column(name = "FechaModificacion", insertable = false)
    private Date fechaModificacion;

    public UsuarioComodines() {
    }

    public int getIdUsuarioComodin() {
        return idUsuarioComodin;
    }

    public void setIdUsuarioComodin(int idUsuarioComodin) {
        this.idUsuarioComodin = idUsuarioComodin;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getUsado() {
        return usado;
    }

    public void setUsado(int usado) {
        this.usado = usado;
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

    public Comodin getComodin() {
        return comodin;
    }

    public void setComodin(Comodin comodin) {
        this.comodin = comodin;
    }

}
