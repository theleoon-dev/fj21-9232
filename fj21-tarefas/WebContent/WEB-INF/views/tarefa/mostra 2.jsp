<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostrar Tarefa</title>
</head>


<body>
	<c:import url="../cabecalho.jsp"></c:import>

	<h3>Alterar tarefa - ${tarefa.id}</h3>
	<form action="alteraTarefa" method="post">
		<input type="hidden" name="id" value="${tarefa.id}" /> 
		
		Descrição:<br />
		<textarea name="descricao" cols="100" rows="5"><%--
		--%>${tarefa.descricao}<%--
	--%></textarea>
		<br />
		 
		Finalizado? <input type="checkbox" name="finalizado" value="true" ${tarefa.finalizado? 'checked' : '' } /> <br /> 
		
		Data de finalização: <br /> 
		<input type="text" name="dataFinalizacao" value="<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy" />" />
		<br /> 
		<input type="submit" value="Alterar" />
	</form>
	
	<c:import url="../rodape.jsp"></c:import>
</body>
</html>