<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	 <form:form action="editarInfo" modelAttribute="idCliente" method="POST">  
	 
        Id: <form:input path="id" readonly="true"/>         		
        <br><br>  									
        Nombre: <form:input path="nombre" />         
        <br><br>  												
        Apellido: <form:input path="apellido" />  
        <br><br>  
        Email: <form:input path="email" />  
        <br><br> 
        <input type="submit" value="Editar" />    
   	
   		
   	
    </form:form>  
	

</body>
</html>