package VisualBasic;

import java_cup.runtime.*;
%%

%class Lexer
%unicode
%line
%column
%public
%int
%cup

%state YYCADENA
%state YYCOMENTARIO

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
Write = "Console.Write"
Read = "Console.In"

/*Tipos de datos*/
Integer			= "Integer"
Double 			= "Double"
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
Coma 			= ","
Punto			= "."
ParIzq			= "("
ParDer			= ")"

/*Valores literales*/
Numero = {Digito}+
Decimal = {Digito}+"."{Digito}+
Bool = "True"|"False"
Caracter = {letra}

%%
<YYINITIAL>{
	/*Comandos de consola*/
  	{Write}				{return symbol(sym.WRITE);}
	{Read}				{return symbol(sym.READ);}

	/*Tipos de datos*/
	{Integer}			{return symbol(sym.ENTERO);}
	{Double}			{return symbol(sym.REAL);}
	{Boolean}			{return symbol(sym.BOOLEAN);}
	{Char}				{return symbol(sym.CARACTER);}
	{String}			{return symbol(sym.STRING);}
	{Type}				{return symbol(sym.TYPE);}

	/*Declaracion de variables*/
	{Dim}				{return symbol(sym.DIM);}
	{As}				{return symbol(sym.AS);}
	{Public}			{return symbol(sym.PUBLIC);}
	{Private}			{return symbol(sym.PRIVATE);}

	/*Comandos de funcion*/
	{Sub}				{return symbol(sym.SUB);}
	{Function}			{return symbol(sym.FUNCTION);}
	{Exit}				{return symbol(sym.EXIT);}
	{Call}				{return symbol(sym.CALL);}
	{ByRef}				{return symbol(sym.BYREF);}
	{ByVal}				{return symbol(sym.BYVAL);}

	/*Operadores logicos*/
	{OpMayorQue}		{return symbol(sym.OP_MAYOR_QUE);}
	{OpMenorQue}		{return symbol(sym.OP_MENOR_QUE);}
	{OpMayorIgualQue}	{return symbol(sym.OP_MAYOR_IGUAL_QUE);}
	{OpMenorIgualQue}	{return symbol(sym.OP_MENOR_IGUAL_QUE);}
	{OpAnd}				{return symbol(sym.OP_AND);}
	{OpOr} 				{return symbol(sym.OP_OR);}
	{OpNot}				{return symbol(sym.OP_NOT);}

	/*Operadores aritmeticos*/
	{OpSuma}			{return symbol(sym.OP_SUMA);}
	{OpResta}			{return symbol(sym.OP_RESTA);}
	{OpMult}			{return symbol(sym.OP_MULTIPLICACION);}
	{OpDiv}				{return symbol(sym.OP_DIVISION);}

	{OpIgual} 			{return symbol(sym.OP_IGUAL);}

	/*Estructuras de control*/
	{If}				{return symbol(sym.IF);}
	{Then}				{return symbol(sym.THEN);}
	{Else}				{return symbol(sym.ELSE);}
	{ElseIf}			{return symbol(sym.ELSE_IF);}
	{End}				{return symbol(sym.END);}
	{For}				{return symbol(sym.FOR);}
	{To} 				{return symbol(sym.TO);}
	{Step}				{return symbol(sym.STEP);}
	{Next}				{return symbol(sym.NEXT);}
	{Loop}		 		{return symbol(sym.LOOP);}
	{Do} 				{return symbol(sym.DO);}
	{While}				{return symbol(sym.WHILE);}
	{Until}				{return symbol(sym.UNTIL);}

	/*Otros*/
	{Coma}				{return symbol(sym.COMA);}
	{Punto}				{return symbol(sym.PUNTO);}
	{ParIzq}			{return symbol(sym.PAR_IZQ);}
	{ParDer}			{return symbol(sym.PAR_DER);}
	{Comillas} 			{yybegin(YYCADENA);}
	{Comentario} 		{yybegin(YYCOMENTARIO);}
	{Id}				{return symbol(sym.IDENTIFICADOR, yytext());}
	{Numero} 			{return symbol(sym.ENTERO_LITERAL, new Integer(Integer.parseInt(yytext())));}
	{Decimal} 			{return symbol(sym.REAL_LITERAL, new Double(Double.parseDouble(yytext())));}
	{Bool} 				{return symbol(sym.BOOLEAN_LITERAL, new Boolean(Boolean.parseBoolean(yytext())));}
	{Caracter} 			{return symbol(sym.CARACTER_LITERAL, yytext().charAt(1));}
	{FinDeLinea}		{return symbol(sym.FIN_LINEA);}	
	{EspacioBlanco}		{/*Espacio blanco*/}
	
    .                   {System.out.println("Error lexico. El caracter " + yytext() + " en linea " + yyline + ", columna " + yycolumn + " no es reconocido.");}
    <<EOF>>				{return symbol(sym.EOF);}
}

<YYCADENA>{
	{Comillas} 			{yybegin(YYINITIAL);
					 	return symbol(sym.CADENA_LITERAL, string.toString());}
	{ComillasEscape}	{string.append("\"");}
	.					{string.append(yytext());}
}

<YYCOMENTARIO>{
	{FinDeLinea}		{yybegin(YYINITIAL);}
	.					{/*Omitir comentario*/}
}


//Matrices, al siguiente nivel (multiplicación)
//Mayor nivel que la ves pasada