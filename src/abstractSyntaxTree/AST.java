/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractSyntaxTree;

import java.util.ArrayList;

public class AST {

    public AST() {}
    public static Node node;

    public static String tabs(int t) {
        String ret_val = "";
        for (int i = 0; i < t; i++) {
            ret_val += "\t";
        }
        return ret_val;
    }
    
    public class Programa {

        private SentenciasPrincipales sentencias_principales;
        Node node;
        
        public Programa(SentenciasPrincipales sp) {
            this.sentencias_principales = sp;
        }
        
        public void setNode() {
            node = new Node("Programa", null, "Programa");
            // //node.addChildren(sentencias_principales.getNode());
            AST.node = node;
        }

        public String toString() {
            String ret_val = "Programa:{";
            if (sentencias_principales != null)
                for (int i = 0; i < sentencias_principales.size(); i++) {
                    ret_val += "\n" + AST.tabs(1) + sentencias_principales.getAt(i);
                }
            return ret_val + "}";
        }
    }

    public class SentenciasPrincipales {

        private ArrayList<SentenciaPrincipal> sentencias;
        Node node;
        int n;
        public SentenciasPrincipales() {
            sentencias = new ArrayList();
            this.n = n;
        }
        
        public Node getNode() {
            node = new Node("Sentencias principales", null, "SentenciasPrincipales");
            for (int i = 0; i < sentencias.size(); i++) {
               // //node.addChildren(sentencias.get(i).getNode());
            }
            return node;
        }
        
        public void add(SentenciaPrincipal s) {
            sentencias.add(s);
        }

        public SentenciaPrincipal getAt(int pos) {
            return sentencias.get(pos);
        }

        public int size() {
            return sentencias.size();
        }
    }

    public abstract class SentenciaPrincipal {
        private Visibilidad v;
        private Parametros p;
        private CuerpoFuncion cf;
        private String lv;
        private TipoDato td;
        private String id;
        private CuerpoNuevoTipo cnt;
        private LlamadoFuncion lf;
        
        public SentenciaPrincipal(Visibilidad v, Parametros p, CuerpoFuncion cf) {
            this.v = v;
            this.p = p;
            this.cf = cf;
        }
        
        public SentenciaPrincipal(Visibilidad v, String lv, TipoDato td) {
            this.v = v;
            this.lv = lv;
            this.td = td;
        }
        
        public SentenciaPrincipal(Visibilidad v, String id, CuerpoNuevoTipo cnt) {
            this.v = v;
            this.id = id;
            this.cnt = cnt;
        }
        
        public SentenciaPrincipal(Visibilidad v, String lv, LlamadoFuncion lf) {
            this.v = v;
            this.lv = lv;
            this.lf = lf;
        }
        
        public abstract Node getNode();
        
        @Override
        public abstract String toString();;
    }

    public class DeclaracionVariables extends SentenciaPrincipal /*implements SentenciaCuerpoFuncion*/   {

        private Visibilidad visibilidad;
        private String identificador;
        private TipoDato tipo_de_dato;
        private LlamadoFuncion llamado_de_funcion;
        private boolean is_new;
        Node node;

        public DeclaracionVariables(Visibilidad v, String id, TipoDato td) {
            super(v, id, td);
            visibilidad = v;
            identificador = id;
            tipo_de_dato = tipo_de_dato;
            is_new = false;
        }
        
        public DeclaracionVariables(Visibilidad v, String id, LlamadoFuncion lf) {
            super(v, id, lf);
            visibilidad = v;
            identificador = id;
            llamado_de_funcion = lf;
            is_new = true;
        }

        @Override
        public String toString() {
            String ret_val = "Declaracion de variables: \n\t"
                    + visibilidad.toString();
            // for (int i = 0; i < lv.size(); i++) {
            //     ret_val += "\n\t\t\t" + lv.getAt(i);
            // }
            
            ret_val += "Identificador: " + identificador;

            if (is_new)
                ret_val += "\n\t\t\t como " + llamado_de_funcion.toString();
            else
                ret_val += "\n\t\t\t como " + tipo_de_dato.toString();
            return ret_val;
        }

        @Override
        public Node getNode() {
            node = new Node("Declaracion de variables", null, "DeclaracionVariables");
            // //node.addChildren(v.getNode());
            // //node.addChildren(lv.getNode());
            // //node.addChildren(td.getNode());
            return node;
        }
    }
    
    public class DeclaracionSub extends SentenciaPrincipal {

        private Visibilidad visibilidad;
        private Parametros parametros;
        private CuerpoFuncion cuerpo_de_funcion;
        Node node;
        
