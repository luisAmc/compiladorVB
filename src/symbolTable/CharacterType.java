/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symbolTable;


public class CharacterType extends PrimitiveType {
    public CharacterType() {
        super();
        this.width = TypeWidths.CHARACTER_WIDTH;
        this.name = "-";
    }

    public CharacterType(String name) {
        super();
        this.width = TypeWidths.CHARACTER_WIDTH;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof CharacterType))
            return false;
        else if (o == this)
            return true;
        return this.name.equalsIgnoreCase(((CharacterType)o).name);
    }

    @Override
    public String toString() {
        return this.name + ": Character";
    }

    @Override
    public boolean isNumericType() {
        return false;
    }
}