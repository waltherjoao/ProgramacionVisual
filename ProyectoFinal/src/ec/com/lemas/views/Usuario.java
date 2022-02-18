package ec.com.lemas.views;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import ec.com.lemas.DAO.UsuarioDao;
import ec.com.lemas.models.Conexion;

public class Usuario {

	int idUsuario;
	String nombreUs;
	String password;
	int tipoUsuario;
	
	
	public String agregar(UsuarioDao usuario) {
		String respuesta = "";
		Connection con = Conexion.conectar();
		try {
			CallableStatement st = con.prepareCall("{call SP_Ingresar_Usuario(?,?,?,?,?,?,?,?,?,?,?)}");
			st.setString(1, usuario.getCodigoUsuario());
			st.setString(2, usuario.getUsuario());
			st.setString(3, usuario.getClave());
			st.setString(4, usuario.getFactor1());
			st.setString(5, usuario.getFactor2());
			st.setString(6, usuario.getEstado());
			st.setDate(7, Date.valueOf(LocalDate.now()));
			st.setString(8, "ADMIN");
			st.registerOutParameter(9, java.sql.Types.NVARCHAR);
			st.registerOutParameter(10, java.sql.Types.NVARCHAR);
			st.registerOutParameter(11, java.sql.Types.NVARCHAR);
			st.execute();
			respuesta = st.getString(9);
		} catch (SQLException e) {
			e.printStackTrace();
			respuesta = "Error";
		}
		return respuesta;
	}
	
	public String eliminar(UsuarioDao usuarioDao) {
		String respuesta = "";
		Connection con = Conexion.conectar();
		try {
			CallableStatement st = con.prepareCall("{call SP_Eliminar_usuario(?,?,?,?)}");
			st.setString(1, usuarioDao.getCodigoUsuario());
			st.registerOutParameter(2, java.sql.Types.NVARCHAR);
			st.registerOutParameter(3, java.sql.Types.NVARCHAR);
			st.registerOutParameter(4, java.sql.Types.NVARCHAR);
			st.execute();
			respuesta = st.getString(2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	public String actualizar(UsuarioDao actualizacionUsuario) {
		String respuesta = "";
		Connection con = Conexion.conectar();
		try {
			CallableStatement st = con.prepareCall("{call SP_Actualizar_usuario(?,?,?,?,?,?,?,?,?,?)}");
			st.setString(1, actualizacionUsuario.getCodigoUsuario());
			st.setString(2, actualizacionUsuario.getUsuario());
			st.setString(3, actualizacionUsuario.getClave());
			st.setString(4, actualizacionUsuario.getFactor1());
			st.setString(5, actualizacionUsuario.getFactor2());
			st.setString(6, actualizacionUsuario.getEstado());
			st.setString(7, "ADMIN-MOD");
			st.registerOutParameter(8, java.sql.Types.NVARCHAR);
			st.registerOutParameter(9, java.sql.Types.NVARCHAR);
			st.registerOutParameter(10, java.sql.Types.NVARCHAR);
			st.execute();
			respuesta = st.getString(8);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
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
			e.printStackTrace();
		}
	}
	
	public UsuarioDao buscarPorId(UsuarioDao busqueda){
		UsuarioDao usuario = null;
		Connection con = Conexion.conectar();
		try {
			CallableStatement st = con.prepareCall("{call SP_Consultar_usuario(?,?,?,?,?,?,?)}");
			st.setString(1, busqueda.getCodigoUsuario());
			st.registerOutParameter(2, java.sql.Types.NVARCHAR);
			st.registerOutParameter(3, java.sql.Types.NVARCHAR);
			st.registerOutParameter(4, java.sql.Types.NVARCHAR);
			st.registerOutParameter(5, java.sql.Types.NVARCHAR);
			st.registerOutParameter(6, java.sql.Types.NVARCHAR);
			st.registerOutParameter(7, java.sql.Types.NVARCHAR);
			st.execute();
			usuario = new UsuarioDao();
			usuario.setCodigoUsuario(st.getString(2));
			usuario.setUsuario(st.getString(3));
			usuario.setClave(st.getString(4));
			usuario.setFactor1(st.getString(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
}