        public DeclaracionSub(Visibilidad v, Parametros p, CuerpoFuncion cp) {
            super(v, p, cp);
            visibilidad = v;
            parametros = p;
            cuerpo_de_funcion = cp;
        }

        @Override
        public String toString() {
            String ret_val = "Declaracion de Sub: \n\t"
                    + visibilidad.toString() + "\n\tParametros: (";

            for (int i = 0; i < parametros.size(); i++) {
                ret_val += "\n" + AST.tabs(2) + parametros.getAt(i);
            }

            ret_val += ")\n" + AST.tabs(2) +  "Cuerpo de Funcion:";

            for (int i = 0; i < cuerpo_de_funcion.size(); i++) {
                ret_val += "\n" + AST.tabs(2) + cuerpo_de_funcion.getAt(i);
            }

            return ret_val;
        }

        @Override
        public Node getNode() {
            node = new Node("Declaracion de sub", null, "DeclaracionSub");
            // //node.addChildren(v.getNode());
            // //node.addChildren(p.getNode());
            // //node.addChildren(cp.getNode());
            return node;
        }
    }
    
    public class DeclaracionFuncion extends SentenciaPrincipal {
        private Visibilidad visibilidad;
        private Parametros parametros;
        private CuerpoFuncion cuerpo_de_funcion;
        Node node;
        
        public DeclaracionFuncion(Visibilidad v, Parametros p, CuerpoFuncion cf) {
            super(v, p, cf);
            this.visibilidad = v;
            this.parametros = p;
            this.cuerpo_de_funcion = cf;
        }
        
        public String toString() {
            String ret_val = "Declaracion de Funcion:"
                    + "\n\t\t" + visibilidad.toString()
                    + "\n\t\tParametros: (";
            
            for (int i = 0; i < parametros.size(); i++) {
                ret_val += "\n\t\t" + parametros.getAt(i);
            }

            ret_val += ")\n\t\tCuerpo de Funcion:";

            for (int i = 0; i < cuerpo_de_funcion.size(); i++) {
                ret_val += "\n\t\t" + cuerpo_de_funcion.getAt(i);
            }
            
            return ret_val;
        }

        @Override
        public Node getNode() {
            node = new Node("Declaracion de funcion", null, "DeclaracionFuncion");
            // //node.addChildren(v.getNode());
            // //node.addChildren(p.getNode());
            // //node.addChildren(cf.getNode());
            return node;
        }
    }
    
    public class DeclaracionType extends SentenciaPrincipal {
        private Visibilidad visibilidad;
        private String identificador;
        private CuerpoNuevoTipo cuerpo_de_type;
        Node node;
        
        public DeclaracionType(Visibilidad v, String id, CuerpoNuevoTipo cnt) {
            super(v, id, cnt);
            this.visibilidad = v;
            this.identificador = id;
            this.cuerpo_de_type = cnt;
        }
        
        public String toString() {
            String ret_val = "Declaracion de Type:"
                    + "\n\t\t" + visibilidad.toString()
                    + "\n\t\tIdentificador: " + identificador
                    + "\n\t\tCuerpo de Type:";
            for (int i = 0; i < cuerpo_de_type.size(); i++) {
                ret_val += "\n\t\t\t" + cuerpo_de_type.getAt(i);
            }
            
            return ret_val;
        }

        @Override
        public Node getNode() {
            node = new Node("Declaracion de Type", null, "DeclaracionType");
            // //node.addChildren(v.getNode());
            // //node.addChildren(new Node(id, null, "Identificador"));
            // //node.addChildren(cnt.getNode());
            return node;
        }
    }
    
    public class CuerpoNuevoTipo {
        public SentenciasCuerpoNuevoTipo sentencias_de_cuerpo_de_type;
        Node node;
        
        public CuerpoNuevoTipo(SentenciasCuerpoNuevoTipo scnt) {
            this.sentencias_de_cuerpo_de_type = scnt;
        }
        
        public int size() {
            return sentencias_de_cuerpo_de_type.size();
        }
        
        public String getAt(int pos) {
            return sentencias_de_cuerpo_de_type.getAt(pos).toString();
        }

        private Node getNode() {
            node = new Node("Cuerpo de Type", null, "CuerpoNuevoTipo");
            // //node.addChildren(sentencias_de_cuerpo_de_type.getNode());
            return node;
        }
    }
    
    public class SentenciasCuerpoNuevoTipo {
        private ArrayList<DeclaracionVariablesNuevoTipo> declaracion_de_variables_de_type;
        Node node;
        
        public SentenciasCuerpoNuevoTipo() {
            declaracion_de_variables_de_type = new ArrayList();
        }
        
