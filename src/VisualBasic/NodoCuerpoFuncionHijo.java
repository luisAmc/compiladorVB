/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VisualBasic;

import java.util.ArrayList;

/**
 *
 * @author emerson
 */
public class NodoCuerpoFuncionHijo extends Nodo {
     ArrayList<Nodo> hijos = new ArrayList<Nodo>();

    public NodoCuerpoFuncionHijo(Nodo sentencias_cuerpo_funcion) {
        hijos.add(sentencias_cuerpo_funcion);
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }
    
}
