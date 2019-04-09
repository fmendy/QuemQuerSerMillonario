/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao;

/**
 *
 * @author alvaro
 */
public interface GenericDAO {

    public void guardar(Object object);

    public Object leer(Object object);

    public void borrar(Object object);
    
    public void actualizar(Object object);
    
    public void iniciar();
    
    public void finalizar();
    
    

}
