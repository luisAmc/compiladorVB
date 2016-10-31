'Se resuelve "x" y "y" apartir de:
'ax+by=m
'cx2+dy2=n

Dim a As Integer
Dim b As Integer
Dim c As Integer
Dim d As Integer
Dim m As Integer
Dim n As Integer
Dim x1 As Double
Dim x2 As Double
Dim y1 As Double
Dim y2 As Double

Sub subUno()

	a = Console.In()
	b = Console.In()
	m = Console.In()
	c = Console.In()
	d = Console.In()
	n = Console.In()
	x1 = (m * a * d + Sqr(m ^ 2 * a ^ 2 * d ^ 2 - (b ^ 2 * c + a ^ 2 * d) * (d * m ^ 2 - b ^ 2 * n))) / (b ^ 2 * c + a ^ 2 * d)

	x2 = (m * a * d - Sqr(m ^ 2 * a ^ 2 * d ^ 2 - (b ^ 2 * c + a ^ 2 * d) * (d * m ^ 2 - b ^ 2 * n))) / (b ^ 2 * c + a ^ 2 * d)

	y1 = (m - a * x1) / b
	y2 = (m - a * x2) / b

End Sub