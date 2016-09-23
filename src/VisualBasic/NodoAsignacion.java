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
public class NodoAsignacion extends Nodo {
      ArrayList<Nodo> hijos = new ArrayList<Nodo>();

    
    
    public NodoAsignacion(Nodo a, Nodo b){
        hijos.add(a);
        hijos.add(b);
      
       
    }
    
    

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }

    
}
