package ec.com.lemas.views;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import ec.com.lemas.models.Conexion;

public class Usuario {

	int idUsuario;
	String nombreUs;
	String password;
	int tipoUsuario;
	
	
	private void agregar() {
		
	}
	
	private void eliminar() {
		
	}
	
	private void actualizar() {
		
	}
	
	public void buscar(String usuario, String contrasenia) {
		Connection con = Conexion.conectar();
		try {
			CallableStatement st = con.prepareCall("{call spusuariologin(?,?,?)}");
			st.setString(1, usuario);
			st.setString(2, contrasenia);
			st.registerOutParameter(3, java.sql.Types.NVARCHAR);
			st.execute();
			System.out.println(st.getString(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
