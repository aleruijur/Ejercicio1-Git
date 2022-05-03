<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<form action="Transferencia" method="POST">
		Cantidad:<input type="number" name="cantidad"><br>
		Cuenta destino:<input type="number" name="receptor"><br>
		<input type="submit" value="Transferir">
		<a href="menu.jsp">Volver</a><br>
	</form>
	</center>
</body>
</html>