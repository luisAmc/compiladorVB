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
public class NodoDeclaracionHijo extends Nodo{
    ArrayList<Nodo> hijos = new ArrayList<Nodo>();

    public NodoDeclaracionHijo(Nodo a, Nodo b, Nodo c) {
        hijos.add(a);
        hijos.add(b);
        hijos.add(c);
        
    }
    
    public NodoDeclaracionHijo(Nodo a, Nodo b) {
        hijos.add(a);
        hijos.add(b);
        
        
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }
    
    
    
    
    
}
