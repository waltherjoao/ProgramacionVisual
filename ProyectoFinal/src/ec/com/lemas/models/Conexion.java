package ec.com.lemas.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static String url = "jdbc:sqlserver://localhost;databaseName=Transporte;user=Lemas;password=lemas";

	public static Connection conectar() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
