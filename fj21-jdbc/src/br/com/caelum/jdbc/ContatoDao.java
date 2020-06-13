package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {

	public void adiciona(Contato contato) throws SQLException {

		Connection conexao = null;

		try {

			conexao = new ConnectionFactory().getConnection();

			System.out.println("Conexão aberta!");

			String sql = "INSERT INTO CONTATOS (nome, email, endereco, dataNascimento) VALUES (?,?,?,?)";

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());

			java.sql.Date data = new java.sql.Date(contato.getDataNascimento().getTimeInMillis());

			stmt.setDate(4, data);

			stmt.execute();
			stmt.close();

			System.out.println("Adicionado com sucesso!");

			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.close();
		}

	}

	public List<Contato> getLista() {

		String sql = "select * from contatos";
		
		Connection conexao = null;
		PreparedStatement stmt = null;
		List<Contato> contatos = new ArrayList<Contato>();

		try {

			conexao = new ConnectionFactory().getConnection();

			stmt = conexao.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Contato c1 = new Contato();

				c1.setId(rs.getInt("id"));
				c1.setNome(rs.getString("nome"));
				c1.setEmail(rs.getString("email"));
				c1.setEndereco(rs.getString("endereco"));

				java.sql.Date dataSql = rs.getDate("dataNascimento");

				if (dataSql != null) {
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(dataSql);
					c1.setDataNascimento(calendar);
				}

				contatos.add(c1);

			}
			
			rs.close(); 

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexao.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}

		return contatos;

	}

}
