/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.interfaces;

import java.util.List;

/**
 *
 * @author alvaro
 */
public interface GenericDAO<T> {

    public void guardar(T object);

    public T leer(T object);

    public void borrar(T object);
    
    public void actualizar(T object);
    
    public void iniciar();
    
    public void finalizar();
    
    public List<T> obtenerTodos(T object);
    
    public T buscarId(T object);
    
    

}
