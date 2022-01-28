package com.lemas.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	public static Connection getConexion() {
		String url = "jdbc:sqlserver://localhost;databaseName=dbDiccionario;user=Lemas;password=lemas";
		try {
			Connection con = DriverManager.getConnection(url);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