        public void add(DeclaracionVariablesNuevoTipo a) {
            declaracion_de_variables_de_type.add(a);
        }
        
        public int size() {
            return declaracion_de_variables_de_type.size();
        }
        
        public DeclaracionVariablesNuevoTipo getAt(int pos) {
            return declaracion_de_variables_de_type.get(pos);
        }

        private Node getNode() {
            node = new Node("Sentencias de cuerpo de Type", null, "SentenciasCuerpoNuevoTipo");
            for (int i = 0; i < declaracion_de_variables_de_type.size(); i++) {
                //node.addChildren(declaracion_de_variables_de_type.get(i).getNode());
            }
            return node;
        }
    }
    
    public class DeclaracionVariablesNuevoTipo {
        private String identificador;
        private TipoDato tipo_de_dato;
        Node node;
        
        public DeclaracionVariablesNuevoTipo(String id, TipoDato td) {
            this.identificador = id;
            this.tipo_de_dato = td;
        }
        
        public String toString() {
            return "Declaracion de variables (type):"
                    + "\n\t\t\tIdentificador: " + identificador
                    + "\n\t\t\t" + tipo_de_dato.toString();
                    
        }

        private Node getNode() {
            node = new Node("Declaracion de variables de Type", null, "DeclaracionVariablesNuevoTipo");
           //node.addChildren(new Node(id, null, "Identificador"));
           //node.addChildren(td.getNode());
            return node;
        }
    }
    
    public class CuerpoFuncion {

        public SentenciasCuerpoFuncion sentencias_de_cuerpo_de_funcion;
        Node node;
        
        public CuerpoFuncion(SentenciasCuerpoFuncion scf) {
            this.sentencias_de_cuerpo_de_funcion = scf;
        }

        public int size() {
            return sentencias_de_cuerpo_de_funcion.size();
        }

        public String getAt(int pos) {
            return sentencias_de_cuerpo_de_funcion.getAt(pos).toString();
        }

        private Node getNode() {
            node = new Node("Cuerpo de funcion", null, "CuerpoFuncion");
            // //node.addChildren(sentencias_de_cuerpo_de_funcion.getNode());
            return node;
        }
    }

    public class SentenciasCuerpoFuncion {

        private ArrayList<SentenciaCuerpoFuncion> sentencias;
        Node node;
        
        public SentenciasCuerpoFuncion() {
            sentencias = new ArrayList();
        }

        public void add(SentenciaCuerpoFuncion scf) {
            sentencias.add(scf);
        }

        public int size() {
            return sentencias.size();
        }

        public SentenciaCuerpoFuncion getAt(int pos) {
            return sentencias.get(pos);
        }

        private Node getNode() {
            node = new Node("Sentencias de cuerpo de funcion", null, "SentenciasCuerpoFuncion");
            for (int i = 0; i < sentencias.size(); i++) {
                // //node.addChildren(sentencias.get(i).getNode());
            }
            return node;
        }
    }

    public abstract class SentenciaCuerpoFuncion {
        @Override
        public abstract String toString();

        public abstract Node getNode();
    }
    
    public class SentenciaLlamadoFuncionPropiedad extends SentenciaCuerpoFuncion{
        private Propiedad propiedad;
        private Argumentos argumentos;
        Node node;
        
        public SentenciaLlamadoFuncionPropiedad(Propiedad p, Argumentos a) {
            this.propiedad = p;
            this.argumentos = a;
        }
        
        public String toString() {
            return "Sentencia llamado de funcion de propiedad:"
                    + "\n" + propiedad.toString()
                    + "\n" + argumentos.toString();
        }

        @Override
        public Node getNode() {
            node = new Node("Sentencia de llamado de funcion (propiedad)", null, "SentenciaLlamadoFuncionPropiedad");
            // //node.addChildren(propiedad.getNode());
            // //node.addChildren(argumentos.getNode());
            return node;
        }
    }
    
    public class DeclaracionVariablesCuerpoFuncion extends SentenciaCuerpoFuncion  {

        private String identificador;
        private TipoDato tipo_de_dato;
        private LlamadoFuncion llamado_de_funcion;
        private boolean is_new;
        Node node;

        public DeclaracionVariablesCuerpoFuncion(String id, TipoDato td) {
            this.identificador = id;
            this.tipo_de_dato = td;
            this.is_new = false;
        }
        
        public DeclaracionVariablesCuerpoFuncion(String id, LlamadoFuncion lf) {
            this.identificador = id;
            this.llamado_de_funcion = lf;
            this.is_new = true;
        }

