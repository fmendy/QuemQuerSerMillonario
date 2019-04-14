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
import javax.persistence.Table;

/**
 *
 * @author alvaro
 */
@Entity
@Table (name = "Dificultad")
public class Dificultad implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDDificultad", unique = true, nullable = false)
    private int idDificultad;
    
    @Column(name = "Nombre")
    private String nombre;
    
    @Column(name = "Activo")
    private int activo;

    @Column(name = "FechaCreacion")
    private Date fechaCreacion;

    @Column(name = "FechaModificacion")
    private Date fechaModificacion;

    public Dificultad() {
    }

    public int getIdDificultad() {
        return idDificultad;
    }

    public void setIdDificultad(int idDificultad) {
        this.idDificultad = idDificultad;
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
        return  nombre;
    }
    
    
    
}
