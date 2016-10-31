/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symbolTable;


public class IntegerType extends PrimitiveType{
    public IntegerType() {
        super();
        this.width = TypeWidths.INTEGER_WIDTH;
        this.name = "-";
    }
    
    public IntegerType(String name) {
        super();
        this.width = TypeWidths.INTEGER_WIDTH;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof IntegerType))
            return false;
        else if (o == this)
            return true;
        return this.name.equalsIgnoreCase(((IntegerType)o).name);
    }

    @Override
    public String toString() {
        return this.name + ": Integer";
    }

    @Override
    public boolean isNumericType() {
        return true;
    }
}