        @Override
        public String toString() {
            String ret_val = "Declaracion de variables cuerpo funcion: \n\t";
            ret_val += "Identificador: " + identificador;
            // for (int i = 0; i < identificador.size(); i++) {
            //     ret_val += "\n\t\t\t\t" + lv.getAt(i);
            // }
            
            if (is_new)
                ret_val += "\n\t\t\t\t como " + llamado_de_funcion.toString();
            else
                ret_val += "\n\t\t\t\t como " + tipo_de_dato.toString();
            return ret_val;
        }

        @Override
        public Node getNode() {
            node = new Node("Declaracion de variables", null, "DeclaracionVariables");
            // //node.addChildren(v.getNode());
            // //node.addChildren(lv.getNode());
            // //node.addChildren(td.getNode());
            return node;
        }
    }
    
    public class SentenciaForStep extends SentenciaCuerpoFuncion {

        private String identificador;
        private Expresion expresion1, expresion2;
        private String tipo_de_step;
        private CuerpoFuncion cuerpo_de_funcion;
        Node node;
        
        public SentenciaForStep(String id, Expresion e1, Expresion e2, String ts, CuerpoFuncion cf) {
            this.identificador = id;
            this.expresion1 = e1;
            this.expresion2 = e2;
            this.tipo_de_step = ts;
            this.cuerpo_de_funcion = cf;
        }

        public String toString() {
            return "Sentencia For(Step):"
                    + "Identificador: " + identificador + "\n"
                    + expresion1.toString() + "\n"
                    + expresion2.toString() + "\n"
                    + "Tipo de step: " + tipo_de_step + "\n"
                    + cuerpo_de_funcion;
        }

        @Override
        public Node getNode() {
            node = new Node("Sentencia for step", null, "SentenciaForStep");
            // //node.addChildren(new Node(identificador, null, "Identificador"));
            // //node.addChildren(expresion1.getNode());
            // //node.addChildren(expresion2.getNode());
            // //node.addChildren(new Node(tipo_de_step, null, "Tipo de step"));
            // //node.addChildren(cuerpo_de_funcion.getNode());
            return node;
        }
    }

    public class SentenciaDoWhile extends SentenciaCuerpoFuncion {

        private Expresion expresion;
        private CuerpoFuncion cuerpo_de_funcion;
        Node node;
        
        public SentenciaDoWhile(Expresion e, CuerpoFuncion cf) {
            this.expresion = e;
            this.cuerpo_de_funcion = cf;
        }

        public String toString() {
            String ret_val = "Sentencia Do While: \n\t\t\t"
                    + expresion.toString();
            ret_val += "\n\t\t\tCuerpo de Funcion:";
            for (int i = 0; i < cuerpo_de_funcion.size(); i++) {
                ret_val += "\n\t\t\t" + cuerpo_de_funcion.getAt(i);
            }

            return ret_val;
        }

        @Override
        public Node getNode() {
            node = new Node("Sentencia Do While", null, "SentenciaDoWhile");
            // //node.addChildren(expresion.getNode());
            // //node.addChildren(cuerpo_de_funcion.getNode());
            return node;
        }
    }

    public class SentenciaIf extends SentenciaCuerpoFuncion {
        private Expresion expresion;
        private CuerpoFuncion cuerpo_de_funcion;
        private SentenciasElseIf sentencia_else_if;
        private SentenciaElse sentencia_else;
        private boolean has_ei, has_e;
        Node node;
        
        public SentenciaIf(Expresion e, CuerpoFuncion cf, SentenciasElseIf sei, SentenciaElse se) {
            this.expresion = e;
            this.cuerpo_de_funcion = cf;
            this.sentencia_else_if = sei;
            this.sentencia_else = se;
            this.has_ei = true;
            this.has_e = true;
        }

        public SentenciaIf(Expresion e, CuerpoFuncion cf, SentenciaElse se) {
            this.expresion = e;
            this.cuerpo_de_funcion = cf;
            this.sentencia_else = se;
            this.has_ei = false;
            this.has_e = true;
        }

        public SentenciaIf(Expresion e, CuerpoFuncion cf) {
            this.expresion = e;
            this.cuerpo_de_funcion = cf;
            this.has_ei = false;
            this.has_e = false;
        }
        
        public String toString() {
            String ret_val = "Sentencia If:\n\t"
                    + expresion.toString();
            
            ret_val += "\n\t\t\tCuerpo de Funcion:";
            for (int i = 0; i < cuerpo_de_funcion.size(); i++) {
                ret_val += "\n\t\t\t" + cuerpo_de_funcion.getAt(i);
            }
            
            if (has_ei)
                ret_val += "\n\t\t\t" + sentencia_else_if.toString();
            else if (has_e)
                ret_val += "\n\t\t\t" + sentencia_else.toString();
            
            return ret_val;
        }

