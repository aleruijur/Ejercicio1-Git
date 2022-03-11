<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicia Sesión</title>
<link rel="stylesheet" href="css/ejercicio5.css"/>
</head>
<body>
	<main class="login">
	<h1>Inicia Sesión</h1>
	<form action="LoginServlet" method="post">
		<label for="username">Usuario:</label> 
		<input id="username" type="text" name="username" autofocus/>
		<br/>
		<label for="password">Contraseña:</label> 
		<input id="password" type="password" name="password"/>
		<br/>
		<input class="button" type="submit"/>
	</form>
	</main>
</body>
</html>