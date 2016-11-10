/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symbolTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;


public class SymbolTable {
    /**
     * HashMap: makes absolutely no guarantees about the iteration order.
     *      Can change the iteration order when new elements are added.
     * 
     * TreeMap: will iterate according to the "natural ordering" (topological?) 
     *      of the keys according to their compareTo() method (or an externally supplied Comparator).
     * 
     * LinkedHashMap: will iterate in the order in which the elements were added.
     */
    private LinkedHashMap<String, Symbol> table;
    private SymbolTable parent;
    private int shift;
    private String name;
    private ArrayList<SymbolTable> children;

    public SymbolTable() {
        this.table = new LinkedHashMap();
        this.parent = null;
        this.shift = 0;
        this.name = "";
        this.children = new ArrayList();
    }
    
    public SymbolTable(String name) {
        this.table = new LinkedHashMap();
        this.parent = null;
        this.shift = 0;
        this.name = name;
        this.children = new ArrayList();
    }
    
    public SymbolTable(SymbolTable parent) {
        this.table = new LinkedHashMap();
        this.parent = parent;
        this.shift = this.parent.shift;
        this.name = "";
        this.children = new ArrayList();
    }
    
    public SymbolTable(SymbolTable parent, String name) {
        this.table = new LinkedHashMap();
        this.parent = parent;
        this.shift = this.parent.shift;
        this.name = name;
        this.children = new ArrayList();
    }

    public String getTableName() {
        String ret_val = this.name;
        for (SymbolTable parent_table = this.getParent(); parent_table != null; parent_table = parent_table.getParent())
            if (ret_val.isEmpty())
                ret_val = parent_table.name;
            else
                ret_val = parent_table.name + "." + ret_val;
        return ret_val;
    }
    
    //TODO: get for functions/subs
    //Can i search with the products?
    public Symbol get(String name) {
        Symbol ret_val = new Symbol();
        for (SymbolTable table = this; table != null; table = table.getParent()) {
            ret_val = table.getTable().get(name);
            if (ret_val != null)
                return ret_val;
        }
        
        return null;
    }
    
    public boolean add(String name, Symbol symbol) {
        if (!(this.table.containsKey(name))) {
            symbol.setAddress(this.shift);
            this.shift += symbol.getType().getWidth();
            table.put(name, symbol);
            return true;
        }
        return false;
    }
    
    public LinkedHashMap<String, Symbol> getTable() {
        return table;
    }

    public SymbolTable getParent() {
        return parent;
    }

    public int getShift() {
        return shift;
    }

    public String getName() {
        return name;
    }

    public ArrayList<SymbolTable> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "Table: " + getTableName() + tableContentToString();
        
    }

    private String tableContentToString() {
        String ret_val = "";
        for (Map.Entry entry : table.entrySet())
            ret_val += "\n\t" + entry.getKey() + " :: " + entry.getValue();
        
        return ret_val;
    }
    
}
