<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dame dame yo</title>
</head>
<body>

	<h1>Holaa</h1>

	<table>
	  <tr>
	    <td>Nombre</td>
	    <td>Apellido</td>
	    <td>Email</td>
	   	<td>Action</td>
	  </tr>
	  
	  <c:forEach var="varCliente" items="${clientes}">
		    <c:url var="linkActualizar" value="/cliente/muestraFormActualizar">
		    	<c:param name="clienteId" value="${varCliente.id}"/>
		    </c:url>
			
			<c:url var="eliminarCliente" value="/cliente/eliminarInfo">
		    	<c:param name="clienteId" value="${varCliente.id}"/>
		    </c:url>
			
		   	<tr>
			    <td>${varCliente.nombre}</td>
			    <td>${varCliente.apellido}</td>
			    <td>${varCliente.email}</td>
			    <td><a href="${linkActualizar}"><input type="button" value="Modificar"/></a></td>
			    <td><a href="${eliminarCliente}"><input type="button" value="Eliminar"
			    	onclick="if(!(confirm('Vas a eliminar un registro. Estas seguro'))) return false"/></a></td>
		 						<!-- Si el usuario no confirma nada de esto. return false -->		
		   	</tr>	
	   </c:forEach>
	</table>
	
<input type="button" value="Agregar Cliente" onclick="window.location.href='btnagregar'; return false;">	
	

</body>
</html>