        @Override
        public Node getNode() {
            node = new Node("Sentencia if", null, "SentenciaIf");
            // //node.addChildren(cf.getNode());
            // if (has_ei)
                // //node.addChildren(sei.getNode());
            // else if (has_e)
                // //node.addChildren(se.getNode());
            return node;
        }
    }
    
    public class SentenciaConsola extends SentenciaCuerpoFuncion {
        private String comando_consola;
        private Termino termino;
        Node node;
        
        public SentenciaConsola(String com, Termino t) {
            this.comando_consola = com;
            this.termino = t;
        }
        
        public String toString() {
            return "Sentencia de consola:"
                    + "\n" + "Comando: " + comando_consola
                    + "\n" + "("
                    + termino.toString()
                    + ")";
        }

        @Override
        public Node getNode() {
            node = new Node("Sentencia de consola", null, "SentenciaConsola");
            // //node.addChildren(new Node(comando, null, "ComandoConsola"));
            // //node.addChildren(termino.getNode());
            return node;
        }
    }
    
    public class SentenciaLlamadoFuncion extends SentenciaCuerpoFuncion {
        private LlamadoFuncion llamado_de_funcion;
        Node node;
        
        public SentenciaLlamadoFuncion(LlamadoFuncion lf) {
            this.llamado_de_funcion = lf;
        }
        
        public String toString() {
            return "Sentencia de llamado de funcion:"
                    + "\n\t" + llamado_de_funcion.toString();
        }

        @Override
        public Node getNode() {
            node = new Node("Sentencia de llamado de funcion", null, "SentenciaLlamadoFuncion");
            // //node.addChildren(llamado_de_funcion.getNode());
            return node;
        }
    }
    
    public class SentenciaAsignacion extends SentenciaCuerpoFuncion {
        private ReceptorAsignacion receptor_asignacion;
        private SentenciaConsola sentencia_consola;
        private Expresion expresion1, expresion2;
        private boolean is_ra;
        private boolean has_cc;
        Node node;
        
        public SentenciaAsignacion(ReceptorAsignacion ra, Expresion e1) {
            this.receptor_asignacion = ra;
            this.expresion1 = e1;
            this.is_ra = true;
            this.has_cc = false;
        }
        
        public SentenciaAsignacion(ReceptorAsignacion ra, SentenciaConsola sc) {
            this.receptor_asignacion = ra;
            this.sentencia_consola = sc;
            this.is_ra = true;
            this.has_cc = true;
        }

        public SentenciaAsignacion(Expresion e1, Expresion e2) {
            this.expresion1 = e1;
            this.expresion2 = e2;
            this.is_ra = false;
            this.has_cc = false;
        }
        
        public String toString() {
            if (is_ra && !has_cc)
                return "Sentencia de asignacion:"
                        + "\n\t" + receptor_asignacion.toString()
                        + "\n\t" + expresion1.toString();
            else if (is_ra && has_cc)
                return "Sentencia de asignacion:"
                        + "\n\t" + receptor_asignacion.toString()
                        + "\n\t" + sentencia_consola.toString();
            return "Sentencia de asignacion:"
                    + "\n\t" + expresion1.toString()
                    + "\n\t" + expresion2.toString();
        }

        @Override
        public Node getNode() {
            node = new Node("Sentencia de asignacion", null, "SentenciaAsignacion");
            // //node.addChildren(receptor_asignacion.getNode());
            // //node.addChildren(expresion1.getNode());
            return node;
        }
    }
    
    public class SentenciasElseIf {
        private ArrayList<SentenciaElseIf> sentencias_else_if;
        Node node;
        
        public SentenciasElseIf() {
            sentencias_else_if = new ArrayList();
        }
        
        public void add(SentenciaElseIf s) {
            sentencias_else_if.add(s);
        }
        
        public String toString() {
            String ret_val = "Sentencias else if:";
            
            for (int i = 0; i < sentencias_else_if.size(); i++) {
                ret_val += "\n\t" + sentencias_else_if.get(i);
            }
            
            return ret_val;
        }

        private Node getNode() {
            node = new Node("Sentencias else if", null, "SentenciasElseIf");
            for (int i = 0; i < sentencias_else_if.size(); i++) {
                // //node.addChildren(sentencias_else_if.get(i).getNode());
            }
            return node;
        }
    }
    
    public class SentenciaElseIf {
        private Expresion expresion;
        private CuerpoFuncion cuerpo_de_funcion;
        Node node;
        
        public SentenciaElseIf(Expresion e, CuerpoFuncion cf) {
            this.expresion = e;
            this.cuerpo_de_funcion = cf;
        }
        
