/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symbolTable;

import java.util.ArrayList;

public class TypeType extends Type {

    public SymbolTable table;

    public TypeType() {
        super();
        this.name = "";
        table = new SymbolTable();
    }
    
    public TypeType(String name) {
        super();
        this.name = name;
        table = new SymbolTable();
    }
    
    public TypeType(String name, SymbolTable table) {
        super();
        this.name = name;
        
        addDomain(table);
    }
    
    private void addDomain(SymbolTable table) {
        ArrayList<Type> domain = new ArrayList();
        
        for (Symbol symbol : table.getTable().values())
            domain.add(symbol.getType());
        
        this.product = domain;
        
        for (Type symbol_type : this.product)
            this.width += symbol_type.getWidth();
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof TypeType))
            return false;
        else if (o == this)
            return true;
        
        TypeType temp_type = (TypeType)o;
        if (!(this.name.equalsIgnoreCase(temp_type.name)) || this.width != temp_type.width)
            return false;
        
        ArrayList<Type> temp_product = temp_type.getProduct();
        for (int i = 0; i < this.product.size(); i++)
            if (!(temp_product.get(i).equals(this.product.get(i))))
                return false;
        
        return true;
    }

    @Override
    public String toString() {
        return ": " + this.name;
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
                ret_val += "x";
        }
        
        return ret_val;
    }
    
    public Type getSymbolType(String name) {
        Symbol symbol = this.table.get(name);
        if (symbol != null)
            return symbol.getType();
        
        return null;
    }
}
