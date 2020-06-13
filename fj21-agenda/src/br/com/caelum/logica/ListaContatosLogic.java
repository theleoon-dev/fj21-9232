package br.com.caelum.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class ListaContatosLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		Connection conexao = (Connection) req.getAttribute("conexao");
		
		ContatoDao dao = new ContatoDao(conexao);
		List<Contato> contatos = dao.getLista();
		
		req.setAttribute("lista", contatos);
		
		return "/WEB-INF/paginas/lista-contatos.jsp";
	}

}
