'Incorrecta declaracion de variables
'If incompleto

Dim a As 
Dim b As Double

Function funcion1()
	Dim numero As Double
	If (b >= 3) Then
		numero =  b ^ 2
	End

	a = numero / b
	Console.Write(a)
End Function