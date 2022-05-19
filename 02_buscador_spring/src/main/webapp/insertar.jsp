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
	<form action="Insertar" method="post">
		Dirección:<input type="text" name="dir" value="${requestScope.pagina.direccion}"><br>
		Temática:<input type="text" name="tema" value="${requestScope.pagina.tematica}"><br>
		Descripción:<input type="text" name="desc" value="${requestScope.pagina.descripcion}"><br>
		<input type="submit" value="Insertar">
	</form>
</center>
</body>
</html>