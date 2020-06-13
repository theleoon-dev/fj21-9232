<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form de Agenda</title>
<link href="css/jquery.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
</head>
<body>

	<form action="mvc">
	
		<input type="text" name="logica" value="AdicionaContatoLogic" hidden="true">
		
		<label>Nome</label>
		<input type="text" name="nome">
		
		<br />
		
		<label>E-mail</label>
		<input type="email" name="email">
		
		<br />
		
		<label>Endereço</label>
		<input type="text" name="endereco">
		
		<br />
		
		<caelum:campoData id="dataNascimento" label="Data de Nascimento"/>
		
		<br />
		
		<input type="submit" value="Gravar">
	
	</form>

	
	

</body>
</html>