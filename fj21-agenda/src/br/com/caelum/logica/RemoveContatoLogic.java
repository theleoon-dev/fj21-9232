package br.com.caelum.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class RemoveContatoLogic implements Logica {
	
	public String executa (HttpServletRequest req, HttpServletResponse resp) {
		
		if (EhCliente()) {
			String id = req.getParameter("id");
			
			Contato contato = new Contato();
			contato.setId(Long.valueOf(id));

			ContatoDao dao = new ContatoDao();
			dao.exclui(contato);
			
			return "mvc?logica=ListaContatosLogic";
			
		} else return "/restrito.jsp";
		
	}
	
	
	public boolean EhCliente() {
		// tem as regras que define se é ou não cliente
		return false;
	}

}
