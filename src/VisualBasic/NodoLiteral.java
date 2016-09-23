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
public class NodoLiteral extends Nodo{
    ArrayList<Nodo> hijos = new ArrayList<Nodo>();
    public NodoLiteral(Nodo a) {
        hijos.add(a);
    }
    
    public NodoLiteral(Nodo a, Nodo b){
        hijos.add(a);
        hijos.add(b);
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }
    
    

    
   
    
    
}
