<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="br.com.caelum.agenda.dao.ContatoDao, br.com.caelum.agenda.modelo.Contato, java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Endereço</th>
			<th>Data de Nascimento</th>
		</tr>
		
		<% 
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
			
			for(Contato contato : contatos) { %>
				<tr>
					<td><%= contato.getId() %></td>
					<td><%= contato.getNome() %></td>
					<td><%= contato.getEmail() %></td>
					<td><%= contato.getEndereco() %></td>
					<td><%= new SimpleDateFormat("dd/MM/yyyy").format(contato.getDataNascimento().getTime()) %></td>
				</tr>
			<%}%>
	
	
	</table>

</body>
</html>