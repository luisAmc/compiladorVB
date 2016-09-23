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
public class NodoPrincipal extends Nodo {
    String Nombre;
    ArrayList<Nodo> hijos = new ArrayList<Nodo>();

   
    
    public NodoPrincipal(Nodo setencias_principales){
        this.Nombre = "Inicio";
        hijos.add(setencias_principales);
    }
    
     public String getNombre() {
        return Nombre;
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }
    
    
   
    
    
    
    
}
