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
	<h2>Alta Alumno</h2>
	<form action="AltaAlumno" method="POST">
		Usuario:<input type="text" name="usuario"><br>
		Contraseña:<input type="text" name="password"><br>
		Nombre:<input type="text" name="nombre"><br>
		Email:<input type="email" name="email"><br>
		Edad:<input type="number" name="edad"><br>
		<input type="submit" value="Guardar">
	</form>
</center>
</body>
</html>