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
@Table(name = "Usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDUsuario", unique = true, nullable = false, length = 40)
    private int idUsuario;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellidos")
    private String apellidos;

    @Column(name = "Email")
    private String email;

    @Column(name = "AnoNacimiento")
    private int anoNacimiento;

    @Column(name = "Password")
    private String password;

    @JoinColumn(name = "Estudios_IDEstudios", nullable = true)
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Estudios estudios;

    @Column(name = "Activo", insertable = false)
    private int activo;

    @Column(name = "FechaCreacion", insertable = false, updatable = false)
    private Date fechaCreacion;

    @Column(name = "FechaModificacion", insertable = false)
    private Date fechaModificacion;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Conexion> listaConexiones = new ArrayList();

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Pregunta> listaPreguntas = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<MovimientoPuntos> listaMovimientoPuntos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Partida> listaPartidas = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<UsuarioComodines> listaComodines = new ArrayList<>();

    public List<UsuarioComodines> getListaComodines() {
        return listaComodines;
    }

    public void setListaComodines(List<UsuarioComodines> listaComodines) {
        this.listaComodines = listaComodines;
    }

    public List<Partida> getListaPartidas() {
        return listaPartidas;
    }

    public void setListaPartidas(List<Partida> listaPartidas) {
        this.listaPartidas = listaPartidas;
    }

    public List<MovimientoPuntos> getListaMovimientoPuntos() {
        return listaMovimientoPuntos;
    }

    public void setListaMovimientoPuntos(List<MovimientoPuntos> listaMovimientoPuntos) {
        this.listaMovimientoPuntos = listaMovimientoPuntos;
    }

    public List<Pregunta> getListaPreguntas() {
        return listaPreguntas;
    }

    public void setListaPreguntas(List<Pregunta> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }

    public List<Conexion> getListaConexiones() {
        return listaConexiones;
    }

    public void setListaConexiones(List<Conexion> listaConexiones) {
        this.listaConexiones = listaConexiones;
    }

    public Usuario() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Estudios getEstudios() {
        return estudios;
    }

    public void setEstudios(Estudios estudios) {
        this.estudios = estudios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAnoNacimiento() {
        return anoNacimiento;
    }

    public void setAnoNacimiento(int anoNacimiento) {
        this.anoNacimiento = anoNacimiento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void aniadirConexion(Conexion conexion) {
        this.listaConexiones.add(conexion);
    }

    public void aniadirPregunta(Pregunta pregunta) {
        this.listaPreguntas.add(pregunta);
    }

    public void aniadirMovimientoPuntos(MovimientoPuntos mp) {
        this.listaMovimientoPuntos.add(mp);
    }

    public void aniadirPartida(Partida p) {
        this.listaPartidas.add(p);
    }

    public void aniadirComodin(UsuarioComodines c) {
        this.listaComodines.add(c);
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", anoNacimiento=" + anoNacimiento + ", password=" + password + ", estudios=" + estudios + ", activo=" + activo + ", fechaCreacion=" + fechaCreacion + ", fechaModificacion=" + fechaModificacion + '}';
    }

}
