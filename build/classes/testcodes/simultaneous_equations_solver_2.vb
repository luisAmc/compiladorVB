'Se resuelve "x" y "y" apartir de:
'ax+by=m
'cx2+dy2=n

Private Sub Command1_Click()
	Dim a, b, c, d, m, n As Integer
	Dim x1, x2, y1, y2 As Double

	a = Val(Txt_a.Text)
	b = Val(Txt_b.Text)
	m = Val(Txt_m.Text)
	c = Val(Txt_c.Text)
	d = Val(Txt_d.Text)
	n = Val(Txt_n.Text)
	x1 = (m * a * d + Sqr(m ^ 2 * a ^ 2 * d ^ 2 - (b ^ 2 * c + a ^ 2 * d) * (d * m ^ 2 - b ^ 2 * n))) / (b ^ 2 * c + a ^ 2 * d)

	x2 = (m * a * d - Sqr(m ^ 2 * a ^ 2 * d ^ 2 - (b ^ 2 * c + a ^ 2 * d) * (d * m ^ 2 - b ^ 2 * n))) / (b ^ 2 * c + a ^ 2 * d)

	y1 = (m - a * x1) / b
	y2 = (m - a * x2) / b
	Lbl_x1.Caption = Round(x1, 2)
	Lbl_y1.Caption = Round(y1, 2)
	Lbl_x2.Caption = Round(x2, 2)
	Lbl_y2.Caption = Round(y2, 2)

End Sub