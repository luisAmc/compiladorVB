Dim numero As Integer

Function funcion(ByRef otrovalor As Double)

	numero = Console.In()
	Dim numero2 As New MiDato()

	If (numero >= 3) Then
		numero2 = otrovalor * 3

	ElseIf (numero >= 5) Then
		numero21 = otrovalor ^ 5 / 7
	
	Else
		numero2 = otrovalor * numero ^ 2
	
	End If

End Function

Function funcion1()
	'Comentario
	Dim a As Double
	b = Console.In()
	Dim numero2 As Double
	
	If (b >= 3) Then
		numero2 =  b ^ 2
	End If

	a = numero2 / b
	Console.Write(a)
End Function