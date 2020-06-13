<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulário - Criação de Tarefa</title>

<link href="resources/css/tarefas.css" type="text/css" rel="stylesheet">
	
</head>
<body>
	<c:import url="../cabecalho.jsp"></c:import>
	<h3>Adicionar tarefas</h3>
	
	<form:errors path="tarefa.descricao" cssStyle="color:red"></form:errors>
	
	<form action="adicionaTarefa" method="post">
		Descrição: 
		
		<br />
		
		<textarea name="descricao" rows="5" cols="100"></textarea>
		<br /> 
		
		<input type="submit" value="Adicionar">
	</form>
	
	<c:import url="../rodape.jsp"></c:import>
</body>
</html>