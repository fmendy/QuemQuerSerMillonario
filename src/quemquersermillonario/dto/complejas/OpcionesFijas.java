/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dto.complejas;

import java.util.ArrayList;
import java.util.List;
import quemquersermillonario.dto.Estudios;
import quemquersermillonario.dto.Estudios;

/**
 *
 * @author alvaro
 */
public class OpcionesFijas {
    public static List<Estudios> listaEstudios=new ArrayList<>();

    public OpcionesFijas() {
    }

    public static List<Estudios> getListaEstudios() {
        return listaEstudios;
    }

    public static void setListaEstudios(List<Estudios> listaEstudios) {
        OpcionesFijas.listaEstudios = listaEstudios;
    }
    
    
    
}
