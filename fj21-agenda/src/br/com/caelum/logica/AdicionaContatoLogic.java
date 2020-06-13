package br.com.caelum.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class AdicionaContatoLogic implements Logica {
	
	public String executa (HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			String nome = req.getParameter("nome");
			String endereco = req.getParameter("endereco");
			String email = req.getParameter("email");
			String dataEmTexto = req.getParameter("dataNascimento");
			
			// criar um contato
			Contato contato = new Contato();
			contato.setNome(nome);
			contato.setEmail(email);
			contato.setEndereco(endereco);
			
			// Calendar (Date) (TimeInMillis)
			// SimpleDateFormat , String para um Date = parse --- Date para um String = format
			
			try {
				Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
				
				Calendar dataCalendar = Calendar.getInstance();
				dataCalendar.setTime(data);
				
				contato.setDataNascimento(dataCalendar);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			ContatoDao dao = new ContatoDao();
			dao.adiciona(contato);
			
			return "/sucesso.jsp";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
