'Se resuelve "x" y "y" apartir de:
'ax+by=m
'cx+dy=n

Private Sub Solve_Click()

    Dim a, b, c, d, m, n As Integer
    Dim x, y As Double

    a = Val(Txt_a.Text)
    b = Val(Txt_b.Text)
    m = Val(Txt_m.Text)
    c = Val(Txt_c.Text)
    d = Val(Txt_d.Text)
    n = Val(Txt_n.Text)
    x = (b * n - d * m) / (b * c - a * d)
    y = (a * n - c * m) / (a * d - b * c)
    Lbl_x.Caption = Round(x, 2)
    Lbl_y.Caption = Round(y, 2)

End Sub

' To get new equations

Private Sub New_Click()

    Txt_a.Text = ""
    Txt_b.Text = ""
    Txt_m.Text = ""
    Txt_c.Text = ""
    Txt_d.Text = ""
    Txt_n.Text = ""
    Lbl_x.Caption = ""
    Lbl_y.Caption = ""

End Sub