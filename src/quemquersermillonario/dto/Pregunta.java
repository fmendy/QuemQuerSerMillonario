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
@Table (name = "Pregunta")
public class Pregunta implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDPregunta", unique = true, nullable = false)
    private int idPregunta;
    
    @ManyToOne
    @JoinColumn(name = "Categoria_IDCategoria", nullable = false)
    private Categoria categoria;
    
    @ManyToOne
    @JoinColumn(name = "Dificultad_IDDificultad", nullable = false)
    private Dificultad dificultad;
    
    @ManyToOne
    @JoinColumn(name = "Usuario_IDUsuario", nullable = false)
    private Usuario usuario;
    
    @Column(name = "Nombre")
    private String nombre;
    
    @Column(name = "Activo")
    private int activo;

    @Column(name = "FechaCreacion")
    private Date fechaCreacion;

    @Column(name = "FechaModificacion")
    private Date fechaModificacion;
    
}
