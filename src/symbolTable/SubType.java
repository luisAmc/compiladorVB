/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symbolTable;

import java.util.ArrayList;


public class SubType extends Type{
    public SubType() {
        super();
        this.width = 0;
        this.name = "-";
    }
    
    public SubType(ArrayList<Type> domain) {
        super();
        this.width = 0;
        this.name = "-";
        this.product = domain;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof SubType))
            return false;
        else if (o == this)
            return true;
        
        SubType sub = (SubType)o;
        if (sub.getWidth() != this.width || sub.getProduct().size() != this.product.size())
            return false;
        
        ArrayList<Type> product = sub.getProduct();
        for (int i = 0; i < this.product.size(); i++)
            if (!(product.get(i).equals(this.product.get(i))))
                return false;
        return true;
    }

    @Override
    public String toString() {
        return "(void -> " + domainToString() + ")";
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
