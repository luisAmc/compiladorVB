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
public class NodoSentenciaHijo extends Nodo{
     ArrayList<Nodo> hijos = new ArrayList<Nodo>();

    public NodoSentenciaHijo(Nodo a, Nodo b, Nodo c) {
        hijos.add(a);
        hijos.add(b);
        hijos.add(c);
    }
    
    public NodoSentenciaHijo(Nodo a, Nodo b) {
        hijos.add(a);
        hijos.add(b);
    }
    
    public NodoSentenciaHijo(Nodo a) {
        hijos.add(a);
        
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }
    
}
