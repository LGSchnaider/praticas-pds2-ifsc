package control;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Pessoa;

public class PessoaDAO {

	private Conection con;

	private static PessoaDAO instancia;

//cr
	public boolean inserir(Pessoa pessoa) {

		con = Conection.getInstancia();

		Connection c = con.link();

		try {
			String query = "Insert Into pessoa" + " (cpf, nome) Values (?, ?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setInt(1, 123);
			stm.setString(2, "big");

			stm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		con.closeConection();
		return false;
	}

	public boolean deletar(Pessoa pessoa) {
		return false;
	}

	public boolean atualizar(Pessoa pessoa) {
		Connection conect = Conection.link();
		
		try{
			String query = "DELETE FROM pessoa WHERE cpf ?";
			PreparedStatement stm = conect.prepareStatement(query);
			stm.setLong(1, pessoa.getCpf());
			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList listarPessoa() {

		ArrayList pessoas = new ArrayList<>();
		con = Conection.getInstancia();

		Connection c = con.link();

		try {

			Statement stm = c.createStatement();
			String query = "Select * from pessoa";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				int cpf = rs.getInt("cpf");
				String nome = rs.getString("nome");
				Pessoa pessoa = new Pessoa();
				pessoa.setCpf(cpf);
				pessoa.setNome(nome);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		con.closeConection();

		return null;
	}
}