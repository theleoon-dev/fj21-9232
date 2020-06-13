package br.com.caelum.jdbc;

import java.util.Calendar;

import br.com.caelum.jdbc.modelo.Contato;

public class JDBCExemplo {

	public static void main(String[] args) throws Exception {
		
		ContatoDao dao = new ContatoDao();

		// criando um novo contato
		Contato contato = new Contato();
		contato.setNome("Ricardo");
		contato.setEmail("ricardo@caelum.com");
		contato.setEndereco("Rua sem nome");
		contato.setDataNascimento(Calendar.getInstance());
		dao.adiciona(contato);

		// obtendo a lista
		for (Contato item : dao.getLista()) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("Data de Nascimento: " +
			contato.getDataNascimento().getTime() + "\n");
		}
		

	}

}