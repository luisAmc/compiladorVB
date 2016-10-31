/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symbolTable;


public class DoubleType extends PrimitiveType{
    public DoubleType() {
        super();
        this.width = TypeWidths.DOUBLE_WIDTH;
        this.name = "-";
    }
    
    public DoubleType(String name) {
        super();
        this.width = TypeWidths.DOUBLE_WIDTH;
        this.name = name;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof DoubleType))
            return false;
        else if (o == this)
            return true;
        return this.name.equalsIgnoreCase(((DoubleType)o).name);
    }

    @Override
    public String toString() {
        return this.name + ": Double";
    }

    @Override
    public boolean isNumericType() {
        return true;
    }

}
