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
public class NodoParametrosHijo extends Nodo{
      ArrayList<Nodo> hijos = new ArrayList<Nodo>();

    public NodoParametrosHijo() {
        
    }
    
    public NodoParametrosHijo(Nodo a, Nodo b, Nodo c){
        hijos.add(a);
        hijos.add(b);
        hijos.add(c);
       
    }
    
    public NodoParametrosHijo(Nodo a, Nodo b){
        hijos.add(a);
        hijos.add(b);
       
       
    }
    
     public NodoParametrosHijo(Nodo a){
        hijos.add(a);
       
       
       
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }
    
}
