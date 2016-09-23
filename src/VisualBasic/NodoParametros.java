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
public class NodoParametros extends Nodo{
    ArrayList<Nodo> hijos = new ArrayList<Nodo>();

    public NodoParametros() {
        
    }
    
    public NodoParametros(Nodo lista_parametros){
        hijos.add(lista_parametros);
        
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }
    
    
    
    
    
    
    
}
