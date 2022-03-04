package ec.com.lema.simulacro.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connecion {
	private static String url = "jdbc:sqlserver://localhost;databaseName=Practica;user=Invitados;password=invitados";

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
