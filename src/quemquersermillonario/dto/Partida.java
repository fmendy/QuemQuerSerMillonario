/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author alvaro
 */
@Entity
@Table(name = "Partida")
public class Partida implements Serializable {

    public Partida() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDPartida", unique = true, nullable = false)
    private int idPartida;

    @ManyToOne
    @JoinColumn(name = "Usuario_IDUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ModoJuego_IDModoJuego", nullable = false)
    private ModoJuego modoJuego;

    @Column(name = "Puntuacion")
    private int puntuacion;

    @Column(name = "FechaCreacion", insertable = false, unique = false)
    private Date fechaCreacion;

    @Column(name = "FechaModificacion", insertable = false)
    private Date fechaModificacion;

    @OneToMany(mappedBy = "partida", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<RespuestaUsuario> listRespuestaUsuarios = new ArrayList<>();

    public List<RespuestaUsuario> getListRespuestaUsuarios() {
        return listRespuestaUsuarios;
    }

    public void setListRespuestaUsuarios(List<RespuestaUsuario> listRespuestaUsuarios) {
        this.listRespuestaUsuarios = listRespuestaUsuarios;
    }

    public void aniadirRespuestaUsuario(RespuestaUsuario ru) {
        this.listRespuestaUsuarios.add(ru);
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ModoJuego getModoJuego() {
        return modoJuego;
    }

    public void setModoJuego(ModoJuego modoJuego) {
        this.modoJuego = modoJuego;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
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
