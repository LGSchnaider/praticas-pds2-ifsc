package ex8;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex8 {
	public static void main(String[] args) {
		try {
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "aluno");

			Statement stm = conexao.createStatement();
			String WSQL = "create database if not exists Lista01";
			stm.executeUpdate(WSQL);
			
			WSQL = "use Lista01";
			stm.executeUpdate(WSQL);
			
			WSQL = "CREATE TABLE animal ("
					+ "  id INT NOT NULL AUTO_INCREMENT,"
					+ "  classe VARCHAR(45) NOT NULL,"
					+ "  especie VARCHAR(45) NOT NULL,"
					+ "  PRIMARY KEY (id))";
			stm.executeUpdate(WSQL);

			WSQL = "INSERT INTO animal (classe, especie) VALUES ('Mamiféro', 'troglodytes')";
			stm.executeUpdate(WSQL);
			
//			WSQL = "SELECT * FROM animal";
//			ResultSet a = stm.executeQuery(WSQL);

			
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
