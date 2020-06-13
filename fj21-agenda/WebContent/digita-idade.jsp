<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Digita idade</title>
</head>
<body>

	<c:import url="cabecalho.jsp"></c:import>

	<form action="mostra-idade.jsp" method="post">
	
		<label>Idade: </label>
		<input type="text" name="idade">
		
		<input type="submit" value="Enviar">
	
	</form>
	
	<c:import url="rodape.jsp"></c:import>

</body>
</html>