        public String toString() {
            String ret_val = "Sentencia else if: ";
            
            ret_val += "\n\t" + expresion.toString();
            ret_val += "\n\tCuerpo de Funcion:";
            for (int i = 0; i < cuerpo_de_funcion.size(); i++) {
                ret_val += "\n\t" + cuerpo_de_funcion.getAt(i);
            }
            
            return ret_val;
        }

        private Node getNode() {
            node = new Node("Sentencia else if", null, "SentenciaElseIf");
            // //node.addChildren(expresion.getNode());
            // //node.addChildren(cuerpo_de_funcion.getNode());
            return node;
        }
    }
    
    public class SentenciaElse {
        private CuerpoFuncion cuerpo_de_funcion;
        Node node;
        
        public SentenciaElse(CuerpoFuncion cf) {
            this.cuerpo_de_funcion = cf;
        }
        
        public String toString() {
            String ret_val = "Sentencia else:";
            ret_val += "\n\tCuerpo de Funcion:";
            for (int i = 0; i < cuerpo_de_funcion.size(); i++) {
                ret_val += "\n\t" + cuerpo_de_funcion.getAt(i);
            }
            return ret_val;
        }

        private Node getNode() {
            node = new Node("Sentencia else", null, "SentenciaElse");
            // //node.addChildren(cuerpo_de_funcion.getNode());
            return node;
        }
    }
    
    public class Expresion {

        private boolean unary, binary, encapsulated, is_term;
        private String operador_unario, operador_binario, term;
        private Expresion expresion1, expresion2;
        private Termino termino;
        Node node;
        
        public Expresion(Expresion e1, String binary_operator, Expresion e2) {
            this.expresion1 = e1;
            this.expresion2 = e2;
            this.operador_binario = binary_operator;
            this.unary = false;
            this.binary = true;
            this.encapsulated = false;
        }

        public Expresion(Expresion e1, String unary_operator) {
            this.expresion1 = e1;
            this.operador_unario = unary_operator;
            this.unary = true;
            this.binary = false;
            this.encapsulated = false;
        }

        public Expresion(Expresion e1) {
            this.expresion1 = e1;
            this.encapsulated = true;
            this.unary = false;
            this.binary = false;
        }

        public Expresion(Termino t) {
            this.termino = t;
            this.encapsulated = false;
            this.unary = false;
            this.binary = false;
        }

        public String toString() {
            String ret_val = "Expresion: \n\t";

            if (binary && !unary && !encapsulated) {
                ret_val += expresion1.toString() + "\n\t"
                        + operador_binario + "\n\t"
                        + expresion2.toString();
            } else if (unary && !binary && !encapsulated) {
                ret_val += operador_unario + "\n\t"
                        + expresion1.toString();
            } else if (encapsulated && !unary && !binary) {
                ret_val += "(\n\t"
                        + expresion1.toString()
                        + ")";
            } else if (!unary && !binary && !encapsulated) {
                ret_val += termino.toString();
            }
            return ret_val;
        }

        private Node getNode() {
            node = new Node("Expresion", null, "Expresion");
            if (binary && !unary && !encapsulated) {
                // //node.addChildren(expresion1.getNode());
                // //node.addChildren(new Node(operador_binario, null, "OperadorBinario"));
                // //node.addChildren(expresion2.getNode());
            } else if (unary && !binary && !encapsulated) {
                // //node.addChildren(new Node(operador_unario, null, "OperadorUnario"));
                // //node.addChildren(expresion1.getNode());
            } else if (encapsulated && !unary && !binary) {
                // //node.addChildren(new Node("(", null, "ParentesisIzquierdo"));
                // //node.addChildren(expresion1.getNode());
                // //node.addChildren(new Node(")", null, "ParentesisDerecho"));
            } else if (!unary && !binary && !encapsulated) {
                // //node.addChildren(termino.getNode());
            }
            return node;
        }
    }

    public class Termino {

        private String termino;
        Node node;

        public Termino(String l) {
            this.termino = l;
        }

        public Termino(LlamadoFuncion lf) {
            termino = lf.toString();
        }

        public Termino(ReceptorAsignacion ra) {
            termino = ra.toString();
        }

        public String toString() {
            return "Termino: " + termino;
        }

        private Node getNode() {
            node = new Node(termino, null, "Termino");
            return node;
        }
    }

    public class LlamadoFuncion {

        private String identificador;
        private Argumentos argumentos;
        Node node;

        public LlamadoFuncion(String id, Argumentos a) {
            this.identificador = id;
            this.argumentos = a;
        }

