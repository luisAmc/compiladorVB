Public Type MiNuevoTipo
	a As Integer
	c As Double
End Type

Private Sub sub1(ByVal variable As MiNuevoTipo)
	Dim i As Integer
	Console.Write(variable)

	For i = 0 To variable.a Step 1
		If i = 3 Then
			Console.Write("Soy tres")
		End If
	Next i

	Do While i <= variable.a 
		Console.Write(i)
	Loop

End Sub