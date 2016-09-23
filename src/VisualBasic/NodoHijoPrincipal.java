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
public class NodoHijoPrincipal extends Nodo{
    ArrayList<Nodo> hijos = new ArrayList<Nodo>();

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }

    public NodoHijoPrincipal(Nodo sentencia_principal) {
        hijos.add(sentencia_principal);
    }
    
    
    
}