        public String getId() {
            return identificador;
        }

        public String toString() {
            return "Llamado de función:\n\t"
                    + "Identificador: " + identificador + "\n\t"
                    + argumentos.toString();
        }

        private Node getNode() {
            node = new Node("Llamado de funcion", null, "LlamadoFuncion");
            // //node.addChildren(new Node(id, null, "Identificador"));
            // //node.addChildren(a.getNode());
            return node;
        }
    }

    public class Argumentos {

        private ListaArgumentos lista_de_argumentos;
        private boolean has_value;
        Node node;
        
        public Argumentos(ListaArgumentos la) {
            this.lista_de_argumentos = la;
            has_value = true;
        }

        public Argumentos() {
            this.lista_de_argumentos = null;
            has_value = false;
        }

        public String toString() {
            if (has_value)
                return "Argumentos:\n\t"
                        + "("
                        + "\n\t" + lista_de_argumentos.toString()
                        + ")";
            return "Argumentos: ()";
        }

        private Node getNode() {
            node = new Node("Argumentos", null, "Argumentos");
            // //node.addChildren(la.getNode());
            return node;
        }
    }

    public class ListaArgumentos {

        private ArrayList<Expresion> expresiones;
        Node node;
        
        public ListaArgumentos() {
            expresiones = new ArrayList();
        }

        public void add(Expresion e) {
            expresiones.add(e);
        }

        public int size() {
            return expresiones.size();
        }

        public Expresion getAt(int i) {
            return expresiones.get(i);
        }

        public String toString() {
            String ret_val = "Lista de argumentos:";
            for (int i = 0; i < expresiones.size(); i++) {
                ret_val += "\n\t" + expresiones.get(i).toString();
            }
            return ret_val;
        }

        private Node getNode() {
            node = new Node("", null, "");
            for (int i = 0; i < expresiones.size(); i++) {
                // //node.addChildren(exps.get(i).getNode());
            }
            return node;
        }
    }

    public class ReceptorAsignacion {

        private String receptor_asignacion;
        Node node;

        public ReceptorAsignacion(String id) {
            receptor_asignacion = id;
        }

        public ReceptorAsignacion(Propiedad p) {
            receptor_asignacion = p.toString();
        }

        public String toString() {
            return receptor_asignacion;
        }

        private Node getNode() {
            node = new Node("Receptor de asignacion", null, "ReceptorAsignacion");
            // //node.addChildren(new Node(ra, null, "Receptor"));
            return node;
        }
    }

    public class Propiedad {

        private String identificador;
        private CadenaPropiedades cadena_de_propiedades;
        Node node;
        
        public Propiedad(CadenaPropiedades cp, String id) {
            this.identificador = id;
            this.cadena_de_propiedades = cp;
        }

        public String toString() {
            return "Propiedad:"
                    + identificador + cadena_de_propiedades.toString();
        }

        private Node getNode() {
            node = new Node("Propiedad", null, "Propiedad");
            // //node.addChildren(new Node(id, null, "Identificador"));
            // //node.addChildren(cp.getNode());
            return node;
        }
    }

    public class CadenaPropiedades {

        private ArrayList<String> cadena;
        Node node;
        
        public CadenaPropiedades() {
            cadena = new ArrayList();
        }

        public void add(String id) {
            cadena.add(0, id);
        }

        public int size() {
            return cadena.size();
        }

        public String getAt(int i) {
            return cadena.get(i);
        }

        public String toString() {
            String ret_val = "";

            for (int i = 0; i < cadena.size(); i++) {
                ret_val += "." + cadena.get(i);
            }

            return ret_val;
        }

        private Node getNode() {
            node = new Node("Cadena de propiedades", null, "CadenaPropiedades");
            for (int i = 0; i < cadena.size(); i++) {
                // //node.addChildren(new Node(cadena.get(i), null, "Propiedad"));
            }
            return node;
        }
    }

    public class Parametros {

        private ListaParametros lista_de_parametros;
        private boolean empty;
        Node node;
        
        public Parametros(ListaParametros lp) {
            this.lista_de_parametros = lp;
            empty = false;
        }

        public Parametros() {
            empty = true;
        }

        public int size() {
            if (empty)
                return 0;
            return lista_de_parametros.size();
        }
        
        public ListaParametros getListaParametros() {
            return this.lista_de_parametros;
        }

        public String getAt(int pos) {
            if (!empty)
                return lista_de_parametros.getAt(pos).toString();
            return "";
        }

        private Node getNode() {
            node = new Node("Parametros", null, "Parametros");
            // //node.addChildren(lp.getNode());
            return node;
        }
    }

    public class ListaParametros {

