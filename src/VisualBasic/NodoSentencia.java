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
public class NodoSentencia extends Nodo{
     ArrayList<Nodo> hijos = new ArrayList<Nodo>();

    public NodoSentencia(Nodo a, Nodo b){
        hijos.add(a);
        hijos.add(b);
    }
    
    public NodoSentencia(Nodo sentencia){
        hijos.add(sentencia);
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }
    
}
