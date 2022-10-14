package dao;

import java.sql.*;

public class DAO {
	protected Connection conexao;
	
	public DAO() {
		conexao = null;
	}

	public boolean conectar() {
		String driverName = "postgres.database.azure.com";                    
		String serverName = "tutoritech-bd";
		// String mydatabase = "postgres";
		int porta = 5432;
		// jdbc:postgresql://$AZ_DATABASE_NAME.postgres.database.azure.com:5432/demo
		String url = "jdbc:postgresql://" + serverName + "." + driverName + ":" + porta +"/" + "postgres";
		String username = "tutoritech_adm";
		String password = "admin_123";
		boolean status = false;

		try {
			// Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexão efetuada com o postgres!");
		//} catch (ClassNotFoundException e) { 
		//	System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
		}

		return status;
	}
	
	public boolean close() {
		boolean status = false;
		
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
}