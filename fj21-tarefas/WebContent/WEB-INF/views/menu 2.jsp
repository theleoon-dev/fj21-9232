<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<link href="resources/css/tarefas.css" type="text/css" rel="stylesheet">
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>

	<h2>Página inicial da Lista de Tarefas</h2>
	<p>Bem vindo, ${usuarioLogado.login}</p>
	<a href="listaTarefas">Clique aqui</a> para acessar a lista de tarefas
	<br />
	<br />
	<a href="logout">Sair</a>

	<c:import url="rodape.jsp"></c:import>
</body>
</html>