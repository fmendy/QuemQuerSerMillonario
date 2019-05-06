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
@Table(name = "Pregunta")
public class Pregunta implements Serializable {

    public Pregunta() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDPregunta", unique = true, nullable = false)
    private int idPregunta;

    
    @JoinColumn(name = "Categoria_IDCategoria", nullable = false)
    @ManyToOne
    private Categoria categoria;

    
    @JoinColumn(name = "Dificultad_IDDificultad", nullable = false)
    @ManyToOne
    private Dificultad dificultad;

    
    @JoinColumn(name = "Usuario_IDUsuario")
    @ManyToOne
    private Usuario usuario;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Activo", insertable = false)
    private int activo;

    @Column(name = "FechaCreacion", insertable = false, updatable = false)
    private Date fechaCreacion;

    @Column(name = "FechaModificacion", insertable = false)
    private Date fechaModificacion;

    @OneToMany(mappedBy = "pregunta", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Respuesta> listaRespuestas = new ArrayList<>();

    @OneToMany(mappedBy = "pregunta", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<RespuestaUsuario> listaRespuestaUsuarios = new ArrayList<>();

    public void aniadirRespuestaUsuario(RespuestaUsuario ru) {
        this.listaRespuestaUsuarios.add(ru);
    }

    public List<RespuestaUsuario> getListaRespuestaUsuarios() {
        return listaRespuestaUsuarios;
    }

    public void setListaRespuestaUsuarios(List<RespuestaUsuario> listaRespuestaUsuarios) {
        this.listaRespuestaUsuarios = listaRespuestaUsuarios;
    }

    public List<Respuesta> getListaRespuestas() {
        return listaRespuestas;
    }

    public void setListaRespuestas(List<Respuesta> listaRespuestas) {
        this.listaRespuestas = listaRespuestas;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
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

    public void aniadirRespuesta(Respuesta respuesta) {
        this.listaRespuestas.add(respuesta);
    }

}
