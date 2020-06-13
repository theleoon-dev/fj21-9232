package br.com.caelum.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.logica.Logica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String parametro = req.getParameter("logica"); // AdicionaContatoLogic
			String nomeDaClasse = "br.com.caelum.logica." + parametro;
			
			Class<?> classe = Class.forName(nomeDaClasse);
			Logica logica = (Logica) classe.newInstance();
			
			String pagina = logica.executa(req, resp);
			
			RequestDispatcher rd = req.getRequestDispatcher(pagina);
			rd.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		
	}
	
}
