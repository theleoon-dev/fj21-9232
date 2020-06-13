<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Contatos com Tags</title>
</head>
<body>

	<c:import url="/cabecalho.jsp"></c:import>

	<table>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Endereço</th>
			<th>Data de Nascimento</th>
			<th>Excluir</th>
		</tr>

		<c:forEach var="contato" items="${lista}">

			<tr>
				<td>${contato.id}</td>
				<td>${contato.nome}</td>
				<td><c:if test="${not empty contato.email}">
						<a href="mailto:${contato.email}"> ${contato.email }</a>
					</c:if> <c:if test="${empty contato.email}">
						E-mail não informado
					</c:if></td>
				<td>${contato.endereco}</td>
				<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
				<td> <a href="mvc?id=${contato.id}&logica=RemoveContatoLogic">Remover</a> </td>
			
			</tr>

		</c:forEach>

	</table>

	<c:import url="/rodape.jsp"></c:import>

</body>
</html>