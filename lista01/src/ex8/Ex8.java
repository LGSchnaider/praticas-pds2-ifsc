package ex8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex8 {
	public static void main(String[] args) {
		try {
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/"+"?serverTimezone=UTC","root","aluno");
		
		Statament stm = conexao.createStatement();
		String WSQL = "create database Lista01";
		stm.exetuteQuery(WSQL);
		
		
		conexao.close();
		}catch(SQLException e) {
			
		}
	}
}