        private ArrayList<Parametro> parametros;
        Node node;
        
        public ListaParametros() {
            parametros = new ArrayList();
        }

        public void add(Parametro p) {
            parametros.add(p);
        }

        public int size() {
            return parametros.size();
        }

        public Parametro getAt(int pos) {
            return parametros.get(pos);
        }

        private Node getNode() {
            node = new Node("", null, "");
            for (int i = 0; i < parametros.size(); i++) {
                // //node.addChildren(parametros.get(i).getNode());
            }
            return node;
        }
    }

    public class Parametro {

        private FormaPaso forma_de_paso;
        private String identificador;
        private TipoDato tipo_de_dato;
        private boolean non_by;
        Node node;
        
        public Parametro(FormaPaso fp, String id, TipoDato td) {
            this.forma_de_paso = fp;
            this.identificador = id;
            this.tipo_de_dato = td;
            this.non_by = false;
        }

        public Parametro(String id, TipoDato td) {
            this.identificador = id;
            this.tipo_de_dato = td;
            this.non_by = true;
        }

        public String getId() {
            return this.identificador;
        }

        public String getTipoDato() {
            return tipo_de_dato.getTipoDato();
        }

        public String toString() {
            String ret_val = "Parametro:\n\t";
            
            if (!non_by)
                ret_val += forma_de_paso.toString() + "\n\t";

            ret_val += "Identificador: " + identificador + "\n\t" 
                    + tipo_de_dato.toString();

            return ret_val;
        }

        private Node getNode() {
            node = new Node("Parametro", null, "Parametro");
//            if (!non_by)
                // //node.addChildren(fp.getNode());
            // //node.addChildren(new Node(id, null, "Identificador"));
            // //node.addChildren(td.getNode());
            return node;
        }
    }

    public class FormaPaso {

        private String forma_de_paso;
        Node node;
        
        public FormaPaso(String fp) {
            this.forma_de_paso = fp;
        }

        public String toString() {
            return "Visibilidad:" + forma_de_paso;
        }

        private Node getNode() {
            node = new Node(forma_de_paso, null, "FormaPaso");
            return node;
        }
    }

    public class Visibilidad {

        private String visibilidad;
        Node node;
        
        public Visibilidad(String v) {
            this.visibilidad = v;
        }

        public String toString() {
            return visibilidad;
        }

        private Node getNode() {
            node = new Node(visibilidad, null, "Visibilidad");
            return node;
        }
    }

    public class ListaVariables {

        private ArrayList<String> lv;
        Node node;
        
        public ListaVariables() {
            lv = new ArrayList();
        }

        public void add(String s) {
            lv.add(0, s);
        }

        public String getAt(int pos) {
            return lv.get(pos);
        }

        public int size() {
            return lv.size();
        }

        private Node getNode() {
            node = new Node("Lista de variables", null, "ListaVariables");
            for (int i = 0; i < lv.size(); i++) {
                // //node.addChildren(new Node(lv.get(i), null, "Identificador"));
            }
            
            return node;
        }
    }

    public class TipoDato {

        private String tipo_de_dato;
        Node node;
        
        public TipoDato(String td) {
            this.tipo_de_dato = td;
        }

        public String toString() {
            return "Tipo de dato:" + tipo_de_dato;
        }

        public String getTipoDato() {
            return tipo_de_dato;
        }

        private Node getNode() {
            node = new Node(tipo_de_dato, null, "TipoDato");
            return node;
        }
    }
    
    public class Node {
        private String name, type;
        private Node parent;
        private ArrayList<Node> children;
        
        public Node(String name, Node parent, String type) {
            this.name = name;
            this.type = type;
            this.parent = parent;
            this.children = new ArrayList();
        }
        
        public String getType() {
            return type;
        }
        
        public void setType(String type) {
            this.type = type;
        }
        
        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
           this.parent = parent;
        }
        
        public void addChildren(Node child) {
            children.add(child);
//            children.get(children.size() - 1).setParent(this);
        }
        
        public void removeChildren(int i) {
            children.remove(i);
        }
    }
    
    public class Tree {
        Node root;
        
        public Tree(Node root) {
            this.root = root;
        }

        public Node getRoot() {
            return root;
        }

        public void setRoot(Node root) {
            this.root = root;
        }
        
        public void recorrerArbol(){
            recorrido(root, 0);
        }
        
        public void recorrido(Node actual, int level){
            for (int i = 0; i <= level; i++) {
                System.out.print("-");
            }
            System.out.println(actual.type);

            for (int i = 0; i < actual.children.size(); i++) {
                recorrido(actual.children.get(i), level++);
            }
        }
    }
}
