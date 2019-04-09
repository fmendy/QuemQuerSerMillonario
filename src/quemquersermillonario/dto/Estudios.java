/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dto;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author alvaro
 */
@Entity
@Table(name = "Estudios", schema = "id9194035_quemquersermillonario")
public class Estudios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDEstudios", unique = true, nullable = false)
    private int idEstudios;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Activo")
    private int activo;

    @Column(name = "FechaCreacion")
    private Date fechaCreacion;

    @Column(name = "FechaModificacion")
    private Date fechaModificacion;

    public Estudios() {
    }

    public int getIdEstudios() {
        return idEstudios;
    }

    public void setIdEstudios(int idEstudios) {
        this.idEstudios = idEstudios;
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

    @Override
    public String toString() {
        return "Estudios{" + "idEstudios=" + idEstudios + ", nombre=" + nombre + ", activo=" + activo + ", fechaCreacion=" + fechaCreacion + ", fechaModificacion=" + fechaModificacion + '}';
    }

}