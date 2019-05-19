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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author alvaro
 */
@Entity
@Table(name = "Formulario")
public class Formulario implements Serializable {

    public Formulario() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDFormulario", unique = true, nullable = false)
    private int idFormulario;

    @JoinColumn(name = "Usuario_IDUsuario")
    @ManyToOne
    private Usuario usuario;

    @Column(name = "Nombre", length = 40, unique = true)
    private String nombre;

    @Column(name = "Activo", insertable = false)
    private int activo;

    @Column(name = "FechaCreacion", insertable = false, updatable = false)
    private Date fechaCreacion;

    @Column(name = "FechaModificacion", insertable = false)
    private Date fechaModificacion;

  /*  @OneToMany(mappedBy = "formulario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PreguntasFormulario> listaPreguntasFormulario = new ArrayList<>();*/


    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable( name = "PreguntasFormulario" , inverseJoinColumns  = @JoinColumn( name ="Pregunta_IDPregunta"))
    private List<Pregunta> listaPreguntas = new ArrayList<>();

    public List<Pregunta> getListaPreguntas() {
        return listaPreguntas;
    }

    public void setListaPreguntas(List<Pregunta> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }

   /* public List<PreguntasFormulario> getListaPreguntasFormulario() {
        return listaPreguntasFormulario;
    }

    public void setListaPreguntasFormulario(List<PreguntasFormulario> listaPreguntasFormulario) {
        this.listaPreguntasFormulario = listaPreguntasFormulario;
    }*/

    public int getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(int idFormulario) {
        this.idFormulario = idFormulario;
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

   /* public void aniadirPreguntaFormulario(PreguntasFormulario pf) {
        this.listaPreguntasFormulario.add(pf);
    }*/

    public void aniadirPegunta(Pregunta p) {
        this.listaPreguntas.add(p);
    }

}
