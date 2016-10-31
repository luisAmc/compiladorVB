/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symbolTable;


public abstract class PrimitiveType extends Type{
    public PrimitiveType() {
        super();
    }
    
    public boolean isPrimitiveType() {
        return true;
    }
}
