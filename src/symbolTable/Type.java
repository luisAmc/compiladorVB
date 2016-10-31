/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symbolTable;

import java.util.ArrayList;


public abstract class Type {
    public int width;
    public String name;
    public ArrayList<Type> product;
    
    /**
     * No los use ☻
     */
//    public Type() {
//        this.width = 0;
//        this.name = "";
//        this.product = new ArrayList();
//    }
//
//    public Type(String name) {
//        this.width = 0;
//        this.name = name;
//        this.product = new ArrayList();
//    }
//
//    public Type(int width, String name) {
//        this.width = 0;
//        this.name = name;
//        this.product = new ArrayList();
//    }
//
//    public Type(ArrayList<Type> product, int width) {
//        this.width = width;
//        this.name = "";
//        this.product = product;
//    }
//    
//    public Type(ArrayList<Type> product, String name) {
//        this.width = 0;
//        this.name = name;
//        this.product = product;
//    }
//    
//    public Type(ArrayList<Type> product, int width, String name) {
//        this.width = width;
//        this.name = name;
//        this.product = product;
//    }
//    
//    public Type(Type type, int width) {
//        this.width = width;
//        this.name = "";
//        this.product = new ArrayList();
//        this.product.add(type);
//    }
//    
//    public Type(Type type) {
//        this.width = type.width;
//        this.name = "";
//        this.product = new ArrayList();
//        this.product.add(type);
//    }
//    
//    public Type(ArrayList<Type> product) {
//        this.name = "";
//        this.product = product;
//        
//        this.width = 0;
//        for (Type type : product)
//            this.width += type.width;
//    }
    
    public abstract boolean equals(Object o);
    public abstract String toString();
    public abstract boolean isPrimitiveType();
    public abstract boolean isNumericType();
    
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Type> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<Type> product) {
        this.product = product;
    }
}
