package br.com.caelum.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.caelum.agenda.ConnectionFactory;

@WebFilter("/*")
public class MeuFiltro implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		String parametro = req.getParameter("logica");
		
		try {
			
			Connection conexao = new ConnectionFactory().getConnection();
			
			req.setAttribute("conexao", conexao);
			
			chain.doFilter(req, resp); // faço isso para continuar
			
			conexao.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// inicial
	}
	
	@Override
	public void destroy() {
		// final
	}
	

}
