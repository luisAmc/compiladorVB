package symbolTable;

public class Symbol {
    private Type type;
    private boolean is_constant;
    private int address;
    
    public Symbol() {
        this.type = null;
        this.is_constant = false;
        this.address = 0;
    }
    
    public Symbol(Type type) {
        this.type = type;
        this.is_constant = false;
        this.address = 0;
    }
    
    public Symbol(Type type, boolean is_constant) {
        this.type = type;
        this.is_constant = is_constant;
        this.address = 0;
    }
    
    public Symbol(Type type, int address) {
        this.type = type;
        this.is_constant = false;
        this.address = address;
    }
    
    public Symbol(Type type, boolean is_constant, int address) {
        this.type = type;
        this.is_constant = is_constant;
        this.address = address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public Type getType() {
        return type;
    }
    
    @Override
    public String toString() {
        String ret_val = "";
        if (is_constant)
            ret_val += "constant ";
        ret_val += type.toString() + " <" + address + ">";
        return ret_val;
    }
}