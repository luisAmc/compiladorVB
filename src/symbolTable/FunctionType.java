/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symbolTable;

import java.util.ArrayList;


public class FunctionType extends Type{
    private Type range;
    
    public FunctionType() {
        super();
        this.range = null;
        this.width = 0;
        this.name = "-";
    }
    
    public FunctionType(Type range) {
        super();
        this.range = range;
        this.width = 0;
        this.name = "-";
    }
    
    public FunctionType(Type range, ArrayList<Type> domain) {
        super();
        this.range = range;
        this.width = 0;
        this.name = "-";
        this.product = domain;
    }
    
    public FunctionType(ArrayList<Type> domain) {
        super();
        this.range = null;
        this.width = 0;
        this.name = "-";
        this.product = domain;
    }

    public Type getRange() {
        return range;
    }

    public void setRange(Type range) {
        this.range = range;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof FunctionType))
            return false;
        else if (o == this)
            return true;
        
        FunctionType function = (FunctionType)o;
        if (!(function.getRange().equals(this.range)) || function.getWidth() != this.width || function.getProduct().size() != this.product.size())
            return false;
        
        ArrayList<Type> product = function.getProduct();
        for (int i = 0; i < this.product.size(); i++)
            if (!(product.get(i).equals(this.product.get(i))))
                return false;
        return true;
    }

    @Override
    public String toString() {
        return "(" + this.range.toString() + " -> " + domainToString() + ")";
    }

    @Override
    public boolean isPrimitiveType() {
        return false;
    }

    @Override
    public boolean isNumericType() {
        return false;
    }
    
    private String domainToString() {
        String ret_val = "";
        for (int i = 0; i < this.product.size(); i++) {
            ret_val += this.product.get(i).toString();
            if (i < this.product.size() - 1)
                 ret_val += " x ";
        }
        
        return ret_val;
    }
}
