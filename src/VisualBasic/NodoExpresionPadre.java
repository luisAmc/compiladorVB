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
public class NodoExpresionPadre extends Nodo{
     ArrayList<Nodo> hijos = new ArrayList<Nodo>();

    public NodoExpresionPadre(Nodo a, Nodo b, Nodo c) {
        hijos.add(a);
        hijos.add(c);
    }
    
    public NodoExpresionPadre(Nodo a, Nodo b) {
        hijos.add(a);
        hijos.add(b);
    }
    
    public NodoExpresionPadre(Nodo a) {
        hijos.add(a);
        
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }
    
    
     
     
    
}
