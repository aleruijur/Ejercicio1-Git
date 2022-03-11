<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido</title>
<link rel="stylesheet" href="css/ejercicio5.css"/>
</head>
<body>
	<nav id="ejercicios">
		<ul>
			<li class="left"><a href="login.jsp">Volver al Inicio de Sesión</a></li>
			<li><a href="ejercicio3.html">Ejercicio3 - CSS</a></li>
			<li><a href="ejercicio2.html">Ejercicio2 - HTML</a></li>
		</ul>
	</nav>
	<h1>Bienvenido <span class="user">${user.user}</span></h1>
	<h2>En en menú de navegación tiene los ejercicio 2 y 3.</h2>	
</body>
</html>