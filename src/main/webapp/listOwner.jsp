<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Owners and their pets</title>
</head>
<body>
	<form action="cargarListado" method="post">
		<input type="submit" value="ver listado">
	</form>


	<%
		List<Actor> actors = (List<Actor>) request.getAttribute("listAllActors");
		pageContext.setAttribute("actors", actors);
	%>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />

	<table border="1">
		<thead>
			<tr>
				<td>Cod Owner</td>
				<td>Name</td>
				<td>Surname</td>
				<td>Editar</td>
				<td>Borrar</td>
				<td>Añadir Macota</td>
				<td>Mascotas</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="actor1" items="${listAllActors}">
				<tr>
					<td><c:out value="${actor1.lugarNacimiento}" /></td>
					<td><c:out value="${actor1.nomActor}" /></td>
					<td><c:out value="${actor1.apellidos}" /></td>
					<td><a href="/editOwner?codOwner=${actor1.codActor}">EDIT</a>
					</td>
					<td><a href="/confirmDeleteOwner?codOwner=${actor1.codActor}">DELETE</a>
					</td>
					<td>
						<form action="inscribirAlumnos" method="post">
							<span>LugarNacimiento:</span><input type="text"
								name="lugarNacimiento"> <span>Nombre:</span><input
								type="text" name="nomActor"> <span>apellidos:</span><input
								type="text" name="apellidos"> <input type="submit">
						</form>



					</td>

					<%-- <td>
	    			<c:forEach var="pet" items="${owner1.mascotas}">
	    				<c:out value="${pet.name} "/>
	    				<a href="/deletePet?codOwner=${owner1.codOwner}&PetName=${pet.name}">BORRAR MASCOTA</a>
	    				<a href="/editPet?codOwner=${owner1.codOwner}&PetName=${pet.name}">EDITAR MASCOTA</a>
	    				<br>
	    			</c:forEach>
	    		</td> --%>

				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>