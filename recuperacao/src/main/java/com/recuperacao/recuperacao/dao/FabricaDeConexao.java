package com.recuperacao.recuperacao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/recuperacao?serverTimezone=UTC", "lucas", "Bppsirmobh9,");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		FabricaDeConexao.getConnection();
	}
	
}
