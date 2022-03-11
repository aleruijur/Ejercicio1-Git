<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicia Sesión</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		Usuario: <input type="text" name="username"/>
		<br/>
		Contraseña: <input type="text" name="password"/>
		<br/>
		<input type="submit"/>
	</form>
</body>
</html>