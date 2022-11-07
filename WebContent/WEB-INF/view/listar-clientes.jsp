<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Holaa</h1>

	<table>
  <tr>
    <td>Nombre</td>
    <td>Apellido</td>
    <td>Email</td>
  </tr>
  
  <c:forEach var="varCliente" items="${clientes}">
        <tr>
    <td>${varCliente.nombre}</td>
    <td>${varCliente.apellido}</td>
    <td>${varCliente.email}</td>
  </tr>
   </c:forEach>
  
	</table>
	
<input type="button" value="Agregar Cliente" onclick="window.location.href='btnagregar'; return false;">	
	

</body>
</html>