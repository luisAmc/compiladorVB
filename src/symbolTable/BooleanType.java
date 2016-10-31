/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symbolTable;

public class BooleanType extends PrimitiveType{
    public BooleanType() {
        super();
        this.width = TypeWidths.BOOLEAN_WIDTH;
        this.name = "-";
    }
    
    public BooleanType(String name) {
        super();
        this.width = TypeWidths.BOOLEAN_WIDTH;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        else if (! (o instanceof BooleanType))
            return false;
        else if (o == this)
            return true;
        return this.name.equalsIgnoreCase(((BooleanType)o).name);
    }

    @Override
    public String toString() {
        return this.name + ": Boolean";
    }

    @Override
    public boolean isNumericType() {
        return false;
    }
    
}
