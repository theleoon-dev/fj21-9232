<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulário de Login</title>
</head>
<link href="resources/css/tarefas.css" type="text/css" rel="stylesheet">
<body>
	<c:import url="cabecalho.jsp"></c:import>
		
	<h2>Página de Login das Tarefas</h2>
	<form action=efetuaLogin method="post">
		Login: <input type="text" name="login" /> <br /> Senha: <input
			type="password" name="senha" /> <br /> <input type="submit"
			value="Entrar nas tarefas" />
	</form>
	
	<c:import url="rodape.jsp"></c:import>
</body>
</html>