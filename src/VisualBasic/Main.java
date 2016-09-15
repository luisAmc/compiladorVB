/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VisualBasic;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author emerson
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "./src/VisualBasic/lexer.flex";
        generateLexer(path);
        testLexer();
       
    }
     private static void generateLexer(String path) {
       File file = new File(path);
       jflex.Main.generate(file);
    }
     
    private static void testLexer() {
        try {
            String file_path = "./src/VisualBasic/visualTest.txt";
            Reader reader = new BufferedReader(new FileReader(file_path));
            VisualBasicLexer lexer = new VisualBasicLexer(reader);
            while(lexer.yylex() == 1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
