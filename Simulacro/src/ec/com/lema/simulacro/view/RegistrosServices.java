package ec.com.lema.simulacro.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ec.com.lema.simulacro.dao.EventoDao;
import ec.com.lema.simulacro.db.Connecion;

public class RegistrosServices {

	public String registrarInvitados(EventoDao invitado) {
		Connection con = Connecion.conectar();
		String mensaje = "No se registro el invitado";
		try {
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO eventos (cedula,nombre,celular,edad,correo,direccion) "
					+ " VALUES (?,?,?,?,?,?)");
			pstmt.setString(1, invitado.getCedula());
			pstmt.setString(2, invitado.getNombre());
			pstmt.setString(3, invitado.getCelular());
			pstmt.setInt(4, invitado.getEdad());
			pstmt.setString(5, invitado.getCorreo());
			pstmt.setString(6, invitado.getDireccion());
			pstmt.executeUpdate();
			mensaje = "Se registra el invitado";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mensaje;
	}

	public EventoDao buscarInvitados(EventoDao eventoDao) {
		Connection con = Connecion.conectar();
		EventoDao objEncontrado = null;
		Statement stmt;
		try {
			
			PreparedStatement pstmt = con.prepareStatement("SELECT cedula,nombre,celular,edad,correo,direccion FROM eventos where cedula = ?");
			pstmt.setString(1, eventoDao.getCedula());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				objEncontrado = new EventoDao();
				objEncontrado.setCedula(rs.getString("cedula"));
				objEncontrado.setNombre(rs.getString("nombre"));
				objEncontrado.setCelular(rs.getString("celular"));
				objEncontrado.setEdad(rs.getInt("edad"));
				objEncontrado.setCorreo(rs.getString("correo"));
				objEncontrado.setDireccion(rs.getString("direccion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objEncontrado;
		
	}
	
	
	public List<EventoDao> buscarTodosInvitados() {
		Connection con = Connecion.conectar();
		List<EventoDao> lstEncontrado = new ArrayList<>();
		try {
			
			PreparedStatement pstmt = con.prepareStatement("SELECT cedula,nombre,celular,edad,correo,direccion FROM eventos");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				EventoDao objEncontrado = new EventoDao();
				objEncontrado.setCedula(rs.getString("cedula"));
				objEncontrado.setNombre(rs.getString("nombre"));
				objEncontrado.setCelular(rs.getString("celular"));
				objEncontrado.setEdad(rs.getInt("edad"));
				objEncontrado.setCorreo(rs.getString("correo"));
				lstEncontrado.add(objEncontrado);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstEncontrado;
		
	}
	
	
	public String actualizarInvitados(EventoDao invitado) {
		Connection con = Connecion.conectar();
		String mensaje = "No se actualiza el invitado";
		try {
			PreparedStatement pstmt = con.prepareStatement("UPDATE eventos SET cedula = ?,nombre = ?,celular = ?,edad = ?,correo = ?,direccion = ? "
					+ " WHERE cedula = ?");
			pstmt.setString(1, invitado.getCedula());
			pstmt.setString(2, invitado.getNombre());
			pstmt.setString(3, invitado.getCelular());
			pstmt.setInt(4, invitado.getEdad());
			pstmt.setString(5, invitado.getCorreo());
			pstmt.setString(6, invitado.getDireccion());
			pstmt.setString(7, invitado.getCedula());
			pstmt.executeUpdate();
			mensaje = "Se actualiza el invitado";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mensaje;
	}

	public boolean eliminarInvitados(EventoDao eventoDao) {
		Connection con = Connecion.conectar();
		try {
			PreparedStatement pstmt = con.prepareStatement("DELETE FROM eventos where cedula = ?");
			pstmt.setString(1, eventoDao.getCedula());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
