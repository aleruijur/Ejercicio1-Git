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
	<h2>Alta Curso</h2>
	<form action="AltaCurso" method="POST">
		Nombre:<input type="text" name="nombre"><br>
		Fecha:<input type="date" name="fechaInicio"><br>
		Duracion:<input type="number" name="duracion"><br>
		Precio:<input type="text" name="precio"><br>
		<input type="submit" value="Guardar">
	</form>
</center>
</body>
</html>