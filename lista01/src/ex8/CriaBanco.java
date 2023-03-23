package ex8;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CriaBanco {
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
			
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public void inserir(String c, String e) {
		String classe = c;
		String especie = e;
		try {
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "aluno");
			Statement stm = conexao.createStatement();
			String WSQL = "use Lista01";
			stm.executeUpdate(WSQL);
			
			WSQL = "INSERT INTO animal (classe, especie) VALUES ('"+classe+"', '"+especie+"')";
			stm.executeUpdate(WSQL);
			
			
		}catch(SQLException e1) {
			e1.printStackTrace();
		}

	}
}
