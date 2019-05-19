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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author alvaro
 */
@Entity
@Table(name = "Comodines")
public class Comodin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDComodines", unique = true, nullable = false)
    private int idComodin;

    @Column(name = "Nombre", length = 40, unique = true)
    private String nombre;

    @Column(name = "Coste")
    private int coste;

    @Column(name = "Activo", insertable = false)
    private int activo;

    @Column(name = "FechaCreacion", insertable = false, updatable = false)
    private Date fechaCreacion;

    @Column(name = "FechaModificacion", insertable = false)
    private Date fechaModificacion;

    @OneToMany(mappedBy = "comodin", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<UsuarioComodines> listUsuarioComodines = new ArrayList<>();

    public Comodin() {
    }

    public int getIdComodin() {
        return idComodin;
    }

    public void setIdComodin(int idCategoria) {
        this.idComodin = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCoste() {
        return coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
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

    public List<UsuarioComodines> getListUsuarioComodines() {
        return listUsuarioComodines;
    }

    public void setListUsuarioComodines(List<UsuarioComodines> listUsuarioComodines) {
        this.listUsuarioComodines = listUsuarioComodines;
    }

    public void aniadirUsuarioComodin(UsuarioComodines uc) {
        this.listUsuarioComodines.add(uc);
    }

    @Override
    public String toString() {
        return nombre;
    }

}
