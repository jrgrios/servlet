<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertar nuevo pelicula</title>
</head>
<body>
	<form action="inscribirPelicula" method="post">
		<span>titulo</span><input type="text" name="titulo">
		<span>Año:</span><input type="text" name="ano">
		<span>Comentario:</span><input type="text" name="comentario">
		<span>Trailer:</span><input type="text" name="trailer">
		
		<input type="submit">
	</form>
</body>
</html>