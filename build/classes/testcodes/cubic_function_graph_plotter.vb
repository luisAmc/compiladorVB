Dim a, b, c, d As Integer
Dim x As Double

Private Function f(x As Variant)
	' Need to make some transformation as the left coordinates in VB start from left
	' our graph starts from center
	f = a * (5 - x) ^ 3 + b * (5 - x) ^ 2 + c * (5 - x) + d

End Function

Private Sub cmd_Clear_Click()
	pic_graph.Cls()
	txt_a.Text = ""
	txt_b.Text = ""
	txt_c.Text = ""
	txt_d.Text = ""
End Sub

Private Sub cmd_draw_Click()
	Dim y As Double
	Dim w As Double

	a = Val(txt_a.Text)
	b = Val(txt_b.Text)
	c = Val(txt_c.Text)
	d = Val(txt_d.Text)
	'Using a scale of 0.5 cm to represent i unit to draw the graph
	' Need to make some transformation as the coordinates in VB start from top left
	For w = 0 To 10 Step 0.0001
	y = f(w)
	pic_graph.PSet (w, 5 - y)

	Next w

End Sub