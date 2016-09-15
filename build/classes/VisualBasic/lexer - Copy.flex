package VisualBasic;

import java_cup.runtime.*;
%%

%class VisualBasicLexer
%unicode
%line
%column
%public
%int
%cup

%state CADENA
%state COMENTARIO

%{
	StringBuilder string = new StringBuilder();
	private Symbol symbol(int type) {
		return new Symbol(type, yyline, yycolumn);
	}

	private Symbol symbol(int type, Object value) {
		return new Symbol(type, yyline, yycolumn, value);
	}
%}

/*Comandos de consola*/
Write = "Write"
Read = "Read"

/*Tipos de datos*/
Integer			= "Integer"
Boolean			= "Boolean"
Char			= "Char"
String			= "String"
Type			= "Type"

/*Declaracion de variables*/
Dim				= "Dim"
As				= "As"
Public			= "Public"
Private			= "Private"

/*Comandos de funcion*/
Sub				= "Sub"
Function		= "Function"
Exit			= "Exit"
Call			= "Call"
ByRef			= "ByRef"
ByVal			= "ByVal"

/*Operadores logicos*/
OpMayorQue		= ">"
OpMenorQue		= "<"
OpMayorIgualQue	= ">="
OpMenorIgualQue	= "<="
OpAnd			= "And"
OpOr 			= "Or"
OpNot			= "Not"

/*Operadores aritmeticos*/
OpSuma			= "+"
OpResta			= "/"
OpMult			= "*"
OpDiv			= "/"

OpIgual 		= "="

/*Estructuras de control*/
If				= "If"
Then			= "Then"
Else			= "Else"
ElseIf			= "ElseIf"
End				= "End"
For				= "For"
To 				= "To"
Step			= "Step"
Next			= "Next"
Loop		 	= "Loop"
Do 				= "Do"
While			= "While"
Until			= "Until"

/*Otros*/
Letra 			= [a-zA-Z]
Digito			= [0-9]
Id = {Letra}({Letra}|{Digito})*
FinDeLinea		= [\r|\n|\r\n]+
EspacioBlanco	= [ \t\f]
Comentario 		= "\'"
Comillas		= "\""
ComillasEscape	= "\\\""

/*Valores literales*/
//true
//false
//1
//1.0

%%
<YYINITIAL>{
	/*Comandos de consola*/
  {Write}			{System.out.println("<Write, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{Read}			{System.out.println("<Read, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}

	/*Tipos de datos*/
	{Integer}			{System.out.println("<Integer, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{Boolean}			{System.out.println("<Boolean, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{Char}			{System.out.println("<Char, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{String}			{System.out.println("<String, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{Type}			{System.out.println("<Type, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}

	/*Declaracion de variables*/
	{Dim}			{System.out.println("<Dim, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{As}			{System.out.println("<As, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{Public}			{System.out.println("<Public, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{Private}			{System.out.println("<Private, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}

	/*Comandos de funcion*/
	{Sub}				{System.out.println("<Sub, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{Function}		{System.out.println("<Function, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{Exit}			{System.out.println("<Exit, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{Call}			{System.out.println("<Call, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{ByRef}			{System.out.println("<ByRef, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{ByVal}			{System.out.println("<ByVal, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}

	/*Operadores logicos*/
	{OpMayorQue}		{System.out.println("<OpMayorQue, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{OpMenorQue}		{System.out.println("<OpMenorQue, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{OpMayorIgualQue}	{System.out.println("<OpMayorIgualQue, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{OpMenorIgualQue}	{System.out.println("<OpMenorIgualQue, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{OpAnd}			{System.out.println("<OpAnd, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{OpOr} 			{System.out.println("<OpOr, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{OpNot}			{System.out.println("<OpNot, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}

	/*Operadores aritmeticos*/
	{OpSuma}			{System.out.println("<OpSuma, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{OpResta}			{System.out.println("<OpResta, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{OpMult}			{System.out.println("<OpMult, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{OpDiv}			{System.out.println("<OpDiv, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}

	{OpIgual} 		{System.out.println("<OpIgual, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}

	/*Estructuras de control*/
	{If}			{System.out.println("<If, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{Then}			{System.out.println("<Then, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{Else}			{System.out.println("<Else, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{ElseIf}			{System.out.println("<ElseIf, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{End}			{System.out.println("<End, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{For}			{System.out.println("<For, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{To} 			{System.out.println("<To, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{Step}			{System.out.println("<Step, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{Next}			{System.out.println("<Next, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{Loop}		 	{System.out.println("<Loop, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{Do} 			{System.out.println("<Do, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{While}			{System.out.println("<While, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{Until}			{System.out.println("<Until, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}

	/*Otros*/
	{Comillas} 		{yybegin(CADENA);}
	{Comentario} 		{yybegin(COMENTARIO);}
	{Id}				{System.out.println("<Id, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
	{FinDeLinea}		{System.out.println("<FinDeLinea, linea:" + yyline + ", columna:" + yycolumn + ">");}	
	{EspacioBlanco}	{System.out.println("<EspacioBlanco, linea:" + yyline + ", columna:" + yycolumn + ">");}
	
        .                       {System.out.println("<Otro, linea:" + yyline + ", columna:" + yycolumn + ", texto: " + yytext() + ">");}
}

<CADENA>{
	{Comillas} 		{System.out.println("<String, linea:" + yyline + ", columna:" + yycolumn + ", texto:" + str + ">");
					 str = "";
				 	 yybegin(YYINITIAL);}
	{ComillasEscape}	{str += "\"";}
	.				{str += yytext();}
}

<COMENTARIO>{
	{FinDeLinea}		{System.out.println("<Comentario, linea:" + yyline + ", columna:" + yycolumn + ", texto:" + str + ">");
					 str = "";}
	.				{str += yytext();}
}
